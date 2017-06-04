package br.com.exerciciojdbc.entity;

import java.io.Serializable;
import java.util.List;

public class Clientes implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idCliente;
	private String nome;
	private String email;
	private List<Pedidos> pedido; 

	
	
	public Clientes(int idCliente, String nome, String email) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
	}
	
	
	
	public Clientes(int idCliente, String nome, String email, List<Pedidos> pedido) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.pedido = pedido;
	}
	
	public Clientes(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}



	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Pedidos> getPedido() {
		return pedido;
	}
	public void setPedido(List<Pedidos> pedido) {
		this.pedido = pedido;
	}
	
	
}
