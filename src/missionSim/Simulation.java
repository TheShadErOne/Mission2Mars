package missionSim;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

	public ArrayList<Item> loadItems(String pathName) throws Exception {
		File file = new File(pathName);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(file);
		ArrayList<Item> equipment = new ArrayList<Item>();

		while (scanner.hasNextLine()) {
			String lane = scanner.nextLine();
			int stringIndex = lane.indexOf("=");
			if (stringIndex > -1) {
				String name = lane.substring(0, stringIndex);
				int weight = Integer.parseInt(lane.substring(stringIndex + 1, lane.length()));
				System.out.println(name + " " + weight);
				Item item = new Item();
				item.setName(name);
				item.setweight(weight);
				equipment.add(item);
			}
		}
		return equipment;
	}

	public ArrayList<Rocket> loadRocketU1(ArrayList<Item> loadedEquipment) {

		ArrayList<Rocket> rockets = new ArrayList<Rocket>();

		U1 spaceshipU1 = new U1();

		for (Item item : loadedEquipment) {
			if (spaceshipU1.canCarry(item)) {
				spaceshipU1.carry(item);
				System.out.println(
						"U1 was loaded by : " + item.getName() + "/ Total weight : " + spaceshipU1.getCargoWeight());
				rockets.add(spaceshipU1);
			} else {
				System.out.println("New Rocket U1");
				spaceshipU1 = new U1();
				if (spaceshipU1.canCarry(item)) 
					spaceshipU1.carry(item);
				System.out.println(
						"U1 was loaded by : " + item.getName() + "/ Total weight : " + spaceshipU1.getCargoWeight());
					rockets.add(spaceshipU1);
			}
		}
		return rockets;
	}

	public ArrayList<Rocket> loadRocketU2(ArrayList<Item> loadedEquipment) {

		ArrayList<Rocket> rockets = new ArrayList<Rocket>();

		U2 spaceshipU2 = new U2();

		for (Item item : loadedEquipment) {
			if (spaceshipU2.canCarry(item)) {
				spaceshipU2.carry(item);
				System.out.println(
						"U2 was loaded by : " + item.getName() + "/ Total weight : " + spaceshipU2.getCargoWeight());
				rockets.add(spaceshipU2);
			} else {
				spaceshipU2 = new U2();
				System.out.println("New Rocket U2");
				if (spaceshipU2.canCarry(item))
					spaceshipU2.carry(item);
				System.out.println(
						"U2 was loaded by : " + item.getName() + "/ Total weight : " + spaceshipU2.getCargoWeight());
				rockets.add(spaceshipU2);
			}
		}
		return rockets;
	}

	public int runSimulation(ArrayList<Rocket> rockets) {
		int totalBudget = 0;

		for (Rocket spaceShips : rockets) {
			totalBudget += spaceShips.getCost();
			while (!spaceShips.launch() || !spaceShips.land()) {
				totalBudget += spaceShips.getCost();
			}
		}

		return totalBudget;
	}

}