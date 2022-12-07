package com.lab3.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.List;

import com.lab3.domain.models.Plant;
import com.lab3.domain.daos.PlantDAO;
import com.lab3.domain.models.PlantFamily;
import com.lab3.domain.daos.PlantFamilyDAO;

public class PlantServlet extends HttpServlet {
	private PlantDAO plantDao;
	private PlantFamilyDAO plantFamilyDao;

	@Override
	public void init() throws ServletException {
		this.plantDao = new PlantDAO();
		this.plantFamilyDao = new PlantFamilyDAO();
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		if (request.getRequestURI().contains("/create")) {
			showCreateForm(request, response);
		} else if (request.getRequestURI().contains("/find")) {
			showFindForm(request, response);
		} else if (request.getRequestURI().contains("/all")) {
			showAll(request, response);
		} else if (request.getRequestURI().contains("/edit")) {
			showEditForm(request, response);
		} else if (request.getRequestURI().contains("/read")) {
			showDetails(request, response);
		}
    }

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		if (request.getRequestURI().contains("/create")) {
			create(request, response);
		} else if (request.getRequestURI().contains("/find")) {
			find(request, response);
		} else if (request.getRequestURI().contains("/edit")) {
			edit(request, response);
		} else if (request.getRequestURI().contains("/delete")) {
			delete(request, response);
		}
    }
    
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PlantFamily> families = plantFamilyDao.fetchAll();
		request.setAttribute("families", families);
		request.getRequestDispatcher("/plants/plant_create.jsp").forward(request, response);
	}

    private void showFindForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/plants/plant_find.jsp").forward(request, response);
	}

    private void showAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Plant> plants = plantDao.fetchAll();
		request.setAttribute("plants", plants);
        request.getRequestDispatcher("/plants/plant_show_all.jsp").forward(request, response);
	}

    private void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		double temperature = Double.valueOf(request.getParameter("temperature"));
		String light = request.getParameter("light");
		boolean isPoisonous;
		if (request.getParameter("isPoisonous") == null) {
			isPoisonous = false;
		} else {
			isPoisonous = true;
		}
		double size = Double.valueOf(request.getParameter("size"));
		String familyName = request.getParameter("familyName");
		PlantFamily family = plantFamilyDao.findByName(familyName).get();
		Plant plant = new Plant(name, temperature, light, isPoisonous, size, family);
		plantDao.save(plant);
		response.sendRedirect("/app/plants/read?name=" + plant.getName());
	}

	private void find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		response.sendRedirect("/app/plants/read?name=" + name);
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldName = request.getParameter("oldName");
		String newName = request.getParameter("newName");
		double temperature = Double.valueOf(request.getParameter("temperature"));
		String light = request.getParameter("light");
		boolean isPoisonous;
		if (request.getParameter("isPoisonous") == null) {
			isPoisonous = false;
		} else {
			isPoisonous = true;
		}
		double size = Double.valueOf(request.getParameter("size"));
		String familyName = request.getParameter("familyName");
		PlantFamily family = plantFamilyDao.findByName(familyName).get();
		Plant plant = plantDao.findByName(oldName).get();
		plant.setName(newName);
		plant.setTemperature(temperature);
		plant.setLight(light);
		plant.setIsPoisonous(isPoisonous);
		plant.setSize(size);
		plant.setFamily(family);
		plantDao.update(plant);
		response.sendRedirect("/app/plants/read?name=" + plant.getName());
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Plant plant = plantDao.findByName(name).get();
		plantDao.delete(plant);
        response.sendRedirect("/app/plants/all");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Plant plant = plantDao.findByName(name).get();
		List<PlantFamily> families = plantFamilyDao.fetchAll();
		request.setAttribute("families", families);
		request.setAttribute("plant", plant);
        request.getRequestDispatcher("/plants/plant_edit.jsp").forward(request, response);
	}
	
	private void showDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Plant plant = plantDao.findByName(name).get();
		request.setAttribute("plant", plant);
        request.getRequestDispatcher("/plants/plant_read.jsp").forward(request, response);
	}
}
