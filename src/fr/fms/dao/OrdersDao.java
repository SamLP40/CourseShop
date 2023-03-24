/**
 *  Méthodes permettant d'exécuter des requêtes SQL (CRUD) en base, relatives aux commandes client.
 */
package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Orders;

public class OrdersDao implements Dao<Orders>{

	@Override
	public boolean create(Orders obj) {
		String str = "INSERT INTO Orders (IdOrder , Amount , IdCustomer) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){	
			ps.setDouble(2, obj.getAmount());
			ps.setInt(3, obj.getIdCustomer());
			ps.executeUpdate();
			try(ResultSet generatedKeySet = ps.getGeneratedKeys()){
				if(generatedKeySet.next()) {
					obj.setIdOrder(generatedKeySet.getInt(1));
					return true;
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Orders read(int id) {
		return null;
	}

	@Override
	public boolean update(Orders obj) {
		return false;
	}

	@Override
	public boolean delete(Orders obj) {
		return false;
	}

	@Override
	public ArrayList<Orders> readAll() {
		return null;
	}
	
}
