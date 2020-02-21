package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzeFactory {
    public static MoodAnalyser createMoodAnalyzer(String message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.dummyproject.MoodAnalyzer");
            Constructor<?> moodConstructor = null;
            try {
                moodConstructor = moodAnalyserClass.getConstructor(String.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            moodConstructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyzer() {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.dummyproject.MoodAnalyzer");
            Constructor<?> moodConstructor = null;
            try {
                moodConstructor = moodAnalyserClass.getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            moodConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
