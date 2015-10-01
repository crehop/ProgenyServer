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
		for(Neuron neu:inputNeurons){
			neu.initiate();
		}
		for(Neuron neu:outputNeurons){
			neu.initiate();
		}
		for(Neuron neu:computationalNeurons){
			neu.initiate();
		}
		System.out.println("SUCCESS!!\nComputational = " + computationalNeurons.size() + "\nInput = "+ inputNeurons.size() + "\nOutput = " + outputNeurons.size());
		int synapses = 0;
		for(Neuron neu:computationalNeurons){
			synapses += neu.getTotalConnections();
		}
		for(Neuron neu:inputNeurons){
			synapses += neu.getTotalConnections();
		}
		for(Neuron neu:outputNeurons){
			synapses += neu.getTotalConnections();
		}
		System.out.println("TOTAL SYNAPSES = " + synapses);
	}

	public Neuron getRandomNeuron() {
		return computationalNeurons.get(rand.nextInt(computationalNetworkSize - 1));
	}
	public Random getRandom(){
		return rand;
	}
}
