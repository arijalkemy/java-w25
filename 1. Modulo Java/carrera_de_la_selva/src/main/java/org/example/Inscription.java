package org.example;

import static org.example.Main.categoryList;

public class Inscription {
    private String id;
    private Competitor competitor;
    private Category category;
    private int price;
    private static int determinePrice(Competitor competitor, Category category){
        int price = 0;
        if (competitor.getAge() < 18) {
            if(categoryList.get(0).getId().equals(category.getId())){
                price = 1300;
            } else if (categoryList.get(1).getId().equals(category.getId())) {
                price = 2000;
            } else if (categoryList.get(2).getId().equals(category.getId())) {
                throw new IllegalArgumentException("No se puede inscribir un menor de edad al circuito avanzado");
            }
        } else {
            if(categoryList.get(0).getId().equals(category.getId())) {
                price = 1500;
            } else if (categoryList.get(1).getId().equals(category.getId())) {
                price = 2300;
            } else if (categoryList.get(2).getId().equals(category.getId())) {
                price = 2800;
            }
        }
        return price;
    }
    public Inscription(String id, Competitor competitor, Category category) {
        this.id = id;
        this.competitor = competitor;
        this.category = category;
        this.price = determinePrice(competitor, category);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
