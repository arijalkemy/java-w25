public class Main {
    public static void main(String[] args) {
        String finalMessage = "Este es el último mensaje";

        try  {
            int[] numbers = new int[5];
            numbers[5] = 10;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            System.out.println(finalMessage);
        }
    }
}
