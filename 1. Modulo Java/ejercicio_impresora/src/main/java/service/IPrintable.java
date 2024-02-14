package service;

public interface IPrintable {
    public static void print(IPrintable printable) {
        System.out.println(printable.toString());
    }

}
