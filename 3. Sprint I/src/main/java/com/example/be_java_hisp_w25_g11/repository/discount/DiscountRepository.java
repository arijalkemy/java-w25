package com.example.be_java_hisp_w25_g11.repository.discount;

import com.example.be_java_hisp_w25_g11.entity.Discount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Repository
public class DiscountRepository  implements IDiscountRepository{
    private final List<Discount> dataSource;

    public DiscountRepository() {
        this.dataSource = new ArrayList<>();
    }


    @Override
    public List<Discount> getAll() {
        return this.dataSource;
    }

    @Override
    public List<Discount> createAll(List<Discount> entities) {
        return null;
    }

    @Override
    public Discount create(Discount discount) {
        this.dataSource.add(discount);
        return discount;
    }

    @Override
    public Optional<Discount> get(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean update(Integer integer, Discount discount) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean existing(Integer integer) {
        return false;
    }
}
