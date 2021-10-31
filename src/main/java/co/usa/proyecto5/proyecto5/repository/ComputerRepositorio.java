package co.usa.proyecto5.proyecto5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.proyecto5.proyecto5.model.Computer;
import co.usa.proyecto5.proyecto5.repository.crud.ComputerCrudRepositorio;

@Repository
public class ComputerRepositorio {
    @Autowired
    private ComputerCrudRepositorio crud;

    public List<Computer> getAll(){
        return (List<Computer>) crud.findAll();
    }

    public Optional<Computer> getComputer(int id){
        return crud.findById(id);
    }

    public Computer save(Computer computer){
        return crud.save(computer);
    }

    public void delete(Computer computer){
        crud.delete(computer);
    }
    
}
