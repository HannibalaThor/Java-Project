package NovaAnn;

import java.util.ArrayList;

public interface INovaAnnWorld {
	
	public int getWidth();
	
	public int getHeight();
	
	public Element[][] getElements();
	
	public Hero getHero();
	
	//public void addMonster(Mobile monster, int x, int y);
	
	//public void addMobile(Hero hero, int x, int y);
	
	public void setMobileHasChanged();
	
	public ArrayList<Mobile> getMobiles();
	
	//public void addObserver(Observer o);
	
}
