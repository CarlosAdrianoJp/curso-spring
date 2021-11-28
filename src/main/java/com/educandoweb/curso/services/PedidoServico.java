package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Pedido;
import com.educandoweb.curso.repositories.PedidoRepositorio;

@Service
public class PedidoServico {

	// criado uma dependencia
	@Autowired
	private PedidoRepositorio repositorio;

	public List<Pedido> encontreTudo() {
		return repositorio.findAll();
	}

	public Pedido encontrePeloId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}

}
