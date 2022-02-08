class Patient {
	String name;
	int ID;
	String[] symptoms;
	Disease disease;

	Patient(String name, int ID, String[] symptoms) {
		this.name = name;
		this.ID = ID;
		this.symptoms = symptoms;
		this.disease = null;
	}

	String getName() {
		return this.name;
	}

	String[] getSymptoms() {
		return this.symptoms.clone();
	}

	int getID() {
		return this.ID;
	}

	Disease getDisease() {
		return this.disease;
	}

	void setDisease(Disease d) {
		this.disease = d;
	}

	boolean hasBeenDiagnosed() {
		return (this.disease != null);
	}

}