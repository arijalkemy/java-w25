package org.bootcamp.javazoo.helper;

import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterListByWeekUnitTest {
    @Test
    @DisplayName("T0008 filterPostsByWeeksAgo -> when weeks is 2 then return a list of posts from the last two weeks")
    void filterPostsByWeeksAgoTest() {
        //Arrange
        int weeks = 2;
        List<Post> posts = new ArrayList<>();
        Post post0 = new Post(0, LocalDate.now(), new Product(100, "Barra de Chocolate", "Comida", "Industrias Wonka", "Marrón", "Deliciosa barra de chocolate mágica con la posibilidad de encontrar un billete dorado"), 1, 2.99);
        Post post1 = new Post(1, LocalDate.now().minusDays(13), new Product(101, "Artefacto Antiguo", "Antigüedades", "Civilizaciones Perdidas", "Oro", "Artefacto raro y misterioso descubierto durante una expedición aventurera"), 2, 9999.99);
        Post post2 = new Post(2, LocalDate.now().minusDays(13), new Product(102, "Gobstopper Eterno", "Dulce", "Industrias Wonka", "Multicolor", "Un caramelo que nunca se desvanece, nunca se disuelve y nunca pierde su sabor"), 1, 0.99);
        Post post3 = new Post(3, LocalDate.now().minusWeeks(3), new Product(103, "Sombrero Fedora", "Ropa", "Equipo del Aventurero", "Marrón", "Sombrero icónico usado por el arqueólogo más renombrado del mundo"), 3, 59.99);
        Post post4 = new Post(4, LocalDate.now().minusWeeks(4), new Product(104, "Látigo", "Accesorio", "Equipo del Aventurero", "Negro", "Herramienta esencial para cualquier aventurero, perfecta para navegar por terrenos peligrosos"), 3, 29.99);
        Collections.addAll(posts, post0, post1, post2, post3, post4);

        //act
        List<Post> postFiltered = FilterListByWeeks.filterPostsByWeeksAgo(weeks, posts);

        //assert
        assertEquals(3, postFiltered.size());
    }
}
