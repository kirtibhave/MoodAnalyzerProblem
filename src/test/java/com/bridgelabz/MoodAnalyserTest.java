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
    public void givenEmptyString_ShouldReturnEmpty() throws AnalyseMoodException {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            String mood = MoodAnalyser.analyseMood();
            Assert.assertEquals("", mood);
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }
    }

    //for default constructor
    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabkz.MoodAnalyser").getConstructor(String.class);
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
            String mood1 = moodAnalyser.analyseMood();
            Assert.assertEquals("Default", mood1);
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_EqualsMethod_toCheckTwoObjectsAreEqual() {
        try {
            MoodAnalyser moodAnalyzer = new MoodAnalyzeFactory().createMoodAnalyzer();
            Assert.assertEquals(new MoodAnalyser(), moodAnalyzer);
        } catch (AnalyseMoodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMoodAnalyserClass_When_ClassNameIsImproper()  {
        try {
            Constructor<?> moodAnalyzer = new MoodAnalyzeFactory().getConstructor("com.bridgelabz.MoodAnygtgalyser", String.class);
        } catch (AnalyseMoodException e) {
            Assert.assertEquals(AnalyseMoodException.EnumExceptionType.CLASS_NOT_FOUND, e.type);

        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenConstructorIsNotProper()  {
        try {
            Constructor<?> moodAnalyzer = new MoodAnalyzeFactory().getConstructor("com.bridgelabz.MoodAnalyser", int.class);

        } catch (AnalyseMoodException e) {
            Assert.assertEquals(AnalyseMoodException.EnumExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenClassIsFound(){
      try {
          MoodAnalyzeFactory.createMoodAnalyser("com.bridghgelabz.MoodAnygtgalyser");
      }
      catch (AnalyseMoodException e){
          Assert.assertEquals(AnalyseMoodException.EnumExceptionType.CLASS_NOT_FOUND, e.type);
      }
    }

    //6.1
    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappy() {
       try {
           MoodAnalyser moodAnalyser = MoodAnalyzeFactory.createMoodMethod("I am in happy mood");
           String mood = MoodAnalyzeFactory.invokeMoodAnalyser(moodAnalyser, "analyseMood");
           Assert.assertEquals("Happy",mood);
       }
       catch (AnalyseMoodException e){
           Assert.assertEquals(AnalyseMoodException.EnumExceptionType.NO_SUCH_METHOD,e.type);
       }
    }

    //6.3
    @Test
    public void givenFieldNameAndItsValue_WhenProper_ShouldReturnHappy() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzeFactory.createMoodMethod("I am in happy mood");
            String mood = MoodAnalyzeFactory.invokeMoodAnalyser(moodAnalyser, "analyseMookjd");
           // Assert.assertEquals("Happy",mood);
        }
        catch (AnalyseMoodException e){
            e.printStackTrace();
            Assert.assertEquals(AnalyseMoodException.EnumExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
    
    @Test
    public void givenHappyMessage_WhenMethodImProper_ShouldThrowException() {
        String mood = MoodAnalyzeFactory.setField("message","Happy");
        Assert.assertEquals("Happy",mood);
    }
    @Test
    public void givenFieldNameAndItsValue_WhenFieldNotProper_ShouldThrowException () {

        try {
            String mood = MoodAnalyzeFactory.setField("message1", "Happy");
        } catch (AnalyseMoodException e) {
            Assert.assertEquals(AnalyseMoodException.EnumExceptionType.NO_SUCH_FIELD, e.type);
        }
    }
        @Test
        public void givenFieldNameAndItsValue_ShouldThrowMoodAnalyserException() {
            try {
                String mood = MoodAnalyzeFactory.setField("message", null);
            } catch (AnalyseMoodException e) {
                Assert.assertEquals(AnalyseMoodException.EnumExceptionType.INVOCATION_ISSUE, e.type);
            }
        }
    }

