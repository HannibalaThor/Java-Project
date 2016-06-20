package model.javaproject.novaann.world.element.mobile;

import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

public class Stormtrooper extends MonsterMobile {
	public Stormtrooper() {
		super(new Sprite(" ","monster_4.png"), Permeability.BLOCKING, ':', new Context(new AIStormtrooper()));
	}
}