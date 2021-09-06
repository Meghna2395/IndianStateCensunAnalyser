package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/statecensus.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/statecensus.csv";
	
	@Test
	public void ifCorrect() throws CensusAnalyserException {
		CensunAnalyser censusAnalyser = new CensunAnalyser();
		int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
		Assert.assertEquals(3, numOfRecords);
		
	}
	
	@Test
	public void ifWrong() throws CensusAnalyserException {
		CensunAnalyser censusAnalyser = new CensunAnalyser();
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(CensusAnalyserException.class);
		censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
	}
}
	