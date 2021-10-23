package leetcode;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.ArrayList;

public class City {
    private Collection<City> adjacentCities;
    private String name;

    public City(String name) {
        this.name = name;
        this.adjacentCities = new ArrayList<City>();
    }

    /**
     * Name of the city, can be assumed to be unique
     */
    public String getName() {
        return name;
    }

    /**
     * Adjacent city are connected to this city directly by road
     */
    public Collection<City> getAdjacentCities() {
        return adjacentCities;
    }

    public void addAdjacentCity(City city) {
        adjacentCities.add(city);
        city.getAdjacentCities().add(this);
    }

    public boolean canDriveTo(City city) {
    	Set<City> canToCities = new LinkedHashSet<City>();
    	ArrayList<City> adjCities = new ArrayList<City>();
    	for (City itemCity : this.adjacentCities) {
    		adjCities.add(itemCity);
    		canToCities.add(itemCity);
    	}
    	while(adjCities.size() > 0) {
    		City curCity = adjCities.remove(adjCities.size() - 1);
    		if(curCity.getName() == city.getName()) {
    			return true;
    		}
    		else {
    			canToCities.add(curCity);
    			for(City itemCity : curCity.getAdjacentCities()) {
    				if (!canToCities.contains(itemCity)) {
    					adjCities.add(itemCity);
    				}
    			}
    		}
    	}
    	return false;
    }

    public static void main(String[] args) {
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");

        a.addAdjacentCity(b);
        b.addAdjacentCity(c);

        System.out.println(a.canDriveTo(c));
    }
}