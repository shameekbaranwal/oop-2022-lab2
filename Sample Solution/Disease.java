public class Disease {
	String name;
	String treatment;
	int communicability;
	String[] symptoms;

	Disease(String name, String treatment, int communicability, String[] symptoms) {
		this.name = name;
		this.treatment = treatment;
		this.communicability = communicability;
		this.symptoms = symptoms;
	}

	String getName() {
		return this.name;
	}

	String getTreatment() {
		return this.treatment;
	}

	boolean isInfectious() {
		return (this.communicability > 42);
	}

	boolean symptomsInclude(String symptom) {
		for (int i = 0; i < this.symptoms.length; i++) {
			if (this.symptoms[i].equals(symptom))
				return true;
		}

		return false;
	}
}