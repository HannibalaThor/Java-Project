package NovaAnn.motionLessElement;

import NovaAnn.element.ActionOnHeroes;
import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;

public class EnergyBubble extends MotionLessElement implements ICollect {
	private boolean collected;
	
	public EnergyBubble() {
		super(new Sprite("*", "crystal_ball.png"), Permeability.PENETRABLE, '*');
		this.collected = false;
	}
	
	public boolean getCollected(){
		return this.collected;
	}
	
	public void setCollected(boolean in){
		this.collected = in;
	}
	
	public ActionOnHeroes getActionOnHeroes(){
		return ActionOnHeroes.COLLECT;
	}
	
}