package co.usa.proyecto5.proyecto5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.proyecto5.proyecto5.model.Categoria;
import co.usa.proyecto5.proyecto5.repository.CategoriaRepositorio;

@Service
public class CategoriaServicio {
    @Autowired
    private CategoriaRepositorio metodosCrud1;

    public List<Categoria> getAll() {
        return metodosCrud1.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud1.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrud1.save(categoria);
        } else {
            Optional<Categoria> categoria1 = metodosCrud1.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud1.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>g=metodosCrud1.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud1.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud1.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}

