package entity;

public class Inscription {
    private int num;
    private Category category;
    private double amount;
    private Competitor competitor;

    public Inscription(int num, Category category, Competitor competitor){
        this.num = num;
        this.category = category;
        this.competitor = competitor;
        if (category.getId() == 3 && competitor.getAge() < 18) {
            throw new IllegalArgumentException( "Underage competitor not allowed for Category 3");
        }
        calculateAmount();
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "num=" + num +
                ", category=" + category +
                ", amount=" + amount +
                ", competitor=" + competitor +
                '}';
    }

    private void calculateAmount(){
        if (this.category.getId() == 1){
            if (this.competitor.getAge() < 18) {
                this.amount = 1300;
            } else {
                this.amount = 1500;
            }
        } else if (this.category.getId() == 2){
            if (this.competitor.getAge() < 18) {
                this.amount = 2000;
            } else {
                this.amount = 2300;
            }
        }else if (this.category.getId() == 3){
            this.amount = 2800;
        }
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }
}
