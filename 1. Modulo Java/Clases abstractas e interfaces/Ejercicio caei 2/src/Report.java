public class Report implements Printable {
    private String text;
    private int amountPages;
    private String author;
    private String revisor;

    public Report(String text, int amountPages, String author, String revisor) {
        this.text = text;
        this.amountPages = amountPages;
        this.author = author;
        this.revisor = revisor;
    }

    @Override
    public void print() {
        System.out.println("Report{" +
                "text='" + text + '\'' +
                ", amountPages=" + amountPages +
                ", author='" + author + '\'' +
                ", revisor='" + revisor + '\'' +
                '}'
        );
    }
}
