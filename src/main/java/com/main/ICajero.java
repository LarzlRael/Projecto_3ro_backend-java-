package com.main;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ICajero extends JpaRepository<CajeroModelo, Integer> {

		
  @Query(value = "update cajero set activo = true where id_cajero = ?1", nativeQuery = true)
  void habilitar(int id);
	
  @Query(value = "UPDATE cajero SET activo = false WHERE id_cajero = ?1", nativeQuery = true)
  void deshabilitar(int id);
  
  @Query(value = "select * from cajero order by id_cajero DESC", nativeQuery = true)
  List <CajeroModelo> getAll();

  @Query(value = "select * from cajero  WHERE activo = true order by id_cajero DESC", nativeQuery = true)
  List <CajeroModelo> getUsersEnabled();

}

