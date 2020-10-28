package ru.bacha.gym;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class ExercisesManagerTest {

    private ExercisesManager manager = new ExercisesManager();

    @Test(expected = IllegalArgumentException.class)
    public void getExercisesThrowsForBigId() {
        manager.getExerciseForID(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getExercisesForIDWithNegativeId() {
        manager.getExerciseForID(-1);
    }

    @Test
    public void getExerciseForIdReturnsNotNullForCorrectId() {
        assertNotNull(manager.getExerciseForID(1));
    }
}