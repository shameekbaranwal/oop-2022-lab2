class Hospital {
	Patient[] patients;
	int numPatients;
	Disease[] diseases;
	int numDiseases;
	Doctor House;
	Doctor Wilson;

	Hospital() {
		patients = new Patient[10];
		numPatients = 0;
		diseases = new Disease[10];
		numDiseases = 0;
		House = new Doctor("Gregory House");
		Wilson = new Doctor("James Wilson");
	}

	Patient[] getPatients() {

	}

	Disease[] getDiseases() {

	}

	void addPatient(String name, int category, String[] symptoms) {

	}

	void addDisease(String name, String treatment, int communicability, String[] symptoms) {

	}

	Doctor assignDoctor(Patient p) {

	}

	void diagnose(Patient p) {

	}

	String treatment(Patient p) {

	}
}