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
import NovaAnn.motionLessElement.MotionLessELements;
import NovaAnn.motionLessElement.MotionLessElement;




public class NovaAnnWorld extends Entity implements INovaAnnWorld, GObserver{
	
	public  MotionLessElement				elements[][];
	DAONovaAnn daoNovaAnn;
	private int width;
	private int height;
	//private int point = 0;
	public ArrayList<Mobile> mobiles;
	private Hero hero;
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public NovaAnnWorld()throws IOException, SQLException{
		int lvl = 1;
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		daoNovaAnn = new DAONovaAnn(connection);
		this.loadFile(lvl); 
	}
	
	public void addElement(final MotionLessElement element,final int x,final int y) {
		this.elements[x][y] = element;

		if (element != null) {
			element.setNovaAnnWorld(this);
			System.out.print(element.getSprite());
		}
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
		this.elements = new MotionLessElement[21][13];
		
		while(end){
			
			
			
			if (daoNovaAnn.findMotionLess(x, y, lvl) != ' '){
			   MotionLessElement elem1 = MotionLessELements.getFromFileSymbol(daoNovaAnn.findMotionLess( x, y, lvl));
				this.addElement(elem1 , x, y);
			}
			else if (daoNovaAnn.findMotionLess(x, y, lvl) == ' '){
				MotionLessElement elem2 = MotionLessELements.FLOOR;
				this.addElement(elem2 , x, y);		
			}
		x++;
		if(x > 20){
			y ++;
			x=1;
			System.out.print("\n");
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
