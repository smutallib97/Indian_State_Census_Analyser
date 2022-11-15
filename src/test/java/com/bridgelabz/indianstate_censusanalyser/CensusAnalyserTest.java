package com.bridgelabz.indianstate_censusanalyser;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.junit.rules.ExpectedException;

class CensusAnalyserTest {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    //Wrong Path
    private String INDIAN_CENSUS_WRONG_CSV_FILE_PATH = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser";
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
}