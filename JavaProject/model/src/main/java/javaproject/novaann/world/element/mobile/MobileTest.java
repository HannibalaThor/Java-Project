package javaproject.novaann.world.element.mobile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javaproject.novaann.world.NovaAnnWorld;

public class MobileTest {
	Hero hero;
	Skeletor skeletor;
	NovaAnnWorld novaAnnWorld;

	@Before
	public void setUp() throws Exception {
		this.hero = new Hero();
		this.skeletor = new Skeletor();
		this.novaAnnWorld = new NovaAnnWorld();
		skeletor.setNovaAnnWorld(novaAnnWorld);
		hero.setNovaAnnWorld(novaAnnWorld);
		
	}

	@Test
	public void testIsMovePossible() {
		skeletor.setX(10);
		skeletor.setY(5);
		skeletor.setNovaAnnWorld(novaAnnWorld);
		hero.setX(5);
		hero.setY(5);
		assertTrue(hero.isMovePossible(skeletor.getX(), skeletor.getY()));
	}
	
	@Test
	public void testIsMovePossibleM() {
		skeletor.setX(10);
		skeletor.setY(5);
		skeletor.setNovaAnnWorld(novaAnnWorld);
		hero.setX(5);
		hero.setY(5);
		assertTrue(hero.isMovePossibleM(hero.getX(), hero.getY()));
	}

}
