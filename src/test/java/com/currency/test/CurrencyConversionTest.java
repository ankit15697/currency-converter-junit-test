package com.currency.test;

import com.currency.controller.Controller;
import com.currency.exceptions.CurrencyNotFoundException;
import com.currency.model.CurrencyData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// This class will test following cases
/*
* Valid Case
* Invalid Case
* Exception Case
* */
public class CurrencyConversionTest {
    private Controller controller;

    @Before
    public void setUp(){
        controller = new Controller();
    }
    @Test
    // This is for valid test case
    public void testValid() {
        CurrencyData result = controller.convertCurrencies("USD", "INR",20);
        CurrencyData expected = new CurrencyData("INR",1428.5714);

        assertEquals(expected, result);
    }

    // This is for invalid test case
    @Test
    public void testInvalid() {
        CurrencyData result = controller.convertCurrencies("USD", "INR",20);
        CurrencyData expected = new CurrencyData("INR",1427.5714);
        assertEquals(expected, result);
    }

    // This test case is for Exception
    @Test(expected = CurrencyNotFoundException.class)
    public void testException(){
        // Invalid currency ABC
        CurrencyData result = controller.convertCurrencies("ABC", "INR",20);
        CurrencyData expected = new CurrencyData("INR",1427.5714);
    }

    @After
    public void release(){
        controller = null;
    }
}
