package com.bridgelabz;

public class MoodAnalyser {
  private static String message;

    public MoodAnalyser() {
    this.message="Default";
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }
    public static String analyseMood() throws AnalyseMoodException {
        try {
            if (message.isEmpty()) {
                throw new AnalyseMoodException(AnalyseMoodException.EnumExceptionType.EMPTY_MESSAGE,"Please enter valid mood");
            }

            if (message.contains("sad")) {
                return "Sad";
            }
            return "Happy";
        }
        catch (NullPointerException e) {
            throw new AnalyseMoodException(AnalyseMoodException.EnumExceptionType.NULL_MESSAGE,"Please enter valid mood");
        }

    }
}