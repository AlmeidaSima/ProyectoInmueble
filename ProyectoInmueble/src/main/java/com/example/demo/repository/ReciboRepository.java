package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Recibo;

public interface ReciboRepository extends JpaRepository<Recibo, Serializable>{

}
