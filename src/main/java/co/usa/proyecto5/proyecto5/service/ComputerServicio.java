package co.usa.proyecto5.proyecto5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.proyecto5.proyecto5.model.Computer;
import co.usa.proyecto5.proyecto5.repository.ComputerRepositorio;



@Service
public class ComputerServicio {
    @Autowired
    private ComputerRepositorio metodosCrud;

    public List<Computer>getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Computer>getComputer(int computerId) {
        return metodosCrud.getComputer(computerId);
    }

    public Computer save(Computer computer){
        if (computer.getId()==null){
            return metodosCrud.save(computer);
        }else{
            Optional<Computer> consulta=metodosCrud.getComputer(computer.getId());
            if(consulta.isEmpty()){
                return metodosCrud.save(computer);
            }else{
                return computer;
            }
        }
    }

    public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> consulta1=metodosCrud.getComputer(computer.getId());
            if(!consulta1.isEmpty()){
                if(computer.getName()!=null){
                    consulta1.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    consulta1.get().setBrand(computer.getBrand());
                }
                if(computer.getYear()!=null){
                    consulta1.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    consulta1.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    consulta1.get().setCategory(computer.getCategory());
                }
                metodosCrud.save(consulta1.get());
                return consulta1.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteComputer(int computerId) {
        Boolean aBoolean = getComputer(computerId).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

