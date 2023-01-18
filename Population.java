import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *	Population: Allow user to sort list of cities by population
	and print different parameters.
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Anshul Sinha
 *	@since	January 15, 2023
 */
public class Population {
	
	// List of cities
	private List<City> cities;
	private SortMethods sorter;
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	public Population() {
		cities = new ArrayList<City>();
		sorter = new SortMethods();
	}

	public static void main(String[] args) {
		Population prog = new Population();
		prog.run();
		
	}
	/**
	 * Main function with method calls.
	 */
	public void run() {
		printIntroduction();
		System.out.println("\n31765 cities in database\n");
		readFile();
		// for (int i = 0; i < cities.size(); i++) {
		// 	System.out.println(cities.get(i));
		// }

		int choice = 0;
		while (choice != 9) {
			printMenu();
			choice = Prompt.getInt("Enter selection");
			switch (choice) {
				case 1:
					botFiftyInUS();
					break;
				case 2:
					topFiftyInUS();
					break;
				case 3:
					topFiftyByName();
					break;
				case 4:
					lastFiftyByName();
					break;
				case 5:
					boolean valid = false;
					while (!valid) {
						String state = Prompt.getString("Enter state name (ie. Alabama)");
						for (int i = 0; i < cities.size(); i++) {
							if (cities.get(i).getState().toLowerCase().equals(state.toLowerCase())){
								valid = true;
								i = cities.size();
							}
						}
						if (valid) topFiftyInState(state);
						else {
							System.out.printf("ERROR: %s is not valid\n", state);
						}
					}
					break;
				case 6:
					String city = Prompt.getString("Enter city name");
					System.out.printf("\n\nCity %s by population\n", city);
					citiesByName(city);
					break;
				case 9:
					System.out.println("\nThanks for using Population!");
					break;

			}
			System.out.println();
		}
		System.out.println();
		
	}
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}

	/**
	 * Sorts cities by name given a city name. Uses merge sort
	 * @param city - String of city name to start.
	 */
	public void citiesByName(String city) {
		List<City> cityCities = new ArrayList<City>();
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getName().toLowerCase().equals(city.toLowerCase())) {
				cityCities.add(cities.get(i));
			}
		}
		System.out.printf("%9s%23s%23s%21s\n", "State", "City", "Type", "Population");

		sorter.mergeSort(cityCities);

		for (int i = 0; i < cityCities.size(); i++) {
			System.out.printf("%3d: ", i + 1);
			System.out.println(cityCities.get(i));
		}

	}

	/**
	 * Sorts cities in a state given state, using merge sort
	 * @param state - State to sort by
	 */
	public void topFiftyInState(String state) {
		System.out.println("Fifty most populous cities in " + state.substring(0, 1).toUpperCase() + state.substring(1).toLowerCase());
		List<City> stateCities = new ArrayList<City>();
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getState().toLowerCase().equals(state.toLowerCase())) {
				stateCities.add(cities.get(i));
			}
		}
		System.out.printf("%9s%23s%23s%21s\n", "State", "City", "Type", "Population");
		long startMillisec = System.currentTimeMillis();
		sorter.mergeSort(stateCities);
		long endMillisec = System.currentTimeMillis();
		for (int i = 0; i < Math.min(50, stateCities.size()); i++) {
			System.out.printf("%3d: ", i + 1);
			System.out.println(stateCities.get(i));
		}
		System.out.printf("\nElapsed Time %d milliseconds\n\n", endMillisec - startMillisec);

	}

	/**
	 * Sorts cities by name in descending order.
	 */
	public void lastFiftyByName() {
		System.out.println("\nFifty cities sorted by name descending");
		System.out.printf("%9s%23s%23s%21s\n", "State", "City", "Type", "Population");
		long startMillisec = System.currentTimeMillis();
		sorter.mergeSortByName(cities);
		long endMillisec = System.currentTimeMillis();
		for (int i = cities.size() - 1; i > cities.size() - 51; i--) {
			System.out.printf("%3d: ", cities.size() - i);
			System.out.println(cities.get(i));
		}
		System.out.printf("\nElapsed Time %d milliseconds\n\n", endMillisec - startMillisec);
	}

	/**
	 * Sorts top fifty cities in the US
	 */
	public void topFiftyInUS() {
		System.out.println("\nFifty most populous cities");
		System.out.printf("%9s%23s%23s%21s\n", "State", "City", "Type", "Population");
		long startMillisec = System.currentTimeMillis();
		sorter.mergeSort(cities);
		long endMillisec = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			System.out.printf("%3d: ", i + 1);
			System.out.println(cities.get(i));
		}
		System.out.printf("\nElapsed Time %d milliseconds\n\n", endMillisec - startMillisec);
	}

	/**
	 * Sorts cities in US and prints bottom fifty.
	 */
	public void botFiftyInUS() {
		System.out.println("\nFifty least populous cities");
		System.out.printf("%9s%23s%23s%21s\n", "State", "City", "Type", "Population");
		long startMillisec = System.currentTimeMillis();
		List<City> copyCities = sorter.selectionSort(cities);
		long endMillisec = System.currentTimeMillis();
		for (int i = copyCities.size() - 1; i > copyCities.size() - 51; i--) {
			System.out.printf("%3d: ", copyCities.size() - i);
			System.out.println(copyCities.get(i));
		}
		System.out.printf("\nElapsed Time %d milliseconds\n\n", endMillisec - startMillisec);
	}

	/**
	 * Sorts cities by name and prints top fifty.
	 */
	public void topFiftyByName() {
		System.out.println("\nFifty cities sorted by name");
		long startMillisec = System.currentTimeMillis();
		List<City> copyCities = sorter.insertionSort(cities);
		long endMillisec = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			System.out.printf("%3d: ", i + 1);
			System.out.println(copyCities.get(i));
		}
		System.out.printf("\nElapsed Time %d milliseconds\n\n", endMillisec - startMillisec);
	}
	
	/**
	 * Reads the file and creates a list of Cities.
	 */
	public void readFile() {
		Scanner infile = FileUtils.openToRead(DATA_FILE);
		while (infile.hasNext()) {
			Scanner line = new Scanner(infile.nextLine());
			line.useDelimiter("\t");
			String state = line.next();
			String city = line.next();
			String type = line.next();
			int pop = Integer.parseInt(line.next());
			cities.add(new City(city, state, type, pop));
		}
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
}