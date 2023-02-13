package com.bethune.demofromationapirest.service;


import com.bethune.demofromationapirest.dto.ClientDTO;
import com.bethune.demofromationapirest.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {


    public List<Client> getAllClient();

    public ClientDTO getClientById(int id) throws Exception;

    public Client updateClient(Client client, int id) ;

    public Client createClient(Client client);
    public boolean deleteClient(int id) ;
}
