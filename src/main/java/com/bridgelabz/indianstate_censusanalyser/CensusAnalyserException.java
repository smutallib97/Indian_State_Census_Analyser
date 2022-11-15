package com.bridgelabz.indianstate_censusanalyser;

public class CensusAnalyserException extends Exception {
    public enum ExceptionType {
        CENSUS_FILE_INCORRECT, CENSUS_INCORRECT_FILE_FORMAT, CENSUS_WRONG_DELIMITER, CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, INDIAN_STATE_CSV_FILE_PATH;
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
