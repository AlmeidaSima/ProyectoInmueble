package com.example.demo.service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Qualifier;

=======
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec
import com.example.demo.entity.Inmueble;

public interface InmuebleService {
	public abstract List<Inmueble> listAllInmuebles();
	public abstract Inmueble addInmueble(Inmueble inmueble);
	public abstract Inmueble getInmuebleById(int id);
	public abstract void updateInmueble(Inmueble inmueble);
<<<<<<< HEAD
	public abstract void deleteInmueble(int id);
	public abstract List<Inmueble> buscarInmuebles(String searchTerm);
    void pruebaBusquedaInmuebles(String ciudad);


=======
	public abstract void deleteInmumeble(int id);
	
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec
}
