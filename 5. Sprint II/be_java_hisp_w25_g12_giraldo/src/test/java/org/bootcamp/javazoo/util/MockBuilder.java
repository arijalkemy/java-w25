package org.bootcamp.javazoo.util;

import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockBuilder {
    public static List<User> usersBuilder() {
        User user1 = new User(1, "Homero Simpson");
        user1.addFollowed(6);
        user1.addFollowed(7);
        user1.addFollowed(8);

        User user2 = new User(2, "Jack Sparrow");
        user2.addFollowed(6);
        user2.addFollowed(9);
        user2.addFollowed(8);

        User user3 = new User(3, "Mario Bross");
        user3.addFollowed(6);
        user3.addFollowed(8);

        User user4 = new User(4, "Bender Doblador Rodriguez");
        user4.addFollowed(6);
        user4.addFollowed(9);

        User user5 = new User(5, "Sheldon Cooper");
        return new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
    }

    public static List<Seller> sellersBuilder() {
        Seller seller6 = new Seller(6, "Willy Wonka", new ArrayList<>(List.of(1,2,3,4)), Arrays.asList(0, 2));
        Seller seller7 = new Seller(7, "Indiana Jones", new ArrayList<>(List.of(1)), Arrays.asList(1, 3, 4));
        Seller seller8 = new Seller(8, "Tony Stark", new ArrayList<>(List.of(3, 1, 2)), Arrays.asList(7, 8));
        Seller seller9 = new Seller(9, "Bruce Wayne", new ArrayList<>(List.of(4, 2)), List.of(6));
        Seller seller10 = new Seller(10, "Peter Parker", List.of(), List.of(5));

        return new ArrayList<>(Arrays.asList(seller6, seller7, seller8, seller9, seller10));
    }

    public static List<Post> postsBuilder() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Post post0 = new Post(0, LocalDate.parse("27-02-2024", formatter), new Product(100, "Barra de Chocolate", "Comida", "Industrias Wonka", "Marrón", "Deliciosa barra de chocolate mágica con la posibilidad de encontrar un billete dorado"), 1, 2.99);
        Post post1 = new Post(1, LocalDate.parse("26-02-2024", formatter), new Product(101, "Artefacto Antiguo", "Antigüedades", "Civilizaciones Perdidas", "Oro", "Artefacto raro y misterioso descubierto durante una expedición aventurera"), 2, 9999.99);
        Post post2 = new Post(2, LocalDate.parse("25-02-2024", formatter), new Product(102, "Gobstopper Eterno", "Dulce", "Industrias Wonka", "Multicolor", "Un caramelo que nunca se desvanece, nunca se disuelve y nunca pierde su sabor"), 1, 0.99);
        Post post3 = new Post(3, LocalDate.parse("24-02-2024", formatter), new Product(103, "Sombrero Fedora", "Ropa", "Equipo del Aventurero", "Marrón", "Sombrero icónico usado por el arqueólogo más renombrado del mundo"), 3, 59.99);
        Post post4 = new Post(4, LocalDate.parse("23-02-2024", formatter), new Product(104, "Látigo", "Accesorio", "Equipo del Aventurero", "Negro", "Herramienta esencial para cualquier aventurero, perfecta para navegar por terrenos peligrosos"), 3, 29.99);
        Post post5 = new Post(5, LocalDate.parse("22-02-2024", formatter), new Product(105, "Traje de Spider-Man", "Disfraz", "Innovaciones Parker", "Rojo y Azul", "Traje de alta tecnología diseñado por Peter Parker para mejorar la agilidad y la fuerza"), 4, 199.99);
        Post post6 = new Post(6, LocalDate.parse("21-02-2024", formatter), new Product(106, "Batimóvil", "Vehículo", "Empresas Wayne", "Negro", "El vehículo definitivo equipado con tecnología de punta para la justicia vigilante"), 5, 250000.00);
        Post post7 = new Post(7, LocalDate.parse("20-02-2024", formatter), new Product(107, "Reactor Arc", "Tecnología", "Industrias Stark", "Plata", "Fuente de energía limpia capaz de alimentar desde un corazón hasta un rascacielos"), 6, 5000.00);
        Post post8 = new Post(8, LocalDate.parse("19-02-2024", formatter), new Product(108, "Traje de Iron Man", "Armadura", "Industrias Stark", "Rojo y Oro", "Traje exoesqueleto avanzado que proporciona fuerza sobrehumana y capacidad de vuelo"), 4, 150000.00);

        return new ArrayList<>(Arrays.asList(post0, post1, post2, post3, post4, post5, post6, post7, post8));
    }
}
