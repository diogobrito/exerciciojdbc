package br.com.exerciciojdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	protected Connection conexao;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	private String url = "jdbc:mysql://localhost:3306/vendas";
	
	protected void abrirConexao() throws SQLException{
		conexao = DriverManager.getConnection(url, "admin", "admin");
	}

	protected void fecharConexao() throws SQLException{
		conexao.close();
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
	}
}