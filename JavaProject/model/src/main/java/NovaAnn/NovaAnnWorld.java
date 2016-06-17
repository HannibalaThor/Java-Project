package NovaAnn;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.sql.Connection;


import NovaAnn.DAO.DAONovaAnn;
import NovaAnn.DAO.DBConnection;
import NovaAnn.DAO.Entity;
import NovaAnn.mobile.Hero;
import NovaAnn.mobile.Mobile;
import NovaAnn.mobile.MonsterMobile;
import NovaAnn.motionLessElement.MotionLessElement;

public class NovaAnnWorld extends Entity implements INovaAnnWorld, GObserver{
	
	
	DAONovaAnn daoNovaAnn;
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

	public NovaAnnWorld()throws IOException{
		int lvl = 1;
		this.loadFile(lvl); 
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
	
	private void loadFile(int lvl){
		int x = 1;
		int y = 1;
		Boolean end = true;
		
		while(end){
			
		this.addElement(MotionLessElement.getfileSymbole(daoNovaAnn.findMotionLess( x, y, lvl)), x, y);
		x++;
		if(x > 20){
			y ++;
			x=1;
		}
		if(y >12){
			end = false;
		}
		}
	}

	public void setMobileHasChanged(){
		this.setChanged();
		this.notifyObservers();
	}
	
	public void notifyObservers(){
		super.notifyObservers();
	}

	public void perform() {
		// TODO Auto-generated method stub
		
	}

	public void addMobile(MonsterMobile monsterMobile, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
