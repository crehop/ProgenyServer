package neuralNetwork;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class NeuralNet {
	private  int ID = 0;
	public  int synapseInSize = 10;
	public  int synapseOutSize = 10;
	private  int computationalSize = 1000;
	private  int outputSize = 5;
	private  int inputSize = 5;
	private  Random rand = new Random();
	private  ArrayList<Neuron> computationalNeurons = new ArrayList<Neuron>();
	private  ArrayList<Neuron> inputNeurons = new ArrayList<Neuron>();
	private  ArrayList<Neuron> outputNeurons = new ArrayList<Neuron>();	
	public  ArrayList<SynapseConnection> synapse = new ArrayList<SynapseConnection>();
	
	public NeuralNet(){
		//TODO DIRECTIONAL TRAVEL < implement time so jumps cant propigate backwards;
	}
	
	public int getID(){
		return ++ID;
	}
	public  Neuron getRandomNeuron() {
		if(rand.nextInt(10) > 7){
			System.out.println("INPUT NEURON");
			return inputNeurons.get(rand.nextInt(inputNeurons.size()));
		}
		else if(rand.nextInt(10) < 2){
			System.out.println("OUTPUT NEURON");
			return outputNeurons.get(rand.nextInt(outputNeurons.size()));
		}
		else{
			System.out.println("COMPUTATIONAL NEURON");
			return computationalNeurons.get(rand.nextInt(computationalNeurons.size()));
		}
	}

	public void activateNetwork() {
		for(int i = 0; i < inputSize; i++){
			Neuron neuron = new Neuron(1, this);
			inputNeurons.add(neuron);
		}
		for(int i = 0; i < outputSize; i++){
			Neuron neuron = new Neuron(3, this);
			outputNeurons.add(neuron);
		}
		for(int i = 0; i < computationalSize; i++){
			Neuron neuron = new Neuron(2, this);
			computationalNeurons.add(neuron);
		}
		for(Neuron neuron:inputNeurons){
			neuron.pulse(1, 1, true);
		}
		for(Neuron neuron:computationalNeurons){
			neuron.pulse(1, 1, true);
		}
		for(Neuron neuron:outputNeurons){
			neuron.pulse(1, 1, true);
		}
		System.out.println("NETWORK CREATION SUCCESSFUL!");		
		JOptionPane.showMessageDialog(null, " PRESS TO PULSE 10 FORWARD" );
		for(Neuron neuron: this.inputNeurons){
			neuron.pulse(10.0f, 1,true);
		}
		JOptionPane.showMessageDialog(null, " PRESS TO PULSE 50 FORWARD" );
		for(Neuron neuron: this.inputNeurons){
			neuron.pulse(50.0f, 1,true);
		}
		JOptionPane.showMessageDialog(null, " PRESS TO PULSE 100 FORWARD" );
		for(Neuron neuron: this.inputNeurons){
			neuron.pulse(100.0f, 1,true);
		}
		JOptionPane.showMessageDialog(null, " PRESS TO PULSE 10 BACKWARD" );
		for(Neuron neuron: this.outputNeurons){
			neuron.pulse(10.0f, 1, false);
		}
		JOptionPane.showMessageDialog(null, " PRESS TO PULSE 50 BACKWARD" );
		for(Neuron neuron: this.outputNeurons){
			neuron.pulse(50.0f, 1, false);
		}
		JOptionPane.showMessageDialog(null, " PRESS TO PULSE 100 BACKWARD" );
		for(Neuron neuron: this.outputNeurons){
			neuron.pulse(100.0f, 1,false);
		}
		
	}

	
	public void stimulateNetwork(){
		
	}
}
