package packets;

public class Packet3Vitals {
	private float energy;
	private float health;
	private float timeTillReproduction;
	private float temperature;
	private float pressure; 
	private int DNApoints;
	public float getEnergy() {
		return energy;
	}
	public void setEnergy(float energy) {
		this.energy = energy;
	}
	public float getHealth() {
		return health;
	}
	public void setHealth(float health) {
		this.health = health;
	}
	public float getTimeTillReproduction() {
		return timeTillReproduction;
	}
	public void setTimeTillReproduction(float timeTillReproduction) {
		this.timeTillReproduction = timeTillReproduction;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public int getDNApoints() {
		return DNApoints;
	}
	public void setDNApoints(int dNApoints) {
		DNApoints = dNApoints;
	}
	
	
}
