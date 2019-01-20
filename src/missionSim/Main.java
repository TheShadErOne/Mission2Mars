package missionSim;

public class Main {

	public static void main(String[] args) throws Exception {

		Simulation sim = new Simulation();
		int budgetU1 = 0;
		int budgetU2 = 0;

		budgetU1 = sim.runSimulation(
				sim.loadRocketU1(sim.loadItems("/home/shaders/eclipse-workspace/Mission2Mars/src/missionSim/phase1")))
				+ sim.runSimulation(sim.loadRocketU1(
						sim.loadItems("/home/shaders/eclipse-workspace/Mission2Mars/src/missionSim/phase2")));

		budgetU2 = sim.runSimulation(
				sim.loadRocketU2(sim.loadItems("/home/shaders/eclipse-workspace/Mission2Mars/src/missionSim/phase1")))
				+ sim.runSimulation(sim.loadRocketU2(
						sim.loadItems("/home/shaders/eclipse-workspace/Mission2Mars/src/missionSim/phase2")));

		System.out.println("\n"+"Budget of U1 : " + budgetU1 + " Budget of U2 : " + budgetU2);

	}
}
