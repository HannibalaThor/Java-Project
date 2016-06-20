package model.javaproject.novaann.world;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.Element;
import contract.INovaAnnWorld;
import model.javaproject.novaann.DAO.DAONovaAnn;
import model.javaproject.novaann.DAO.DBConnection;
import model.javaproject.novaann.sound.NovaAnnSound;
import model.javaproject.novaann.world.element.mobile.Hero;
import model.javaproject.novaann.world.element.mobile.Mobile;
import model.javaproject.novaann.world.element.mobile.MonsterMobile;
import model.javaproject.novaann.world.element.mobile.MonsterMobiles;
import model.javaproject.novaann.world.element.motionless.MotionlessElement;
import model.javaproject.novaann.world.element.motionless.MotionlessElements;



public class NovaAnnWorld extends Observable implements INovaAnnWorld {
	public MotionlessElement				elements[][];
	public final ArrayList<Mobile> mobiles;
	public final ArrayList<MonsterMobile>	mobilesTest;
	private int											width;
	private int											height;
	private static Hero										hero;
	DAONovaAnn daoNovaAnn;
	//private RainbowSpell	rainbowSpell;
	private static Score score;
	private int xEB;
	private int yEB;

	public NovaAnnWorld(int lvl) throws SQLException {
		this.mobiles = new ArrayList<Mobile>();
		this.mobilesTest = new ArrayList<MonsterMobile>();
		NovaAnnWorld.score = new Score();

		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		this.daoNovaAnn = new DAONovaAnn(connection);

		this.loadFile(lvl);
	}


	public int getWidth() {
		return this.width;
	}


	public int getHeight() {
		return this.height;
	}

	public static Score getScoreScore(){
		return score;
	}

	public int getScore(){
		return NovaAnnWorld.score.getScore();
	}


	public void setScore(int score){
		NovaAnnWorld.score.setScore(score);
	}


	public MotionlessElement getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}

	
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


	public void addMobile(final MonsterMobile mobile, int x, final int y) {
		this.mobiles.add(mobile);
		this.mobilesTest.add(mobile);
		mobile.setNovaAnnWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}


	public void addMobile(final Hero hero, final int x, final int y) {
		this.setHero(hero);
		this.mobiles.add(hero);
		hero.setNovaAnnWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}

	private void loadFile(int lvl){
		int x = 1;
		int y = 1;
		int id = 1;
		this.height = 12;
		this.width = 20;
		Boolean end1 = true;
		boolean end2 = true;
		this.elements = new MotionlessElement[this.getWidth()][this.getHeight()];

		while(end1 == true){
			int a = x- 1;
			int b = y - 1;
			if ((this.daoNovaAnn.findMotionLess(x, y, lvl) != ' ') && (this.daoNovaAnn.findMotionLess(x, y, lvl) != 'D')){
				this.addElement(MotionlessElements.getFromFileSymbol(this.daoNovaAnn.findMotionLess( x, y, lvl)) , a, b);
				if(this.daoNovaAnn.findMotionLess(x, y, lvl) == '*'){
					this.xEB = a;
					this.yEB = b;
				}
			}
			else if (this.daoNovaAnn.findMotionLess(x, y, lvl) == 'D'){
				this.addElement(MotionlessElements.DOOR , a, b);
				this.addMobile(MonsterMobiles.DOORMONSTER, a,b);
			} else if (this.daoNovaAnn.findMotionLess(x, y, lvl) == ' '){
				this.addElement(MotionlessElements.FLOOR , a, b);
			}
			x++;
			if(x >= 21){
				y ++;
				x=1;
			}
			if(y >=13){
				end1 = false;
			}

		}

		while(end2 == true){
			id++;
			this.daoNovaAnn.findMobile(lvl, id);
			if ((this.daoNovaAnn.getX() >= 0) && (this.daoNovaAnn.getY() >= 0)){
				this.addMobile(MonsterMobiles.getElement(id), this.daoNovaAnn.getX() -1 , this.daoNovaAnn.getY() -1);
			}

			if (id > 4){
				end2 = false;
			}
		}
		this.setChanged();
	}

	private void setHero(final Hero hero) {
		this.hero = hero;
		this.setChanged();
	}

	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void notifyObservers() {
		super.notifyObservers();
	}


	public Element[][] getElements() {
		return this.elements;
	}


	public ArrayList<MonsterMobile> getMobiles() {
		return this.mobilesTest;
	}


	public ArrayList<Mobile> getMobilesM() {
		return this.mobiles;
	}

	public static int getXhero(){
		return hero.getX();
	}
	public static int getYhero(){
		return hero.getY();
	}


	public void death(){
		for(int x = 0; x <= (this.mobilesTest.size()-1); x++){

			if((NovaAnnWorld.getXhero() == this.mobiles.get(x).getX()) && (NovaAnnWorld.getYhero() == this.mobilesTest.get(x).getY())){
				Thread playWave=new NovaAnnSound("sounds/game_over.wav");
				playWave.start();
				this.mobiles.remove(this.mobilesTest.size());
			} else if((this.mobiles.get(x).getClass().getName() == "javaproject.novaann.world.element.mobile.DoorMonster") && (this.elements[this.xEB][this.yEB].isCollected() == true)){
				this.mobiles.remove(x);
				this.mobilesTest.remove(x);
			}
		}
	}


	public void destructCollected(){
		if((this.elements[getXhero()][getYhero()].getClass().getName() == "javaproject.novaann.world.element.motionless.Gold") || (this.elements[getXhero()][getYhero()].getClass().getName() == "javaproject.novaann.world.element.motionless.EnergyBubble")){
			this.elements[getXhero()][getYhero()].setCollected(true);
		}
		this.death();
		if(this.elements[getXhero()][getYhero()].isCollected() == true){
			this.addElement(MotionlessElements.getFromFileSymbol(' '), getXhero(), getYhero());
		}
	}


	public contract.MotionlessElement getElements(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}


	public contract.Hero getHero() {
		// TODO Auto-generated method stub
		return null;
	}


	public void addMobile(contract.MonsterMobile mobile, int x, int y) {
		// TODO Auto-generated method stub
		
	}


	public void addMobile(contract.Hero hero, int x, int y) {
		// TODO Auto-generated method stub
		
	}


	public Element[][] getElements() {
		// TODO Auto-generated method stub
		return null;
	}
}