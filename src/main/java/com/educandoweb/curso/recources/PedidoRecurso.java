package com.educandoweb.curso.recources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Pedido;
import com.educandoweb.curso.services.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {
	
	@Autowired
	private PedidoServico servico;

	@GetMapping
	public ResponseEntity<List<Pedido>> encontreTudo(){
		
		List<Pedido> list = servico.encontreTudo();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> encontrePeloId(@PathVariable Long id){
		Pedido obj = servico.encontrePeloId(id);
		return ResponseEntity.ok().body(obj);
	}
}
