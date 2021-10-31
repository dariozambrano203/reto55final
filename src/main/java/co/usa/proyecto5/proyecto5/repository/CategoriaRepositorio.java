package co.usa.proyecto5.proyecto5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.proyecto5.proyecto5.model.Categoria;
import co.usa.proyecto5.proyecto5.repository.crud.CategoriaCrudRepositorio;

@Repository
public class CategoriaRepositorio {
    @Autowired
    private CategoriaCrudRepositorio crud1;
    public List<Categoria> getAll(){
        return (List<Categoria>) crud1.findAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return crud1.findById(id);
    }

    public Categoria save(Categoria Categoria){
        return crud1.save(Categoria);
    }
    public void delete(Categoria Categoria){
       crud1.delete(Categoria);
    }
    
}
