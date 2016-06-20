package model.javaproject.novaann.world.element.mobile;

import java.util.Random;

import javaproject.novaann.world.NovaAnnWorld;

public class AIStormtrooper implements IStrategy {

	@Override
	public void animate(Mobile mobile){
		int xL = NovaAnnWorld.getXhero();
		int yL = NovaAnnWorld.getYhero();
		int xM = mobile.getX();
		int yM = mobile.getY();
		int DA = 5;
		double rand = Math.random();

		if((Math.abs(xM - xL) < DA) && (Math.abs(yM - yL) < DA)){
			if((xL > xM) && (yL == yM)) {

				if(mobile.isMovePossibleM(xM+1, yM) == true){
					mobile.moveRightM();
				} else if(((mobile.isMovePossibleM(xM, yM-1) == true) && (mobile.isMovePossibleM(xM-1, yM) == false)) || (rand == 0)){
					mobile.moveUpM();
				}
				else if(((mobile.isMovePossibleM(xM, yM+1) == true)) || (rand == 1)){
					mobile.moveDownM();
				}
			} else if((xL < xM) && (yL == yM)){
				if(mobile.isMovePossibleM(xM-1, yM) == true){
					mobile.moveLeftM();
				} else if(((mobile.isMovePossibleM(xM, yM-1) == true) && (mobile.isMovePossibleM(xM-1, yM) == false)) || (rand == 0)){
					mobile.moveUpM();
				}
				else if(((mobile.isMovePossibleM(xM, yM+1) == true)) || (rand == 1)){
					mobile.moveDownM();
				}
			} else if((xL == xM) && (yL > yM)){
				mobile.moveDownM();
				if(mobile.isMovePossibleM(xM, yM+1) == true){
					mobile.moveDownM();
				} else if(((mobile.isMovePossibleM(xM+1, yM) == true) && (mobile.isMovePossibleM(xM-1, yM) == false)) || (rand == 0)){
					mobile.moveRightM();
				}
				else if(((mobile.isMovePossibleM(xM-1, yM) == true)) || (rand == 1)){
					mobile.moveLeftM();
				}
			} else if((xL == xM) && (yL < yM)){
				if(mobile.isMovePossibleM(xM, yM-1) == true){
					mobile.moveUp();
				} else if(((mobile.isMovePossibleM(xM+1, yM) == true) && (mobile.isMovePossibleM(xM-1, yM) == false)) || (rand == 0)){
					mobile.moveRightM();
				}
				else if(((mobile.isMovePossibleM(xM-1, yM) == true)) || (rand == 1)){
					mobile.moveLeftM();
				}
			} else if((xL > xM) && (yL > yM)) {
				if(mobile.isMovePossibleM(xM+1, yM+1) == true){
					mobile.moveDownRightM();
				} else if(((mobile.isMovePossibleM(xM+1, yM) == true) && (mobile.isMovePossibleM(xM, yM+1) == false)) || (rand == 0)){
					mobile.moveRightM();
				}
				else if(((mobile.isMovePossibleM(xM, yM+1) == true)) || (rand == 1)){
					mobile.moveDownM();
				}
			} else if((xL < xM) && (yL > yM)){
				if(mobile.isMovePossibleM(xM-1, yM+1) == true){
					mobile.moveDownLeftM();
				} else if(((mobile.isMovePossibleM(xM-1, yM) == true) && (mobile.isMovePossibleM(xM, yM+1) == false)) || (rand == 0)){
					mobile.moveLeftM();
				}
				else if(((mobile.isMovePossibleM(xM, yM+1) == true)) || (rand == 1)){
					mobile.moveDownM();
				}
			} else if((xL > xM) && (yL < yM)){
				if(mobile.isMovePossibleM(xM+1, yM-1) == true){
					mobile.moveUpRightM();
				} else if(((mobile.isMovePossibleM(xM+1, yM) == true) && (mobile.isMovePossibleM(xM, yM-1) == false)) || (rand == 0)){
					mobile.moveRightM();
				}
				else if(((mobile.isMovePossibleM(xM, yM-1) == true)) || (rand == 1)){
					mobile.moveUpM();
				}
			} else if((xL < xM) && (yL < yM)){
				if(mobile.isMovePossibleM(xM-1, yM-1) == true){
					mobile.moveUpLeftM();
				} else if(((mobile.isMovePossibleM(xM-1, yM) == true) && (mobile.isMovePossibleM(xM, yM-1) == false)) || (rand == 0)){
					mobile.moveLeftM();
				}
				else if(((mobile.isMovePossibleM(xM, yM-1) == true)) || (rand == 1)){
					mobile.moveUpM();
				}
			}
		} else {
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
	}
}
