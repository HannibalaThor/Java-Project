package NovaAnn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import NovaAnn.mobile.Hero;
import NovaAnn.mobile.Mobile;
import NovaAnn.motionLessElement.MotionLessElement;

public class NovaAnnWorld extends Observable implements INovaAnnWorld{
	
	private int width;
	private int height;
	//private int point = 0;
	public ArrayList<Mobile> mobiles;
	private Hero hero;
	public MotionLessElement elements[][];
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public NovaAnnWorld(String fileName)throws IOException{
		this.loadFile(fileName); 
	}
	
	public void addElement(MotionLessElement element, int x, int y){
		this.elements[x][y] = element;
		if(element != null){
			element.setNovaAnnWorld(this);
		} 
		this.setChanged(); 
	}
	
	public void addMobile(Hero hero, int x, int y){
		this.mobiles.add(hero);
		hero.setNovaAnnWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void addMonster(Mobile monster, int x, int y) {
		this.mobiles.add(monster);
		monster.setNovaAnnWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}
	
	public MotionLessElement getElements(int x, int y) {
		return this.elements[x][y];
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
