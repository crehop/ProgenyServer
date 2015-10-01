package neuralNetwork;

import java.util.ArrayList;

public class Neuron {
	//input and output should be between 0-1;
	private int ID = 0;
	private int type;
	private float input;
	private float output;
	private int layer;
	private boolean connected = false;
	private ArrayList<SynapseConnection> inConnections  = new ArrayList<SynapseConnection>();;
	private ArrayList<SynapseConnection> outConnections = new ArrayList<SynapseConnection>();;
	private NeuralNet network;
	//SIGMOID NEURONS
	//
	public Neuron(NeuralNet network){
		this.network = network;
	}
	public void excite(float input){
		this.maintainConnections();
		this.output = 0;
		for(SynapseConnection incoming:inConnections){
			this.output +=  (incoming.getFrom().getOutput() * incoming.getStrength());
		}
		this.output = this.output/inConnections.size();
	}
	private float getOutput() {
		return output;
	}
	private void maintainConnections() {

	}
	public void inhibit(float input){
		this.input = input/100;
		if(input > 0){
			flip();
		}
	}
	public void flip(){
		input *= -1;
	}
	public void initiate(){
		while(this.outConnections.size() < network.getRandom().nextInt(10)){
			this.outConnections.add(new SynapseConnection(this,network.getRandomNeuron()));
		}
	}
	public void setPleasure(float pleasure){
		this.setPleasure(pleasure);
	}
	public int getTotalConnections(){
		return this.inConnections.size() + this.outConnections.size();
	}
	public int getLayer(){
		return this.layer;
	}
	public int getType(){
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
		if(this.type == 3){
			this.connected = true;
		}else{
			while(this.connected == false){
				System.out.println("Attempted Pulse: " + this.toString());
				this.outConnections.add(new SynapseConnection(this,network.getRandomNeuron()));
				pulse(100f);
			}
		}
	}
	public boolean isConnected(){
		return connected;
	}
	public void setConnected(boolean connected){
		this.connected = connected;
		if(connected){
			for(SynapseConnection connection:this.inConnections){
				connection.getFrom().setConnected(true);
			}
		}
	}

	public void pulse(float f){
		for(SynapseConnection connect:this.outConnections){
			System.out.println("PULSE:" + ID++ + " " + this.toString());
			connect.pulse(f);
		}
		ID = 0;
	}
}
