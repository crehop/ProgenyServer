package neuralNetwork;

public class SynapseConnection {
	private Neuron forward;
	private Neuron back;
	int ID;
	private boolean connectedIn;
	private boolean connectedOut;
	public SynapseConnection(Neuron from, Neuron to, boolean forward){
		this.ID = from.getNetwork().getID();
		if(forward){
			this.forward = to;
			this.back = from;
		}else{
			this.back = to;
			this.forward = from;
		}
		if(this.back.isConnectedIn()){
			this.setConnectedIn(true);
			this.forward.setConnectedIn(true);
		}
		if(this.forward.isConnectedOut()){
			this.setConnectedOut(true);
			this.back.setConnectedOut(true);
		}
		
		if(this.back.isConnectedIn() && this.forward.isConnectedIn() == false){
			this.forward.setConnectedIn(true);
		}
		if(this.forward.isConnectedOut() && this.back.isConnectedOut() == false){
			this.back.setConnectedOut(true);
		}
		this.forward.incomingConnection(this);
		this.back.outgoingConnection(this);
	}
	public void pulseForward(float intensity, int jumps){
		
	}
	public void pulseBackward(float intensity, int jumps){
		
	}
	public Object getID() {
		return this.ID;
	}
	public boolean isConnectedIn() {
		return connectedIn;
	}
	public void setConnectedIn(boolean connectedIn) {
		this.connectedIn = connectedIn;
		if(connectedIn)this.forward.setConnectedIn(true);
	}
	public boolean isConnectedOut() {
		return connectedOut;
	}
	public void setConnectedOut(boolean connectedOut) {
		this.connectedOut = connectedOut;
		if(connectedOut)this.back.setConnectedOut(true);
	}
}
