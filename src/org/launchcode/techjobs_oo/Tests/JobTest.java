package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JobTest {
    Job jobOne;
    Job jobTwo;

    @Before
    public void createJobObjects() {
        jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTwo = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue(jobOne.getId() + 1 == jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(jobOne.getName().equals("Product tester"));
        assertTrue(jobOne.getEmployer().toString().equals("ACME"));
        assertTrue(jobOne.getEmployer() instanceof Employer);
        assertTrue(jobOne.getLocation().toString().equals("Desert"));
        assertTrue(jobOne.getLocation() instanceof Location);
        assertTrue(jobOne.getPositionType().toString().equals("Quality control"));
        assertTrue(jobOne.getPositionType() instanceof PositionType);
        assertTrue(jobOne.getCoreCompetency().toString().equals("Persistence"));
        assertTrue(jobOne.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobOne.equals(jobThree));
    }
}
