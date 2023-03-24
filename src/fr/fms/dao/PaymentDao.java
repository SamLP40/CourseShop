/**
 * Méthodes permettant d'exécuter des requêtes SQL (CRUD) en base, relatives au paiement.
 * 
 * @author Le-porcherS
 */

package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Cart;
import fr.fms.entities.Payment;

public class PaymentDao implements Dao<Payment> {

	@Override
	public boolean create(Payment obj) {
		String str = "INSERT INTO Payment (IdArticle, Quantity, UnitaryPrice, IdOrder) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setInt(1, obj.getIdPayment());
			ps.setDouble(2, obj.getAmount());
			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			logger.severe("Erreur lors de la création d'un paiement en base : " + e.getMessage());
		}
		return false;
	}

	@Override
	public Payment read(int id) {
		return null;
	}

	@Override
	public boolean update(Payment obj) {
		return false;
	}

	@Override
	public boolean delete(Payment obj) {
		return false;
	}

	@Override
	public ArrayList<Payment> readAll() {
		return null;
	}
}
