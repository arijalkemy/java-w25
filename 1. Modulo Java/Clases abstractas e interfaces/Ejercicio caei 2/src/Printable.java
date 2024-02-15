public interface Printable {
    void print();

    static void printDocument(Printable printable) {
        printable.print();
    }
}
