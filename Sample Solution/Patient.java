public class Patient {
	String name;
	int category;
	String[] symptoms;
	Disease disease;

	/** Creates a new instance of Patient */
	Patient(String name, int category, String[] symptoms) {
		this.name = name;
		this.category = category;
		this.symptoms = symptoms;
		this.disease = null;
	}

	/**
	 * @return the name
	 */
	String getName() {
		return this.name;
	}

	/**
	 * @return the category
	 */
	String[] getSymptoms() {
		return this.symptoms.clone();
	}

	/**
	 * @return the disease category
	 */
	int getCategory() {
		return this.category;
	}

	/**
	 * @return the disease
	 */
	Disease getDisease() {
		return this.disease;
	}

	/**
	 * @param A disease object
	 *         Set the disease of the patient
	 */
	void setDisease(Disease d) {
		this.disease = d;
	}

	/**
	 * @return true if the patient has been diagnosed
	 */
	boolean hasBeenDiagnosed() {
		return (this.disease != null);
	}

}