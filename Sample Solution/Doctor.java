class Doctor {
	String name;

	Doctor(String name) {
		this.name = name;
	}

	String getName() {
		return this.name;
	}

	Disease differentialDiagnosis(Patient p, Disease[] d) {
		int maxScore = 0;
		Disease maxMatchingDisease = null;
		String[] patientSymptoms = p.getSymptoms();

		for (int i = 0; i < d.length; i++) {
			int score = 0;

			for (int j = 0; j < patientSymptoms.length; j++) {
				if (d[i].symptomsInclude(patientSymptoms[j]))
					score++;
			}

			if (score > maxScore) {
				maxScore = score;
				maxMatchingDisease = d[i];
			}
		}

		return maxMatchingDisease;
	}
}