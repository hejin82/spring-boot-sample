package org.hejin.springboot.jsonview.model;

import org.hejin.springboot.jsonview.view.View;

import com.fasterxml.jackson.annotation.JsonView;

public class Product {

    @JsonView(View.DetailView.class)
    private int id;
    @JsonView({View.OveralView.class, View.ProductView.class})
    private String name;
    @JsonView(View.ProductView.class)
    private Company company;

    public Product() {

    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(int id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
