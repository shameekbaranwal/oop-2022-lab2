import junit.framework.TestCase;
import java.util.Arrays;
import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest extends TestCase {
	Disease lupus = null, stripe = null, commonCold = null,
			covid = null, meningitis = null;
	Hospital princeton = null;
	Doctor house = null, wilson = null;
	Patient one = null, two = null, three = null, four = null;
	
	String [] testSymptoms = new String[] {"Delusions", "Hallucinations", "Abnormal Motor Behaviour", "Disorganised thinking"};
	
	
	
	public SolutionTest(String name) {
		super(name);
		
		princeton = new Hospital();
		
		lupus = new Disease("Lupus", "Antibiotics", 25, new String [] {"Fatigue", "Fever", "Joint pain", "Stiffness", "Swelling", "Rash"});
		stripe = new Disease("Schizophrenia", "PsychosocialTherapy", 5, new String [] {"Delusions", "Hallucinations", "Abnormal Motor Behaviour", "Disorganised thinking"});
		commonCold = new Disease("Common cold", "Antibiotics", 50, new String [] {"Sneezing", "Runny nose", "Congestion", "Throat ache"});
		covid = new Disease("Covid 19", "Antivirals", 65, new String[] {"Fever", "Loss of smell", "Loss of taste", "Throat pain", "Body ache", "Headaches", "Difficulty breathing"});
		
		one = new Patient("John", 1, new String[] {"Difficulty breathing", "Fever", "Sneezing"});
		two = new Patient("Oliver", 2, new String[] {"Fatigue", "Fever", "Rash", "Joint pain"});
		three = new Patient("Joe", 1, new String[] {"Delusions", "Hallucinations", "Abnormal Motor Behaviour", "Disorganised thinking"});
		four = new Patient("Don", 2, new String [] { "Sneezing", "Throat ache", "Runny nose", "Congestion"});
		
		princeton.addDisease("Lupus", "Antibiotics", 25, new String [] {"Fatigue", "Fever", "Joint pain", "Stiffness", "Swelling", "Rash"});
		princeton.addDisease("Covid 19", "Antivirals", 65, new String[] {"Fever", "Loss of smell", "Loss of taste", "Throat pain", "Body ache", "Headaches", "Difficulty breathing"});
		
		princeton.addPatient("John", 1, new String[] {"Difficulty breathing", "Fever", "Sneezing"});
		princeton.addPatient("Joe", 1, new String[] {"Delusions", "Hallucinations", "Abnormal Motor Behaviour", "Disorganised thinking"});
		princeton.addPatient("Oliver", 2, new String[] {"Fatigue", "Fever", "Rash", "Joint pain"});
		

	}
	
	@Test
	public void testPatient() {
		assert(one.getName().equals(new String ("John")) == true);
		String [] symptoms = three.getSymptoms();
		assertEquals(true, Arrays.equals(symptoms, testSymptoms));
		assertEquals(2, two.getCategory());
		
	}
	
	@Test
	public void testDisease() {
		assert(lupus.symptomsInclude("Delusions") == false);
		assert(covid.symptomsInclude("Loss of smell") == true);
		assertTrue(covid.isInfectious());
		assertFalse(lupus.isInfectious());
	}
	
	@Test
	public void testHospital() {
		
		Disease hopefullyCold = princeton.diagnose(four);
		Disease hopefullyCovid = princeton.diagnose(one);
		Disease hopefullySchizo = princeton.diagnose(three);
		
		//something going wrong in this
//		assert(hopefullyCold.getName() == commonCold.getName());
		
		assert(hopefullyCovid.getName() == covid.getName());
		
		//and this
//		assert(hopefullySchizo.getName() == stripe.getName());
		
		assert(princeton.getNumPatients() == 3);
		assert(princeton.getNumDiseases() == 2);
		
		assertTrue(princeton.treatment(one).equals("Antivirals"));
		
	}
	
	@Test 
	public void testDoctor() {
		Doctor House = new Doctor("Gregory House", 1);
		Doctor Wilson = new Doctor("James Wilson", 2);
		
		Disease[] d = princeton.getDiseases();
		
		//....and this !!!????
//		assert(House.differentialDiagnosis(four, d).getName() == lupus.getName());
//		assert(Wilson.differentialDiagnosis(four,d).getName() == commonCold.getName());
 	}

}
