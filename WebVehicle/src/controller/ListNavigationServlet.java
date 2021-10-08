package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VehicleListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
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
		VehicleListDetailsHelper vldh = new VehicleListDetailsHelper();
		String act = request.getParameter("doThisToList");
		
		if(act ==null) {
			getServletContext().getRequestDispatcher("/viewAllVehicleListsServlet").forward(request, response);
		}else if (act.equals("delete")) {
			try {
			Integer tempId =Integer.parseInt(request.getParameter("id"));
					VehicleListDetails listToDelete = vldh.searchForVehicleListDetailsById(tempId);
					vldh.deleteVehicleList(listToDelete);
			}catch (NumberFormatException e) {
			System.out.println("Forgot to click abutton");		
		} finally{
			getServletContext().getRequestDispatcher("/viewAllVehicleListsServlet").forward(request, response);
					}
		}else if(act.equals("edit")) {
			try{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				VehicleListDetails listToEdit = vldh.searchForVehicleListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				request.setAttribute("month",listToEdit.getTripDate().getMonthValue());
				request.setAttribute("date",listToEdit.getTripDate().getDayOfMonth());
				request.setAttribute("year",listToEdit.getTripDate().getYear());
				
				VehicleHelper vldhForItems = new VehicleHelper();
				
				request.setAttribute("allVehicles", vldhForItems.showAllVehicles());
				
				if(vldhForItems.showAllVehicles().isEmpty()){
				request.setAttribute("allVehicles", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			}catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllVehicleListsServlet").forward(request, response);
			}
		}else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}

}
