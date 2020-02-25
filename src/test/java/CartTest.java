package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Alcohol;
import main.java.Cart;
import main.java.Dairy;
import main.java.FrozenFood;
import main.java.Meat;
import main.java.Produce;
import main.java.Product;
import main.java.UnderAgeException;

public class CartTest {

	Cart cart;
	Product product;
	Produce prod;
	
	Cart cart1, cart2, cart3, cart4, cart5, cart6, cart7, cart8, cart9;
 
    double cart1Expected, cart2Expected, cart3Expected, cart4Expected, cart5Expected,
    cart6Expected; 
    
 
    @Before
    public void setUp() throws Exception { 
        cart = new Cart(45);
        product = new Product(1);
       
        
        prod = new Produce();
        
        cart1 = new Cart(40);
        for (int i = 0; i < 2; i++) {
            cart1.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart1.addItem(new Meat());
        }

        cart1Expected = 70.2;
        
        
        cart2 = new Cart(21);
        for(int i = 0; i < 1; i++) {
        	cart2.addItem(new Alcohol());
        }
      
        cart2Expected = 8.64;
        
        cart3 = new Cart(22);
        for(int i = 0; i < 5; i++) {
        	cart3.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
        	cart3.addItem(new FrozenFood());
        }
      
        cart3Expected = 49.68;
        
        
        cart4 = new Cart(21);
        for(int i = 0; i < 1; i++) {
        	cart4.addItem(new Alcohol());
        }
        cart4Expected = 8.64;
        
        cart5 = new Cart(66);
        for(int i = 0; i < 2; i++) {
        	cart5.addItem(new Alcohol());
        	cart5.addItem(new FrozenFood());
        }
        
        cart6 = new Cart(10);
        for(int i = 0; i < 3; i++) {
        	cart6.addItem(new Produce());
        }
        
        cart6Expected = 5.4;
        
        cart7 = new Cart(10);
        cart7.addItem(product);
        
        cart8 = new Cart(30);
        for(int i = 0; i < 3; i++) {
        	cart8.addItem(prod);
        }
        
        cart9 = new Cart(10);
        for(int i = 0; i < 2; i++) {
        	cart9.addItem(new FrozenFood());
        	cart9.addItem(new Dairy());
        }
     
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void amountSaved() throws UnderAgeException {
    	double amount = cart6.Amount_saved();
        assertEquals(1.0, amount, .01);
    }
  
    @Test
    public void amountSaved2() throws UnderAgeException {
    	double amount = cart8.Amount_saved();
        assertEquals(1.0, amount, .01);
    }
    
    @Test
    public void amountSaved3() throws UnderAgeException {
    	double amount = cart5.Amount_saved();
        assertEquals(-6.0, amount, .01);
    }
    
    @Test
    public void amountSave4() throws UnderAgeException {
    	double amount = cart9.Amount_saved();
        assertEquals(0.0, amount, .01);
    }
    
    @Test
    public void getAZTax() {
        assertEquals(4.0, cart.getTax(50, "AZ"), .01);
    }
    
    @Test
    public void getAZTax2() {
        assertNotEquals(4.0, cart.getTax(44, "AZ"), .01);
    }
    
    @Test
    public void getCATax() {
        assertEquals(1.8, cart.getTax(20, "CA"), .01);
    }
    
    @Test
    public void getNYTax() {
        assertEquals(2.1, cart.getTax(30, "NY"), .01);
    }
    
    @Test
    public void getCOTax() {
        assertEquals(2.8, cart.getTax(40, "CO"), .01);
    }
    
    @Test
    public void getDefaultTax() {
    	assertEquals(0.0, cart.getTax(0, ""), .01);
    }
    
    @Test
    public void removeItem() {
        assertFalse(cart.RemoveItem(product));
    }
    
    @Test
    public void removeItem2() {
    	boolean p = cart7.RemoveItem(product);
        assertEquals(true, p);
    }

    @Test
    public void calcCostCart1() throws UnderAgeException {
        double amount = cart1.calcCost();
        assertEquals(cart1Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart2() throws UnderAgeException {
    	double amount = cart2.calcCost();
    	assertEquals(cart2Expected, amount, .01);
    }
    

    @Test
    public void caclCostCart4() throws UnderAgeException {
    	double amount = cart4.calcCost();
    	assertEquals(cart4Expected, amount, .01);
    }
 
    
}
