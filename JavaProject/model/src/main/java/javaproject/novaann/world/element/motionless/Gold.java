package javaproject.novaann.world.element.motionless;

import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class Gold extends MotionlessElement {
	private int collectedPoint;

	public Gold() {
		super(new Sprite("G", "purse.png"), Permeability.PENETRABLE, 'G');
		this.collectedPoint = 650;
	}

	public int getCollectedPoint(){
		return this.collectedPoint;
	}

	public void setCollectedPoint(int in){
		this.collectedPoint = in;
	}
}
