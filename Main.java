package immigrationSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The "Visitor list in immigration department " program implements an
 * application that creates a list of people at the moment when they arrive in
 * the immigration department. The officer at the department, has the option to
 * insert a person to the first position, to the middle of the list, to the end
 * of the list or in any other position too. Each option has its own method.
 * Also the options to check the current position of a person by name, check
 * current position by ID, update person's information, remove a person from the
 * list by the ID and remove any number of people from the end of the list is
 * also available.
 * 
 * @author Felipe Mello 2015335
 * 
 * 
 * @version 4.0
 * @since 21-12-2017
 */

// The class Main is operating the display process, where the user will type the
// information
// of the person.
public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PersonDetails pDetails = new PersonDetails();

	boolean inputOk;
	int option;

	// This is the first call where the class main gets the list of options from
	// the menu().
	public Main() {
		System.out.println("****************************************************************************"
				+ "**********************************" + "*\n********************************"
				+ "****** Welcome to the Immigration System *********************"
				+ "*****************\n*******************************************"
				+ "**************************************************************" + "******");
		menu();
	}

	// This method prompts the options available in the program and once the
	// user types the value
	// the method will call the next method where the user wants to go.
	public void menu() {
		printMenu();
		switch (option) {
		case 1:
			pDetails.addPerson();
			menu();
			break;
		case 2:
			pDetails.checkPositionByName();
			menu();
			break;
		case 3:
			pDetails.checkPositionById();
			menu();
			break;
		case 4:
			pDetails.updatePersonById();
			menu();
			break;
		case 5:
			pDetails.removePersonById();
			menu();
			break;
		case 6:
			pDetails.removeNPersonFromTheEndOfTheList();
			menu();
			break;
		case 7:
			pDetails.showList();
			menu();
			break;
		case 8:
			exit();
			break;
		}
	}

	public void printMenu() {
		option = 0;
		inputOk = false;
		do {
			try {
				System.out.println("\n");
				System.out.println("Press [1] to add a new person");
				System.out.println(
						"Press [2] to check the current position of a person in the list by the 'first name + last name' ");
				System.out.println("Press [3] to check the current position of a person by the 'ID number'");
				System.out.println("Press [4] to update a person's information by unique ID number");
				System.out.println("Press [5] to remove a person in any position in the list by 'unique ID number'");
				System.out.println("Press [6] to remove 'N number of people' from the end of the list");
				System.out.println("Press [7] Show list");
				System.out.println("Press [8] Exit the program");
				option = Integer.parseInt(br.readLine());

				if (option <= 8 && option >= 1) {
					inputOk = true;
				} else {
					inputOk = false;
					System.out.println("******************************\nOption : " + option + " is not avaliable"
							+ " \nPlease enter a valid option \n******************************");
				}
			} catch (Exception e) {
				inputOk = false;
			}
		} while (inputOk != true);

	}

	// Exits the command prompt.
	public void exit() {
		System.out.println("The program is successfully finalized...");
		System.exit(0);
	}

	public static void main(String[] args) {
		new Main();
	}
}