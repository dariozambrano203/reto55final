package co.usa.proyecto5.proyecto5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.proyecto5.proyecto5.model.Cliente;
import co.usa.proyecto5.proyecto5.repository.ClienteRepositorio;


@Service
public class ClienteServicio {
    @Autowired
     private ClienteRepositorio metodosCrud2;
     
     public List<Cliente> getAll(){
        return metodosCrud2.getAll();
    }
     
      public Optional<Cliente> getClient(int clientId) {
        return metodosCrud2.getCliente(clientId);
    }

    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud2.save(client);
        }else{
            Optional<Cliente> e= metodosCrud2.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud2.save(client);
            }else{
                return client;
            }
        }
    }

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud2.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud2.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud2.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

