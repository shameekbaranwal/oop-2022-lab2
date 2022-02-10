/**
 * 
 * The Disease Class. This is the class that holds the features for a particular
 * disease object,
 * including its symptoms, treatment and communicability.
 *
 */

public class Disease {
	String name;
	String treatment;
	int communicability;
	String[] symptoms;

	/**
	 * Constructor for the Disease class.
	 * 
	 * @param name            Name of the disease
	 * @param treatment       Treatment for the disease
	 * @param communicability How communicable the disease is.
	 * @param symptoms        The list of symptoms associated with the disease.
	 */
	public Disease(String name, String treatment, int communicability, String[] symptoms) {
		this.name = name;
		this.treatment = treatment;
		this.communicability = communicability;
		this.symptoms = symptoms;
	}

	/**
	 * This method returns the name of the disease.
	 * 
	 * @return The name of the Disease;
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * To get the treatment specified by the disease
	 * 
	 * @return The treatment specified for the disease.
	 */
	public String getTreatment() {
		return this.treatment;
	}

	/**
	 * To check if the disease is communicable
	 * 
	 * @return boolean
	 */
	public boolean isInfectious() {
		return (this.communicability > 42);
	}

	/**
	 * To check if a particular symptom matches that of the disease.
	 * 
	 * @param symptom The particular symptom we want to check with the disease
	 * @return True if the symptom is in the list of symptoms of the disease.
	 */
	public boolean symptomsInclude(String symptom) {
		for (int i = 0; i < this.symptoms.length; i++) {
			if (this.symptoms[i].equals(symptom))
				return true;
		}

		return false;
	}
}