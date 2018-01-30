package immigrationSystem;


/* This method has the object of the program (Person) where contain the first name, last name, date of arrival
 passport number and a unique id that is generated automatically when the user adds a new person.
 For every variable in the method a get and set is created, on set, the information can be created
 on get, the information can be retrieved.    
 */

public class E {
  private static int count = 0;
  private int id;
  private String firstName;
  private String lastName;
  private String dateOfArrival;
  private String passportNumber; 
  
  // This method initializes the object person
  public E(String firstName, String lastName, String dateOfArrival, String passportNumber) {
  	super();
  	this.id = ++ E.count;
  	this.firstName = firstName;
  	this.lastName = lastName;
  	this.dateOfArrival = dateOfArrival;
  	this.passportNumber = passportNumber;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getDateOfArrival() {
    return dateOfArrival;
  }
  
  public void setDateOfArrival(String dateOfArrival) {
    this.dateOfArrival = dateOfArrival;
  }
  
  public String getPassportNumber() {
    return passportNumber;
  }
  
  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }
  
  /* This method is creating a string that contains the id, first name and last name for every person 
   in the list. This information is used by the method printList() in the LinkedList class.*/ 
  public String toString() {
    
    return String.format("%-5s%-15s%-30s%-21s%-15s", id, firstName, lastName, dateOfArrival, passportNumber);
    
  }
  
 }