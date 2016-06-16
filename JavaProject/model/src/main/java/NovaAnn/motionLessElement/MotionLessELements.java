package NovaAnn.motionLessElement;

public class MotionLessELements {
	public static final MotionLessElement	BALLWALL									= new BallWall();
	public static final MotionLessElement	BONEVERTICAL								= new BoneVertical();
	public static final MotionLessElement	BONEHORIZONTAL								= new BoneHorizontal();
	public static final MotionLessElement	GOLD										= new Gold();
	public static final MotionLessElement	ENERGYBUBBLE								= new EnergyBubble();
	public static final MotionLessElement	DOOR										= new Door();
	public static final MotionLessElement	FLOOR										= new Floor();
	
	
	private static MotionLessElement			motionlessElements[]	= { BALLWALL, BONEVERTICAL, BONEHORIZONTAL, GOLD, ENERGYBUBBLE, DOOR, FLOOR };

	public static MotionLessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionLessElement motionLessElement : motionlessElements) {
			if (motionLessElement.getFileSymbol() == fileSymbol) {
				return motionLessElement;
			}
		}
		return FLOOR;
	}

}
