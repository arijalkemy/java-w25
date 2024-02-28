public class Texto {
    private int len;
    private String data;

    public Texto(int len, String data) {
        this.len = len;
        this.data = data;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Texto{" +
                "len=" + len +
                ", data='" + data + '\'' +
                '}';
    }
}
