package br.com.exerciciojdbc.dao;

import java.sql.Date;
import java.sql.SQLException;

import br.com.exerciciojdbc.entity.Pedidos;

public class PedidosDao extends Dao {
	public void incluirPedido(Pedidos pedido) throws SQLException{
		abrirConexao();
		
		String sql = "insert into pedidos(idcliente, data, descricao, valor)"
				   + " values(?, ?, ?, ?)";
		
		stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, pedido.getIdCliente());
		stmt.setDate(2, (Date)pedido.getData());
		stmt.setString(3, pedido.getDescricao());
		stmt.setDouble(4, pedido.getValor());
		
		stmt.execute();
		stmt.close();
		
		sql = "select last_insert_id() as id";
		stmt = conexao.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		if(rs.next()){
			pedido.setIdPedido(rs.getInt("id"));
		}
		
		fecharConexao();
	}
	
	public Pedidos buscarPedido(int id) throws SQLException{
		Pedidos pedido = null;
		
		abrirConexao();
		
		String sql =  "select idcliente, data, descricao, valor"
			    + "  from pedidos"
			    + " where idpedido = ?";
		
		stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		while(rs.next()){
			pedido = new Pedidos(id,
								rs.getInt("idcliente"),
					            rs.getDate("data"),
					            rs.getString("descricao"),
					            rs.getDouble("valor"));
		}
		
		rs.close();
		stmt.close();
		
		fecharConexao();
		
		return pedido;
	}
}
