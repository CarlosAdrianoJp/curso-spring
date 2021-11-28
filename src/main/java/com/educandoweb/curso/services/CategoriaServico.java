package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Categoria;
import com.educandoweb.curso.repositories.CategoriaRepositorio;

@Service
public class CategoriaServico {

	// criado uma dependencia
	@Autowired
	private CategoriaRepositorio repositorio;

	public List<Categoria> encontreTudo() {
		return repositorio.findAll();
	}

	public Categoria encontrePeloId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}

}
