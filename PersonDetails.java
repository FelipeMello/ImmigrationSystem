package immigrationSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonDetails {
	String regex;
	boolean inputOk;
	String fn, ln, doa, pn, answer;
	int hk, id, position, option;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	LinkedList<String> linkedList = new LinkedList<String>();
	E person;
	

	// This method validate the user inputs for the name and surname. Only words
	// are valid.
	public void enterName() {
		regex = "^[\\p{L} .'-]+$";
		inputOk = false;
		do {
			try {
				System.out.print("First name please: ");
				fn = br.readLine();
				if (fn.matches(regex)) {
					System.out.print("Surname please: ");
					ln = br.readLine();
					if (ln.matches(regex)) {
						inputOk = true;
					} else {
						System.out.println("Surname invalid please enter a valid surname");
						inputOk = false;
					}
				} else {
					inputOk = false;
					System.out.println("First name not valid please enter a valid name");
				}
			} catch (Exception e) {
				inputOk = false;

			}
		} while (inputOk != true);
	}

	// This method validates the user inputs for date. only dates at the format
	// dd/mm/yyyy are valid.
	public void enterDate() {
		inputOk = false;
		do {
			try {
				Date date = null;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.print("Please enter the date of your arrival (dd/MM/yyyy): ");
				doa = br.readLine();
				date = sdf.parse(doa);
				sdf.parse(doa);

				if (doa.equals(sdf.format(date))) {
					inputOk = true;
				}
			} catch (Exception e) {
				System.out.println(doa + " is not in the valid format"
						+ " \nPlease enter the valid format as specified(dd/MM/yyyy)");
			}
		} while (inputOk != true);
	}

	// This method validates the user inputs for passport numbers, maximum 2
	// letters and maximum 7 numbers are valid
	public void enterPassport() {
		inputOk = false;
		regex = "[a-zA-Z]{2}[0-9]{7}";
		do {
			try {
				System.out.print("Passport number: ");
				pn = br.readLine();
				pn = pn.toUpperCase();

				if (pn.matches(regex)) {
					inputOk = true;
					System.out.println("Valid passport");
				} else {
					inputOk = false;
					System.out.println("This passport is not valid please enter a valid passport\n"
							+ "Format: XX000000000\nUsually a passport has 2 first as characters as letters and the rest are numbers\n"
							+ "Example:PA1900025");
				}
			} catch (Exception e) {
				inputOk = false;
				System.out.println("This passport is not valid please enter a valid passport\n"
						+ "Format: XX000000000\nUsually a passport has 2 first as charcters as letters and the rest are numbers\n"
						+ "Example:PA1900025");
			}

		} while (inputOk != true);
	}

	// this method checks if the person has kids in order to place them in the
	// correct place in the list
	public void enterChild() {
		inputOk = false;
		do {
			try {
				System.out.print(
						"Person has a child less than 3 year old with them?\n Please only enter 'yes' or 'no' as your answer: ");
				answer = br.readLine();
				answer = answer.toLowerCase();
				if (answer.equals("yes")) {
					boolean ageOk = false;
					do {
						try {
							System.out.print("Please press (1) if the child is less than than '1' year old "
									+ "\nPlease press(2) if the child is less than 3 years old");
							hk = Integer.parseInt(br.readLine());
							if (hk <= 2 && hk >= 1) {
								ageOk = true;
								inputOk = true;
							}
						} catch (IOException e) {
							System.out.print("Please enter a valid option\n Only press '1' or '2': ");
							ageOk = false;
						}
					} while (ageOk != true);

				} else if (answer.equals("no")) {
					System.out.println("No kids lets continue");
					hk = 0;
					inputOk = true;
				}
			} catch (Exception e) {
				System.out.print("Please enter a valid answer such as 'yes' or 'no': ");
				inputOk = false;
			}

		} while (inputOk != true);

	}

	public void enterPosition() {
		inputOk = false;
		answer = null;
		do {
			try {
				System.out.println(
						"Would like to add this person to a certain position ?" + "/nPlease enter 'yes' or 'no'");
				
				answer = br.readLine();
				answer = answer.toLowerCase();
				if (answer.equals("yes")) {
					boolean positionOk = false;
					do {
						try {
							System.out
							.println("What position would like ? The last position is : " + linkedList.size());
							position = Integer.parseInt(br.readLine());
							if (position <= linkedList.size()) {
								hk = 3;
								positionOk = true;
								inputOk = true;
							}
							

						} catch (IOException e) {
							System.out.println("Pleaser enter a valid position \n" + "The position '" + position
									+ "' is not valid");
						}

					} while (positionOk != true);
				} else if (answer.equals("no")) {
					inputOk = true;
				}
			} catch (IOException e) {
				System.out.println("Your answer " + answer + " is not valid");
			}

		} while (inputOk != true);
	}

	// This method adds a persons information to the list. first name, last
	// name, date of arrival and passport number.
	public void addToTheList() {
		person = new E(fn, ln, doa, pn);

		switch (hk) {
		case 0:
			linkedList.add(person);
			break;
		case 1:
			linkedList.addFirst(person);
			break;
		case 2:
			linkedList.addToTheMiddleOfList(person);
			break;
		case 3:
			linkedList.add(position, person);
		}

		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println(
				"The person was added to the list at postion : " + linkedList.checkPositionById(person.getId()));
		System.out.println(" ID: " + person.getId() + "\n " + "First Name: " + person.getFirstName() + "\n "
				+ "Last name: " + person.getLastName() + "\n " + "Date of Arrival: " + person.getDateOfArrival() + "\n "
				+ "Passport number: " + person.getPassportNumber());
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
	}

	/*
	 * This method is called when the user needs to update the information a a
	 * person.
	 */

	public void updatePersonById() {
		// TODO
		inputOk = false;
		id = 0;
		do {
			try {
				if (linkedList.isEmpty() == true) {
					System.out.println("The List is empty and there's nothing to update");
					inputOk = true;
				} else {
					System.out.print("Enter the ID: ");
					// check if the id is Valid
					id = Integer.parseInt(br.readLine());

				}

				if (id >= 1) {
					enterName();
					enterDate();
					enterPassport();
					inputOk = true;

					linkedList.updatePersonById(id, fn, ln, doa, pn);
				}
			} catch (NumberFormatException | IOException e) {
				System.out.print("Please enter a valid ID: ");
			}

		} while (inputOk != true);
	}

	/*
	 * This method is called when the user needs to check the position of a
	 * person in the list by the name, only words are valid as inputs
	 */

	public void checkPositionByName() {
		regex = "^[\\p{L} .'-]+$";
		inputOk = false;
		do {
			try {
				if (linkedList.isEmpty() == true) {
					System.out.println("The List is empty and there's no position to check");
					inputOk = true;
				} else {
					System.out.print("First name: ");
					fn = br.readLine();
					if (fn.matches(regex)) {
						do {
							System.out.print("Last name: ");
							ln = br.readLine();
							if (ln.matches(regex)) {
								inputOk = true;
								System.out.print("Postion: " + linkedList.checkPositionByName(fn, ln));
							} else {
								System.out.println("'" + ln + "' Invalid surname: ");
							}
						} while (inputOk != true);
					} else {
						System.out.print("'" + fn + "' Invalid Please enter a proper name: ");
					}
				}
			} catch (Exception e) {
				System.out.println(fn + " Invalid");
				inputOk = false;
			}

		} while (inputOk != true);
	}

	/*
	 * This method is called when the user needs to check the position of a
	 * person in the list by the unique ID. Only numbers are valid
	 */
	public void checkPositionById() {
		id = 0;
		inputOk = false;

		do {
			try {
				if (linkedList.isEmpty() == true) {
					System.out.println("The List is empty and there's no position to check");
					inputOk = true;
				} else {
					System.out.print("Please enter the ID number : ");
					id = Integer.parseInt(br.readLine());
					inputOk = true;
					System.out.println("Position : " + linkedList.checkPositionById(id));
				}

			} catch (NumberFormatException | IOException e) {
				System.out.println("Please enter only Integers");
				inputOk = false;
			}
		} while (inputOk != true);

	}

	/*
	 * This method is called when the user needs to remove a person by the
	 * unique ID.
	 */
	public void removePersonById() {
		// TOO
		inputOk = false;
		id = 0;
		do {
			try {

				if (linkedList.isEmpty() == true) {
					System.out.println("The List is empty and there's nothing to remove");
					inputOk = true;
				} else {
					System.out.println("Remove person by unique ID number.");
					id = Integer.parseInt(br.readLine());
					int index = linkedList.checkPositionById(id);
					if (index - 1 == 0) {
						linkedList.removeFirstPosition();
						inputOk = true;
					} else if (index - 1 >= 1) {
						linkedList.removePersonById(id);
						inputOk = true;
					}
				}
			} catch (NumberFormatException | IOException e) {
				System.out.print("Please enter a valid ID: ");
			}
		} while (inputOk != true);
	}

	/*
	 * This method is called when the user needs to remove any number of people
	 * from the end of the list.
	 */
	public void removeNPersonFromTheEndOfTheList() {
		// TODO
		inputOk = false;
		int indexes = 0;
		do {
			try {
				if (linkedList.isEmpty() == true) {
					System.out.println("The List is empty and there's nothing to remove");
					inputOk = true;
					System.out.println("List size :'"+linkedList.size()+"'");
				} else {
					System.out.println("Remove N person from the end of the list.");
					
					indexes = Integer.parseInt(br.readLine());
					
					if(linkedList.size()>= indexes){
						//continue
						linkedList.removeNfromTheEndOfTheList(indexes);
						inputOk = true;
					}else{
						System.out.println("The is only "+linkedList.size()+" postions on the list");
					}

				
				}
			} catch (NumberFormatException | IOException e) {
				System.out.print("Please enter a valid ID: ");
			}
		} while (inputOk != true);

	}

	/*
	 * This method works to add a new person into the list, and for this program
	 * the user has 4 options to insert a new person. So, the method will point
	 * the next step according to the chosen option. e.g: adding to the end, to
	 * the first, to the middle or in any position in the list. Each option has
	 * its own method.
	 */

	public void addPerson() {
		enterName();
		enterDate();
		enterPassport();
		if(linkedList.size()>=1){
			enterChild();
			enterPosition();	
		}	
		addToTheList();
	}
	

	// This method is called when the user needs to display the full list of
	// people.
	public void showList() {

		if (linkedList.isEmpty() == true) {
			System.out.println("The List is empty and there's nothing to show");
			inputOk = true;
		} else {
		linkedList.printList();
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		}
		}

}
