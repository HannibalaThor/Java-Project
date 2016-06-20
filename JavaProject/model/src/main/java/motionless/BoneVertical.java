package motionless;
import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class BoneVertical extends MotionlessElement {

	public BoneVertical() {
		super(new Sprite("o", "vertical_bone.png"), Permeability.BLOCKING, 'o', false);
	}

}
