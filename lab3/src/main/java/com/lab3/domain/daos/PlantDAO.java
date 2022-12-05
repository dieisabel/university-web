package com.lab3.domain.daos;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lab3.domain.models.Plant;
import com.lab3.domain.models.PlantFamily;
import com.lab3.database.Database;

public class PlantDAO {
	public List<Plant> fetchAll() {
		List<Plant> plants = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			connection = Database.createConnection();
			statement = connection.createStatement();
			result = statement.executeQuery(
				"SELECT * " +
				"FROM plants AS p " +
				"JOIN plant_families AS f ON p.family_id = f.family_id " +
				"ORDER BY p.name"
			);
			while (result.next()) {
				plants.add(createPlant(result));
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
				"SELECT * " +
				"FROM plants AS p " +
				"JOIN plant_families AS f ON p.family_id = f.family_id " +
				"WHERE p.name = ?"
			);
			statement.setString(1, name);
			result = statement.executeQuery();
			while (result.next()) {
				plant = Optional.of(createPlant(result));
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

	public Optional<Plant> save(Plant plant) {
		Optional<Plant> p = findByName(plant.getName());
		if (p.isPresent()) {
			return p;
		}
		p = Optional.empty();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"INSERT INTO plants(name, temperature, light, is_poisonous, size, family_id) " +
				"VALUES (?, ?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS
			);
			statement.setString(1, plant.getName());
			statement.setFloat(2, plant.getTemperature());
			statement.setString(3, plant.getLight());
			if (plant.getIsPoisonous()) {
				statement.setString(4, "y");
			} else {
				statement.setString(4, "n");
			}
			statement.setFloat(5, plant.getSize());
			statement.setInt(6, plant.getPlantFamily().getId());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			if (result.next()) {
				plant.setId(result.getInt(1));
				// TODO: ????
				p = Optional.of(plant);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closeResultSet(result);
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
		return p;
	}

	public void update(Plant plant) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"UPDATE plants " +
				"SET name = ?, temperature = ?, light = ?, is_poisonous = ?, size = ?, family_id = ? "  +
				"WHERE plant_id = ?"
			);
			statement.setString(1, plant.getName());
			statement.setFloat(2, plant.getTemperature());
			statement.setString(3, plant.getLight());
			if (plant.getIsPoisonous()) {
				statement.setString(4, "y");
			} else {
				statement.setString(4, "n");
			}
			statement.setFloat(5, plant.getSize());
			statement.setInt(6, plant.getPlantFamily().getId());
			statement.setInt(7, plant.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			Database.closePreparedStatement(statement);
			Database.closeConnection(connection);
		}
	}

	public void delete(Plant plant) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Database.createConnection();
			statement = connection.prepareStatement(
				"DELETE FROM plants WHERE name = ?"
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
		
	private Plant createPlant(ResultSet result) throws SQLException {
		int id = Integer.parseInt(result.getString("p.plant_id"));
		String name = result.getString("p.name");
		float temperature = result.getFloat("p.temperature");
		String light = result.getString("p.light");
		String p = result.getString("p.is_poisonous");
		boolean is_poisonous;
		if (p == "y") {
			is_poisonous = true;
		} else {
			is_poisonous = false;
		}
		float size = result.getFloat("p.size");
		PlantFamily family = new PlantFamily(
			result.getInt("f.family_id"),
			result.getString("f.name")
		);
		return new Plant(id, name, temperature, light, is_poisonous, size, family);
	}
}
