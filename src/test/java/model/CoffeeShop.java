package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CoffeeShop {
    @JsonProperty ("coffee_shop")
    private String name;
    private List<Category> menu;

    public String getName() {
        return name;
    }

    public List<Category> getMenu() {
        return menu;
    }
}
