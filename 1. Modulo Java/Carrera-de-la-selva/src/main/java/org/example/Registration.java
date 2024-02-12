package org.example;

public class Registration {
    private int registrationNumber;
    private Category category;
    private Competitor competitor;
    private int payment;

    public Registration(int registrationNumber, Category category, Competitor competitor) {
        this.registrationNumber = registrationNumber;
        this.category = category;
        this.competitor = competitor;
        this.payment = calculatePayment(competitor.getAge(),category.getName());
    }

    private int calculatePayment(int age, String categoryName) {//throws IllegalArgumentException{
        if(age < 18){
            switch (categoryName){
                case "Circuito chico":
                    return 1300;
                case "Circuito medio":
                    return 2000;
                case "Circuito avanzado":
                    System.out.println("No se permite inscripciones a menores de 18 años.");
                    //throw new IllegalArgumentException("No se permite inscripciones a menores de 18 años.");
                    break;
                default:
                    System.out.println("El circuito no existe ");
                    break;
            }
        }else {
            switch (categoryName){
                case "Circuito chico":
                    return 1500;
                case "Circuito medio":
                    return 2300;
                case "Circuito avanzado":
                    return 2800;
                default:
                    System.out.println("El circuito no existe ");
                    break;
            }
        }

        return 0;
    }

//    GettersAndSetters
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public Category getCategory() {
        return category;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public int getPayment() {
        return payment;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
