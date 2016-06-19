package javaproject.novaann.world;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;


import javaproject.novaann.sound.NovaAnnSound;
import javaproject.novaann.world.element.Element;
import javaproject.novaann.world.element.mobile.Hero;
import javaproject.novaann.world.element.mobile.Mobile;
import javaproject.novaann.world.element.mobile.MonsterMobile;
import javaproject.novaann.world.element.mobile.Skeletor;
import javaproject.novaann.world.element.motionless.MotionlessElement;
import javaproject.novaann.world.element.motionless.MotionlessElements;

public class NovaAnnWorld extends Observable implements INovaAnnWorld {
	public MotionlessElement				elements[][];
	public final ArrayList<Mobile> mobiles;
	public final ArrayList<MonsterMobile>	mobilesTest;
	private int											width;
	private int											height;
	private static Hero										hero;
	//private RainbowSpell	rainbowSpell;

	private NovaAnnWorld() {
		this.mobiles = new ArrayList<Mobile>();
		this.mobilesTest = new ArrayList<MonsterMobile>();
	}

	public NovaAnnWorld(final String fileName) throws IOException {
		this();
		this.loadFile(fileName);
	}

	//@Override
	public int getWidth() {
		return this.width;
	}

	//@Override
	public int getHeight() {
		return this.height;
	}

	//@Override
	public MotionlessElement getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}

	//@Override
	public Hero getHero() {
		return this.hero;
	}

	private void addElement(final MotionlessElement element, final int x, final int y) {
		this.elements[x][y] = element;
		if (element != null) {
			element.setNovaAnnWorld(this);
		}
		this.setChanged();
	}

	//@Override
	public void addMobile(final MonsterMobile mobile, int x, final int y) {
		this.mobiles.add(mobile);
		this.mobilesTest.add(mobile);
		mobile.setNovaAnnWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}

	//@Override
	public void addMobile(final Hero hero, final int x, final int y) {
		this.setHero(hero);
		this.mobiles.add(hero);
		hero.setNovaAnnWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}

	private void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line = null;
		int numLine = 0;
		this.width = Integer.parseInt(line);
		line = buffer.readLine();
		this.height = Integer.parseInt(line);
		this.elements = new MotionlessElement[this.getWidth()][this.getHeight()];
		while ((line = buffer.readLine()) != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				this.addElement(MotionlessElements.getFromFileSymbol(line.toCharArray()[x]), x, numLine);
			}
			numLine++;
		}
		buffer.close();
		this.setChanged();
		this.addMobile(new Skeletor(), 12, 9);
	}

	private void setHero(final Hero hero) {
		this.hero = hero;
		this.setChanged();
	}

	//@Override
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	//@Override
	public void notifyObservers() {
		super.notifyObservers();
	}

	//@Override
	public Element[][] getElements() {
		return this.elements;
	}

	//@Override
	public ArrayList<MonsterMobile> getMobiles() {
		return this.mobilesTest;
	}

	//@Override
	public ArrayList<Mobile> getMobilesM() {
		return this.mobiles;
	}

	public static int getXhero(){
		return hero.getX();
	}
	public static int getYhero(){
		return hero.getY();
	}

	//@Override
	public void death(){


		for(int x = 0; x <= (this.mobilesTest.size()-1); x++){
			if((NovaAnnWorld.getXhero() == this.mobiles.get(x).getX()) && (NovaAnnWorld.getYhero() == this.mobilesTest.get(x).getY())){
				Thread playWave=new NovaAnnSound("sounds/game_over.wav");
				playWave.start();
				//this.mobiles.remove(this.mobilesTest.size());
			}
		}
	}
}
