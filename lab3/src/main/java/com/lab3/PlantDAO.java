package com.lab3;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class PlantDAO {
	public List<Plant> fetchAll() {
		List<Plant> plants = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			connection = Database.createConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM plants ORDER BY name");
			while (result.next()) {
				String name = result.getString("name");
				plants.add(new Plant(name));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closeResultSet(result);
			Database.closeStatement(statement);
			Database.closeConnection(connection);
		}
		return plants;
	}

	public Optional<Plant> findByName(String name) {
		Optional<Plant> plant = Optional.empty();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"SELECT * FROM plants WHERE name = ?"
			);
			statement.setString(1, name);
			result = statement.executeQuery();
			while (result.next()) {
				String plantName = result.getString("name");
				plant = Optional.of(new Plant(plantName));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closeResultSet(result);
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
		return plant;
	}

	public void save(Plant plant) {
		if (findByName(plant.getName()).isPresent()) {
			return;
		}
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"INSERT INTO plants(name) VALUES (?)"
			);
			statement.setString(1, plant.getName());
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
	}

	public void update(Plant plant) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"UPDATE plants " +
				"SET name = ? "  +
				"WHERE name = ?"
			);
			statement.setString(1, plant.getName());
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closePreparedStatement(statement);
			Database.closeConnection();
		}
	}

	public void delete(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"DELETE FROM plants WHERE name = ?"
			);
			statement.setString(1, name);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
	}
}
