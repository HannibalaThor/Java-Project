package NovaAnn.mobile;

public class RainbowSpell extends Mobile {
	private static RainbowSpell INSTANCE = null;

	private RainbowSpell() {
		super(new Sprite("RainbowSpell.jpg"), Permeability.BLOCKING, 'R');
	}


	public static synchronized RainbowSpell getRainbowSpell() {
		if (INSTANCE == null) {
			INSTANCE = new RainbowSpell();
		}
		return INSTANCE;
	}
}