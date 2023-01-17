/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	
 *	@since	
 */
public class City implements Comparable<City> {
	
	// fields
	private String name;
	private String state;
	private String designation;
	private int population;
	// constructor
	public City(String cityName, String stateName, String type, int pop) {
		name = cityName;
		state = stateName;
		designation = type;
		population = pop;
	}
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	 public int compareTo(City other) {
		 if (population != other.population) return population - other.population;
		 if (!state.equals(other.state)) return state.compareTo(other.state);
		 return name.compareTo(other.name);
	 }

	 public int compareByName(City other) {
		if (!name.equals(other.name)) return name.compareTo(other.name);
		if (population != other.population) return population - other.population;
		return state.compareTo(other.state);
	 }
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	 public boolean equals(City other) {
		return name.equals(other.name) && state.equals(other.state);
		
	 }
	
	/**	Accessor methods */
	
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, designation,
						population);
	}
}
