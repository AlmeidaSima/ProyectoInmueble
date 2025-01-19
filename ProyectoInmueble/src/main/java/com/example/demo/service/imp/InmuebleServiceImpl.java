package com.example.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inmueble;
import com.example.demo.repository.InmuebleRepository;
import com.example.demo.service.InmuebleService;

@Service("inmuebleservice")
public class InmuebleServiceImpl implements InmuebleService {

    private static final Logger logger = LoggerFactory.getLogger(InmuebleServiceImpl.class);

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
        return inmueblerepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inmueble no encontrado con ID " + id));
    }


    @Override
    public void updateInmueble(Inmueble inmueble) {
        logger.info("Inmueble a actualizar: {}, {}, {}, {}", 
                    inmueble.getIdInmueble(), 
                    inmueble.getInmuTitulo(), 
                    inmueble.getInmuPrecio(), 
                    inmueble.getInmuDescrip());
        if (inmueblerepository.existsById(inmueble.getIdInmueble())) {
            inmueblerepository.save(inmueble);  
        } else {
            throw new RuntimeException("Inmueble no encontrado para actualizar");
        }
    }

    @Override
    public void deleteInmueble(int id) {
        if (inmueblerepository.existsById(id)) {
            inmueblerepository.deleteById(id);
        } else {
            throw new RuntimeException("Inmueble no encontrado para eliminar");
        }
    }

    @Override
    public List<Inmueble> buscarInmuebles(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty() || searchTerm.trim().length() < 3) {
            throw new IllegalArgumentException("El término de búsqueda debe tener al menos 3 caracteres");
        }
        return inmueblerepository.buscarPorTermino(searchTerm.trim());
    }




    @Override
    public void pruebaBusquedaInmuebles(String ciudad) {
        // Validamos que el término de búsqueda tenga al menos 3 caracteres
        if (ciudad == null || ciudad.length() < 3) {
            System.out.println("El término de búsqueda debe tener al menos 3 caracteres.");
            return; // Salimos del método si no cumple la condición
        }

        // Realizamos la búsqueda si el término tiene 3 o más caracteres
        List<Inmueble> inmuebles = inmueblerepository.buscarPorTermino(ciudad);
        if (inmuebles.isEmpty()) {
            System.out.println("No se encontraron inmuebles en la ciudad: " + ciudad);
        } else {
            inmuebles.forEach(inmueble -> {
                System.out.println("Inmueble encontrado: " + inmueble.getInmuTitulo() + " - Precio: " + inmueble.getInmuPrecio());
            });
        }
    }
    //public Inmueble obtenerInmueblePorId(Long id) {
     //   Optional<Inmueble> inmueble = inmueblerepository.findById(id);
    //    return inmueble.orElse(null);  // Devuelve null si no se encuentra
  //  }
    @Override
    public void saveInmueble(Inmueble inmueble) {
        inmueblerepository.save(inmueble); // Guardar inmueble
    }

	
}
