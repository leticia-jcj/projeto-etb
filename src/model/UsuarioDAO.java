package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.Perfil;
import model.Usuario;

public class UsuarioDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	
	public ArrayList<Usuario> getLista()throws SQLException{
		ArrayList<Usuario> lista = new ArrayList<>();
		sql = "SELECT p.idPerfil, p.nome, u.idUsuario, u.nome, u.login, " +
				"u.senha, u.status, u.idPerfil " +
				"FROM perfil p " +
				"INNER JOIN usuario u " +
				"ON p.idPerfil = u.idPerfil";
	
			con = ConexaoFactory.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setIdUsuario(rs.getInt("u.idUsuario"));
				u.setNome(rs.getString("u.nome"));
				u.setLogin(rs.getString("u.login"));
				u.setSenha(rs.getString("u.senha"));
				u.setStatus(rs.getInt("u.status"));
				
				Perfil p = new Perfil();
				p.setIdPerfil(rs.getInt("p.idPerfil"));
				p.setNome(rs.getString("p.nome"));
				
				//Associa��o entre usu�rio e perfil
				u.setPerfil(p);
				//adiciona o objeto usuario ao arraylist lista
				lista.add(u);

				
				
			}
			
			ConexaoFactory.close(con);
				
		
		return lista;
		
	}
	
	public boolean gravar(Usuario u)
		throws SQLException{
		con = ConexaoFactory.conectar();
		if(u.getIdUsuario() == 0) {
			sql = "INSERT INTO usuario " + 
					"(nome, login, senha, status, idPerfil) " +
					"VALUES (?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getStatus());
			ps.setInt(5, u.getPerfil().getIdPerfil());
			
			
		}else {
			sql = "UPDATE usuario " +
				  "SET nome = ?, login = ?, senha = ?, " +
				  "status = ?, idPerfil = ? " +
				  "WHERE idUsuario = ?";
			
			ps = con.prepareStatement(sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getStatus());
			ps.setInt(5, u.getPerfil().getIdPerfil());
			
		}
		
		if(u.getIdUsuario() > 0) {
			ps.setInt(6, u.getIdUsuario());
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
	}
	
	public Usuario getCarregarPorId(int idUsuario)
		throws SQLException{
		Usuario u = new Usuario();
		sql = "SELECT p.nome, p.idPerfil, u.idUsuario, " +
			  "u.nome, u.login, u.senha, u.status, u.idPerfil " +
			  "FROM usuario u " +
			  "INNER JOIN perfil p " +
			  "ON p.idPerfil = u.idPerfil " +
			  "WHERE u.idUsuario = ? ";
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idUsuario);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			u.setIdUsuario(rs.getInt("u.idUsuario"));
			u.setNome(rs.getString("u.nome"));
			u.setLogin(rs.getString("u.login"));
			u.setSenha(rs.getString("u.senha"));
			u.setStatus(rs.getInt("u.status"));
			
			Perfil p = new Perfil();
			p.setIdPerfil(rs.getInt("p.idPerfil"));
			p.setNome(rs.getString("p.nome"));
			
			//Associação entre as classes Perfil e Usuario
			
			u.setPerfil(p);
		}
		ConexaoFactory.close(con);
		
		return u;
		
	}
	

	public boolean desativar(Usuario u)
		throws SQLException{
		sql = "UPDATE usuario SET status = 0 WHERE idUsuario = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, u.getIdUsuario());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
		
	}
	
	public boolean ativar(Usuario u)
		throws SQLException {
		sql = "UPDATE usuario SET status = 1 WHERE idUsuario = ?";
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, u.getIdUsuario());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
		
	}
	

	


}
