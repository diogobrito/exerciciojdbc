package br.com.exerciciojdbc.entity;

import java.io.Serializable;
import java.util.Date;

public class Pedidos implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int idPedido;
	private int idCliente;
	private Date data;
	private String descricao;
	private double valor;
	
	
	
	public Pedidos(int idPedido, int idCliente, Date data, String descricao, double valor) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Pedidos(int idCliente, Date data, String descricao, double valor) {
		super();
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
		
}
