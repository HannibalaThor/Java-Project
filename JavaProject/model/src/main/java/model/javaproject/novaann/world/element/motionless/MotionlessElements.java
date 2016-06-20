package model.javaproject.novaann.world.element.motionless;

import contract.INovaAnnWorld;

public abstract class MotionlessElements {
	public static final MotionlessElement	BONEHORIZONTAL							= new BoneHorizontal();
	public static final MotionlessElement	BONEVERTICAL							= new BoneVertical();
	public static final MotionlessElement	BALLWALL								= new BallWall();
	public static final MotionlessElement	DOOR									= new Door();
	public static final MotionlessElement	GOLD									= new Gold();
	public static final MotionlessElement	FLOOR									= new Floor();
	public static final MotionlessElement	ENERGYBUBBLE							= new EnergyBubble();


	private static MotionlessElement			motionlessElements[]	= { BONEHORIZONTAL, BONEVERTICAL, BALLWALL, DOOR, GOLD, FLOOR, ENERGYBUBBLE };

	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			}
		}
		return FLOOR;
	}
}