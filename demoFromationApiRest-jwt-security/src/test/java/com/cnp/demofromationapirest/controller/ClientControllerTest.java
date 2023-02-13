package com.cnp.demofromationapirest.controller;

import com.cnp.demofromationapirest.DemoFromationApiRestApplication;
import com.cnp.demofromationapirest.model.Client;
import com.cnp.demofromationapirest.service.ClientService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.*;


@ContextConfiguration(classes = DemoFromationApiRestApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;


    @Mock
    private ClientService clientService;
    @InjectMocks
    private ClientController clientController;

    @Before
    public void setup() {
        //Construire le mock de notre application avant chaque test.
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void verifyGetAllClients() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/clients")).andExpect(jsonPath("$", hasSize(3)));
    }

    @org.junit.Test
    public void verifyCreateClient() throws Exception {
        doNothing().when(clientService).createClient(any(Client.class));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/clients/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\" : \"Michel\", \"prenom\" : \"Tom\", \"telephone\" : \"0123456789\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.bom").value("Michel"))
                .andExpect(jsonPath("$.prenom").value("Tom"))
                .andDo(print());

    }
}
