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
	public Neuron(int type, NeuralNet network){
		//STOPPED AT PREPATING INITIAL PULSE FOR EACH TYPE;
		this.network = network;
		this.ID = network.getID();
		this.type = type;
		if(this.type == 3){
			this.setConnectedOut(true);
		}
		if(this.type == 1){
			this.setConnectedIn(true);
		}
	}
	public void pulseForward(float intensity, int jump){
		System.out.println("pulseForward");		
		if(!this.connectedOut)checkConnection(true);
	}
	public void pulseBack(float intensity, int jump){
		System.out.println("pulseBack");		
		if(!this.connectedIn)checkConnection(false);
	}
	private void checkConnection(boolean forward) {
		Neuron random;
		if(forward){
			for(SynapseConnection connection:outConnections){
				if(connection.isConnectedOut()){
					this.setConnectedOut(true);
					if(this.connectedIn && this.connectedOut && !this.connected)this.connected = true;
					return;
				}
			}
			while(this.isConnectedOut() == false){
				random = network.getRandomNeuron();
				while(outConnections.contains(random) || random.getType() == 1){
					random = network.getRandomNeuron();
					while(this.type == 3 && random.getType() != 2){
						random = network.getRandomNeuron();
					}
					while(this.type == 1 && random.getType() != 2){
						random = network.getRandomNeuron();
					}
				}
				SynapseConnection connect = new SynapseConnection(this, random, true);
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
				while(inConnections.contains(random) || random.getType() == 1){
					random = network.getRandomNeuron();
					while(this.type == 3 && random.getType() != 2){
						random = network.getRandomNeuron();
					}
					while(this.type == 1 && random.getType() != 2){
						random = network.getRandomNeuron();
					}
				}
				SynapseConnection connect = new SynapseConnection(random, this, true);
				System.out.println(this.inConnections.size() + " SIZE" + connect.isConnectedIn());
			}
		}
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
	public void incomingConnection(SynapseConnection connection2) {
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
}

