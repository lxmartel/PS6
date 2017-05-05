package base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	private static PersonDomainModel per1 = new PersonDomainModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		per1.setBirthday(new Date(0));
		per1.setCity("Newark");
		per1.setFirstName("Lorna");
		per1.setLastName("Martel");
		per1.setPostalCode(19717);
		per1.setStreet("35 Ray Street");
		
		PersonDAL.addPerson(per1);
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertNotNull(per2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(per1.getPersonID()); 
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestGetAllPerson()
	{
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
	}
	
	@Test
	public void TestUpdateDeletePerson() {
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per1.getPersonID(), per2.getPersonID());
		
		per2.setLastName("Kennedy");
		PersonDAL.updatePerson(per2);
		
		PersonDomainModel per3 = PersonDAL.getPerson(per2.getPersonID());
		assertEquals(per2.getLastName(), per3.getLastName());
		assertNotEquals(per1.getLastName(),per3.getLastName());
		
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDomainModel per4 = PersonDAL.getPerson(per3.getPersonID());
		assertNull(per4);
	}
	
	@Test
	public void AddPerson() {
		PersonDomainModel per1 = new PersonDomainModel();
		per1.setBirthday(new Date(0));
		per1.setCity("Newark");
		per1.setFirstName("Lorna");
		per1.setLastName("Martel"); 
		per1.setPostalCode(19717);
		per1.setStreet("35 Ray Street");
		
		PersonDAL.addPerson(per1);
		
		
	}

}
