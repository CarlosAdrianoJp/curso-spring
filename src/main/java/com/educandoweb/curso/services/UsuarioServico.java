package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.repositories.UsuarioRepositorio;
import com.educandoweb.curso.services.exceptions.AtualizacaoNaoEncontradoException;
import com.educandoweb.curso.services.exceptions.DataBaseException;
import com.educandoweb.curso.services.exceptions.RecursoNaoEncontradoException;


@Service
public class UsuarioServico  {

	// criado uma dependencia
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> encontreTudo(){
		return repositorio.findAll();
	}
	
	public Usuario encontrePeloId(Long id) {
	Optional<Usuario> obj =	repositorio.findById(id);
	return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id));
	}
	
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletar(Long id) {
		
		try {
		repositorio.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new RecursoNaoEncontradoException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	
	public Usuario atualizar(Long id, Usuario obj) {
		try {
		Usuario entity = repositorio.getOne(id);
		atualizarDados(entity, obj);
		return repositorio.save(entity);
		}catch(EntityNotFoundException e) {
			throw new AtualizacaoNaoEncontradoException(e.getMessage());
		}
	}

	private void atualizarDados(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		
		
	}
}
