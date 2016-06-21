package javaproject.novaann.world.element;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.junit.BeforeClass;

import javaproject.novaann.world.NovaAnnWorld;
import javaproject.novaann.world.element.mobile.Skeletor;

public class ElementTest {
	Skeletor skeletor;
	ISprite sprite;
	String image;
	String c;
	NovaAnnWorld novaAnnWorld;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.skeletor = new Skeletor();
		this.sprite = new Sprite(c, image);
		this.novaAnnWorld = new NovaAnnWorld();

	}

	@Test
	public void testGetSprite() {
		skeletor.setSprite(sprite);
		assertEquals(sprite, skeletor.getSprite());
	}

	@Test
	public void testGetPermeability() {

	}

	@Test
	public void testGetNovaAnnWorld() {
		skeletor.setNovaAnnWorld(novaAnnWorld);
		assertEquals(novaAnnWorld, skeletor.getNovaAnnWorld());
	}

	@Test
	public void testGetImage() {
		assertNotNull(skeletor.getImage());
		

	}

}