package org.hejin.messaging.rest.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rate {

    @Id
    private String code;
    private Float rate;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    private Date date;

    public Rate() {
        super();
    }

    public Rate(String code, Float rate, Date date) {
        super();
        this.code = code;
        this.rate = rate;
        this.date = date;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rate [code=");
        builder.append(code);
        builder.append(", rate=");
        builder.append(rate);
        builder.append(", date=");
        builder.append(date);
        builder.append("]");
        return builder.toString();
    }


}
