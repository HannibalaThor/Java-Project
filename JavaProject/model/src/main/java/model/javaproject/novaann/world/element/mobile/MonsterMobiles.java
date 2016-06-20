package model.javaproject.novaann.world.element.mobile;

public class MonsterMobiles {
	public static final MonsterMobile DOORMONSTER = new DoorMonster();
	public static final MonsterMobile SKELETOR = new Skeletor();
	public static final MonsterMobile CHAINMAIL = new Chainmail();
	public static final MonsterMobile BUTTERFLY = new Butterfly();
	public static final MonsterMobile STORMTROOPER = new Stormtrooper();


	private static MonsterMobile monsterMobiles[] = { null ,SKELETOR, CHAINMAIL, BUTTERFLY, STORMTROOPER, DOORMONSTER };

	public static MonsterMobile getFromFileSymbol(final char fileSymbol) {
		for (final MonsterMobile monsterMobile : monsterMobiles) {
			if (monsterMobile.getFileSymbol() == fileSymbol) {
				return monsterMobile;
			}
		}
		return null;
	}

	public static MonsterMobile getElement(int id) {
		return monsterMobiles[id - 1];
	}
}