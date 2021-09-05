package com.capgemini.market.persistence;

import com.capgemini.market.persistence.crud.ClienteCrudRepository;
import com.capgemini.market.persistence.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Repository
public class ClienteRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;


    public List<Cliente> getAll(){
        return (List<Cliente>) clienteCrudRepository.findAll();
    }
    //El metodo save actualiza y guarda
    public void save(Cliente cliente){
        clienteCrudRepository.save(cliente);
    }
    public void deleteById(Integer id){

        clienteCrudRepository.deleteById(String.valueOf(id));
    }
    public Long getClintCount(){
        return clienteCrudRepository.count();
    }
    //named Qquery

}
