package packets;

public class Packet2MoveMent {
	private String ID;
	private float x;
	private float y;
	private float rotation;
	private float rotationalInertia;
	private float inertia;
	private float mass;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getRotation() {
		return rotation;
	}
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	public float getRotationalInertia() {
		return rotationalInertia;
	}
	public void setRotationalInertia(float rotationalInertia) {
		this.rotationalInertia = rotationalInertia;
	}
	public float getInertia() {
		return inertia;
	}
	public void setInertia(float inertia) {
		this.inertia = inertia;
	}
	public float getMass() {
		return mass;
	}
	public void setMass(float mass) {
		this.mass = mass;
	}
}
