package com.lab3.domain.daos;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lab3.domain.models.PlantFamily;
import com.lab3.database.Database;

public class PlantFamilyDAO {
	public List<PlantFamily> fetchAll() {
		List<PlantFamily> plantFamilies = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			connection = Database.createConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM plant_families ORDER BY name");
			while (result.next()) {
				int id = Integer.parseInt(result.getString("family_id"));
				String name = result.getString("name");
				plantFamilies.add(new PlantFamily(id, name));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closeResultSet(result);
			Database.closeStatement(statement);
			Database.closeConnection(connection);
		}
		return plantFamilies;
	}

	public Optional<PlantFamily> findByName(String name) {
		Optional<PlantFamily> plantFamily = Optional.empty();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"SELECT * FROM plant_families WHERE name = ?"
			);
			statement.setString(1, name);
			result = statement.executeQuery();
			while (result.next()) {
				int id = Integer.parseInt(result.getString("family_id"));
				String n = result.getString("name");
				plantFamily = Optional.of(new PlantFamily(id, n));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closeResultSet(result);
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
		return plantFamily;
	}

	public Optional<PlantFamily> save(PlantFamily plantFamily) {
		Optional<PlantFamily> family = findByName(plantFamily.getName());
		if (family.isPresent()) {
			return family;
		}
		family = Optional.empty();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"INSERT INTO plant_families(name) VALUES (?)",
				Statement.RETURN_GENERATED_KEYS
			);
			statement.setString(1, plantFamily.getName());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			if (result.next()) {
				plantFamily.setId(result.getInt(1));
				family = Optional.of(plantFamily);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closeResultSet(result);
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
		return family;
	}

	public void update(PlantFamily plantFamily) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"UPDATE plant_families " +
				"SET name = ? "  +
				"WHERE family_id = ?"
			);
			statement.setString(1, plantFamily.getName());
			statement.setInt(2, plantFamily.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
	}

	public void delete(PlantFamily plantFamily) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"DELETE FROM plant_families WHERE name = ?"
			);
			statement.setString(1, plantFamily.getName());
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
	}
}
