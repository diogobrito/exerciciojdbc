package br.com.exerciciojdbc.main;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.exerciciojdbc.dao.ClientesDao;
import br.com.exerciciojdbc.dao.PedidosDao;
import br.com.exerciciojdbc.entity.Clientes;
import br.com.exerciciojdbc.entity.Pedidos;

public class CadastroClientes {

	public static void main(String[] args) {
	
		try {
			
			System.out.println("Cadastrando Cliente ...");
			
			PedidosDao pedidosDao = new PedidosDao();
			List<Pedidos> pedidosCliente = new ArrayList<Pedidos>();
			
			ClientesDao clienteDao = new ClientesDao();
			Clientes cliente = new Clientes("Joaozinho","joazinho@john.com");
			clienteDao.incluirCliente(cliente);
			
			pedidosCliente.add(new Pedidos(cliente.getIdCliente(), new Date(), "PS4", 1200.00));
			pedidosCliente.add(new Pedidos(cliente.getIdCliente(), new Date(), "Jogo PS4 Fifa17", 99.00));
			
			for (Pedidos pedido : pedidosCliente) {
				pedidosDao.incluirPedido(pedido);
			}
			
			System.out.println("Cadastrando Cliente Finalizado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}