import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.BuyerHelper;
import controller.VehicleListDetailsHelper;
import model.Buyer;
import model.MakeModel;
import model.VehicleListDetails;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class VehicleListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer cameron = new Buyer("Cameron");
		
		//BuyerHelper bh = new BuyerHelper();
		
		//bh.insertBuyer(cameron);
		
		VehicleListDetailsHelper vldh = new VehicleListDetailsHelper();
		MakeModel truck = new MakeModel("Chevy", "Silverado");
		MakeModel suv = new MakeModel("GMC", "Yukon");
		
		List<MakeModel> cameronsVehicles = new ArrayList<MakeModel>();
		cameronsVehicles.add(truck);
		cameronsVehicles.add(suv);
		
		VehicleListDetails cameronList = new VehicleListDetails("Cameron's List",LocalDate.now(), cameron);
		cameronList.setListOfVehicles(cameronsVehicles);
		
		vldh.insertNewVehicleListDetails(cameronList);
		
		List<VehicleListDetails> allLists = vldh.getLists();
		for(VehicleListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
