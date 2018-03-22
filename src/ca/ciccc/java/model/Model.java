package ca.ciccc.java.model;

/**
 *
 * This class represent person who is modeling. And, it is capable to calculate salary (pay per hour).<br>
 * It has attributes below.
 * <ul>
 * <li>firstName</li>
 * <li>lastName</li>
 * <li>height (Unit : inches)</li>
 * <li>weight (Unit : pounds)</li>
 * <li>canTravel</li>
 * <li>smokes</li>
 * <li>occupation [static]</li>
 * </ul>
 *
 * @since 2018-03-20
 * @author shouhei.mizuno
 *
 */

public class Model {

	private String firstName;
	private String lastName;
	private int height; // inches
	private double weight; // pounds
	private boolean canTravel;
	private boolean smokes;
	static String occupation = "modeling";

	/**
	 * A value of inches per foot.
	 */
	public static final int INCHES_PER_FOOT = 12;
	/**
	 * A value of base rate dollars per hour.
	 */
	public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
	/**
	 * A threshold of height(Unit:inches).
	 */
	public static final int TALL_INCHES = 67;
	/**
	 * A threshold of weight(Unit:pounds).
	 */
	public static final double THIN_POUNDS = 140.0;
	/**
	 * A Bonus of tall, thin modes.
	 */
	public static final double TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
	/**
	 * A bonus of models who willing to travel.
	 */
	public static final double TRAVEL_BOUNUS_DOLLARS_PER_HOUR = 4;
	/**
	 * A deduction of models who are smoker.
	 */
	public static final double SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;
	/**
	 * A value of kilogram per pounds.
	 */
	public static final double KG_PER_POUNDS = 0.453592;
	/**
	 * A value of inches per centimeter.
	 */
	public static final double INCHES_PER_CM = 0.393;

	/**
	 *
	 * Default constructor of this class.
	 *
	 */
	public Model() {

	}

	/**
	 *
	 * Constructs a new Model object by setting initial values in specified values.
	 *
	 * @param firstName The firstName of the person
	 * @param lastName The lastName of the person
	 * @param height The height(Unit:inches) of the person
	 * @param weight The weight(Unit:pounds) of the person
	 * @param canTravel The person can travel or not.
	 * @param smokes The person smokes or not.
	 */
	public Model(String firstName, String lastName, int height, double weight, boolean canTravel, boolean smokes) {

		setFirstName(firstName);
		setLastName(lastName);
		setHeight(height);
		setWeight(weight);
		setCanTravel(canTravel);
		setSmokes(smokes);

	}

	/**
	 *
	 * Constructs a new Model object by setting initial values in specified values.<br>
	 * [canTravel] and [smokes] are set in true and false.
	 *
	 * @param firstName The firstName of the person.
	 * @param lastName The lastName of the person.
	 * @param height The height(Unit:inches) of the person.
	 * @param weight The weight(Unit:pounds) of the person.
	 */
	public Model(String firstName, String lastName, int height, double weight) {
		this(firstName, lastName, height, weight, true, false);
	}

	/**
	 * Stdout the Model object's attributes.
	 */
	public void printDetails() {

		System.out.println("Name:" + getFirstName() + " " + getLastName());
		System.out.println("Height:" + getHeight() + " inches");
		System.out.println("Weight:" + Math.round(getWeight()) + " pounds");

		if (canTravel == true) {
			System.out.println("Dose travel");
		} else {
			System.out.println("Does not travel");
		}

		if (smokes == true) {
			System.out.println("Does smoke");
		} else {
			System.out.println("Does not smoke");
		}

	}

	/**
	 *
	 * Calculate the dollars per hour of the Model's object.
	 *
	 * @return dollars per hour
	 */
	public int calculatePayDollarsPerHour() {

		int amount = BASE_RATE_DOLLARS_PER_HOUR;
		if (TALL_INCHES <= getHeight() && THIN_POUNDS >= getWeight()) {
			amount += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
		}
		if (isCanTravel()) {
			amount += TRAVEL_BOUNUS_DOLLARS_PER_HOUR;
		}
		if (isSmokes()) {
			amount -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
		}
		return amount;

	}

	/**
	 *
	 * Stdout the Model object's attributes and hourly rate of the Model's object.
	 *
	 */
	public void displayModelDetials() {

		System.out.println("Name:" + getFirstName() + " " + getLastName());
		System.out.println("Height:" + getHeightInFeetAndInches());
		System.out.println("Weight:" + getWeight() + " pounds");

		if (canTravel == true) {
			System.out.println("yep");
		} else {
			System.out.println("nope");
		}

		if (smokes == true) {
			System.out.println("yep");
		} else {
			System.out.println("nope");
		}
		System.out.println("Hourly rate: $" + calculatePayDollarsPerHour());

	}

