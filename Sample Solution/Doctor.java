public class Doctor {
	String name;
	int specialization;

	Doctor(String name, int specialization) {
		this.name = name;
		this.specialization = specialization;
	}

	String getName() {
		return this.name;
	}

	int getSpecialization() {
		return this.specialization;
	}

	Disease differentialDiagnosis(Patient p, Disease[] d) {
		int maxScore = 0;
		Disease maxMatchingDisease = null;
		String[] patientSymptoms = p.getSymptoms();

		for (int i = 0; i < d.length; i++) {
			int score = 0;

			for (int j = 0; j < patientSymptoms.length; j++) {
//				System.out.println(patientSymptoms[i]);
				if (d[i] != null && d[i].symptomsInclude(patientSymptoms[j])) {
					score++;
					System.out.println(d[i].getName());
				}
					
			}

			if (score > maxScore) {
				maxScore = score;
				maxMatchingDisease = d[i];
			}
		}

		return maxMatchingDisease;
	}
}