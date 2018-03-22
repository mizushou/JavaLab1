package ca.ciccc.java.model;

/**
 *
 * @author shouhei
 *
 */
public class Driver {

	public static void main(String[] args) {

		Model m1 = new Model("Shouhei", "Mizuno", 65, 116, true, false);
		m1.printDetails();
		System.out.println(m1.getHeightInFeetAndInches());
		System.out.println();
		m1.setWeight(100L);
		System.out.println(m1.getWeight());
		m1.setWeight(80.123);
		System.out.println(m1.getWeight());
		m1.setHeight(6, 5);
		System.out.println(m1.getHeight());
		m1.setHeight(84);
		System.out.println(m1.getHeight());
		System.out.println(Model.getOccupation());
		System.out.println();
		m1.printDetails();

		Model m2 = new Model("Tom", "Cruise", 75, 116, false, true);
		m2.displayModelDetials();
		System.out.println();
		m2.displayModelDetials(true);

		System.out.println();
		System.out.println(m1);
		System.out.println(m2);

	}

}
