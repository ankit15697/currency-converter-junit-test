package com.currency.test;

import com.currency.controller.Controller;
import com.currency.exceptions.CurrencyNotFoundException;
import com.currency.model.CurrencyData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

// This class will do mocking related activity
public class CurrencyControllerMockTest {
    @Mock
    Controller controller;
    CurrencyData result;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        result = new CurrencyData("INR", 1428.57);
    }

    @Test
    public void testConvertCurrenciesMethod() {

        // Mocking the convertCurrencies Method
        when(controller.convertCurrencies(any(String.class), any(String.class), any(Double.class))).
                thenReturn(result);
        CurrencyData currencyData = controller.convertCurrencies("USD", "INR", 200);

        // To check mocking happened or not
        assertEquals(currencyData, result);
    }

    // this method is to throw an exception
    @Test(expected = CurrencyNotFoundException.class)
    public void testException() {

        // Mocking the convertCurrencies Method
        when(controller.convertCurrencies(any(String.class), any(String.class), any(Double.class))).
                thenThrow(CurrencyNotFoundException.class);
        CurrencyData currencyData = controller.convertCurrencies("USD", "INR", 20);

    }
}
