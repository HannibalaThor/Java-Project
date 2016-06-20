package model.javaproject.novaann.world.element.mobile;


import java.awt.Point;

import aedt.showboard.IPawn;
import contract.IMobile;
import contract.IModel;
import contract.INovaAnnWorld;
import contract.ISprite;
import contract.Permeability;
import model.javaproject.novaann.world.element.Element;


public abstract class Mobile extends Element implements IPawn, IModel, IMobile {
	private final Point position;
	private final Point lastPosition;

	public Mobile(final ISprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
		this.lastPosition = new Point();
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}

	//@Override
	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#getX()
	 */
	public int getX() {
		return this.position.x;
	}

	protected void setX(final int x) {
		if ((x >= 0) && (x < this.getNovaAnnWorld().getWidth())) {
			this.position.x = x;
			this.getNovaAnnWorld().setMobileHasChanged();
		}
	}

	//@Override
	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#getY()
	 */
	public int getY() {
		return this.position.y;
	}

	protected void setY(final int y) {
		if ((y >= 0) && (y < this.getNovaAnnWorld().getHeight())) {
			this.position.y = y;
			this.getNovaAnnWorld().setMobileHasChanged();
		}
	}

	//@Override
	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#getPosition()
	 */
	public Point getPosition() {
		return this.position;
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#getLastPosition()
	 */
	public Point getLastPosition(){
		return this.lastPosition;
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#setNovaAnnWorld(contract.INovaAnnWorld, int, int)
	 */
	public void setNovaAnnWorld(final INovaAnnWorld novaAnnWorld, final int x, final int y) {
		super.setNovaAnnWorld(novaAnnWorld);
		this.setX(x);
		this.setY(y);
	}

	private boolean isMovePossible(final int x, final int y) {
		return (this.getNovaAnnWorld().getElements(x, y).getPermeability() != Permeability.BLOCKING);
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#isMovePossibleM(int, int)
	 */
	public boolean isMovePossibleM( int x, int y) {
		char c = this.getNovaAnnWorld().getElements(x, y).getFileSymbol();
		if (c == 'L'){
			return (true);
		}
		else {
			return(false);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveUp()
	 */
	public void moveUp() {
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.setY(this.getY() - 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveLeft()
	 */
	public void moveLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.setX(this.getX() - 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveDown()
	 */
	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveRight()
	 */
	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveUpRight()
	 */
	public void moveUpRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY() - 1)) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveDownRight()
	 */
	public void moveDownRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY() + 1)) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveUpLeft()
	 */
	public void moveUpLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveDownLeft()
	 */
	public void moveDownLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() + 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveUpM()
	 */
	public void moveUpM() {
		if (this.isMovePossibleM(this.getX(), this.getY() - 1)) {
			this.saveLastPosition();
			this.setY(this.getY() - 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveLeftM()
	 */
	public void moveLeftM() {
		if (this.isMovePossibleM(this.getX() - 1, this.getY())) {
			this.saveLastPosition();
			this.setX(this.getX() - 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveDownM()
	 */
	public void moveDownM() {
		if (this.isMovePossibleM(this.getX(), this.getY() + 1)) {
			this.saveLastPosition();
			this.setY(this.getY() + 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveRightM()
	 */
	public void moveRightM() {
		if (this.isMovePossibleM(this.getX() + 1, this.getY())) {
			this.saveLastPosition();
			this.setX(this.getX() + 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveUpRightM()
	 */
	public void moveUpRightM() {
		if (this.isMovePossibleM(this.getX() + 1, this.getY() - 1)) {
			this.saveLastPosition();
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveDownRightM()
	 */
	public void moveDownRightM() {
		if (this.isMovePossibleM(this.getX() + 1, this.getY() + 1)) {
			this.saveLastPosition();
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveUpLeftM()
	 */
	public void moveUpLeftM() {
		if (this.isMovePossibleM(this.getX() - 1, this.getY() - 1)) {
			this.saveLastPosition();
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.mobile.IMobile#moveDownLeftM()
	 */
	public void moveDownLeftM() {
		if (this.isMovePossibleM(this.getX() - 1, this.getY() + 1)) {
			this.saveLastPosition();
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}

	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}
}
