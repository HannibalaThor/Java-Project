package model.javaproject.novaann.world;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IElement;
import contract.IHero;
import contract.IMobile;
import contract.IMonsterMobile;
import contract.IMotionlessElement;
import contract.INovaAnnWorld;
import contract.IScore;
import model.javaproject.novaann.DAO.DAONovaAnn;
import model.javaproject.novaann.DAO.DBConnection;
import model.javaproject.novaann.sound.NovaAnnSound;
import model.javaproject.novaann.world.element.mobile.Butterfly;
import model.javaproject.novaann.world.element.mobile.Chainmail;
import model.javaproject.novaann.world.element.mobile.DoorMonster;
import model.javaproject.novaann.world.element.mobile.MonsterMobiles;
import model.javaproject.novaann.world.element.mobile.Skeletor;
import model.javaproject.novaann.world.element.mobile.Stormtrooper;
import model.javaproject.novaann.world.element.motionless.MotionlessElement;
import model.javaproject.novaann.world.element.motionless.MotionlessElements;



public class NovaAnnWorld extends Observable implements INovaAnnWorld {
	public IMotionlessElement				elements[][];
	public final ArrayList<IMobile> mobiles;
	public final ArrayList<IMonsterMobile>	mobilesTest;
	private int											width;
	private int											height;
	private static IHero										hero;
	DAONovaAnn daoNovaAnn;
	//private RainbowSpell	rainbowSpell;
	private static IScore score;
	private int xEB;
	private int yEB;

	public NovaAnnWorld(int lvl) throws SQLException {
		this.mobiles = new ArrayList<IMobile>();
		this.mobilesTest = new ArrayList<IMonsterMobile>();
		NovaAnnWorld.score = new Score();

		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		this.daoNovaAnn = new DAONovaAnn(connection);

		try {
			this.loadFile(lvl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public int getWidth() {
		return this.width;
	}


	public int getHeight() {
		return this.height;
	}
	
	public IScore getScoreScore(){
		return score;
	}

	public int getScore(){
		return NovaAnnWorld.score.getScore();
	}


	public void setScore(int score){
		NovaAnnWorld.score.setScore(score);
	}


	public IMotionlessElement getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}

	
	public IHero getHero() {
		return this.hero;
	}

	private void addElement(final IMotionlessElement element, final int x, final int y) {
		
		this.elements[x][y] = element;
		
		if (element != null) {
			element.setNovaAnnWorld(this);

		}
		this.setChanged();
	}


	public void addMobile(final IMonsterMobile mobile, int x, final int y) {
		this.mobiles.add(mobile);
		this.mobilesTest.add(mobile);
		mobile.setNovaAnnWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}


	public void addMobile(final IHero hero, final int x, final int y) {
		this.setHero(hero);
		this.mobiles.add(hero);
		hero.setNovaAnnWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}

	private void loadFile(int lvl) throws IOException{
		int x = 1;
		int y = 1;
		int id = 1;
		this.height = 12;
		this.width = 20;
		Boolean end1 = true;
		boolean end2 = true;
		this.elements = new IMotionlessElement[this.getWidth()][this.getHeight()];

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
		/*final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/clementerb/git/Java-Project/JavaProject/model/map1.txt")));
		String line = null;
		int numLine = 0;
		this.width = 12;
		this.height = 20;
		this.elements = new IMotionlessElement[this.getWidth()][this.getHeight()];
		while ((line = buffer.readLine()) != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				this.addElement(MotionlessElements.getFromFileSymbol(line.toCharArray()[x]), x, numLine);
				if(line.toCharArray()[x] == 'D'){
					this.addMobile(new DoorMonster(), x, numLine);
				} else if (line.toCharArray()[x] == 'E'){
					this.xEB = x;
					this.yEB = numLine;
				}
			}
			numLine++;
		}
		buffer.close();
		this.setChanged();
		this.addMobile(new Skeletor(), 15, 8);
		//this.addMobile(new Chainmail(), 14, 8);
		//this.addMobile(new Butterfly(), 14, 9);
		//this.addMobile(new Stormtrooper(), 15, 9);*/
	}

	private void setHero(final IHero hero) {
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


	public IElement[][] getElements() {
		return this.elements;
	}


	public ArrayList<IMonsterMobile> getMobiles() {
		return this.mobilesTest;
	}


	public ArrayList<IMobile> getMobilesM() {
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
}