package test.java;


import main.java.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import main.java.Cart;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class calcCostTest {
 
    private Class<Cart> classUnderTest;

    @SuppressWarnings("unchecked")
    public calcCostTest(Object classUnderTest) {
        this.classUnderTest = (Class<Cart>) classUnderTest;
    }
 
    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
            {Cart.class}
            
        };
        return Arrays.asList(classes);
    }

    private Cart createCart(int age) throws Exception {
        Constructor<Cart> constructor = classUnderTest.getConstructor(Integer.TYPE);
        return constructor.newInstance(age);
    }

    // A sample Cart

    Cart cart1, cart2, cart3, cart4, cart5, cart6, cart7, cart8, cart9, cart10, cart11, cart12,
    cart13, cart14;
 
    double cart1Expected, cart2Expected, cart3Expected, cart4Expected, cart5Expected, 
    cart6Expected, cart7Expected, cart8Expected, cart9Expected, cart10Expected, cart11Expected,
    cart12Expected, cart13Expected, cart14Expected;
   

    @org.junit.Before
    public void setUp() throws Exception {

        // all carts should be set up like this

        // cart created with an age 40 shopper
        cart1 = createCart(40);
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
        
        // cart created with an age 10 shopper
        cart2 = createCart(10);
        for(int i = 0; i < 1; i++) {
        	cart2.addItem(new Alcohol());
        }
      
        cart2Expected = 8.64;
        
     // cart created with an age 22 shopper
        cart3 = createCart(22);
        for(int i = 0; i < 5; i++) {
        	cart3.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
        	cart3.addItem(new FrozenFood());
        }
      
        cart3Expected = 49.68;
        
        // cart created with an age 3 shopper
        cart4 = createCart(21);
        for(int i = 0; i < 1; i++) {
        	cart4.addItem(new Alcohol());
        }
        cart4Expected = 8.64;
 
        // cart created with an age 11 shopper
        cart5 = createCart(11);
        for(int i = 0; i < 1; i++) {
        	cart5.addItem(new Alcohol());
        }
        
        cart5Expected = 8.64;
        
        // cart created with an age 10 shopper
        cart6 = createCart(10);
        
        for(int i = 0; i < 3; i++) {
        	cart6.addItem(new Produce());
        }
      
        cart6Expected = 5.4;
        
        
        // cart created with an age 21 shopper
        cart7 = createCart(21);
        for(int i = 0; i < 1; i++) {
        	cart7.addItem(new Alcohol());
        }
        for(int i = 0; i < 1; i++) {
        	cart7.addItem(new FrozenFood());
        }
        for(int i = 0; i < 3; i++) {
        	cart7.addItem(new Produce());
        }
        
        cart7Expected = 16.2;
        
        // cart created with an age 100 shopper
        cart8 = createCart(100);
        for(int i = 0; i < 2; i++) {
        	cart8.addItem(new Dairy());
        }
        
        cart8Expected = 6.48;

        // cart created with an age 18 shopper
        cart9 = createCart(18);
        for(int i = 0; i < 1; i++) {
        	cart9.addItem(new Meat());
        }
       
        cart9Expected = 10.8;
        
        // cart created with an age 45 shopper
        cart10 = createCart(45);
        for(int i = 0; i < 1; i++) {
        	cart10.addItem(new FrozenFood());
        }
       
        cart10Expected = 5.4;
        
        // cart created with an age 5 shopper
        cart11 = createCart(5);
        for(int i = 0; i < 1; i++) {
        	cart11.addItem(new Produce());
        }
       
        cart11Expected = 2.16;
        
        // cart created with an age -1 shopper
        cart12 = createCart(-1);
        for(int i = 0; i < 1; i++) {
        	cart12.addItem(new Alcohol());
        }
        
        cart12Expected = 8.64;
        
        // cart created with an age 30 shopper
        cart13 = createCart(30);
        
        cart13Expected = 0.0;
        
        // cart created with an age 99 shopper
        cart14 = createCart(99);
        for(int i = 0; i < 1; i++) {
        	cart14.addItem(new Dairy());
        }
        for(int i = 0; i < 1; i++) {
        	cart14.addItem(new Meat());
        }
        for(int i = 0; i < 1; i++) {
        	cart14.addItem(new Alcohol());
        }
        for(int i = 0; i < 1; i++) {
        	cart14.addItem(new FrozenFood());
        }
        for(int i = 0; i < 1; i++) {
        	cart14.addItem(new Produce());
        }
        
        cart14Expected = 27.0;
    }

    // sample test
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
    public void caclCostCart3() throws UnderAgeException {
    	double amount = cart3.calcCost();
    	assertEquals(cart3Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart4() throws UnderAgeException {
    	double amount = cart4.calcCost();
    	assertEquals(cart4Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart5() throws UnderAgeException {
    	double amount = cart5.calcCost();
    	assertEquals(cart5Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart6() throws UnderAgeException {
    	double amount = cart6.calcCost();
    	assertEquals(cart6Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart7() throws UnderAgeException {
    	double amount = cart7.calcCost();
    	assertEquals(cart7Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart8() throws UnderAgeException {
    	double amount = cart8.calcCost();
    	assertEquals(cart8Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart9() throws UnderAgeException {
    	double amount = cart9.calcCost();
    	assertEquals(cart9Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart10() throws UnderAgeException {
    	double amount = cart10.calcCost();
    	assertEquals(cart10Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart11() throws UnderAgeException {
    	double amount = cart11.calcCost();
    	assertEquals(cart11Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart12() throws UnderAgeException {
    	double amount = cart12.calcCost();
    	assertEquals(cart12Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart13() throws UnderAgeException {
    	double amount = cart13.calcCost();
    	assertEquals(cart13Expected, amount, .01);
    }
    
    @Test
    public void caclCostCart14() throws UnderAgeException {
    	double amount = cart14.calcCost();
    	assertEquals(cart14Expected, amount, .01);
    }
}