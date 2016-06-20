package motionless;
import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class BoneHorizontal extends MotionlessElement {

	public BoneHorizontal() {
		super(new Sprite("o", "horizontal_bone.png"), Permeability.BLOCKING, 'O', false);
	}

}
