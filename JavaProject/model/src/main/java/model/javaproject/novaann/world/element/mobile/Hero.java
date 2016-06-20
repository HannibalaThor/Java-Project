package model.javaproject.novaann.world.element.mobile;

import java.awt.Point;
import java.util.Observable;

import contract.IHero;
import model.javaproject.novaann.world.element.Sprite;


public class Hero extends Mobile implements IHero {
	private final Point lastPosition;

	public Hero() {
		super(new Sprite("☺!", "lorann_b.png"));
		this.lastPosition = new Point();
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}

	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IHero#moveUp()
	 */
	public void moveUp() {
		this.saveLastPosition();
		super.moveUp();
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IHero#moveLeft()
	 */
	public void moveLeft() {
		this.saveLastPosition();
		super.moveLeft();
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IHero#moveDown()
	 */
	public void moveDown() {
		this.saveLastPosition();
		super.moveDown();
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IHero#moveRight()
	 */
	public void moveRight() {
		this.saveLastPosition();
		super.moveRight();
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IHero#moveBack()
	 */
	public void moveBack() {
		this.setX(this.lastPosition.x);
		this.setY(this.lastPosition.y);
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void loadMessage(String key) {
		// TODO Auto-generated method stub
		
	}

	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}
}
