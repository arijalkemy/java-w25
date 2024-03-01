package org.socialmeli.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.entity.Client;
import org.socialmeli.repository.implementation.ClientRepositoryImp;
import org.socialmeli.repository.implementation.VendorRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ClientRepositoryImpTest {
    @Autowired
    VendorRepositoryImp vendorRepositoryImp;
    @Autowired
    ClientRepositoryImp clientRepositoryImp;
    
    //Tests unitarios del repositorio
    

    @Test
    @DisplayName("findAllOk")
    void testFindAll() {
        List<Client> allClients = clientRepositoryImp.findAll();
        assertNotNull(allClients);
        assertEquals(4, allClients.size());
    }


    @Test
    @DisplayName("saveUserOK")
    void testSave() {
    Integer expectedId = 5;
    Client client = new Client();

    Integer savedUserId = clientRepositoryImp.save(client);

    assertNotNull(savedUserId);
    assertNotEquals(expectedId, savedUserId);
    }

    @Test
    @DisplayName("findOneUserOK")
    void testFindOne() {
    Client client = new Client();
    client.setUserName("Test User");

    Integer savedUserId = clientRepositoryImp.save(client);

    Client foundClient = clientRepositoryImp.findOne(savedUserId);

    assertNotNull(foundClient);
    assertEquals(savedUserId, foundClient.getUserId());
    }

    @Test
    @DisplayName("deleteUserOK")
    void testDeleteOne() {
    Client client = new Client();
    client.setUserName("Test User");

    Integer savedUserId = clientRepositoryImp.save(client);

    clientRepositoryImp.deleteOne(savedUserId);

    Client deletedClient = clientRepositoryImp.findOne(savedUserId);

    assertNull(deletedClient);
    }
}
