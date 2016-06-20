package model.javaproject.novaann.world.element.mobile;

import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

public class Butterfly extends MonsterMobile {
	public Butterfly() {
		super(new Sprite(" ","monster_3.png"), Permeability.BLOCKING, ':', new Context(new AIButterfly()));
	}
}