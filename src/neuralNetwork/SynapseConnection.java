package neuralNetwork;

public class SynapseConnection {
	private Neuron from;
	private Neuron to;
	private int connectionStrength = 155;
	private int ID = 0;
	private int jumps = 1;
	private boolean kill;
	
	public SynapseConnection(Neuron from, Neuron to){
		this.from = from;
		this.to = to;
		this.connectionStrength = 150;
		if(to.isConnected() && from.isConnected() == false){
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
		if(this.connectionStrength > 1000){
			this.connectionStrength = 1000;
		}
		if(this.connectionStrength < -1000){
			this.connectionStrength = -1000;
		}
	}
	public float getStrength() {
		return this.connectionStrength/100000;
	}
	public void pulse(float intensity, int jumps) {
		this.connectionStrength--;
		this.jumps = jumps;
		if(to.isConnected()){
			from.setConnected(true);
			ID++;
			System.out.println("SP FROM:" + from.toString() + " TO:" + to.toString() + " END TOTAL JUMPS:"+ jumps);
		}else if(intensity > 10.0f){
			to.pulse((float)(intensity/++this.jumps), this.jumps);
			System.out.println("SP FROM:" + from.toString() + " TO:" + to.toString() + " END TOTAL JUMPS:"+ jumps);
		}else{
			
		}
	}
}
