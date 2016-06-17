package NovaAnn.mobile;

import java.awt.Point;
import NovaAnn.element.Sprite;


public class Hero extends Mobile{
	private final Point lastPosition;

	public Hero() {
		super(new Sprite("☺!", "Hero.png"));
		this.lastPosition = new Point();
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}

	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX())
				|| (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}

	public void moveUp() {
		this.saveLastPosition();
		super.moveUp();
	}

	public void moveLeft() {
		this.saveLastPosition();
		super.moveLeft();
	}

	public void moveDown() {
		this.saveLastPosition();
		super.moveDown();
	}

	public void moveRight() {
		this.saveLastPosition();
		super.moveRight();
	}

	public void moveBack() {
		this.setX(this.lastPosition.x);
		this.setY(this.lastPosition.y);
	}
}