package com.lab3.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.List;
import javax.persistence.*;

import com.lab3.domain.models.PlantFamily;
import com.lab3.domain.daos.PlantFamilyDAO;
import com.lab3.database.Database;

public class PlantFamilyServlet extends HttpServlet {
	private PlantFamilyDAO dao;

	@Override
	public void init() throws ServletException {
		this.dao = new PlantFamilyDAO();
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
		request.getRequestDispatcher("/families/family_create.jsp").forward(request, response);
	}

    private void showFindForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/families/family_find.jsp").forward(request, response);
	}

    private void showAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PlantFamily> families = dao.fetchAll();
		request.setAttribute("families", families);
        request.getRequestDispatcher("/families/family_show_all.jsp").forward(request, response);
	}

    private void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		PlantFamily family = new PlantFamily();
        family.setName(name);
		PlantFamilyDAO dao = new PlantFamilyDAO();
		dao.save(family);
		response.sendRedirect("/app/families/read?name=" + family.getName());
	}

	private void find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		response.sendRedirect("/app/families/read?name=" + name);
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldName = request.getParameter("oldName");
		String newName = request.getParameter("newName");
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Query query = manager.createNamedQuery("find plant family by name");
        query.setParameter("name", oldName);
        PlantFamily family = (PlantFamily) query.getSingleResult();
		family.setName(newName);
        transaction.commit();
        database.closeEntityManager(manager);
		response.sendRedirect("/app/families/read?name=" + family.getName());
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		PlantFamily family = dao.findByName(name);
		dao.delete(family);
        response.sendRedirect("/app/families/all");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		PlantFamily family = dao.findByName(name);
		request.setAttribute("family", family);
        request.getRequestDispatcher("/families/family_edit.jsp").forward(request, response);
	}
	
	private void showDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		PlantFamily family = dao.findByName(name);
		request.setAttribute("family", family);
        request.getRequestDispatcher("/families/family_read.jsp").forward(request, response);
	}
}
