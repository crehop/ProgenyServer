package neuralNetwork;

public class SynapseConnection {
	private Neuron from;
	private Neuron to;
	private int connectionStrength = 155;
	private int ID = 0;
	private int jumps = 1;
	private boolean connected;
	
	public SynapseConnection(Neuron from, Neuron to){
		from.addTo(this);
		to.addFrom(this);
		this.from = from;
		this.to = to;
		this.connectionStrength = 150;
		if(to.isConnectedOut() && from.isConnectedOut() == false){
			from.setConnectedOut(true);
		}
		if(from.isConnectedIn() && to.isConnectedIn() == false){
			to.setConnectedIn(true);
		}
		if(to.isConnectedIn() && from.isConnectedIn()){
			this.connected = true;
		}else{
			this.connected = false;
		}
	}
	public Neuron getFrom() {
		return from;
	}
	public void setFrom(Neuron from) {
		this.from = from;
	}
	public Neuron getTo() {
		return to;
	}
	public void setTo(Neuron to) {
		this.to = to;
	}
	public float getStrength() {
		return this.connectionStrength/100000;
	}
	public void pulseForward(float intensity, int jumps) {
		if(to.isConnectedIn() && from.isConnectedIn()){
			this.connected = true;
		}else{
			this.connected = false;
		}
		if(!connected){
			this.pulseForwardInitialize(intensity,jumps);
		}else if(intensity > 10.0f){
			to.pulseForward((float)(intensity/++this.jumps), this.jumps);
			System.out.println(intensity + "SP OUT CONNECTED FORWARD:" + from.toString() + " TO:" + to.toString() + " END TOTAL JUMPS:"+ jumps);
		}
	}
	public void pulseBack(float intensity, int jumps) {
		if(to.isConnectedIn() && from.isConnectedIn()){
			this.connected = true;
		}else{
			this.connected = false;
		}
		if(!connected){
			this.pulseBackInitialize(intensity,jumps);
		}else if(intensity > 10.0f){
			to.pulseForward((float)(intensity/++this.jumps), this.jumps);
			System.out.println(intensity + "SP IN CONNECTED BACK:" + from.toString() + " TO:" + to.toString() + " END TOTAL JUMPS:"+ jumps);
		}
	}
	private void pulseForwardInitialize(float intensity, int jumps) {
		this.jumps = jumps;
		if(to.isConnectedOut()){
			from.setConnectedOut(true);
			ID++;
			System.out.println("SP OUT FROM1:" + from.toString() + " TO:" + to.toString() + " END TOTAL JUMPS:"+ jumps);
		}else if(intensity > 10.0f){
			to.pulseForward((float)(intensity/++this.jumps), this.jumps);
			System.out.println("SP OUT FROM2:" + from.toString() + " TO:" + to.toString() + " END TOTAL JUMPS:"+ jumps);
		}
	}
	public void pulseBackInitialize(float intensity, int jumps) {
		System.out.println("CODE REACHED");
		this.jumps = jumps + 1;
		if(from.isConnectedIn()){
			System.out.println("SP BACK FROM1: " + from.isConnectedIn() + " " + from.toString() + " TO:" + to.isConnectedIn() + " "  +  to.toString() + " END TOTAL JUMPS:"+ jumps);
			to.setConnectedIn(true);
			ID++;
		}else if(intensity > 10.0f){
			System.out.println("SP BACK FROM2: " + from.isConnectedIn() + " " + from.toString() + " TO:" + to.isConnectedIn() + " "  +  to.toString() + " END TOTAL JUMPS:"+ jumps);
			from.pulseBack((float)(intensity/this.jumps), this.jumps);
		}else{
			
		}
	}
	public void excite(){
		
	}
	public void inhibit(){
		
	}
	public boolean connected(){
		return this.connected;
	}
}
