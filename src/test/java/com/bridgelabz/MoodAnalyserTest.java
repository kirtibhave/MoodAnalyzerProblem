package com.bridgelabz;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {

    @Test
    public void givenNullMessage_ShouldReturnHappy() throws AnalyseMoodException {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("I am in happy mood");
            String mood = MoodAnalyser.analyseMood();
            Assert.assertEquals("Happy", mood);
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMessage_ShouldReturnSad() throws AnalyseMoodException {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood");
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("Sad", mood);
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullAnyMood_ShouldReturnHappy() throws AnalyseMoodException {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood");
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("Happy", mood);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenEmptyString() throws AnalyseMoodException {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            String mood = MoodAnalyser.analyseMood();
            Assert.assertEquals("", mood);
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        try {
            Constructor<?> constructor = Class.forName("com.MoodAnalyser").getConstructor(String.class);
            Object object = constructor.newInstance("I am in happy mood");
            MoodAnalyser moodAnalyser = (MoodAnalyser) object;
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("Happy", mood);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzeFactory.createMoodAnalyzer("I am in happy mood");
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("Happy", mood);
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMoodAnalyserFactoryClass_toCreateMoodAnalyserObject() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzeFactory.createMoodAnalyzer("");
            String mood1= moodAnalyser.analyseMood();
            Assert.assertEquals("Default",mood1);
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }
    }
}





