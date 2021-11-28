package com.educandoweb.curso.recources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Produto;
import com.educandoweb.curso.services.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso {
	
	@Autowired
	private ProdutoServico servico;

	@GetMapping
	public ResponseEntity<List<Produto>> encontreTudo(){
		
		List<Produto> list = servico.encontreTudo();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> encontrePeloId(@PathVariable Long id){
		Produto obj = servico.encontrePeloId(id);
		return ResponseEntity.ok().body(obj);
	}
}