	/**
	 *
	 * Stdout the Model object's attributes and hourly rate of the Model's object.<br>
	 * This method display as metricUnits if you pass true argument.
	 *
	 * @param metricUnits display as metricUnits or not
	 */
	public void displayModelDetials(boolean metricUnits) {
		if (metricUnits) {
			System.out.println("Name:" + getFirstName() + " " + getLastName());
			System.out.println("Height:" + getHeightCm() + " cm");
			System.out.println("Weight:" + getWeightKg() + " kg");

			if (canTravel == true) {
				System.out.println("yep");
			} else {
				System.out.println("nope");
			}

			if (smokes == true) {
				System.out.println("yep");
			} else {
				System.out.println("nope");
			}
			System.out.println("Hourly rate: $" + calculatePayDollarsPerHour());
		} else {
			displayModelDetials();
		}
	}

	/**
	 *
	 * Getter of FirstName value;
	 *
	 * @return firstName firstName
	 */
	public final String getFirstName() {

		return this.firstName;

	}

	/**
	 * Setter of FirstName value.
	 *
	 * @param firstName firstName
	 */
	public final void setFirstName(String firstName) {
		if ((firstName != null) && (firstName.length() >= 3) && (firstName.length() <= 20)) {
			this.firstName = firstName;
		}

	}

	/**
	 *
	 * Getter of the height value. Return height in feet and inch.
	 *
	 * @return height
	 */
	public String getHeightInFeetAndInches() {
		int height = this.getHeight();
		int feet = height / 12;
		int inch = height % 12;

		if (inch == 0) {
			return feet + " feet";
		} else if (inch == 1) {
			return feet + " feet " + inch + " inch";
		} else {
			return feet + " feet " + inch + " inches";
		}

	}

	/**
	 *
	 * Getter of the height value. Return height in centimeter.
	 *
	 * @return height
	 */
	public long getHeightCm() {

		int height = getHeight();
		double cm = height / INCHES_PER_CM;
		return Math.round(cm);

	}

	/**
	 *
	 * Getter of lastName value;
	 *
	 * @return lastName lastName
	 */
	public final String getLastName() {

		return this.lastName;

	}

	/**
	 * Setter of lastName value.
	 *
	 * @param lastName lastName
	 */
	public final void setLastName(String lastName) {

		this.lastName = lastName;

	}

	/**
	 *
	 * Getter of height value.
	 *
	 * @return height height
	 */
	public final int getHeight() {

		return this.height;

	}

	/**
	 *
	 * Setter of height value. This method can receive height argument in feet and inches.
	 *
	 * @param feet height's feet part
	 * @param inches height's inches part
	 */
	public final void setHeight(int feet, int inches) {

		setHeight(feet * INCHES_PER_FOOT + inches);

	}

	/**
	 *
	 * Setter of height value.
	 *
	 * @param inches height
	 */
	public final void setHeight(int inches) {

		if ((inches >= 24) && (inches <= 84)) {
			this.height = inches;

		}

	}

	/**
	 *
	 * Getter of weight value.
	 *
	 * @return weight weight
	 */
	public final double getWeight() {

		return this.weight;

	}

	/**
	 *
	 * Getter of weight value. Return weight in kilogram.
	 *
	 * @return weight weight
	 */
	public long getWeightKg() {
		double weight = this.getWeight();
		long weightKg = Math.round(weight * KG_PER_POUNDS);
		return weightKg;
	}

	/**
	 *
	 * Setter of weight value. This method can receive weight argument in kilograms.
	 *
	 * @param kilogramas weight
	 */
	public final void setWeight(long kilogramas) {
		double pounds = kilogramas / KG_PER_POUNDS;
		setWeight(pounds);
	}

	/**
	 *
	 * Setter of weight value.
	 *
	 * @param pounds weight
	 */
	public final void setWeight(double pounds) {

		if ((pounds >= 80) && (pounds <= 280)) {
			this.weight = pounds;
		}

	}

	/**
	 * Getter of canTravel value.
	 *
	 * @return canTravel canTravel
	 */
	public final boolean isCanTravel() {
		return this.canTravel;
	}

	/**
	 *
	 * Setter of canTravel value.
	 *
	 * @param canTravel canTravel
	 */
	public final void setCanTravel(boolean canTravel) {
		this.canTravel = canTravel;
	}

	/**
	 *
	 * Getter of smokes value.
	 *
	 * @return smokes smokes
	 */
	public final boolean isSmokes() {
		return this.smokes;
	}

	/**
	 *
	 * Setter of smokes value.
	 *
	 * @param smokes smokes
	 */
	public final void setSmokes(boolean smokes) {
		this.smokes = smokes;
	}


	/**
	 *
	 * Getter of occupation value.
	 *
	 * @return occupation occupation
	 */
	public static String getOccupation() {
		return occupation;
	}

	@Override
	/**
	 * Returns the string representation of this Model.
	 *
	 * @return The string representation of this Model
	 */
	public String toString() {

		return "This is Model class's instance. The name is " + getFirstName() + " " + getLastName();

	}

}
