package com.bridgelabz.indianstate_censusanalyser;
import static com.bridgelabz.indianstate_censusanalyser.CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.junit.rules.ExpectedException;

class CensusAnalyserTest {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    //Wrong Path
    private String INDIAN_CENSUS_WRONG_CSV_FILE_PATH = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser";
    //Wrong File Type
    private String INDIAN_CENSUS_INCORRECT_FILE_FORMAT = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.txt";
    //Wrong Delimiter
    private String INDIAN_CENSUS_WRONG_DELIMITER = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusDataWithWrongDelimiter.csv";
    //TC1.1- Check to ensure the number of record matches
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws IOException, CensusAnalyserException {

        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        int count = censusAnalyzer.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(29, count);

    }

    // TC1.2
    @Test
    public void givenIndianCensusWrongCSVFile_WhenLoad_ShouldReturnException() {
        try {
            CensusAnalyser censusAnalyzer = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadIndiaCensusData(INDIAN_CENSUS_WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(e.type, CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TC1.3
    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_INCORRECT_FILE_FORMAT);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CENSUS_INCORRECT_FILE_FORMAT, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // TC1.4
    @Test
    public void givenIndianCensusCSVFile_WhenWrongDelimiter_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WRONG_DELIMITER);
        }
        catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER, e.type);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}