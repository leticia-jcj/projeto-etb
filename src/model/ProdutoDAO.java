package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;

public class ProdutoDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public ArrayList<Produto> getLista() throws SQLException{
		ArrayList<Produto> produtos = new ArrayList<>();
		sql = "SELECT idProduto, nome, descricao, estoque, preco, nomeArquivo, caminho, status " +
			  "FROM produto";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Produto produto = new Produto();
			produto.setIdProduto(rs.getInt("idProduto"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setEstoque(rs.getInt("estoque"));
			produto.setPreco(rs.getInt("preco"));
			produto.setNomeArquivo(rs.getString("nomeArquivo"));
			produto.setCaminho(rs.getString("caminho"));
			produto.setStatus(rs.getInt("status"));
			produtos.add(produto);
			
		}
		
		ConexaoFactory.close(con);
		return produtos;
	}
	
	public boolean gravar(Produto produto)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(produto.getIdProduto() == 0) {
			sql = "INSERT INTO produto (nome, descricao, estoque, preco, nomeArquivo, caminho, status) VALUES (?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setInt(3, produto.getEstoque());
			ps.setDouble(4, produto.getPreco());
			ps.setString(5, produto.getNomeArquivo());	
			ps.setString(6, produto.getCaminho());
			ps.setInt(7, produto.getStatus());
			
		}else {
			sql = "UPDATE produto SET nome = ?, descricao = ?, estoque = ?, preco = ?, nomeArquivo = ?, caminho = ?, status = ? " +
				   "WHERE idProduto = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setInt(3, produto.getEstoque());
			ps.setDouble(4, produto.getPreco());
			ps.setString(5, produto.getNomeArquivo());	
			ps.setString(6, produto.getCaminho());
			ps.setInt(7, produto.getStatus());
			ps.setInt(8, produto.getIdProduto());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public Produto getCarregarPorId(int idProduto)throws 
		SQLException {
		Produto produto = new Produto();
		sql = "SELECT idProduto, nome, descricao, estoque, preco, nomeArquivo, caminho, status" +
			  " FROM produto WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idProduto);
		rs = ps.executeQuery();
		if(rs.next()) {
			
			produto.setIdProduto(rs.getInt("idProduto"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setEstoque(rs.getInt("estoque"));
			produto.setPreco(rs.getInt("preco"));
			produto.setNomeArquivo(rs.getString("nomeArquivo"));
			produto.setCaminho(rs.getString("caminho"));
			produto.setStatus(rs.getInt("status"));
		
		}
		
		ConexaoFactory.close(con);
		
		return produto;
	}
	
	public boolean desativar(Produto produto)throws SQLException{
		sql = "UPDATE produto set status = 0 " +
			  "WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, produto.getIdProduto());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}
	
	public boolean ativar(Produto produto)throws SQLException{
		sql = "UPDATE produto set status = 1 " +
			  "WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, produto.getIdProduto());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}
	
}
