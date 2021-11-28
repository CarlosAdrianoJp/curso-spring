package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Pedido;


public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}
