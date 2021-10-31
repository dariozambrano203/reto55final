package co.usa.proyecto5.proyecto5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.proyecto5.proyecto5.model.Mensaje;
import co.usa.proyecto5.proyecto5.repository.MensajeRepositorio;

@Service
public class MensajeServicio {
    @Autowired
    private MensajeRepositorio metodosCrud3;

    public List<Mensaje> getAll(){
        return metodosCrud3.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud3.getMessage(messageId);
    }

    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud3.save(message);
        }else{
            Optional<Mensaje> e= metodosCrud3.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud3.save(message);
            }else{
                return message;
            }
        }
    }

    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e= metodosCrud3.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud3.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud3.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

