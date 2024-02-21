public class App {
    public static void main(String[] args) throws Exception {
        int[] array = {1,2,3,4,5};
        array = Ejercicio1.burbuja(array);

        for(Integer elem:array){
            System.out.println(elem);
        }
    }
}
