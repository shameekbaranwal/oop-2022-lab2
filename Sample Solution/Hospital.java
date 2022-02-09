public class Hospital {
	Patient[] patients;
	int numPatients;
	Disease[] diseases;
	int numDiseases;
	Doctor House;
	Doctor Wilson;

	/*
	 * Creates a new instance of Hospital
	 */
	public Hospital() {
		patients = new Patient[10];
		diseases = new Disease[10];
		House = new Doctor("Gregory House", 1);
		Wilson = new Doctor("James Wilson", 2);
	}

	/*
	 * @return all patients in the hospital.
	 */
	public Patient[] getPatients() {
		return this.patients;
	}
	
	/*
	 * @return numPatients
	 */
	public int getNumPatients() {
		return this.numPatients;
	}

	/*
	 * @return numDiseases
	 */
	public int getNumDiseases() {
		return this.numDiseases;
	}
	
	
	/*
	 * @return all diseases in the list for diagnosis.
	 */
	public Disease[] getDiseases() {
		return this.diseases;
	}

	/*
	 * @param The name of the patient, the category of admittance and the list of
	 * symptoms.
	 */
	public void addPatient(String name, int category, String[] symptoms) {
		Patient p = new Patient(name, category, symptoms);
		patients[numPatients++] = p;
	}

	/*
	 * @param The name of the disease, the treatment and the communicability.
	 */
	public void addDisease(String name, String treatment, int communicability, String[] symptoms) {
		Disease d = new Disease(name, treatment, communicability, symptoms);
		diseases[numDiseases++] = d;
	}

	/*
	 * @param A Patient object.
	 * 
	 * @return The Disease object.
	 */
	public Disease diagnose(Patient p) {
		if (p.hasBeenDiagnosed())
			return p.getDisease();

		Doctor assignedDoctor = null;

		if (p.getCategory() == House.getSpecialization())
			assignedDoctor = House;
		else
			assignedDoctor = Wilson;

		Disease d = assignedDoctor.differentialDiagnosis(p, diseases);
		p.disease = d;
		return d;
	}

	/*
	 * @param A Patient object.
	 * 
	 * @return The diagnosis.
	 */
	public String treatment(Patient p) {
		if (p.hasBeenDiagnosed())
			return p.getDisease().getTreatment();
		else
			return "Not diagnosed yet.";
	}
}