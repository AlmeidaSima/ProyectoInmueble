package com.example.demo.service.imp;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inmueble;
import com.example.demo.repository.InmuebleRepository;
import com.example.demo.service.InmuebleService;

@Service("inmuebleservice")
public class InmuebleServiceImpl implements InmuebleService{
	
	@Autowired
	@Qualifier("inmueblerepository")
	private InmuebleRepository inmueblerepository;

	@Override
	public List<Inmueble> listAllInmuebles() {
		return inmueblerepository.findAll();
	}

	@Override
	public Inmueble addInmueble(Inmueble inmueble) {
		return inmueblerepository.save(inmueble);
	}

	@Override
	public Inmueble getInmuebleById(int id) {
		
		return  inmueblerepository.findById(id).orElseThrow(() ->
		new RuntimeException("inmueble no encontrado con ID "+ id));				
	}

	@Override
	public void updateInmueble(Inmueble inmueble) {
		System.out.println("inmueble a actualizar: " + inmueble.getIdInmueble() + ", " + inmueble.getInmuTitulo() + ", " 
	+ inmueble.getInmuPrecio() + " "+ inmueble.getInmuDescrip() + inmueble.getInmuEstado());
	    if (inmueblerepository.existsById(inmueble.getIdInmueble())) {
	        inmueblerepository.save(inmueble);  
	    } else {
	        throw new RuntimeException("inmuble no encontrado para actualizar");
	    }
		
	}

	@Override
	public void deleteInmumeble(int id) {
		inmueblerepository.deleteById(id);
		
	}

	
}
