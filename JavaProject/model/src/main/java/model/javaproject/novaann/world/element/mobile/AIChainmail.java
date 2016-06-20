package model.javaproject.novaann.world.element.mobile;

import java.util.Random;

import contract.IMonsterMobile;

public class AIChainmail implements IStrategy {
	public void animate(Mobile mobile){
		int xM = mobile.getX();
		int yM = mobile.getY();

		int poss = 0;
		while(poss == 0) {
			Random rand2 = new Random();
			int nombre = rand2.nextInt(9);
			if(nombre == 0){
				if(mobile.isMovePossibleM(xM, yM-1) == true){
					mobile.moveUpM();
					poss = 1;
				}
			} else if(nombre == 1){
				if(mobile.isMovePossibleM(xM+1, yM-1) == true){
					mobile.moveUpRightM();
					poss = 1;
				}
			} else if(nombre == 2){
				if(mobile.isMovePossibleM(xM+1, yM) == true){
					mobile.moveRightM();
					poss = 1;
				}
			} else if(nombre == 3){
				if(mobile.isMovePossibleM(xM+1, yM+1) == true){
					mobile.moveDownRightM();
					poss = 1;
				}
			} else if(nombre == 4){
				if(mobile.isMovePossibleM(xM, yM+1) == true){
					mobile.moveDownM();
					poss = 1;
				}
			} else if(nombre == 5){
				if(mobile.isMovePossibleM(xM-1, yM+1) == true){
					mobile.moveDownLeftM();
					poss = 1;
				}
			} else if(nombre == 6){
				if(mobile.isMovePossibleM(xM-1, yM) == true){
					mobile.moveLeftM();
					poss = 1;
				}
			} else if(nombre == 7){
				if(mobile.isMovePossibleM(xM-1, yM-1) == true){
					mobile.moveUpLeftM();
					poss = 1;
				}
			}
		}
	}

	public void animate(IMonsterMobile mobile) {
		// TODO Auto-generated method stub
		
	}
}
