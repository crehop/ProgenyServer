package neuralNetwork;

public class SynapseConnection {
	private Neuron forward;
	private Neuron back;
	int ID;
	private boolean connectedIn;
	private boolean connectedOut;
	private float strength = 100;
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
	public void pulseForward(float strength, int jumps){
		this.strength = strength/jumps;
		this.inhibit();
		System.out.println("PF : Strength: " + strength + " : Jumps : " + jumps + " : FROM : " + back.toString() + " : TO : " + forward.toString());
		if(this.strength > 0.5f){
			forward.pulse(this.strength, jumps, true);
		}
	}
	public void pulseBackward(float strength, int jumps){
		this.strength = strength/jumps;
		this.inhibit();
		System.out.println("PB : Strength: " + strength + " : Jumps : " + jumps + " : FROM : " + forward.toString() + " : TO : " + back.toString());
		if(this.strength > 0.5f){
			back.pulse(this.strength, jumps, false);
		}
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
	public void inhibit(){
		this.strength = ((float)(this.strength - 0.01));
		if(this.strength < 0){
			this.strength = 0.0f;
		}
	}
	public void strengthen(){
		this.strength = ((float)(this.strength + 0.01));
		if(this.strength > 100){
			this.strength = 100f;
		}
	}
	public float getStrength(){
		return ((float)(this.strength/100));
	}
	public Neuron getBack() {
		return this.back;
	}
	public Neuron getForward(){
		return this.forward;
	}
	public void excite() {
		this.strength += 10;
	}
}
