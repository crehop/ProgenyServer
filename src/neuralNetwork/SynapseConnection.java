package neuralNetwork;

public class SynapseConnection {
	private Neuron from;
	private Neuron to;
	private int connectionStrength = 155;
	private int ID = 0;
	private int jumps = 1;
	private boolean kill;
	
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
	public void pulseOut(float intensity, int jumps) {
		this.jumps = jumps;
		if(to.isConnectedOut()){
			from.setConnectedOut(true);
			ID++;
			System.out.println("SP OUT FROM1:" + from.toString() + " TO:" + to.toString() + " END TOTAL JUMPS:"+ jumps);
		}else if(intensity > 10.0f){
			to.pulseOut((float)(intensity/++this.jumps), this.jumps);
			System.out.println("SP OUT FROM2:" + from.toString() + " TO:" + to.toString() + " END TOTAL JUMPS:"+ jumps);
		}else{
			
		}
	}
	public void pulseBack(float intensity, int jumps) {
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
}
