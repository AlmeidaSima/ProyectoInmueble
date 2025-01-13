package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inmueble;
@Repository ("inmueblerepository")
public interface InmuebleRepository extends JpaRepository <Inmueble, Serializable>{

}
