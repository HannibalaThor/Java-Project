package motionless;
import java.util.ArrayList;

import javaproject.novaann.world.Observer;

public class ObservableGold implements Observed {
	private final ArrayList <Observer> observers;

	public ObservableGold(){
		this.observers = new ArrayList <Observer>();
	}


	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObserver(int score) {
		for(Observer observer : this.observers){
			observer.update(score);

		}
	}
}
