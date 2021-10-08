package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Buyer;
import model.MakeModel;
import model.VehicleListDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		VehicleHelper vh = new VehicleHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String buyerName = request.getParameter("buyerName");
		LocalDate ld;
		
		try{
		ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		}catch
		(NumberFormatException ex) {
		ld = LocalDate.now();
		}
		
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<MakeModel> selectedItemsInList = new ArrayList<MakeModel>();
		
		if (selectedItems != null && selectedItems.length > 0)
		{
		for(int i = 0; i<selectedItems.length; i++) {
		System.out.println(selectedItems[i]);MakeModel c =vh.searchForVehicleBySerialNumber(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(c);
		}
		}
		Buyer buyer = new Buyer(buyerName);
		VehicleListDetails vld = new VehicleListDetails(listName, ld, buyer);
		
		vld.setListOfVehicles(selectedItemsInList);
		VehicleListDetailsHelper vldh = new VehicleListDetailsHelper();
		vldh.insertNewVehicleListDetails(vld);
		
		System.out.println("Success!");
		System.out.println(vld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllVehicleListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

	}
}
