package neuralNetwork;

import java.util.ArrayList;
import java.util.Random;

public class NeuralNet {
	private ArrayList<Neuron> computationalNeurons = new ArrayList<Neuron>();
	private ArrayList<Neuron> inputNeurons = new ArrayList<Neuron>();
	private ArrayList<Neuron> outputNeurons = new ArrayList<Neuron>();	
	private int computationalNetworkSize = 10;
	private int inputSize = 5;
	private int outputSize = 5;
	private Random rand = new Random();
	
	public void activateNetwork(){
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
		}
		for(Neuron neu:inputNeurons){
			neu.initiate();
		}
		for(Neuron neu:computationalNeurons){
			neu.initiate();
		}
		int synapses = 0;
		int unconnected = -1;
		for(Neuron neu:outputNeurons){
			neu.setType(3);
			synapses += neu.getTotalConnections();
		}
		for(Neuron neu:computationalNeurons){
			neu.setType(2);
			synapses += neu.getTotalConnections();
		}
		for(Neuron neu:inputNeurons){
			neu.setType(1);
			synapses += neu.getTotalConnections();
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
		System.out.println("TOTAL UNCONNECTED SYNAPSES = " + unconnected);
	}

	public Neuron getRandomNeuron() {
		if(rand.nextFloat() > 0.9){
			return outputNeurons.get(rand.nextInt(outputSize));
		}
		if(rand.nextFloat() > 0.1){
			return inputNeurons.get(rand.nextInt(inputSize));
		}
		return computationalNeurons.get(rand.nextInt(computationalNetworkSize));
	}
	public Random getRandom(){
		return rand;
	}
}
