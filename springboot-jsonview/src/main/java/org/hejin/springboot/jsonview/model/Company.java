package org.hejin.springboot.jsonview.model;

import java.util.List;

import org.hejin.springboot.jsonview.view.View;

import com.fasterxml.jackson.annotation.JsonView;

public class Company {

    @JsonView(View.DetailView.class)
    private int id;
    @JsonView({View.OveralView.class, View.ProductView.class})
    private String name;
    @JsonView(View.OveralView.class)
    private List<Product> products;

    public Company() {

    }

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
