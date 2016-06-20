package model.javaproject.novaann.world.element.mobile;

import contract.IMonsterMobile;

public class Context {
	private IStrategy strategy;

	public Context(IStrategy strategy){
		this.strategy = strategy;
	}

	public void executeStrategy(IMonsterMobile mobile){
		this.strategy.animate(mobile);
	}
}
