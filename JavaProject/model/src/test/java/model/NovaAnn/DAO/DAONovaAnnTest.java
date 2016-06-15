package model.NovaAnn.DAO;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DAONovaAnnTest {

	private static final Connection Connection = null;
	private DAONovaAnn daoNovaAnn;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.daoNovaAnn = new DAONovaAnn(Connection);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDAONovaAnn() {
		assertNotNull(daoNovaAnn);
	}

	@Test
	public void testCreateNovaAnnWorld() {
		NovaAnnWorld entity;
		assertFalse(daoNovaAnn.create(entity));
	}

	@Test
	public void testDeleteNovaAnnWorld() {
		NovaAnnWorld entity;
		assertFalse(daoNovaAnn.delete(entity));
	}

	@Test
	public void testFindMotionLessIntIntInt() {
		assertNull(daoNovaAnn.findMotionLess(3, 1, 2));
	}

	@Test
	public void testFindMobileInt() {
		assertNull(daoNovaAnn.findMobile(2));
	}

}
