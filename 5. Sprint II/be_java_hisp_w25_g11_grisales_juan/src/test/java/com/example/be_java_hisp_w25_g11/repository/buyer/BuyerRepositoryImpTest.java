package com.example.be_java_hisp_w25_g11.repository.buyer;

import com.example.be_java_hisp_w25_g11.entity.Buyer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuyerRepositoryImpTest {
    private IBuyerRepository buyerRepository;

    @BeforeEach
    void setup() {
        buyerRepository = new BuyerRepositoryImp();
    }

    @Test
    void testGetAllOk() {
        // Arrange
        List<Buyer> buyers = List.of(
            new Buyer(1, "Buyer 1"),
            new Buyer(2, "Buyer 2"),
            new Buyer(3, "Buyer 3")
        );
        buyerRepository.createAll(buyers);
        // Act
        List<Buyer> actualBuyers = buyerRepository.getAll();
        // Assert
        assertEquals(buyers.size(), actualBuyers.size());
        assertIterableEquals(buyers, actualBuyers);
    }

    @Test
    void testCreateAllOk() {
        // Arrange
        List<Buyer> buyers = List.of(
                new Buyer(1, "Buyer 1"),
                new Buyer(2, "Buyer 2"),
                new Buyer(3, "Buyer 3")
        );
        buyerRepository.createAll(buyers);
        // Act
        List<Buyer> actualBuyers = buyerRepository.getAll();
        // Assert
        assertEquals(buyers.size(), actualBuyers.size());
        assertIterableEquals(buyers, actualBuyers);
    }

    @Test
    void testCreateOk() {
        // Arrange
        Integer buyerId = 1;
        Buyer buyer = new Buyer(buyerId, "Buyer 1");
        // Act
        buyerRepository.create(buyer);
        Buyer actualBuyer = buyerRepository.get(buyerId).orElse(null);
        // Assert
        assertEquals(buyer, actualBuyer);
    }

    @Test
    void testGetOk() {
        // Arrange
        Integer buyerId = 1;
        Buyer buyer = new Buyer(buyerId, "Buyer 1");
        buyerRepository.create(buyer);
        // Act
        Buyer actualBuyer = buyerRepository.get(buyerId).orElse(null);
        // Assert
        assertEquals(buyer, actualBuyer);
    }

    @Test
    void testUpdateOk() {
        // Arrange
        Integer buyerId = 1;
        Buyer buyer = new Buyer(buyerId, "Buyer 1");
        Buyer updatedBuyer = new Buyer(buyerId, "Buyer 1 updated");
        buyerRepository.create(buyer);
        // Act
        buyerRepository.update(buyerId, updatedBuyer);
        Buyer actualBuyer = buyerRepository.get(buyerId).orElse(null);
        // Assert
        assertEquals(updatedBuyer, actualBuyer);
    }

    @Test
    void testDeleteOk() {
        // Arrange
        Integer buyerId = 1;
        List<Buyer> buyers = List.of(
                new Buyer(1, "Buyer 1"),
                new Buyer(2, "Buyer 2"),
                new Buyer(3, "Buyer 3")
        );
        buyerRepository.createAll(buyers);
        Integer expectedSize = buyers.size() - 1;
        // Act
        buyerRepository.delete(buyerId);
        Buyer actualBuyer = buyerRepository.get(buyerId).orElse(null);
        // Assert
        assertNull(actualBuyer);
        assertEquals(expectedSize, buyerRepository.getAll().size());
    }

    @Test
    void testExistingOk() {
        // Arrange
        Integer buyerId = 1;
        Buyer buyer = new Buyer(buyerId, "Buyer 1");
        buyerRepository.create(buyer);
        // Act
        boolean existing = buyerRepository.existing(buyerId);
        // Assert
        assertTrue(existing);
    }
}