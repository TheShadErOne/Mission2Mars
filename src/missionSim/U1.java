package missionSim;

import java.util.Random;

public class U1 extends Rocket {

	  private Random random = new Random();
	  private double chance = random.nextDouble();
	  
	public U1() {

		setRocketWeight(10000);
		setRocketweightLimit(18000);
		setCost(100);
	}


	@Override
	public boolean launch() {
		double explosionProbabilityEq = 0.05 * ((double)cargoWeight / (double)weightLimit);
		if (explosionProbabilityEq >= chance) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean land() {
		double crashProbabilityEq = 0.01 * ((double)cargoWeight / (double)weightLimit);
		if (crashProbabilityEq >= chance) {
			return false;
		} else {
			return true;
		}
	}
}