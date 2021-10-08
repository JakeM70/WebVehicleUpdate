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
 * Servlet implementation class EditVehicleListDetailsServlet
 */
@WebServlet("/editVehicleListDetailsServlet")
public class EditVehicleListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVehicleListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		VehicleListDetailsHelper vldh =new VehicleListDetailsHelper();
		VehicleHelper vh =new VehicleHelper();
		BuyerHelper bh =new BuyerHelper();
		
		Integer tempId=Integer.parseInt(request.getParameter("id"));
		VehicleListDetails listToUpdate = vldh.searchForVehicleListDetailsById(tempId);
		
		String newVehicleListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String buyerName = request.getParameter("buyerName");
		Buyer newBuyer = bh.findBuyer(buyerName);
		
		LocalDate ld;
		
		try{
		ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
		ld = LocalDate.now();
		}
		
		try{
		//items are selected in list to add
		String[] selectedItems =request.getParameterValues("allItemsToAdd");
		List<MakeModel> selectedItemsInList =new ArrayList<MakeModel>();
		
		for(int i = 0; i < selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		MakeModel c = vh.searchForVehicleBySerialNumber(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(c);
	}
		listToUpdate.setListOfVehicles(selectedItemsInList);
		
		}catch(NullPointerException ex) {	
			List<MakeModel> selectedItemsInList = new ArrayList<MakeModel>();
			listToUpdate.setListOfVehicles(selectedItemsInList);
		}
		listToUpdate.setVehicleListName(newVehicleListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setBuyer(newBuyer);
		
		vldh.updateVehicleList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllVehicleListsServlet").forward(request, response);
	}
}
