package NovaAnn.motionLessElement;

import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;

public class Gold extends MotionLessElement implements ICollect {
	private int collectPoint;
	private boolean collected;
	
	public Gold() {
		super(new Sprite("G", "purse.png"), Permeability.PENETRABLE, 'G');
		this.collectPoint = 650;
		this.collected = false;
	}
	
	public boolean getCollected(){
		return this.collected;
	}
	
	public void setCollected(boolean in){
		this.collected = in;
	}
}