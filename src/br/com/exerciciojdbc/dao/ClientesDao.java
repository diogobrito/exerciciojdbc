package br.com.exerciciojdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exerciciojdbc.entity.Clientes;
import br.com.exerciciojdbc.entity.Pedidos;

public class ClientesDao extends Dao {
	public void incluirCliente(Clientes cliente) throws SQLException{
		abrirConexao();
		
		String sql = "insert into clientes(nome, email) values(?, ?)";
		
		stmt = conexao.prepareStatement(sql);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEmail());
		
		stmt.execute();
		stmt.close();
		
		sql = "select last_insert_id() as id";
		stmt = conexao.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		if(rs.next()){
			cliente.setIdCliente(rs.getInt("id"));
		}
		
		fecharConexao();
	}
	
	public Clientes buscarCliente(int id) throws SQLException{
		Clientes cliente = null;
		List<Pedidos> pedidos = new ArrayList<>();
		
		abrirConexao();
		
		String sql =  "select idpedido, data, descricao, valor"
				    + "  from pedidos"
				    + " where idcliente = ?";
		
		stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		while(rs.next()){
			pedidos.add(new Pedidos(rs.getInt("idpedido"),
								   id,
					               rs.getDate("data"),
					               rs.getString("descricao"),
					               rs.getDouble("valor")));
		}
		
		rs.close();
		stmt.close();
		
		sql =  "select nome, email"
			 + "  from clientes"
			 + " where id = ?";	
		
		stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);

		rs = stmt.executeQuery();
		
		while(rs.next()){
			cliente = new Clientes(id,
								  rs.getString("nome"),
					              rs.getString("email"),
					              pedidos);		
		}
		
		rs.close();
		stmt.close();

		fecharConexao();
		
		return cliente;
	}
}