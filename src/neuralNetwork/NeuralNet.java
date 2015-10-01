package neuralNetwork;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class NeuralNet {
	private ArrayList<Neuron> computationalNeurons = new ArrayList<Neuron>();
	private ArrayList<Neuron> inputNeurons = new ArrayList<Neuron>();
	private ArrayList<Neuron> outputNeurons = new ArrayList<Neuron>();	
	private int computationalNetworkSize = 10;
	private int inputSize = 5;
	private int outputSize = 5;
	private Random rand = new Random();
	public void activateNetwork(){
		System.out.println("ACTIVATING NEURAL NETWORK");
		for(int i = 0; i < computationalNetworkSize; i++){
			computationalNeurons.add(new Neuron(this));
		}
		for(int i = 0; i < inputSize; i++){
			inputNeurons.add(new Neuron(this));
		}
		for(int i = 0; i < outputSize; i++){
			outputNeurons.add(new Neuron(this));
		}
		for(Neuron neu:outputNeurons){
			neu.initiate();
			neu.clearOutPut();
		}
		for(Neuron neu:inputNeurons){
			neu.initiate();
		}
		for(Neuron neu:computationalNeurons){
			neu.initiate();
		}
		int synapses = 0;
		int neurons = 0;
		int unconnected = 0;
		int chain = 0;
		for(Neuron neu:outputNeurons){
			neu.setType(3);
			neurons++;
			synapses += neu.getTotalConnections();
			if(chain < neu.getTotalConnections()){
				chain = neu.getTotalConnections();
			}
		}
		for(Neuron neu:computationalNeurons){
			neu.setType(2);
			neurons++;
			synapses += neu.getTotalConnections();
			if(chain < neu.getTotalConnections()){
				chain = neu.getTotalConnections();
			}
		}
		for(Neuron neu:inputNeurons){
			neu.setType(1);
			neurons++;
			synapses += neu.getTotalConnections();
			if(chain < neu.getTotalConnections()){
				chain = neu.getTotalConnections();
			}
		}
		for(Neuron neu:outputNeurons){
			if(neu.isConnected()){
			}else{
				unconnected++;
			}
		}
		for(Neuron neu:computationalNeurons){
			if(neu.isConnected()){
				
			}else{
				unconnected++;
			}
		}
		for(Neuron neu:inputNeurons){
			if(neu.isConnected()){
			}else{
				unconnected++;
			}
		}
		System.out.println("SUCCESS!!\nComputational = " + computationalNeurons.size() + "\nInput = "+ inputNeurons.size() + "\nOutput = " + outputNeurons.size());
		System.out.println("TOTAL SYNAPSES = " + synapses);
		System.out.println("TOTAL NEURONS = " + neurons);
		System.out.println("TOTAL UNCONNECTED SYNAPSES = " + unconnected);
		System.out.println("longest Synapse chain = " + chain);
		JOptionPane.showMessageDialog(null, "SEND PULSE 30");
		System.out.println("30 PULSE============================================================================================================================");
		for(Neuron neu:inputNeurons){
			neu.pulse(30000,1);
		}
		unconnected = 0;
		for(Neuron neu:inputNeurons){
			if(neu.isConnected()){
			}else{
				unconnected++;
			}
		}
		System.out.println("TOTAL UNCONNECTED SYNAPSES = " + unconnected);
		System.out.println("100 PULSE============================================================================================================================");
		JOptionPane.showMessageDialog(null, "SEND PULSE 100");
		for(Neuron neu:computationalNeurons){
			neu.pulse(1000,1);
		}
		unconnected = 0;
		for(Neuron neu:inputNeurons){
			if(neu.isConnected()){
			}else{
				unconnected++;
			}
		}
		System.out.println("TOTAL UNCONNECTED SYNAPSES = " + unconnected);

	}

	public Neuron getRandomNeuron() {
		if(rand.nextFloat() > 0.8){
			return outputNeurons.get(rand.nextInt(outputSize));
		}
		if(rand.nextFloat() > 0.2){
			return inputNeurons.get(rand.nextInt(inputSize));
		}
		return computationalNeurons.get(rand.nextInt(computationalNetworkSize));
	}
	public Random getRandom(){
		return rand;
	}
}
