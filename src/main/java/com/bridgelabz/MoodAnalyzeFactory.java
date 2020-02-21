package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzeFactory {
    public static MoodAnalyser createMoodAnalyzer(String message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> moodConstructor = null;
            moodConstructor = moodAnalyserClass.getConstructor(String.class);
            moodConstructor.newInstance(message);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
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
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyzer");
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

    public static Constructor<?> getConstructor(String param, Class<?> constructor)  {
        try {
            Class<?> moodAnalyserClass = Class.forName(param);
            return moodAnalyserClass.getConstructor(constructor);
        } catch (ClassNotFoundException e) {
            throw new AnalyseMoodException(AnalyseMoodException.EnumExceptionType.CLASS_NOT_FOUND, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new AnalyseMoodException(AnalyseMoodException.EnumExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }
}



