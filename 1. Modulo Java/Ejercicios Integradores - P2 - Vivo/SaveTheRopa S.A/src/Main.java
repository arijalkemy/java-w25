import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Clothing clothing1 = new Clothing("Nike", "Buzo");
        Clothing clothing2 = new Clothing("Adidas", "Zapatos");

        Wardrobe wardrobe = new Wardrobe();
        Integer id = wardrobe.storeClothes(Arrays.asList(clothing1, clothing2));

        System.out.println("Prendas guardadas en el guardaropa, id: " + id);
        wardrobe.showClothes();

        System.out.println("\nMostrar Prendas");
        wardrobe.returnClothes(id).forEach(System.out::println);

    }
}