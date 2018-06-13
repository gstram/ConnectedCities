package com.giuseppe.stram.beans;

public class Connection {

	private final String origin, destination;
	
	public Connection(String origin, String destination) {
		super();
		this.origin = origin;
		this.destination = destination;
		}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

}
