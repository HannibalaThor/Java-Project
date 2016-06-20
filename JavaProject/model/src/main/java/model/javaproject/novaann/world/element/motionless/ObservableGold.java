package model.javaproject.novaann.world.element.motionless;

import java.util.ArrayList;

import model.javaproject.novaann.world.Observer;



public class ObservableGold implements Observed {
	private final ArrayList <Observer> observers;

	public ObservableGold(){
		this.observers = new ArrayList <Observer>();
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void deleteObserver(Observer observer) {
		this.observers.remove(observer);
	}

	public void notifyObserver(int score) {
		for(Observer observer : this.observers){
			observer.update(score);

		}
	}
}
