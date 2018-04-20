package org.hejin.messaging.rest.domain;

public class CurrencyConversion {
    private String base;
    private String code;
    private float amount;
    private float total;

    public CurrencyConversion() {
        super();
    }

    public CurrencyConversion(String base, String code, float amount, float total) {
        super();
        this.base = base;
        this.code = code;
        this.amount = amount;
        this.total = total;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CurrencyConversion [base=");
        builder.append(base);
        builder.append(", code=");
        builder.append(code);
        builder.append(", amount=");
        builder.append(amount);
        builder.append(", total=");
        builder.append(total);
        builder.append("]");
        return builder.toString();
    }
}
