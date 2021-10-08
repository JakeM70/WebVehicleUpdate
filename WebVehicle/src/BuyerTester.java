import java.util.List;

import controller.BuyerHelper;
import model.Buyer;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class BuyerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer bill = new Buyer("Bill");
		
		BuyerHelper bh = new BuyerHelper();
		bh.insertBuyer(bill);
		
		List<Buyer> allBuyers = bh.showAllBuyers();
		for(Buyer a: allBuyers) {
			System.out.println(a.toString());
		}

	}

}
