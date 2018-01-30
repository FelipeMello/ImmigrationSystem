package immigrationSystem;


import static org.junit.Assert.*;
import org.junit.Test;




/* The unique ID of each person object in the class E, is auto increment, 
 * as the test class runs all the tests in the same time,
 * the ID will not reset for every test.
 * Although, for every test is generated a new list
 * 
 * Also all the are passing. If a test fail, try to check the unique ID number of the person*/
public class test {
  
  LinkedList<String> list = new LinkedList<String>();
  
  @Test
  public void testAddTwoPeopleToTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    list.add(p1);
    list.add(p2);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.size());
  }
  
  @Test
  public void testaddNewPersonToTheFirstPositionOfTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    list.add(p1);
    list.add(p2);
    E p3 = new E("Tom", "Cruise", "24/11/2017", "TC123");
    list.addFirst(p3);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(1, list.checkPositionByName("Tom", "Cruise"));
  }
  
  @Test
  public void testaddNewPersonToTheMidleOfTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    list.add(p1);
    list.add(p2);
    E p3 = new E("Tom", "Cruise", "24/11/2017", "TC123");
    list.addToTheMiddleOfList(p3);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionByName("Tom", "Cruise"));
  }
  
  @Test
  public void testaddNewPersonToAnyIndexToTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    E p3 = new E("Tom", "Cruise", "24/11/2017", "TC123");
    E p4 = new E("Emma", "Stone", "24/11/2017", "ES123");
    E p5 = new E("Olivia", "Palito", "24/11/2017", "OP123");
    E p6 = new E("Natalie", "Portman", "30/11/2017", "AL123");
    E p7 = new E("Sandra", "Bullock", "20/12/2017", "SB123");
    list.add(p1);
    list.add(p2);
    list.add(p3);
    list.add(p4);
    list.add(p5);
    list.add(p6);
    list.add(2, p7);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionByName("Sandra", "Bullock"));
  }
  
  @Test
  public void testcheckPositionByNameInTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    list.add(p1);
    list.add(p2);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionByName("Felipe", "Mello"));
  }
  
  @Test
  public void testcheckPositionByIDInTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    list.add(p1);
    list.add(p2);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionById(37));
  }
  
  @Test
  public void testupdatePersonByIdInTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    list.add(p1);
    list.add(p2);
    list.updatePersonById(33, "Sandra", "Bullock", "20/12/2017", "SB123");
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionByName("Sandra", "Bullock"));
    
  }
  
  @Test
  public void testremovePersonByIdInTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    list.add(p1);
    list.add(p2);
    list.removePersonById(7);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(1, list.size());
  }
  
  @Test
  public void testremoveNPersonFromTheEndOfTheList() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    E p3 = new E("Tom", "Cruise", "24/11/2017", "TC123");
    E p4 = new E("Felipe", "Melo", "24/11/2017", "FM123");
    E p5 = new E("Emma", "Stone", "24/11/2017", "ES123");
    E p6 = new E("Natalie", "Portman", "30/11/2017", "AL123");
    E p7 = new E("Sandra", "Bullock", "20/12/2017", "SB123");
    list.add(p1);
    list.add(p2);
    list.add(p3);
    list.add(p4);
    list.add(p5);
    list.add(p6);
    list.add(p7);
    list.removeNfromTheEndOfTheList(4);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(3, list.size());
  }
  
  @Test
  public void testListSize() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    E p3 = new E("Tom", "Cruise", "24/11/2017", "TC123");
    E p4 = new E("Felipe", "Melo", "24/11/2017", "FM123");
    E p5 = new E("Emma", "Stone", "24/11/2017", "ES123");
    E p6 = new E("Natalie", "Portman", "30/11/2017", "AL123");
    E p7 = new E("Sandra", "Bullock", "20/12/2017", "SB123");
    list.add(p1);
    list.add(p2);
    list.add(p3);
    list.add(p4);
    list.add(p5);
    list.add(p6);
    list.add(p7);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(7, list.size());
  }
  
  @Test
  public void testremoveFirstPosition() {
    E p1 = new E("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    E p2 = new E("Felipe", "Mello", "24/11/2017", "FM123");
    E p3 = new E("Tom", "Cruise", "24/11/2017", "TC123");
    E p4 = new E("Felipe", "Melo", "24/11/2017", "FM123");
    E p5 = new E("Emma", "Stone", "24/11/2017", "ES123");
    E p6 = new E("Natalie", "Portman", "30/11/2017", "AL123");
    E p7 = new E("Sandra", "Bullock", "20/12/2017", "SB123");
    list.add(p1);
    list.add(p2);
    list.add(p3);
    list.add(p4);
    list.add(p5);
    list.add(p6);
    list.add(p7);
    list.removeFirstPosition();
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(6, list.size());
  }
  
  @Test
  public void testIsEmpty(){
	 boolean answer = true;
	 boolean test = list.isEmpty();
	 
	 assertEquals(answer, test);
  }
  
  
  
}