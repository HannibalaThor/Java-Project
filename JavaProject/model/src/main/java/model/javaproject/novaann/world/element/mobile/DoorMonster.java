package model.javaproject.novaann.world.element.mobile;

import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

public class DoorMonster extends MonsterMobile {
	public DoorMonster() {
		super(new Sprite(" ","gate_closed.png"), Permeability.BLOCKING, 'C', new Context(new AIDoorMonster()));
	}
}