package com.bethune.demofromationapirest.service.imp;

import com.bethune.demofromationapirest.dto.ClientDTO;
import com.bethune.demofromationapirest.exception.CustomNotFoundException;
import com.bethune.demofromationapirest.model.Client;
import com.bethune.demofromationapirest.repository.ClientRepository;
import com.bethune.demofromationapirest.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClient() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public ClientDTO getClientById(int id) throws Exception {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(!clientOptional.isPresent()) {
            throw new CustomNotFoundException();
        }
        return new ModelMapper().map(clientOptional.get(), ClientDTO.class);
    }

    @Override
    public Client updateClient(Client client, int id) {
        Client clientExist = clientRepository.findById(id).get();
        clientExist.setNom(client.getNom());
        clientExist.setPrenom(client.getPrenom());
        clientExist.setTelephone(client.getTelephone());
        return clientRepository.save(clientExist);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean deleteClient(int id) {
        Client clientExist = clientRepository.findById(id).get();
        clientRepository.delete(clientExist);
        return true;
    }
}
