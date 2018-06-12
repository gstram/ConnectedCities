package com.giuseppe.stram;

public class Connection {
    private final String origin, destination;

    public Connection(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String validConnection()
    {
    	return "no";
    }
}
