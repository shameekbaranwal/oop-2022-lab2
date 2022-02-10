/**
 * 
 * The main Hospital Class. This is where all the patients and diseases are
 * stored, and doctor objects are made.
 *
 */
public class Hospital {
	Patient[] patients;
	int numPatients;
	Disease[] diseases;
	int numDiseases;
	Doctor House;
	Doctor Wilson;

	/**
	 * Creates a new instance of Hospital
	 */
	public Hospital() {
		patients = new Patient[10];
		diseases = new Disease[10];
		House = new Doctor("Gregory House");
		Wilson = new Doctor("James Wilson");
	}

	/**
	 * Get all patients of the hospital
	 * 
	 * @return All patients in the hospital.
	 */
	public Patient[] getPatients() {
		return this.patients;
	}

	/**
	 * Get the number of patients in the hospital
	 * 
	 * @return Number of patients in the hospital.
	 */
	public int getNumPatients() {
		return this.numPatients;
	}

	/**
	 * Get the number of diseases in the hospital.
	 * 
	 * @return Number of diseases in the hospital's list.
	 */
	public int getNumDiseases() {
		return this.numDiseases;
	}

	/**
	 * Get the list of diseases in the hospital.
	 * 
	 * @return All diseases in the list for diagnosis.
	 */
	public Disease[] getDiseases() {
		return this.diseases;
	}

	/**
	 * 
	 * Adds a patient to the current patient list,
	 * and increments the number of patients
	 * 
	 * @param name     The name of the patient,
	 * @param category The category of admittance
	 * @param symptoms The list of symptoms.
	 */
	public void addPatient(String name, int category, String[] symptoms) {
		Patient p = new Patient(name, category, symptoms);
		patients[numPatients++] = p;
	}

	/**
	 * 
	 * This function adds a new Disease into the Hospital's
	 * list, and increments the number of diseases.
	 * 
	 * @param name            The name of the disease.
	 * @param treatment       The name of the treatment for the disease.
	 * @param communicability An integer denoting how communicable the disease is.
	 * @param symptoms        A list of Strings denoting the symptoms of the
	 *                        disease.
	 */
	public void addDisease(String name, String treatment, int communicability, String[] symptoms) {
		Disease d = new Disease(name, treatment, communicability, symptoms);
		diseases[numDiseases++] = d;
	}

	/**
	 * 
	 * The assignDoctor function receives a patient object and checks if
	 * its ID field is even or odd.
	 * If ID is odd, then it returns a reference to the "House", else it
	 * returns a reference to the "Wilson" object.
	 * 
	 * @param p A Patient object.
	 * @return The assigned Doctor's object reference.
	 */

	public Doctor assignDoctor(Patient p) {
		if (p.getID() % 2 == 1)
			return House;

		return Wilson;
	}

	/**
	 * 
	 * The diagnose function assigns a doctor to the patient and then
	 * returns what the diagnosed disease is.
	 *
	 * @param p A Patient object.
	 * @return The Disease object.
	 */
	public void diagnose(Patient p) {
		if (p.hasBeenDiagnosed())
			return;

		Doctor assignedDoctor = this.assignDoctor(p);

		Disease d = assignedDoctor.differentialDiagnosis(p, diseases);
		p.disease = d;
	}

	/**
	 * 
	 * The function returns the treatment specified for the disease the
	 * patient is diagnosed with.
	 * 
	 * @param p - A Patient object.
	 * @return The Treatment for the disease.
	 */
	public String treatment(Patient p) {
		if (p.hasBeenDiagnosed())
			return p.getDisease().getTreatment();
		else
			return "Not diagnosed yet.";
	}
}