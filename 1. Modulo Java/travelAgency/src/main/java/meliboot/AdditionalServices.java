package meliboot;

public class AdditionalServices {
    private int foodTicketsAmount;
    private int travelTicketsAmount;
    private int transportTicketAmount;

    public AdditionalServices(int foodTicketsAmount, int travelTicketsAmount, int transportTicketAmount) {
        this.foodTicketsAmount = foodTicketsAmount;
        this.travelTicketsAmount = travelTicketsAmount;
        this.transportTicketAmount = transportTicketAmount;
    }

    public int getFoodTicketsAmount() {
        return foodTicketsAmount;
    }

    public int getTravelTicketsAmount() {
        return travelTicketsAmount;
    }

    public int getTransportTicketAmount() {
        return transportTicketAmount;
    }
}
