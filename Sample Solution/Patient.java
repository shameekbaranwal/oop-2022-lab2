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
	 * Constructor for the Patient class.
	 * 
	 * @param name     Name of the patient
	 * @param ID       for deciding which doctor will be assigned.
	 * @param symptoms The list of symptoms.
	 * 
	 */
	public Patient(String name, int ID, String[] symptoms) {
		this.name = name;
		this.ID = ID;
		this.symptoms = symptoms;
		this.disease = null;
	}

	/**
	 * Get the name of the patient.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get all symptoms of the patient.
	 * 
	 * @return the list of symptoms.
	 */
	public String[] getSymptoms() {
		return this.symptoms.clone();
	}

	/**
	 * Get the ID of the patient.
	 * 
	 * @return the disease ID
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * Get the disease of the patient.
	 * 
	 * @return the disease
	 */
	public Disease getDisease() {
		return this.disease;
	}

	/**
	 * Set the disease for the patient.
	 * 
	 * @param d A disease object
	 * 
	 */
	public void setDisease(Disease d) {
		this.disease = d;
	}

	/**
	 * Check if the patient has been diagnosed yet.
	 * 
	 * @return true if the patient has been diagnosed
	 */
	public boolean hasBeenDiagnosed() {
		return (this.disease != null);
	}

}