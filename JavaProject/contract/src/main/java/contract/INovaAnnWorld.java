package contract;

import java.util.ArrayList;
import java.util.Observer;



public interface INovaAnnWorld {

	public int getWidth();

	public int getHeight();

	public int getScore();

	public void setScore(int score);

	public IMotionlessElement getElements(int x, int y);

	public IHero getHero();

	public void addMobile(final IMonsterMobile mobile, int x, final int y);

	public void addMobile(IHero hero, int x, int y);

	public void setMobileHasChanged();

	public IElement[][] getElements();

	public ArrayList<IMonsterMobile> getMobiles();

	public void addObserver(Observer o);

	public ArrayList<IMobile> getMobilesM();

	public void death();

	public void destructCollected();
	
	public Observer getScoreScore();

}