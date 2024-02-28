public class Inscription {
    private int id;
    private Category category;

    private Participant participant;

    public Inscription(Category category, Participant participant) {
        this.id = generateId();
        this.category = category;
        this.participant = participant;
    }

    public int getId() {
        return id;
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

    private int generateId(){
        return (int) (Math.floor(Math.random()*(99999999-10000000+1)+10000000));
    }

    public int getAmount () {
        if(this.participant.getAge() >= 18)
            return this.category.getMaxAmount();
        else
            return this.category.getMinAmount();
    }
}
