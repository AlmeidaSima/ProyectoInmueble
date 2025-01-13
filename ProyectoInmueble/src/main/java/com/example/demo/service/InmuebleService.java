package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Inmueble;

public interface InmuebleService {
	public abstract List<Inmueble> listAllInmuebles();
	public abstract Inmueble addInmueble(Inmueble inmueble);
	public abstract Inmueble getInmuebleById(int id);
	public abstract void updateInmueble(Inmueble inmueble);
	public abstract void deleteInmumeble(int id);
	
}
