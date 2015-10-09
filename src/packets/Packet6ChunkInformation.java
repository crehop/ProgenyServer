package packets;

public class Packet6ChunkInformation extends Packet{
	private float energy;
	private float temperature;
	private float pressure; 
	private float timeSinceProduction;
	private int x;
	private int y;
	
	public Packet6ChunkInformation(float energy, float temperature, float pressure, float timeSinceProduction,int x, int y){
		this.energy = energy;
		this.temperature = temperature;
		this.pressure = pressure;
		this.timeSinceProduction = timeSinceProduction;
		this.x = x;
		this.y = y;
	}

	public float getEnergy() {
		return energy;
	}

	public void setEnergy(float energy) {
		this.energy = energy;
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

	public float getTimeSinceProduction() {
		return timeSinceProduction;
	}

	public void setTimeSinceProduction(float timeSinceProduction) {
		this.timeSinceProduction = timeSinceProduction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}

