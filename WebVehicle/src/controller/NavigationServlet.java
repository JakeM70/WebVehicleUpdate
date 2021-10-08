package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MakeModel;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
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
		String act = request.getParameter("doThisToVehicle");
		String path = "/viewAllVehiclesServlet";
		
		//if(act ==null) {
		//	getServletContext().getRequestDispatcher("/viewAllVehicleListsServlet").forward(request, response);
		//}
		
		 if(act.equals("delete")) {
			try {
			Integer tempserialNumber = Integer.parseInt(request.getParameter("serialNumber"));
			MakeModel vehicleToDelete = vh.searchForVehicleBySerialNumber(tempserialNumber);
			vh.deleteVehicle(vehicleToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if(act.equals("edit")) {
			try {
			Integer tempserialNumber = Integer.parseInt(request.getParameter("serialNumber"));
			MakeModel vehicleToEdit = vh.searchForVehicleBySerialNumber(tempserialNumber);
			request.setAttribute("ListToEdit", vehicleToEdit);
			path = "/edit-item.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if(act.equals("add")) {
			path = "/index.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

}
