package model.javaproject.novaann.world.element.mobile;

import model.javaproject.novaann.world.element.Permeability;
import model.javaproject.novaann.world.element.Sprite;

public class Chainmail extends MonsterMobile {
	public Chainmail() {
		super(new Sprite(" ","monster_2.png"), Permeability.BLOCKING, ':', new Context(new AIChainmail()));
	}
}