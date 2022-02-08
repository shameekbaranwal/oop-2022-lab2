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
		return this.patients;
	}

	Disease[] getDiseases() {
		return this.diseases;
	}

	void addPatient(String name, int category, String[] symptoms) {
		Patient p = new Patient(name, category, symptoms);
		patients[numPatients++] = p;
	}

	void addDisease(String name, String treatment, int communicability, String[] symptoms) {
		Disease d = new Disease(name, treatment, communicability, symptoms);
		diseases[numDiseases++] = d;
	}

	Doctor assignDoctor(Patient p) {
		if (p.getID() % 2 == 1)
			return House;

		return Wilson;
	}

	Disease diagnose(Patient p) {
		if (p.hasBeenDiagnosed())
			return p.getDisease();

		Doctor assignedDoctor = this.assignDoctor(p);

		Disease d = assignedDoctor.differentialDiagnosis(p, diseases);
		p.disease = d;
		return d;
	}

	String treatment(Patient p) {
		if (p.hasBeenDiagnosed())
			return p.getDisease().getTreatment();
		else
			return "Not diagnosed yet.";
	}
}