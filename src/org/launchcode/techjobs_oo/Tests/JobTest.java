package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

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

    //@Test
    //public void forMySanity() {
    //    assertEquals("ACME", jobOne.getEmployer().toString());
    //}

    @Test
    public void testToStringReturnsStringWithBlankLineBeforeAndAfter() {
        char[] chars = jobOne.toString().toCharArray();
        assertEquals('\n', chars[0]);
        assertEquals('\n', chars[chars.length-1]);
    }

    @Test
    public void testToStringReturnsLabelsAndDataOnSeparateLines() {
        String template = "\n" +
                "ID: " + jobOne.getId() +
                "\nName: " + jobOne.getName() +
                "\nEmployer: " + jobOne.getEmployer().toString() +
                "\nLocation: " + jobOne.getLocation().toString() +
                "\nPosition Type: " + jobOne.getPositionType().toString() +
                "\nCore Competency: " + jobOne.getCoreCompetency().toString() +
                "\n";

        assertEquals(template, jobOne.toString());
    }

    @Test
    public void testStringReturnsMessageWhenDataMissing() {
        Job jobFour = new Job("", new Employer("Cowabunga Inc."), new Location("Miami"), new PositionType("Code Surfer"), new CoreCompetency());

        assertEquals("\n" +
                "ID: " + jobFour.getId() +
                "\nName: " + "Data not available" +
                "\nEmployer: " + jobFour.getEmployer().toString() +
                "\nLocation: " + jobFour.getLocation().toString() +
                "\nPosition Type: " + jobFour.getPositionType().toString() +
                "\nCore Competency: " + "Data not available" +
                "\n", jobFour.toString());
    }

    @Test
    public void testReturnJobDoesNotExistWhenOnlyHasId() {
        Job jobFive = new Job();
        assertEquals("OOPS! This job does not seem to exist.", jobFive.toString());
    }

}
