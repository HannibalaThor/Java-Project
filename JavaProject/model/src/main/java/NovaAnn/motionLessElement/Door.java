package NovaAnn.motionLessElement;

import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;

public class Door extends MotionLessElement implements IDoor {
	private boolean open;
	
	public Door() {
		super(new Sprite("D", "gate_closed.png"), Permeability.PENETRABLE, 'D');
		this.open = false;
	}
	
	public boolean getOpen(){
		return this.open;
	}
	
	public void setOpen(boolean in){
		this.open = in;
	}
}