package NovaAnn.mobile;

public class MonsterMobiles {
	public static final MonsterMobile SKELETOR = new Skeletor();
	public static final MonsterMobile CHAINMAIL = new Chainmail();
	public static final MonsterMobile BUTTERFLY = new Butterfly();
	public static final MonsterMobile STORMTROOPER = new Stormtrooper();
	public static final MonsterMobile DOORMONSTER = new DoorMonster();

	private static MonsterMobile monsterMobiles[] = { SKELETOR, CHAINMAIL, BUTTERFLY, STORMTROOPER, DOORMONSTER};

	public static MonsterMobile getFromFileSymbol(final char fileSymbol) {
		for (final MonsterMobile monsterMobile : monsterMobiles) {
			if (monsterMobile.getFileSymbol() == fileSymbol) {
				return monsterMobile;
			}
		}
		return null;

	}
}