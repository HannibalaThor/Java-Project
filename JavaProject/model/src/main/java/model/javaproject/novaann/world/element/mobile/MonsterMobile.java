package model.javaproject.novaann.world.element.mobile;

import java.util.Observable;

import contract.IMonsterMobile;
import contract.ISprite;
import contract.Permeability;

public class MonsterMobile extends Mobile implements IMonsterMobile {
	private final char fileSymbol;
	private Context context;

	public MonsterMobile(final ISprite sprite, final Permeability permeability, final char fileSymbol, Context context ) {
		super(sprite);
		this.fileSymbol = fileSymbol;
		this.context = context;
	}

	public char getFileSymbol() {
		return this.fileSymbol;
	}

	//@Override
	public void getAnimate(IMonsterMobile mobile) {
		// TODO Auto-generated method stub
		this.context.executeStrategy(mobile);

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