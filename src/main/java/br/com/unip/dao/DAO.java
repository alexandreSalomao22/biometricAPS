package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.unip.conexao.ConnectionFactory;

public class DAO {
	Connection connection = ConnectionFactory.conectar();
	
	public void inserir() {
		String sql = "insert into tb_grupos ";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
		{
			
			
			
			preparedStatement.execute();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void apagar() {
		String sql = "";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql))
		{
//			preparestatement.setString(1, usuario.getNome()); //substitui o ? pelo dado do usuario
//			preparestatement.setString(2, usuario.getLogin());
//			preparestatement.setString(3, usuario.getSenha());
			
			preparedStatement.execute();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
