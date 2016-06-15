package NovaAnn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;

import jpu2016.nettle.world.element.motionless.MotionlessElement;
import jpu2016.nettle.world.element.motionless.MotionlessElements;

public class NovaAnnWorld extends Observable implements INovaAnnWorld{
	
	private int width;
	private int height;
	private int point = 0;
	public ArrayList<Mobile> mobiles;
	private Hero hero;
	public MontionlessElements elements[][];
	
	@Override
	public int getWidth(){
		return width;
	}
	
	@Override
	public int getHeight(){
		return height;
	}

	public NovaAnnWorld(String fileName)throws IOException{
		this.loadFile(fileName); 
	}
	
	public void addElement(MotionlessElements element, int x, int y){
		this.elements[x][y] = element;
		if(element != null){
			element.setNovaAnnWorld(this);
		} 
		this.setChanged(); 
	}
	
	public void addMobile(Hero hero, int x, int y){
		this.mobiles.add(hero);
		hero.setNettleWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void addMonster(Mobile monster, int x, int y) {
		this.mobiles.add(monster);
		monster.setNettleWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}
	
	public Element[][] getElements() {
		return elements;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public ArrayList<Mobile> getMobiles() {
		return mobiles;
	}
	
	private void loadFile(String fileName){
		// Database with Clement
	}

	public void setMobileHasChanged(){
		this.setChanged();
		this.notifyObservers();
	}
	
	public void notifyObservers(){
		super.notifyObservers();
	}

}
