package fr.fms.dao;

import java.lang.System.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Users;

public class UsersDao implements Dao<Users> {

	@Override
	public boolean create(Users obj) {
		String str = "INSERT INTO Users (Login,Password) VALUES (?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());			
			if( ps.executeUpdate() == 1)	return true;				
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'un utilisateur ");
		} 				
		return false;
	}

	@Override
	public Users read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM Users where IdUser=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) 
				return new Users(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			logger.severe("pb sql sur la lecture d'un user " + e.getMessage());
		} 	
		return null;
	}

	@Override
	public boolean update(Users obj) {
		try (Statement statement = connection.createStatement()){
			String str = "UPDATE Users set Login='" + obj.getLogin() +"' , " +
							                "Password='" 		+ obj.getPassword() +"' , " + " where idUser=" + obj.getIdUser() + ";";			
			statement.executeUpdate(str);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 	
		return true;
	}

	@Override
	public boolean delete(Users obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM Users where IdUser=" + obj.getIdUser() + ";";									
			statement.executeUpdate(str);		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Users> readAll() {
		ArrayList<Users> users = new ArrayList<Users>();
		String strSql = "SELECT * FROM Users";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);							
					users.add((new Users(rsId,rsLogin,rsPassword)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return users;
	}
	
	public Users findUserByCredentials(String login, String password) {
		String str = "SELECT * FROM Users where Login=? and Password=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, login);									
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
				return new Users(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}
	
	public Users findUserByLogin(String login) {
		String str = "SELECT * FROM Users where Login=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, login);									
			try (ResultSet rs = ps.executeQuery()){
				if(rs.next()) 
					return new Users(rs.getInt(1) , rs.getString(2) , rs.getString(3));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}
}