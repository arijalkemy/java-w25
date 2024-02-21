package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Objects;


public final class AddPostDto {
    @JsonProperty("user_id")
    private final Integer userId;
    @JsonProperty("date")
    private final LocalDate date;
    @JsonProperty("product")
    private final ProductDto product;
    @JsonProperty("category")
    private final Integer category;
    @JsonProperty("has_promo")
    private final boolean has_promo;
    @JsonProperty("discount")
    private final Double discount;
    @JsonProperty("price")
    private final Double price;

    public AddPostDto(
            @JsonProperty("user_id") Integer userId,
            @JsonProperty("date") LocalDate date,
            @JsonProperty("product") ProductDto product,
            @JsonProperty("category") Integer category,
            @JsonProperty("has_promo") boolean has_promo,
            @JsonProperty("discount") Double discount,
            @JsonProperty("price") Double price

    ) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.has_promo = has_promo;
        this.discount = discount;
        this.price = price;
    }

    @JsonProperty("user_id")
    public Integer userId() {
        return userId;
    }

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate date() {
        return date;
    }

    @JsonProperty("product")
    public ProductDto product() {
        return product;
    }

    @JsonProperty("category")
    public Integer category() {
        return category;
    }

    @JsonProperty("has_promo")
    public boolean has_promo() {
        return has_promo;
    }

    @JsonProperty("discount")
    public Double discount() {
        if (discount == null){ return 1.0;}
        return discount;
    }

    @JsonProperty("price")
    public Double price() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AddPostDto) obj;
        return Objects.equals(this.userId, that.userId) &&
                Objects.equals(this.date, that.date) &&
                Objects.equals(this.product, that.product) &&
                Objects.equals(this.category, that.category) &&
                this.has_promo == that.has_promo &&
                Objects.equals(this.discount, that.discount) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, date, product, category, has_promo, discount, price);
    }

    @Override
    public String toString() {
        return "AddPostDto[" +
                "userId=" + userId + ", " +
                "date=" + date + ", " +
                "product=" + product + ", " +
                "category=" + category + ", " +
                "has_promo=" + has_promo + ", " +
                "discount=" + discount + ", " +
                "price=" + price + ']';
    }

}
