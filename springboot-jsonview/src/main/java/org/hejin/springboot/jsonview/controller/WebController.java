package org.hejin.springboot.jsonview.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hejin.springboot.jsonview.model.Company;
import org.hejin.springboot.jsonview.model.Product;
import org.hejin.springboot.jsonview.view.View;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/")
public class WebController {

    private Company apple;
    private Product iphone;
    private Product ipad;

    @PostConstruct
    public void initial() {
        iphone = new Product(1, "iphone");
        ipad = new Product(2, "ipad");
        List<Product> appleProducts = new ArrayList<Product>(Arrays.asList(iphone, ipad));
        apple = new Company(1, "Apple", appleProducts);
        iphone.setCompany(apple);
        ipad.setCompany(apple);
    }

    @GetMapping("/company")
    public Company getCompany() {
        return apple;
    }

    @GetMapping("/product")
    public Product getProduct() {
        return iphone;
    }

    @JsonView(View.OveralView.class)
    @GetMapping("/company/overalview")
    public Company getOveralViewCompany() {
        return apple;
    }

    @JsonView(View.DetailView.class)
    @GetMapping("/company/detailview")
    public Company getDetailViewCompany() {
        return apple;
    }

    @JsonView(View.ProductView.class)
    @GetMapping("/product/view")
    public Product getProductView() {
        return iphone;
    }
}
