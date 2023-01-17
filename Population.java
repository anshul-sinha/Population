import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *	Population - <description goes here>
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	
 *	@since	
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
	public void run() {
		printIntroduction();
		readFile();
		for (int i = 0; i < cities.size(); i++) {
			System.out.println(cities.get(i));
		}
		System.out.println();
		System.out.printf("%9s%23s%23s%21s\n", "State", "City", "Type", "Population");
		// botFiftyInUS();
		fiftyByName();
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

	public void botFiftyInUS() {
		long startMillisec = System.currentTimeMillis();
		List<City> copyCities = sorter.selectionSort(cities);
		long endMillisec = System.currentTimeMillis();
		for (int i = copyCities.size() - 1; i > copyCities.size() - 51; i--) {
			System.out.printf("%3d: ", copyCities.size() - i);
			System.out.println(copyCities.get(i));
		}
		System.out.printf("\nElapsed Time %d milliseconds\n\n", endMillisec - startMillisec);
	}

	public void fiftyByName() {
		long startMillisec = System.currentTimeMillis();
		List<City> copyCities = sorter.insertionSort(cities);
		long endMillisec = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			System.out.printf("%3d: ", i + 1);
			System.out.println(copyCities.get(i));
		}
		System.out.printf("\nElapsed Time %d milliseconds\n\n", endMillisec - startMillisec);
	}
	
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
