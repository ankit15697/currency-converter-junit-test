package com.currency.test;

import com.currency.controller.Controller;
import com.currency.model.CurrencyData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

// This class is to check method on many data
@RunWith(Parameterized.class)
public class CurrencyConversionParameterizedTest {
    private String sourceCurrency;
    private String targetCurrency;
    private double amount;
    private CurrencyData expected;

    // constructor
    public CurrencyConversionParameterizedTest(String sourceCurrency, String targetCurrency, double amount, CurrencyData expected) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]
                {
                        {"USD", "INR", 20, new CurrencyData("INR", 1428.5714)},
                        {"CAD", "INR", 20, new CurrencyData("INR", 1085.7148)},
                        {"CDF", "INR", 20, new CurrencyData("INR", 0.7285)},
                        {"CHF", "INR", 20, new CurrencyData("INR", 1585.7142)},
                        {"INR", "CHF", 2000, new CurrencyData("CHF", 28.2252)}
                };
        return Arrays.asList(data);
    }

    // All test cases are valid except last one
    @Test
    public void testConverter(){
        Controller controller = new Controller();
        CurrencyData actual = controller.convertCurrencies(sourceCurrency, targetCurrency, amount);
        assertEquals(expected, actual);
    }



}
