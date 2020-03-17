package test.java;

import main.java.Alcohol;
import main.java.Cart;
import main.java.Dairy;
import main.java.FrozenFood;
import main.java.Meat;
import main.java.Produce;
import main.java.Product;
import main.java.UnderAgeException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class CartTest {

    Cart cart;
    Product product; 
    Product product2;
    Produce prod;

    Cart cart1;
    Cart cart2;
    Cart cart3; 
    Cart cart4; 
    Cart cart5; 
    Cart cart6; 
    Cart cart7; 
    Cart cart8; 
    Cart cart9; 
    Cart cart10; 
    Cart cart11; 
    Cart cart12;
    Cart cart13; 
    Cart cart14; 
    Cart cart15; 
    Cart cart16; 
    Cart cart17; 
    Cart cart18;

    double cart1Expected; 
    double cart2Expected; 
    double cart3Expected; 
    double cart4Expected; 
    double cart5Expected;
    double cart6Expected; 
    double cart7Expected; 
    double cart8Expected; 
    double cart9Expected; 
    double cart10Expected; 
    double cart11Expected;
    double cart12Expected;
    double cart13Expected; 
    double cart14Expected;  


    @Before
    public void setUp() throws Exception { 
        cart = new Cart(45);
        product = new Product(1);
        product2 = new Alcohol();

        prod = new Produce();

        cart = new Cart(33);
        cart.addItem(product2);

        cart1 = new Cart(40);
        for (int i = 0; i < 2; i++) {
            cart1.addItem(new Alcohol());
        }
        for (int i = 0; i < 3; i++) {
            cart1.addItem(new Dairy());
        }
        for (int i = 0; i < 4; i++) {
            cart1.addItem(new Meat());
        }

        cart1Expected = 70.2;


        cart2 = new Cart(21);
        for (int i = 0; i < 1; i++) {
            cart2.addItem(new Alcohol());
        }

        cart2Expected = 8.64;

        cart3 = new Cart(22);
        for (int i = 0; i < 5; i++) {
            cart3.addItem(new Alcohol());
        }
        for (int i = 0; i < 3; i++) {
            cart3.addItem(new FrozenFood());
        }

        cart3Expected = 49.68;

        cart4 = new Cart(21);
        for (int i = 0; i < 1; i++) {
            cart4.addItem(new Alcohol());
        }
        cart4Expected = 8.64;

        cart5 = new Cart(66);
        for (int i = 0; i < 2; i++) {
            cart5.addItem(new Alcohol());
            cart5.addItem(new FrozenFood());
        }

        // cart created with an age 100 shopper
        cart8 = new Cart(100);
        for (int i = 0; i < 2; i++) {
            cart8.addItem(new Dairy());
        }

        cart8Expected = 6.48;

        // cart created with an age 18 shopper
        cart9 = new Cart(18);
        for (int i = 0; i < 1; i++) {
            cart9.addItem(new Meat());
        }

        cart9Expected = 10.8;

        // cart created with an age 45 shopper
        cart10 = new Cart(45);
        for (int i = 0; i < 1; i++) {
            cart10.addItem(new FrozenFood());
        }

        cart10Expected = 5.4;

        // cart created with an age 5 shopper
        cart11 = new Cart(5);
        for (int i = 0; i < 1; i++) {
            cart11.addItem(new Produce());
        }

        cart11Expected = 2.16;

        // cart created with an age -1 shopper
        cart12 = new Cart(-1);
        for (int i = 0; i < 1; i++) {
            cart12.addItem(new Alcohol());
        }

        cart12Expected = 8.64;

        // cart created with an age 30 shopper
        cart13 = new Cart(30);

        cart13Expected = 0.0;

        // cart created with an age 5 shopper
        cart14 = new Cart(5);
        for (int i = 0; i < 1; i++) {
            cart14.addItem(new Produce());
        }

        cart14Expected = 2.16;


        cart15 = new Cart(10);
        cart15.addItem(product);

        cart16 = new Cart(30);
        for (int i = 0; i < 3; i++) {
            cart16.addItem(prod);
        }

        cart17 = new Cart(10);
        for (int i = 0; i < 2; i++) {
            cart17.addItem(new FrozenFood());
            cart17.addItem(new Dairy());
        }

        cart18 = new Cart(21);
        for (int i = 0; i < 4; i++) {
            cart18.addItem(new Produce());
        }

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void amountSaved() throws UnderAgeException {
        double amount = cart15.amountSaved();
        assertEquals(0.0, amount, .01);
    }

    @Test
    public void amountSaved2() throws UnderAgeException {
        double amount = cart16.amountSaved();
        assertEquals(1.0, amount, .01);
    }

    @Test
    public void amountSaved3() throws UnderAgeException {
        double amount = cart5.amountSaved();
        assertEquals(-6.0, amount, .01);
    }

    @Test
    public void amountSave4() throws UnderAgeException {
        double amount = cart17.amountSaved();
        assertEquals(0.0, amount, .01);
    }

    @Test
    public void amountSave5() throws UnderAgeException {
        double amount = cart17.amountSaved();
        assertNotNull(amount);
    }

    @Test
    public void amountSave6() throws UnderAgeException {
        double amount = cart17.amountSaved();
        assertNotEquals(cart1Expected, amount);
    }

    @Test
    public void getAzTax() {
        assertEquals(4.0, cart.getTax(50, "AZ"), .01);
    }

    @Test
    public void getAzTax2() {
        assertNotEquals(4.0, cart.getTax(44, "AZ"), .01);
    }

    @Test
    public void getCaTax() {
        assertEquals(1.8, cart.getTax(20, "CA"), .01);
    }

    @Test
    public void getCaTax2() {
        assertNotEquals(4.0, cart.getTax(3, "CA"), .01);
    }

    @Test
    public void getNyTax() {
        assertEquals(2.1, cart.getTax(30, "NY"), .01);
    }

    @Test
    public void getNyTax2() {
        assertNotEquals(4.0, cart.getTax(5, "NY"), .01);
    }

    @Test
    public void getCoTax() {
        assertEquals(2.8, cart.getTax(40, "CO"), .01);
    }

    @Test
    public void getCoTax2() {
        assertNotEquals(4.0, cart.getTax(10, "CO"), .01);
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
        boolean p = cart15.RemoveItem(product);
        assertEquals(true, p);
    }

    @Test
    public void removeItem3() {
        boolean p = cart.RemoveItem(product2);
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
    public void calcCostCart14() throws UnderAgeException {
        double amount = cart14.calcCost();
        assertEquals(cart14Expected, amount, .01);
    }

    @Test
    public void caclCostCart15() throws UnderAgeException {
        double amount = cart2.calcCost();
        assertNotEquals(cart3Expected, amount, .01);
    }

    @Test
    public void caclCostCart16() throws UnderAgeException {
        double amount = cart4.calcCost();
        assertNotEquals(cart5Expected, amount, .01);
    }

    @Test
    public void caclCostCart18() throws UnderAgeException {
        double amount = cart18.calcCost();
        assertEquals(7.56, amount, .01);
    }

}
