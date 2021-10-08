package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MakeModel;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editVehicleServlet")
public class EditVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		VehicleHelper vh = new VehicleHelper();
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		Integer tempSn = Integer.parseInt(request.getParameter("serialNumber"));
		
		MakeModel vehicleToUpdate = vh.searchForVehicleBySerialNumber(tempSn);
		vehicleToUpdate.setMake(make);
		vehicleToUpdate.setModel(model);
		
		vh.updateVehicle(vehicleToUpdate);
		getServletContext().getRequestDispatcher("/viewAllVehiclesServlet").forward(request, response);
	}

}
