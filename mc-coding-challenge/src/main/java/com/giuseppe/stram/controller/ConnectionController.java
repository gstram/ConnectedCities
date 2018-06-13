package com.giuseppe.stram.controller;

import org.springframework.web.bind.annotation.RestController;

import com.giuseppe.stram.DoesConnectionExist;
import com.giuseppe.stram.beans.Connection;

import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ConnectionController {
	
    @RequestMapping("/connected")
    public String connection(
    		@RequestParam(value="origin", defaultValue="null") String origin,
    		@RequestParam(value="destination", defaultValue="null") String destination) 
    {
    	// Create connection with request parameters
    	Connection con1 = new Connection(origin.trim(),destination.trim());
    	
    	//Display No if origin or destination are null
    	if(con1.getOrigin().equals("null") || con1.getDestination().equals("null"))
    	{
    		return "No";
    	}
  
    	// Create map of connections from city.txt
    	Map<String, Set<String>> map = DoesConnectionExist.createMap();
    	
    	// Determine if route exists
    	boolean isConnected = DoesConnectionExist.findRoute(con1.getOrigin(), con1.getDestination(), map);
    	
    	//Display result
    	if(isConnected)
    	{
    		return "Yes";
    	}
    	else
    		return "No";
    }

}
