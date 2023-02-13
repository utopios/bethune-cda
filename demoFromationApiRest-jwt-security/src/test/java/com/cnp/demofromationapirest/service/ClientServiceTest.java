package com.cnp.demofromationapirest.service;

import com.cnp.demofromationapirest.model.Client;
import com.cnp.demofromationapirest.repository.ClientRepository;
import com.cnp.demofromationapirest.service.imp.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    public void testGetAllClient() {
        //Code du test unitaire
        //AAA
        //Arange
        //Préparer l'objet pour récupérer les clients
        //Création d'un clientService
        //La réalisation du mock des repositories
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("toto","tata", "01010101010"));
        clients.add(new Client("minet","titi", "01010101010"));
        when(clientRepository.findAll()).thenReturn(clients);

        //Act
        //Lancer la méthode de récupération
        List<Client> result = clientService.getAllClient();
        //Assert
        //Comparer le resultat de la méthode avec le resultat prévu.
        assertEquals(2,result.size());
    }
}
