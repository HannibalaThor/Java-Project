package contract;

import java.awt.Point;

import aedt.showboard.IPawn;

public interface IMobile extends IPawn{

	//@Override
	int getX();

	//@Override
	int getY();

	//@Override
	Point getPosition();

	Point getLastPosition();

	void setNovaAnnWorld(INovaAnnWorld novaAnnWorld, int x, int y);

	boolean isMovePossibleM(int x, int y);

	void moveUp();

	void moveLeft();

	void moveDown();

	void moveRight();

	void moveUpRight();

	void moveDownRight();

	void moveUpLeft();

	void moveDownLeft();

	void moveUpM();

	void moveLeftM();

	void moveDownM();

	void moveRightM();

	void moveUpRightM();

	void moveDownRightM();

	void moveUpLeftM();

	void moveDownLeftM();

}