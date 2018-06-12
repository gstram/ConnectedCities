package com.giuseppe.stram;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class DoesConnectionExist 
{

	// Helper method to determine if city has a matching city in map 
	// or add it to map
	private static Set<String> getCityConnections(Map<String, Set<String>> map, String city) {
		// if map doesnt not contain city, add it to map
		if (!map.containsKey(city)) {
			map.put(city, new HashSet<String>());
		}

		// return set of matching cities
		return map.get(city);
	}

	// method to determine if route between cities exists
	public static boolean findRoute(String city1, String city2, Map<String, Set<String>> nodeMap) 
	{
		// determine if city1 and city2 are the same city
		boolean isFound = city1.equals(city2);

		if (nodeMap.containsKey(city1) && nodeMap.containsKey(city2)) {
			// Queue to determine cities to visit
			Queue<String> citiesToVisit = new LinkedList<String>();

			// Set to hold all the cities visited so
			// the function doesnt visit a city more than once
			Set<String> citiesVisited = new HashSet<String>();

			// add initial city to cities to visit
			citiesToVisit.add(city1);

			while (!citiesToVisit.isEmpty() && !isFound) {
				// remove city from queue and set it to string
				String cityToVisit = citiesToVisit.poll();

				// determine if city1 and city2 are same to break loop
				isFound = cityToVisit.equals(city2);

				// query node map to get all possible connections from city
				Set<String> routes = nodeMap.get(cityToVisit);

				// iterate through routes set
				for (String city : routes) {
					if (!citiesVisited.contains(city)) {
						// add city to cities to visit and cities visited
						citiesToVisit.add(city);
						citiesVisited.add(city);
					}
				}
			}
		}

		return isFound;
	}
	
	public static Map<String, Set<String>> createMap()
	{
		// create a node map 
		Map<String, Set<String>> nodeMap = new HashMap<String, Set<String>>();

		// Parse file to get all travel routes
		try (Scanner scanner = new Scanner(new File("city.txt")).useDelimiter(",|\r\n")) 
		{
			while (scanner.hasNext()) 
			{
				// Get start and ending city of travel route
				String start = scanner.next().trim();
				String end = scanner.next().trim();

				// Populate node map with all possible routes
				Set<String> startConnections = getCityConnections(nodeMap, start);
				Set<String> endConnections = getCityConnections(nodeMap, end);
				startConnections.add(end);
				endConnections.add(start);
			}
			scanner.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return nodeMap;
	}
}
