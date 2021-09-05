package com.capgemini.market.domain.service;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(Integer clientId){

        return clientRepository.getClient(clientId);
    }
    public Client save(Client client){

        return clientRepository.save(client);
    }
    public boolean delete(Integer clientId){
        return getClient(clientId).map(client -> {
            clientRepository.delete(clientId);
            return true;
        }).orElse(false);
        /*
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else {
            return false;
        }*/
    }



}
