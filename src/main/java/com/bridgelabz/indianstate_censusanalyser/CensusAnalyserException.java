package com.bridgelabz.indianstate_censusanalyser;

public class CensusAnalyserException extends Exception {
    public enum ExceptionType {
        CENSUS_FILE_INCORRECT, CENSUS_INCORRECT_FILE_FORMAT;
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
