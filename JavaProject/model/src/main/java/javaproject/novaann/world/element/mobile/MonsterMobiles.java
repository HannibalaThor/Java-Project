package javaproject.novaann.world.element.mobile;

public class MonsterMobiles {
	public static final MonsterMobile SKELETOR = new Skeletor();


	private static MonsterMobile monsterMobiles[] = { SKELETOR };

	public static MonsterMobile getFromFileSymbol(final char fileSymbol) {
		for (final MonsterMobile monsterMobile : monsterMobiles) {
			if (monsterMobile.getFileSymbol() == fileSymbol) {
				return monsterMobile;
			}
		}
		return null;

	}
}