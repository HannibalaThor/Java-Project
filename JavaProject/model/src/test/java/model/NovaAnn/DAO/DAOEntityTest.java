package model.NovaAnn.DAO;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DAOEntityTest {

	private static final Connection Connection = null;
	private DAOEntity daoEntity;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
		this.daoEntity = new DAOEntity(Connection);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDAOEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConnection() {
		assertNotNull(this.daoEntity.getConnection());
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindMotionLess() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindMobile() {
		fail("Not yet implemented");
	}

}
