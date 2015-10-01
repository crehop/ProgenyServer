package neuralNetwork;

import java.util.ArrayList;

public class Neuron {
	//input and output should be between 0-1;
	private int type;
	private float input;
	private float output;
	private int layer;
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
	public void initiate(){
		while(this.outConnections.size() < network.getRandom().nextInt(10)){
			this.outConnections.add(new SynapseConnection(this,network.getRandomNeuron()));
		}
	}
}
