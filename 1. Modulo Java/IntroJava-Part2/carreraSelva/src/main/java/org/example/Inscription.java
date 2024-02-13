package org.example;

import java.util.List;

public class Inscription{
    private int inscriptionNumber;
    private Category category;
    private Participant participant;
    private int amount;

    public Inscription(int inscriptionNumber, Category category, Participant participant) {
        this.inscriptionNumber = inscriptionNumber;
        this.category = category;
        this.participant = participant;
        calculateAmount();
    }

    public int getInscriptionNumber() {
        return inscriptionNumber;
    }

    public void setInscriptionNumber(int inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void calculateAmount(){
        switch (this.category.id){
            case 1: {
                if (this.participant.age >= 18) {
                    this.amount = 1500;
                } else {
                    this.amount = 1300;
                }
                break;
            }
            case 2:{
                if (this.participant.age >= 18) {
                    this.amount = 2300;
                } else {
                    this.amount = 2000;
                }
                break;
            }

            case 3:{
                if (this.participant.age >= 18) {
                    this.amount = 2800;
                } else {
                    this.amount = -1;
                }
                break;
            }
        }


    }
}
