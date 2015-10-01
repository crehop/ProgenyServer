package neuralNetwork;

public class SynapseConnection {
	private Neuron from;
	private Neuron to;
	private float connectionStrength;
	private int ID = 0;
	
	public SynapseConnection(Neuron from, Neuron to){
		this.from = from;
		this.to = to;
		this.connectionStrength = 0.5f;
		if(to.isConnected()){
			from.setConnected(true);
		}
	}
	public Neuron getFrom() {
		return from;
	}
	public void setFrom(Neuron from) {
		this.from = from;
	}
	public Neuron getTo() {
		return to;
	}
	public void setTo(Neuron to) {
		this.to = to;
	}
	public void feedback(float pleasure){
		this.connectionStrength += pleasure;
		if(this.connectionStrength > 100000){
			this.connectionStrength = 100000;
		}
		if(this.connectionStrength < -100000){
			this.connectionStrength = -100000;
		}
	}
	public float getStrength() {
		return this.connectionStrength/100000;
	}
	public void pulse(float intensity) {
		if(to.isConnected()){
			from.setConnected(true);
			ID++;
			System.out.println("SYNAPSE PULSE FORWARD \nFROM:" + from.toString() + "\nTO:" + to.toString() + "\n Synapse Number of pulses:" + ID);
		}else{
			if(intensity > 10){
				to.pulse(intensity / 2);
			}
		}
	}
}
