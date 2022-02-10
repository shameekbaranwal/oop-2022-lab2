import junit.framework.TestCase;
import java.util.Arrays;
import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest extends TestCase {
	// Disease Objects for testing.
	Disease lupus = null, stripe = null, commonCold = null,
			covid = null, meningitis = null;
	// Hospital Object
	Hospital princeton = null;
	// Two doctor objects as described in the problem statement.
	Doctor House = null, Wilson = null;
	// Patient objects to test different cases.
	Patient one = null, two = null, three = null, four = null;

	// test String array to check for symptoms received back.
	String[] testSymptoms = new String[] { "Delusions", "Hallucinations", "Abnormal Motor Behaviour",
			"Disorganised thinking" };

	Patient[] patients = new Patient[3];
	Disease[] diseases = new Disease[4];

	// initializing all objects.
	public SolutionTest(String name) {
		super(name);

		princeton = new Hospital();

		lupus = new Disease("Lupus", "Antibiotics", 25,
				new String[] { "Fatigue", "Fever", "Joint pain", "Stiffness", "Swelling", "Rash" });
		stripe = new Disease("Schizophrenia", "PsychosocialTherapy", 5,
				new String[] { "Delusions", "Hallucinations", "Abnormal Motor Behaviour", "Disorganised thinking" });
		commonCold = new Disease("Common cold", "Antibiotics", 50,
				new String[] { "Sneezing", "Runny nose", "Congestion", "Throat ache" });
		covid = new Disease("Covid 19", "Antivirals", 65, new String[] { "Fever", "Loss of smell", "Loss of taste",
				"Throat pain", "Body ache", "Headaches", "Difficulty breathing" });

		one = new Patient("John", 1, new String[] { "Difficulty breathing", "Fever", "Sneezing" });
		two = new Patient("Oliver", 2, new String[] { "Fatigue", "Fever", "Rash", "Joint pain" });
		three = new Patient("Joe", 1,
				new String[] { "Delusions", "Hallucinations", "Abnormal Motor Behaviour", "Disorganised thinking" });
		four = new Patient("Don", 2, new String[] { "Sneezing", "Throat ache", "Runny nose", "Congestion" });

		patients[0] = one;
		patients[1] = three;
		patients[2] = two;

		diseases[0] = lupus;
		diseases[1] = covid;
		diseases[2] = commonCold;
		diseases[3] = stripe;

		House = new Doctor("Gregory House");
		Wilson = new Doctor("James Wilson");

		princeton.addDisease("Lupus", "Antibiotics", 25,
				new String[] { "Fatigue", "Fever", "Joint pain", "Stiffness", "Swelling", "Rash" });
		princeton.addDisease("Covid 19", "Antivirals", 65, new String[] { "Fever", "Loss of smell", "Loss of taste",
				"Throat pain", "Body ache", "Headaches", "Difficulty breathing" });
		princeton.addDisease("Common cold", "Antibiotics", 50,
				new String[] { "Sneezing", "Runny nose", "Congestion", "Throat ache" });
		princeton.addDisease("Schizophrenia", "PsychosocialTherapy", 5,
				new String[] { "Delusions", "Hallucinations", "Abnormal Motor Behaviour", "Disorganised thinking" });

		princeton.addPatient("John", 1, new String[] { "Difficulty breathing", "Fever", "Sneezing" });
		princeton.addPatient("Joe", 1,
				new String[] { "Delusions", "Hallucinations", "Abnormal Motor Behaviour", "Disorganised thinking" });
		princeton.addPatient("Oliver", 2, new String[] { "Fatigue", "Fever", "Rash", "Joint pain" });

	}
	/*
	 * The test cases. Note that the order of the test cases is as described in the
	 * problem statement.
	 */

	@Test
	public void testCase1() {
		assert (one.getName().equals(new String("John")) == true);
	}

	@Test
	public void testCase2() {
		String[] symptoms = three.getSymptoms();
		assertEquals(true, Arrays.equals(symptoms, testSymptoms));
	}

	@Test
	public void testCase3() {
		assertEquals(2, two.getID());
	}

	@Test
	public void testCase4() {
		assert (lupus.symptomsInclude("Delusions") == false);
		assert (covid.symptomsInclude("Loss of smell") == true);
	}

	@Test
	public void testCase5() {
		assertTrue(covid.isInfectious());
		assertFalse(lupus.isInfectious());
	}

	@Test
	public void testCase6() {
		assert (princeton.getNumPatients() == 3);
	}

	@Test
	public void testCase7() {

		Patient[] get = princeton.getPatients();

		for (int i = 0; i < 3; ++i) {
			assertTrue(get[i].getName().equals(patients[i].getName()));
			assert (get[i].getID() == patients[i].getID());
		}

	}

	@Test
	public void testCase8() {
		assert (princeton.getNumDiseases() == 4);
	}

	@Test
	public void testCase9() {
		Disease[] get = princeton.getDiseases();

		for (int i = 0; i < 3; ++i) {
			assertTrue(get[i].getName().equals(diseases[i].getName()));
		}
	}

	@Test
	public void testCase10() {
		princeton.diagnose(four);
		princeton.diagnose(one);
		princeton.diagnose(three);

		assert (four.getDisease().getName().equals(commonCold.getName()));
		assert (one.getDisease().getName().equals(covid.getName()));
		assert (three.getDisease().getName().equals(stripe.getName()));

	}

	@Test
	public void testCase11() {
		princeton.diagnose(three);
		princeton.diagnose(four);

		assertTrue(princeton.treatment(three).equals("PsychosocialTherapy"));
		assertTrue(princeton.treatment(four).equals("Antibiotics"));
	}

	@Test
	public void testCase12() {
		assert (House.differentialDiagnosis(one, diseases).getName() == covid.getName());
		assert (Wilson.differentialDiagnosis(four, diseases).getName() == commonCold.getName());
	}

}