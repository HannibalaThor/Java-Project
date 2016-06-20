package model.javaproject.novaann.world.element.mobile;

import javaproject.novaann.world.element.ISprite;
import javaproject.novaann.world.element.Permeability;

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
	public void getAnimate(MonsterMobile mobile) {
		// TODO Auto-generated method stub
		this.context.executeStrategy(mobile);

	}
}
