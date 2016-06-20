package model.javaproject.novaann.world.element.motionless;

import model.javaproject.novaann.world.Observer;

public interface Observed {
	public void addObserver(Observer observer);
	public void deleteObserver(Observer observer);
	public void notifyObserver(int score);
}
