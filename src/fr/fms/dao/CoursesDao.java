/**
 * Méthodes permettant d'exécuter des requêtes SQL (CRUD) en base, relatives aux formations.
 */
package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Courses;

public class CoursesDao implements Dao<Courses> {

	public CoursesDao() {
	logger.info("Here we Go !");
	}

	@Override
	public boolean create(Courses obj) {
		String str = "INSERT INTO Courses (Name, Duration, Description, Category, Type, Price) VALUES (?,?,?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getIdCourse());
			ps.setString(2, obj.getName());
			ps.setInt(3, obj.getDuration());
			ps.setString(4, obj.getDescription());
			ps.setString(5, obj.getCategory());
			ps.setString(6, obj.getType());
			ps.setDouble(7, obj.getPrice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'une formation " + e.getMessage());
		} 	
		return false;
	}

	@Override
	public Courses read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM Courses where IdCourse=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Courses(rs.getInt(1) , rs.getString(2) , rs.getInt(3), rs.getString(4) , rs.getString(5), rs.getString(6), rs.getDouble(7));
		} catch (SQLException e) {
			logger.severe("pb sql sur la lecture d'une formation " + e.getMessage());
		} 	
		return null;
	}

	@Override
	public boolean update(Courses obj) {
		String str = "UPDATE Courses set Name=? , Duration=? , Description=? , Category=? , Type=? , Price=? where IdCourse=?;";	
		try (PreparedStatement ps = connection.prepareStatement(str)){				
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setString(3, obj.getCategory());
			ps.setString(5, obj.getType());
			ps.setDouble(6, obj.getPrice());	
			if( ps.executeUpdate() == 1)
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la mise à jour d'une formation " + e.getMessage());
		} 	
		return false;
	}

	@Override
	public boolean delete(Courses obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM Courses where IdCourse=" + obj.getIdCourse() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la suppression d'une formation " + e.getMessage());
		} 	
		return false;
	}

	@Override
	public ArrayList<Courses> readAll() {
		ArrayList<Courses> courses = new ArrayList<Courses>();
		String strSql = "SELECT * FROM Courses";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdCourse = resultSet.getInt(1);
					String rsName = resultSet.getString(2);
					int rsDuration = resultSet.getInt(3);
					String rsDescription = resultSet.getString(4);
					String rsCategory = resultSet.getString(5);
					String rsType = resultSet.getString(6); 
					double rsPrice = resultSet.getDouble(7);		
					courses.add((new Courses(rsIdCourse, rsName, rsDuration, rsDescription,rsCategory, rsType, rsPrice)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur l'affichage des formations " + e.getMessage());
		}	
		catch (Exception e) {
			logger.severe("pb : " + e.getMessage());
		}
		return courses;
	}
	
	public ArrayList<Courses> readAllByCat(int id) {
		ArrayList<Courses> courses = new ArrayList<Courses>();
		String strSql = "SELECT * FROM Courses where idCourse=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdCourse = resultSet.getInt(1);
					String rsName = resultSet.getString(2);
					int rsDuration = resultSet.getInt(3);
					String rsDescription = resultSet.getString(4);
					String rsCategory = resultSet.getString(5);
					String rsType = resultSet.getString(6); 
					double rsPrice = resultSet.getDouble(7);	
					courses.add((new Courses(rsIdCourse, rsName, rsDuration, rsDescription,rsCategory, rsType, rsPrice)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur l'affichage des formations par catégories " + e.getMessage());
		}			
		return courses;
	}
	
}
