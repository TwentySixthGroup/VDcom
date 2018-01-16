package model;

/**
 * Model proportion
 * 
 * @author ovsyannikovda
 *
 */
public class Proportion {
	
	private double a;
	private double b;
	private String v;
	private String w;

	/**
	 * Constructor 
	 * 
	 * @param a
	 * 				Quantity a
	 * @param v
	 * 				Type a
	 * @param b
	 * 				Quantity b
	 * @param w
	 * 				Type b
	 */
	public Proportion(double a, String v, double b, String w) {
		this.a = a;
		this.b = b;
		this.v = v;
		this.w = w;
	}
	
	/**
	 * Setter a
	 * 
	 * @param a
	 * 				Quantity a
	 */
	public void setA(double a) {
		this.a = a;
	}
	
	/**
	 * Setter b
	 * 
	 * @param b
	 * 				Quantity b
	 */
	public void setb(double b) {
		this.b = b;
	}
	
	/**
	 * Setter v
	 * 
	 * @param v
	 * 				Type a
	 */
	public void setv(String v) {
		this.v = v;
	}
	
	/**
	 * Setter w
	 * 
	 * @param w
	 * 				Type b
	 */
	public void setW(String w) {
		this.w = w;
	}
	
	/**
	 * Getter a
	 * 
	 * @return
	 * 			returns a
	 */
	public double getA() {
		return this.a;
	}
	
	/**
	 * Getter b
	 * 
	 * @return
	 * 			returns b
	 */
	public double getB() {
		return this.b;
	}
	
	/**
	 * Getter v
	 * 
	 * @return
	 * 			returns v
	 */
	public String getV() {
		return this.v;
	}
	
	/**
	 * Getter w
	 * 
	 * @return
	 * 			returns w
	 */
	public String getW() {
		return this.w;
	}

}
