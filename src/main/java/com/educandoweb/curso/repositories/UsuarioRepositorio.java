package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
