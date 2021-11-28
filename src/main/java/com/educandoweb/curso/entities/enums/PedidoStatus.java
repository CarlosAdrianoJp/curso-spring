package com.educandoweb.curso.entities.enums;

public enum PedidoStatus {
	
	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CALCELADO(5);
	
	
	private int codigo;
	
	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	
	public static PedidoStatus vaLorDo(int codigo) {
		for(PedidoStatus  valor : PedidoStatus.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Pedido_Status invalido");
	}
}
