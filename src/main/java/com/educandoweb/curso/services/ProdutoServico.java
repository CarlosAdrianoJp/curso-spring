package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Produto;
import com.educandoweb.curso.repositories.ProdutoRepositorio;

@Service
public class ProdutoServico {

	// criado uma dependencia
	@Autowired
	private ProdutoRepositorio repositorio;

	public List<Produto> encontreTudo() {
		return repositorio.findAll();
	}

	public Produto encontrePeloId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}

}
