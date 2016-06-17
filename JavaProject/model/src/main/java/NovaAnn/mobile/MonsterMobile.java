package NovaAnn.mobile;

import NovaAnn.element.ISprite;

public class MonsterMobile extends Mobile {
	private final char fileSymbol;

	public MonsterMobile(final ISprite sprite, final char fileSymbol) {
		super(sprite);
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return this.fileSymbol;
	}
}
