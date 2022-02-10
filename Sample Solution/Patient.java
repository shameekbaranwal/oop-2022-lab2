/**
 * 
 * The Patient Class. This is where the symptoms are listed, and the patient is
 * used in the doctor class to
 * diagnose with the appropriate disease.
 *
 */
public class Patient {
	String name;
	int ID;
	String[] symptoms;
	Disease disease;

	/**
	 * @param name     Name of the patient
	 * @param ID       for deciding which doctor will be assigned.
	 * @param symptoms The list of symptoms.
	 *                 Creates a new instance of Patient
	 */
	public Patient(String name, int ID, String[] symptoms) {
		this.name = name;
		this.ID = ID;
		this.symptoms = symptoms;
		this.disease = null;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the list of symptoms.
	 */
	public String[] getSymptoms() {
		return this.symptoms.clone();
	}

	/**
	 * @return the disease ID
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * @return the disease
	 */
	public Disease getDisease() {
		return this.disease;
	}

	/**
	 * @param d A disease object
	 *          Set the disease of the patient
	 */
	public void setDisease(Disease d) {
		this.disease = d;
	}

	/**
	 * @return true if the patient has been diagnosed
	 */
	public boolean hasBeenDiagnosed() {
		return (this.disease != null);
	}

}