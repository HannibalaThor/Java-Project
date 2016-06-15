package model.NovaAnn.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DBPropertiesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private DBProperties DBroperties;

	@Before
	public void setUp() throws Exception {
		this.DBroperties = new DBProperties();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUrl() {
		final String expected = "jdbc:mysql://localhost:8889/JavaLorann";
		 assertEquals(expected, this.DBroperties.getUrl());
	}

	@Test
	public void testGetLogin() {
		final String expected = "root";
		 assertEquals(expected, this.DBroperties.getLogin());
	}

	@Test
	public void testGetPassword() {
		final String expected = "root";
		 assertEquals(expected, this.DBroperties.getPassword());
	}

}
