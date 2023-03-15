package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Cart;

public class CartDao implements Dao<Cart> {


	@Override
	public boolean create(Cart obj) {
		String str = "INSERT INTO Cart (IdArticle, Quantity, UnitaryPrice, IdOrder) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setInt(1, obj.getIdCart());
			ps.setInt(2, obj.getTotalCourses());
			ps.setDouble(3, obj.getIdOrder());
			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			logger.severe("Erreur lors de la création du panier en base : " + e.getMessage());
		}
		return false;
	}

	@Override
	public Cart read(int id) {
		return null;
	}

	@Override
	public boolean update(Cart obj) {
		return false;
	}

	@Override
	public boolean delete(Cart obj) {
		return false;
	}

	@Override
	public ArrayList<Cart> readAll() {
		return null;
	}
}
