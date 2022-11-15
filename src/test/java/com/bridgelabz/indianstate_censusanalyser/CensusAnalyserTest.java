package com.bridgelabz.indianstate_censusanalyser;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class CensusAnalyserTest {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws IOException {

        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        int count = censusAnalyzer.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(29, count);

    }
}