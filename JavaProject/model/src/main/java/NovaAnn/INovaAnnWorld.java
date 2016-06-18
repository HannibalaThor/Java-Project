package NovaAnn;

import java.util.ArrayList;

import NovaAnn.mobile.Hero;
import NovaAnn.mobile.Mobile;
import NovaAnn.motionLessElement.MotionLessElement;

public interface INovaAnnWorld {
	
	public int getWidth();
	
	public int getHeight();
	
	public MotionLessElement getElements(int x, int y);
	
	public Hero getHero();
	
	public void addMobile(Mobile mobile, int x, int y);
	
	public void setMobileHasChanged();
	
	public ArrayList<Mobile> getMobiles();
	
	//public void addObserver(Observer o);
	
}
