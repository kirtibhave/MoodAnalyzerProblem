package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.ClosedSelectorException;

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

    public static MoodAnalyser createMoodAnalyser(String className) {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodConstructor = null;
            moodConstructor = moodAnalyserClass.getConstructor();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new AnalyseMoodException(AnalyseMoodException.EnumExceptionType.CLASS_NOT_FOUND,e.getMessage());
        }
        return null;
    }

    //invoke method(6.0)
    public static String invokeMoodAnalyser(MoodAnalyser o1, String methodName) {
        try {
            Method declareMethod = o1.getClass().getDeclaredMethod(methodName);
            return (String) declareMethod.invoke(o1);
        } catch (NoSuchMethodException e) {
            throw new AnalyseMoodException(AnalyseMoodException.EnumExceptionType.NO_SUCH_METHOD,"method not found");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    //6.1
    public static MoodAnalyser createMoodMethod(String message){
        Constructor<?> moodConstructor= null;
        try {
         //   Constructor<?> constructor = Class.forName("com.bridgelabz.MoodAnalyser").getConstructor(String.class);
            moodConstructor = Class.forName("com.bridgelabz.MoodAnalyser").getConstructor(String.class);
            Object obj1=moodConstructor.newInstance(message);
            return (MoodAnalyser) obj1;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  null;
    }


    public static String setField(String fieldName,String message) {
        try {
            Object obj = Class.forName("com.bridgelabz.MoodAnalyser").getConstructor().newInstance();
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj,message);
           return(String) obj.getClass().getDeclaredMethod("analyseMood").invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new AnalyseMoodException(AnalyseMoodException.EnumExceptionType.INVOCATION_ISSUE,"method not found");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new AnalyseMoodException(AnalyseMoodException.EnumExceptionType.NO_SUCH_FIELD,"method not found");
        }

        return null;
    }
}



