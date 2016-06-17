package NovaAnn;

import java.util.ArrayList;

import NovaAnn.mobile.Hero;
import NovaAnn.mobile.Mobile;
import NovaAnn.mobile.MonsterMobile;
import NovaAnn.motionLessElement.MotionLessElement;

public interface INovaAnnWorld {
	
	public int getWidth();
	
	public int getHeight();
	
	public MotionLessElement getElements(int x, int y);
	
	public Hero getHero();
	
	public void addMonster(Mobile monster, int x, int y);
	
	public void addMobile(Hero hero, int x, int y);
	
	public void setMobileHasChanged();
	
	public ArrayList<Mobile> getMobiles();

	public void addMobile(MonsterMobile monsterMobile, int x, int y);
	
	//public void addObserver(Observer o);
	
}
