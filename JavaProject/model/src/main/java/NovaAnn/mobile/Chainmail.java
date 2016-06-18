package NovaAnn.mobile;

import NovaAnn.element.ActionOnHeroes;
import NovaAnn.element.Sprite;

public class Chainmail extends MonsterMobile {
	public Chainmail() {
		super(new Sprite("Chainmail.jpg"), '+');
	}
	
	public ActionOnHeroes getActionOnHeroes(){
		return ActionOnHeroes.DEATH;
	}
	
}
