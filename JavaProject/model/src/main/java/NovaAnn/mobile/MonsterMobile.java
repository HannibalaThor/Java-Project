package NovaAnn.mobile;

public class MonsterMobile extends Mobile {
	private final char fileSymbol;

	public MonsterMobile(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return this.fileSymbol;
	}
}
