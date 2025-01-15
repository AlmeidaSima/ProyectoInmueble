package com.example.demo.repository;

import java.io.Serializable;
<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
=======

import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inmueble;
@Repository ("inmueblerepository")
<<<<<<< HEAD

public interface InmuebleRepository extends JpaRepository <Inmueble, Serializable>{
    
	List<Inmueble> findByInmuCiudadContainingIgnoreCase(String inmuCiudad);
    
    List<Inmueble> findByInmuDepart(String inmuDepart);
    
    List<Inmueble> findByInmuPrecioBetween(BigDecimal minPrecio, BigDecimal maxPrecio);

    List<Inmueble> findByInmuEstado(String inmuEstado);
    
    List<Inmueble> findByInmuCiudadAndInmuPrecioBetween(String inmuCiudad, BigDecimal minPrecio, BigDecimal maxPrecio);
    
    @Query("SELECT i FROM Inmueble i WHERE LOWER(i.inmuDepart) LIKE LOWER(CONCAT('%', :searchTerm, '%'))" +
    	       " OR LOWER(i.inmuCiudad) LIKE LOWER(CONCAT('%', :searchTerm, '%'))" +
    	       " OR LOWER(i.inmuArea) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    	List<Inmueble> buscarPorTermino(@Param("searchTerm") String searchTerm);
=======
public interface InmuebleRepository extends JpaRepository <Inmueble, Serializable>{
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec

}
