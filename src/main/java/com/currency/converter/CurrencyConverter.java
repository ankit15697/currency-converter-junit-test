package com.currency.converter;

import com.currency.model.CurrencyData;
import com.currency.model.CurrencyDataContainer;

// This class is responsible for converting the currencies
public class CurrencyConverter {
        private static CurrencyDataContainer currencyDataContainer = CurrencyDataContainer.getCurrencyDataContainer();

        public static CurrencyData convert(String sourceCurrency, String targetCurrency, double amount) {
            double sourceCurrencyInDollar = currencyDataContainer.getCurrencyObject(sourceCurrency).getCurrencyValue();
            double targetCurrencyInDollar = currencyDataContainer.getCurrencyObject(targetCurrency).getCurrencyValue();

            return new CurrencyData(targetCurrency, (sourceCurrencyInDollar/ targetCurrencyInDollar *amount));
        }
}
