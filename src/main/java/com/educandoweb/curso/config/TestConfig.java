package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Categoria;
import com.educandoweb.curso.entities.ItemPedido;
import com.educandoweb.curso.entities.Pagamento;
import com.educandoweb.curso.entities.Pedido;
import com.educandoweb.curso.entities.Produto;
import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.entities.enums.PedidoStatus;
import com.educandoweb.curso.repositories.CategoriaRepositorio;
import com.educandoweb.curso.repositories.ItemPedidoRepositorio;
import com.educandoweb.curso.repositories.PedidoRepositorio;
import com.educandoweb.curso.repositories.ProdutoRepositorio;
import com.educandoweb.curso.repositories.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ItemPedidoRepositorio itemPedidoRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Eletronicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");
		
		Produto prod1 = new Produto(null, "Harry Potter e o Calice de Fogo", "filme da saga harry potter", 500.0, "");
		Produto prod2 = new Produto(null, "Smart tv", "Tv de tela plana 50 polegadas", 2500.0, "");
		Produto prod3 = new Produto(null, "Macbook Pro", "NOTEBOOKS mais caros", 9000.0, "");
		Produto prod4 = new Produto(null, "Pc gamer", "pc da marca DELL", 5000.0, "");
		Produto prod5 = new Produto(null, "Piratas do Caribe", "filme da saga de john deep", 300.0, "");
		
		produtoRepositorio.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5));
		categoriaRepositorio.saveAll(Arrays.asList(c1,c2,c3));
		
		
		prod1.getCategorias().add(c2);
		prod2.getCategorias().add(c1);
		prod2.getCategorias().add(c3);
		prod3.getCategorias().add(c3);
		prod4.getCategorias().add(c3);
		prod5.getCategorias().add(c2);
		
		produtoRepositorio.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5));
		
		
		Usuario u1 = new Usuario(null, "bob", "bob@gmail.com", "123456789", "321");
		Usuario u2 = new Usuario(null, "carlos", "carlos@gmail.com", "9988776655", "111");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u2);
		Pedido p2 = new Pedido(null,  Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.ENVIADO, u1);
		Pedido p3 = new Pedido(null,  Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.ENTREGUE, u2);
		
		

		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		pedidoRepositorio.saveAll(Arrays.asList(p1,p2,p3));
		
		
		ItemPedido ip1 = new ItemPedido(p1, prod1, 2, prod1.getPreco());
		ItemPedido ip2 = new ItemPedido(p1, prod3, 1, prod3.getPreco());
		ItemPedido ip3 = new ItemPedido(p2, prod3, 2, prod3.getPreco());
		ItemPedido ip4 = new ItemPedido(p3, prod5, 2, prod5.getPreco());
		
		itemPedidoRepositorio.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), p1);
		p1.setPagamento(pag1);
		
		pedidoRepositorio.save(p1);
	}

}
