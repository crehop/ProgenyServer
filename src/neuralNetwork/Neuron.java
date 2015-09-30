package neuralNetwork;

public abstract class Neuron {
	//input and output should be between 0-1;
	private float input;
	private float pleasure = 0;
	private float pain = 0;
	private boolean back;
	private boolean gate;
	private boolean flipped;
	public Neuron(float input){
		this.input = input/100;
		if(input < 1){
			flip();
		}
		this.fire(input);
	}
	public float fire(float input){
		return 0;
	}
	public void flip(){
		input *= -1;
		flipped = true;
	}
	public void setPain(float pain){
		this.pain = pain;
	}
	public void setPleasure(float pleasure){
		this.setPleasure(pleasure);
	}
	public abstract float getOutput();
}
