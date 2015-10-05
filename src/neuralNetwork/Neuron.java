package neuralNetwork;

import java.util.ArrayList;

public class Neuron {
	private NeuralNet network;
	private int type;
	private ArrayList<SynapseConnection> inConnections = new ArrayList<SynapseConnection>();
	private ArrayList<SynapseConnection> outConnections = new ArrayList<SynapseConnection>();
	private boolean connected;
	private boolean connectedOut;
	private boolean connectedIn;
	private int ID;
	private float intensity;
	private float decay = 0.03f;
	private float computation = 0;
	private int stagger = 0;

	public Neuron(int type, NeuralNet network){
		this.network = network;
		this.ID = network.getID();
		this.type = type;
		if(this.type == 3){
			this.setConnectedOut(true);
			this.outConnections.clear();
		}
		if(this.type == 1){
			this.setConnectedIn(true);
			this.inConnections.clear();
		}
	}
	public void pulse(float intensity, int jump, boolean forward){
		if(this.stagger > this.inConnections.size()){
			this.stagger = 0;
		}
		this.intensity = intensity;
		System.out.println("pulse " + forward);		
		if(this.getType() == 1){
			this.computation = intensity;
			System.out.println("ENTRANCE NODE  " + intensity);
		}else if(this.getType() == 3){
			this.computation = intensity;
			System.out.println("EXIT NODE  " + intensity);
		}
		if(!this.connectedIn)checkConnection(false);
		if(this.getType() != 1 && !forward){
			for(int i = 0; i < inConnections.size(); i++){
				if(i+stagger > inConnections.size() - 1 || stagger + i < 0){
					inConnections.get(i).pulseBackward(this.intensity, jump + 1);
				}else{
					inConnections.get(stagger).pulseBackward(this.intensity, jump + 1);
				}
			stagger++;
			}
		}else if(this.getType() != 3 && forward){
			for(int i = 0; i < outConnections.size(); i++){
				if(i+stagger > outConnections.size() - 1 || stagger + i < 0){
					outConnections.get(i).pulseForward(this.intensity, jump + 1);
				}else{
					outConnections.get(stagger).pulseForward(this.intensity, jump + 1);
				}
			stagger++;
			}
		}
	}
	private void checkConnection(boolean forward) {
		SynapseConnection connect = null;
		Neuron random;
		if(forward){
			for(SynapseConnection connection:outConnections){
				if(connection.isConnectedOut()){
					this.setConnectedOut(true);
					if(this.connectedIn && this.connectedOut && !this.connected)this.connected = true;
					return;
				}
			}
			while(this.isConnectedOut() == false || (this.outConnections.size() < network.synapseOutSize && this.getType() != 3)){
				random = network.getRandomNeuron();
				while(isAlreadyConnected(random, this.outConnections, false) || random.getType() == 1 || random.getID() == this.getID()){
					random = network.getRandomNeuron();
					while(this.type == 3 && random.getType() != 2){
						random = network.getRandomNeuron();
					}
					while(this.type == 1 && random.getType() != 2){
						random = network.getRandomNeuron();
					}
				}
				connect = new SynapseConnection(this, random, true);
				System.out.println(this.outConnections.size() + " SIZE" + connect.isConnectedOut());
			}
		}else{			
			for(SynapseConnection connection:inConnections){
				if(connection.isConnectedIn()){
					this.setConnectedIn(true);
					if(this.connectedIn && this.connectedOut && !this.connected)this.connected = true;
					return;
				}
			}
			while(this.isConnectedIn() == false){
				random = network.getRandomNeuron();
				while(isAlreadyConnected(random, this.inConnections, true) || random.getType() == 3 || random.getID() == this.getID()){
					random = network.getRandomNeuron();
					while(this.type == 3 && random.getType() != 2){
						random = network.getRandomNeuron();
					}
					while(this.type == 1 && random.getType() != 2){
						random = network.getRandomNeuron();
					}
				}
				connect = new SynapseConnection(random, this, true);
				System.out.println(this.inConnections.size() + " SIZE" + connect.isConnectedIn());

			}
		}
	}
	private boolean isAlreadyConnected(Neuron random,ArrayList<SynapseConnection> connections, boolean in) {
		for(SynapseConnection connection: connections){
			if(in){
				if(connection.getForward().getID() == random.getID())return true;
			}else{
				if(connection.getBack().getID() == random.getID())return true;
			}
		}
		return false;
	}
	public boolean isConnected() {
		if(this.inConnections.size() > 0 && this.outConnections.size() > 0){
			return true;
		}else if(this.type == 1 && this.outConnections.size() > 0){
			return true;
		}else if(this.type == 3 && this.inConnections.size() > 0){
			return true;
		}
		return false;
	}
	public void outgoingConnection(SynapseConnection connection2) {
		if(this.type != 3){
			for(SynapseConnection connection:this.outConnections){
				if(connection.getID() == connection2.getID()){
					return;
				}
			}
			if(connection2.isConnectedOut()){
				this.setConnectedOut(true);
			}
			outConnections.add(connection2);
		}
	}
	public void incomingConnection(SynapseConnection connection2) {
		if(this.type != 1){
			for(SynapseConnection connection:this.inConnections){
				if(connection.getID() == connection2.getID()){
					return;
				}
			}
			if(connection2.isConnectedIn()){
				this.setConnectedIn(true);
			}
			inConnections.add(connection2);
		}

	}
	public boolean contains(ArrayList<SynapseConnection> connection, SynapseConnection connection2){
		for(SynapseConnection compare: connection){
			if(compare.toString().equalsIgnoreCase(connection2.toString()) || this.toString().equalsIgnoreCase(connection2.toString())){
				return true;
			}
		}
		return false;
	}
	public NeuralNet getNetwork(){
		return this.network;
	}
	public boolean isConnectedOut() {
		return connectedOut;
	}	
	public boolean isConnectedIn() {
		return connectedIn;
	}
	public void setConnectedOut(boolean connectedOut) {
		if(connectedOut){
			for(SynapseConnection connection: inConnections){
				if(!connection.isConnectedOut())connection.setConnectedOut(true);
			}
		}
		this.connectedOut = connectedOut;
	}

	public void setConnectedIn(boolean connectedIn) {
		if(connectedIn){
			for(SynapseConnection connection: outConnections){
				if(!connection.isConnectedIn())connection.setConnectedIn(true);
			}
		}
		this.connectedIn = connectedIn;
	}
	public int getID(){
		return this.ID;
	}
	public int getType(){
		return this.type;
	}
	public int connectionsIn(){
		return this.inConnections.size();
	}
	public int connectionsOut(){
		return this.outConnections.size();
	}
	public float getComputation(){
		return this.computation;
	}
}

