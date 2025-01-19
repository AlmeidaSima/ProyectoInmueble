package com.example.demo.repository;

import com.example.demo.entity.Pago;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PagoRepository extends JpaRepository<Pago, Serializable> {

}
