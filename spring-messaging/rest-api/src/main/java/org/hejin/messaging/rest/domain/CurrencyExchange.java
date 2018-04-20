package org.hejin.messaging.rest.domain;

import java.util.Arrays;

public class CurrencyExchange {
    public static final String BASE_CODE = "USD";
    private String base;
    private String date;
    private Rate[] rates;

    public CurrencyExchange(String base, String date, Rate[] rates) {
        super();
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public CurrencyExchange() {
        super();
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rate[] getRates() {
        return rates;
    }

    public void setRates(Rate[] rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CurrencyExchange [base=");
        builder.append(base);
        builder.append(", date=");
        builder.append(date);
        builder.append(", rates=");
        builder.append(Arrays.toString(rates));
        builder.append("]");
        return builder.toString();
    }
}
