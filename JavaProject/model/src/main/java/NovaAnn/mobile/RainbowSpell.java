package NovaAnn.mobile;


import NovaAnn.element.Sprite;

public class RainbowSpell extends Mobile {
	private static RainbowSpell INSTANCE = null;

	private RainbowSpell() {
		super(new Sprite("RainbowSpell.jpg"));
	}


	public static synchronized RainbowSpell getRainbowSpell() {
		if (INSTANCE == null) {
			INSTANCE = new RainbowSpell();
		}
		return INSTANCE;
	}
}