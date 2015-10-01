package neuralNetwork;

public class SynapseConnection {
	public Neuron from;
	public Neuron to;
	public float connectionStrength;
	
	public SynapseConnection(Neuron from, Neuron to){
		this.from = from;
		this.to = to;
		this.connectionStrength = 0.5f;
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
}
