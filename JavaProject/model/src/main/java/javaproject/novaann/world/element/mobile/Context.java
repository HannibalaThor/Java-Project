package javaproject.novaann.world.element.mobile;

public class Context {
	private IStrategy strategy;

	public Context(IStrategy strategy){
		this.strategy = strategy;
	}

	public void executeStrategy(Mobile mobile){
		this.strategy.animate(mobile);
	}
}
