package objects;

public class Inscription {
    private Long inscriptionNumber;
    private Category category;
    private Competitor competitor;
    private Double price;
    
    public Inscription(Long inscriptionNumber, Category category, Competitor competitor) {
        this.inscriptionNumber = inscriptionNumber;
        this.category = category;
        this.competitor = competitor;
        if(this.category.getId() == 1 && this.competitor.getAge() < 18){
            this.price = Double.valueOf(1300);
        }else{
            this.price = Double.valueOf(1300);
        }
        if(this.category.getId() == 3){
            this.price = Double.valueOf(2800);
        }
    }
    
    public Long getInscriptionNumber() {
        return inscriptionNumber;
    }
    public void setInscriptionNumber(Long inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Competitor getCompetitor() {
        return competitor;
    }
    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
