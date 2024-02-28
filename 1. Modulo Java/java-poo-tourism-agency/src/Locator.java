import java.util.List;

public class Locator {
    private Client client;
    private List<Reserve> reserveList;

    private double total;

    public Locator(Client client, List<Reserve> reserveList) {
        this.client = client;
        this.reserveList = reserveList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Reserve> getReserveList() {
        return reserveList;
    }

    public void setReserveList(List<Reserve> reserveList) {
        this.reserveList = reserveList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Locator{" +
                "client=" + client +
                ", reserveList=" + reserveList +
                ", total=" + total +
                '}';
    }
}
