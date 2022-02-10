/**
 * 
 * The Doctor Class. This is the class that will be used to get the differential
 * diagnosis
 * for each patient. The diagnosed disease is used to then decide the treatment.
 *
 */
public class Doctor {

	String name;

	/**
	 * 
	 * @param name The name of the doctor.
	 */
	public Doctor(String name) {
		this.name = name;
	}

	/**
	 * @return the Name of the doctor object.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param p - A patient object which is to be diagnosed
	 * @param d - The list of diseases that could potentially be the diagnosis.
	 *          <br/>
	 *          This is the main diagnosis function. It takes in a patient and the
	 *          list of diseases that the
	 *          hospital object has, and determines the diagnostic report by
	 *          checking the maximum matching symptoms with any
	 *          disease.
	 *          <br/>
	 * @return A Disease object that is the diagnosed disease based on symptoms
	 */
	public Disease differentialDiagnosis(Patient p, Disease[] d) {
		int maxScore = 0;
		Disease maxMatchingDisease = d[0];
		String[] patientSymptoms = p.getSymptoms();

		for (int i = 0; i < d.length; i++) {
			int score = 0;

			for (int j = 0; j < patientSymptoms.length; j++) {
				// System.out.println(patientSymptoms[i]);
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