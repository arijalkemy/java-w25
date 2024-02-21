package org.socialmeli.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class VendorRepositoryImp implements IRepository<Vendor> {
    private List<Vendor> vendors = new ArrayList<>();

    public VendorRepositoryImp() {
        Vendor vendor1 = new Vendor();
        Vendor vendor2 = new Vendor();
        Vendor vendor3 = new Vendor();
        Vendor vendor4 = new Vendor();
        Vendor vendor5 = new Vendor();

        vendor1.setUserName("Fernando Gómez");
        vendor2.setUserName("Alejandra Torres");
        vendor3.setUserName("Javier Hernández");
        vendor4.setUserName("José Cobra Mucho");
        vendor5.setUserName("Pablo Ricachón");

        this.save(vendor1);
        this.save(vendor2);
        this.save(vendor3);
        this.save(vendor4);
        this.save(vendor5);
    }

    private Integer autoIncrementId() {
        User.userIdCounter ++ ;
        return User.userIdCounter;
    }

    public List<Vendor> findAll() {
        return vendors;
    }

    public Integer save(Vendor vendor) {
        vendor.setUserId(autoIncrementId());
        vendors.add(vendor);
        return vendor.getUserId();
    }

    public Vendor findOne (Integer id) {
        return vendors.stream()
                .filter(client -> client.getUserId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteOne(Integer id) {
        vendors.removeIf(c -> c.getUserId().equals(id));
    }
}
