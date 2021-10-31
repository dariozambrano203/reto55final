package co.usa.proyecto5.proyecto5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.proyecto5.proyecto5.model.Mensaje;
import co.usa.proyecto5.proyecto5.repository.crud.MensajeCrudRepositorio;

@Repository
public class MensajeRepositorio {
    @Autowired
    private MensajeCrudRepositorio crud3;
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud3.findAll();
    }
    public Optional<Mensaje> getMessage(int id){
        return crud3.findById(id);
    }

    public Mensaje save(Mensaje message){
        return crud3.save(message);
    }
    public void delete(Mensaje message){
        crud3.delete(message);
    }
    
}

