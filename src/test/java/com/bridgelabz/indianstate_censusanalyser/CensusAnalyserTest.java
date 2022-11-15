package com.bridgelabz.indianstate_censusanalyser;
import static com.bridgelabz.indianstate_censusanalyser.CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT;
import static com.bridgelabz.indianstate_censusanalyser.CensusAnalyserException.ExceptionType.INCORRECT_FILE_FORMAT;
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
    //wrongHeader
    private String INDIAN_CENSUS_WITHWRONG_HEADER = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusDataWithWrongHeader.csv";
    //IndiaStateCodeCsv
    private String INDIAN_STATE_CSV_FILE_PATH = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv";
    //wrong path 2.2
    private String INIDAN_STATE__CODE_WRONGCSV_FILE_PATH = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndiaStateCode.csv";

    private String INDIAN_STATE_CODE_INCORRECT_FILE_FORMAT = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.txt";
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
    // TC1.5
    @Test
    public void givenIndianCensusCSVFile_WhenWrongHeader_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WITHWRONG_HEADER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // UC2 -  TC2.1
    @Test
    public void givenIndianStateCodeCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws Exception {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndianStateCodeData(INDIAN_STATE_CSV_FILE_PATH);
        Assertions.assertEquals(37, count);
    }
    // TC2.2
    @Test
    public void givenIndianStateCode_WrongCSVFile_WhenLoad_ShouldReturnException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndianStateCodeData(INIDAN_STATE__CODE_WRONGCSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(e.type, CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // TC2.3
    @Test
    public void givenIndianStateCode_CSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_STATE_CODE_INCORRECT_FILE_FORMAT);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(INCORRECT_FILE_FORMAT, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}