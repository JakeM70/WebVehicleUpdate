import java.util.List;
import java.util.Scanner;


import controller.VehicleHelper;
import model.MakeModel;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static VehicleHelper vh = new VehicleHelper();

	private static void addAVehicle() {
		// TODO Auto-generated method stub
		System.out.print("Enter Make: ");
		String make = in.nextLine();
		System.out.print("Enter Model: ");
		String model = in.nextLine();
		MakeModel toAdd = new MakeModel(make, model);
		vh.insertVehicle(toAdd);
	}

	private static void deleteAVehicle() {
		// TODO Auto-generated method stub
		System.out.print("Enter the make to delete: ");
		String make = in.nextLine();
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
		MakeModel toDelete=new MakeModel(make, model);
		vh.deleteVehicle(toDelete);

	}

	private static void editAVehicle() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Make");
		System.out.println("2 : Search by Model");
		int searchBy = in.nextInt();
		in.nextLine();
		List<MakeModel> foundVehicle;
		if (searchBy == 1) {
			System.out.print("Enter the vehicle make: ");
			String vehicleMake = in.nextLine();
			foundVehicle=vh.searchForVehicleByMake(vehicleMake);
			
		} else {
			System.out.print("Enter the model: ");
			String vehicleModel = in.nextLine();
			foundVehicle=vh.searchForVehicleByModel(vehicleModel);

		}

		if (!foundVehicle.isEmpty()) {
			System.out.println("Found Results.");
			for (MakeModel v : foundVehicle) {
				System.out.println(v.getSerialNumber() + " : " + v.toString());
			}
			System.out.print("Which Serial Number to edit: ");
			int serialNumberToEdit = in.nextInt();

			MakeModel toEdit = vh.searchForVehicleBySerialNumber(serialNumberToEdit);
			System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getMake());
			System.out.println("1 : Update Make");
			System.out.println("2 : Update Model");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			} else if (update == 2) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			}

			vh.updateVehicle(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		
		while (goAgain) {
			System.out.println("*  Select One Please:");
			System.out.println("*  1 -- Add an vehicle");
			System.out.println("*  2 -- Edit an vehicle");
			System.out.println("*  3 -- Delete an vehicle");
			System.out.println("*  4 -- View the vehicles");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAVehicle();
			} else if (selection == 2) {
				editAVehicle();
			} else if (selection == 3) {
				deleteAVehicle();
			} else if (selection == 4) {
				viewTheVehicles();
			} else {
				vh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheVehicles() {
		// TODO Auto-generated method stub
		List<MakeModel> allVehicles = vh.showAllVehicles();
		for(MakeModel singleVehicle : allVehicles) {
			System.out.print(singleVehicle.returnMakeModel()+ "\n");
		}

	}

}
