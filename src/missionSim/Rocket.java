package missionSim;

import java.util.ArrayList;

public class Rocket implements SpaceShip {
	public int weightLimit;
	public int cost;
	public int rocketWeight;
	public int cargoWeight;
	public double explosionProbability;
	public double crashProbability;
	ArrayList<Item> cargo = new ArrayList<Item>();

	public void setRocketWeight(int rocketWeight) {
		this.rocketWeight = rocketWeight;
	}

	public int getRocketweightLimit() {
		return rocketWeight;
	}
	
	public int getCargoWeight() {
		return cargoWeight;
	}

	public void setRocketweightLimit(int weightLimit) {
		this.weightLimit = weightLimit;
	}

	public int getRocketWeight() {
		return weightLimit;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public boolean launch() {
		return true;
	}

	@Override
	public boolean land() {
		return true;
	}

	@Override
	final public boolean canCarry(Item item) {

		if (cargoWeight + item.getWeight() >= weightLimit)
			return false;
		else
			return true;

	}

	@Override
	final public void carry(Item item) {

		cargo.add(item);
		cargoWeight = cargoWeight + item.getWeight();

	}

}
