package contract;

import java.util.ArrayList;
import java.util.Observer;



public interface INovaAnnWorld {

	public int getWidth();

	public int getHeight();

	public int getScore();

	public void setScore(int score);

	public MotionlessElement getElements(int x, int y);

	public Hero getHero();

	public void addMobile(final MonsterMobile mobile, int x, final int y);

	public void addMobile(Hero hero, int x, int y);

	public void setMobileHasChanged();

	public Element[][] getElements();

	public ArrayList<MonsterMobile> getMobiles();

	public void addObserver(Observer o);

	public ArrayList<Mobile> getMobilesM();

	public void death();

	public void destructCollected();

}