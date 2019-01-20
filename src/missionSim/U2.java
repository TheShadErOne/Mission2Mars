package missionSim;

import java.util.Random;

public class U2 extends Rocket {

	  private Random random = new Random();
	  private double chance = random.nextDouble();
	  
	public U2() {

		setRocketWeight(18000);
		setRocketweightLimit(29000);
		setCost(120);
	}


	@Override
	public boolean launch() {
		double explosionProbabilityEq = 0.08 * ((double)cargoWeight / (double)weightLimit);
		if (explosionProbabilityEq >= chance) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean land() {
		double crashProbabilityEq = 0.04 * ((double)cargoWeight / (double)weightLimit);
		if (crashProbabilityEq >= chance) {
			return false;
		} else {
			return true;
		}
	}
}
