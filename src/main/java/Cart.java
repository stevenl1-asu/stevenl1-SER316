package main.java;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    protected int userAge;
    public List<Product> cart;
    public int cartStorage;

    /**
     * Calculates the final cost after all savings and tax has been applied. Also checks
     * that the user is of age to purchase alcohol if it is in their cart at checkout. Sales tax is always AZ tax.
     *
     * Calculation is based off of the following prices and deals:
     * Dairy -> $3
     * Meat -> $10
     * Produce -> $2 or 3 for $5
     * Alcohol -> $8
     * Frozen Food -> $5
     * Alcohol + Frozen Food -> $10
     *
     * If there is an alcohol product in the cart and the user is under 21, then an
     * UnderAgeException should be thrown.
     *
     * @return double totalCost
     * @throws UnderAgeException
     */
    public double calcCost() throws UnderAgeException {
        int price = 0;
        double tax = 0.0;
        double finalTotal = 0.0;

        int produce = 0;
        int alcohol = 0;
        int frozenFood = 0;

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass() == Alcohol.class || cart.get(i).getClass() == FrozenFood.class || cart.get(i).getClass() == Produce.class) {
                alcohol++;
                frozenFood++;
                produce++;
            }
            else if (produce >= 3) {
                price -= 1;
                produce = 0;
            }

            else if (alcohol >= 1 && frozenFood >= 1) {
                price -= 3;
                alcohol--;
                frozenFood--;
            }

        price += cart.get(i).getCost();    		
        }
        tax = getTax(price, "AZ");
        finalTotal = tax + price;

        return finalTotal; //implement me, will be important for assignment 4 (nothing to do here for assignment 3)
    }

    // calculates how much was saved in the current shopping cart based on the deals, returns the saved amount
    // throws exception if alcohol is bought from underage person
    // TODO: Create node graph for this method in assign 4: create white box tests and fix the method
    // reach at least 98% coverage
    public int amountSaved() throws UnderAgeException {
        int subTotal = 0;
        int costAfterSavings = 0;

        double produce_counter = 0;
        int alcoholCounter = 0;
        int frozenFoodCounter = 0; 
        int dairyCounter = 0;

        for (int i = 0; i < cart.size(); i++) {
            subTotal += cart.get(i).getCost();
            costAfterSavings = costAfterSavings + cart.get(i).getCost();

            //SER316-START 
            //Changed equality signs to .equals to compare Strings
            if (cart.get(i).getClass().toString().equals(Produce.class.toString())) {
                //SER316-END
                produce_counter++;

                if (produce_counter >= 3) {
                    costAfterSavings -= 1;
                    produce_counter = 0;
                }
            }
            //SER316-START 
            //Changed equality signs to .equals to compare Strings
            else if (cart.get(i).getClass().toString().equals(Alcohol.class.toString())) {
                //SER316-END
                alcoholCounter++;
                if (userAge < 21) {
                    throw new UnderAgeException("The User is not of age to purchase alcohol!");
                }
            }

            //SER316-START 
            //Changed equality signs to .equals to compare Strings
            else if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString())) {
                //SER316-END    
                frozenFoodCounter++;
            }
            //SER316-START 
            //Commented out duplicate code and dairycounter
            //else if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString()))  
            //dairyCounter++;
            //SER316-END  
            
            //SER316 TASK 2 SPOTBUG FIX
            else if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString())) {
                frozenFoodCounter++;
            }   


            if (alcoholCounter >= 1 && frozenFoodCounter >= 1) {
                costAfterSavings = costAfterSavings + 3;
                alcoholCounter--;
                frozenFoodCounter--;
            }
        }

        return subTotal - costAfterSavings;
    }

    // Gets the tax based on state and the total
    public double getTax(double totalBt, String twoLetterUSStateAbbreviation) {
        double newTotal = 0;
        if(twoLetterUSStateAbbreviation.equals("AZ")) {
            calcAZ(totalBt);
        } else if(twoLetterUSStateAbbreviation.equals("CA")) {
            calcCA(totalBt);
        } else if(twoLetterUSStateAbbreviation.equals("NY")) {
            calcNY(totalBt);
        } else {
            calcCO(totalBt);
        
        }
        return newTotal;
    }
    
    public void calcAZ(double totalBt) {
        double newTotal = totalBt * .08;
    }
    
    public void calcCA(double totalBt) {
        double newTotal = totalBt * .09;
    }
    
    public void calcNY(double totalBt) {
        double newTotal = totalBt * .1;
    }
    
    public void calcCO(double totalBt) {
        double newTotal = totalBt * .07;
    }
    
    public void addItem(Product np) {
        cart.add(np);
    }

    public boolean RemoveItem(Product productToRemove) {
        boolean test = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i) == productToRemove) {
                cart.remove(i);
                test = true;
                return test;
            }
        }
        return false;
    }

    public Cart(int age) {
        userAge = age;
        cart = new ArrayList<Product>();
    }
}
