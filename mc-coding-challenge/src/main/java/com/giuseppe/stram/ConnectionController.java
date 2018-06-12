package com.giuseppe.stram;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ConnectionController {
	
    @RequestMapping("/connected")
    public String connection(
    		@RequestParam(value="origin", defaultValue="null") String origin,
    		@RequestParam(value="destination", defaultValue="null") String destination) 
    {
    	
    	if(origin.equals("null") || destination.equals("null"))
    	{
    		return "No";
    	}
    	boolean isConnected = DoesConnectionExist.findRoute(origin, destination, DoesConnectionExist.createMap());
    	
    	if(isConnected)
    	{
    		return "Yes";
    	}
    	else
    		return "No";
    	
    }

}
