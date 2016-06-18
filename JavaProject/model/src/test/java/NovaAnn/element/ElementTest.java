package NovaAnn.element;

import org.junit.*;

import NovaAnn.world.element.Element;


public class ElementTest {
	private Element element;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	@Before
	public void setUp() throws Exception {
		Sprite sprite = new Sprite("c");
		this.element = new Element(sprite,Permeability.BLOCKING);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetSprite(){
		
	}
	
	@Test
	public void testSetSprite(){
	}
	
	@Test
	public void testGetPermeability(){
	}
	
	@Test
	public void testSetPermeability(){
	}
	
	@Test
	public void testGetNovaAnnWorld(){
	}
	
	@Test
	public void testSetNovaAnnWorld(){
	}
	
	@Test
	public void testGetImage(){
		//Test
	}
	
}
