package model.javaproject.novaann.world.element.mobile;

import model.javaproject.novaann.world.element.Permeability;
import model.javaproject.novaann.world.element.Sprite;

public class Skeletor extends MonsterMobile {
	public Skeletor() {
		super(new Sprite(" ","monster_1.png"), Permeability.BLOCKING, ':', new Context(new AISkeletor()));
	}
}