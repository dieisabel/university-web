package com.lab2;

import com.lab2.dtos.TabulationData;
import com.lab2.dtos.TabulationInput;
import com.lab2.services.TabulationService;
import com.lab2.services.TabulationServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double start = Double.parseDouble(request.getParameter("start"));
        double end = Double.parseDouble(request.getParameter("end"));
        double step = Double.parseDouble(request.getParameter("step"));
        TabulationService service = new TabulationServiceImpl();
        TabulationInput input = new TabulationInput(start, end, step);
        TabulationData data = service.tabulate(input);
        request.setAttribute("data", data);
        request.getRequestDispatcher("/tabulation.jsp").forward(request, response);
    }
}
