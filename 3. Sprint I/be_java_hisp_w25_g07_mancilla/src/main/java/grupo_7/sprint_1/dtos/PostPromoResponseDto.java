package grupo_7.sprint_1.dtos;

public record PostPromoResponseDto(
        int userId,
        String userName,
        int count
) {
    @Override
    public String toString() {
        return "user_id:" + userId +
                ", user_name:'" + userName + '\'' +
                ", promo_products_count:" + count;
    }
}

