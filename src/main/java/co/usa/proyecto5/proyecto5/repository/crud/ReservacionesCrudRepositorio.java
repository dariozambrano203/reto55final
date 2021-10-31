package co.usa.proyecto5.proyecto5.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.usa.proyecto5.proyecto5.model.Reservaciones;

public interface ReservacionesCrudRepositorio extends CrudRepository<Reservaciones,Integer>{

    public List<Reservaciones> findAllByStatus (String status); 
    
    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservacionesByCliente();
    
}