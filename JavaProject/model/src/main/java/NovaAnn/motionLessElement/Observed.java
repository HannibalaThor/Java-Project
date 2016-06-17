package NovaAnn.motionLessElement;

import java.util.Observer;

public interface Observed {
	public void registerObserver(Observer observer);
	public void unregisterObserver(Observer observer);
	public void notifyObserver();
}
