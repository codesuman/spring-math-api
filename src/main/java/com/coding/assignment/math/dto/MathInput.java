package com.coding.assignment.math.dto;

public class MathInput {
	private String x;
	private String y;
	
	public MathInput() {
	}	
	
	public MathInput(String x, String y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
}