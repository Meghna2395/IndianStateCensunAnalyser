package com.bridgelabz;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;



public class IndianCensusCSV {
	

		public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException{
			try {
				Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
				CsvToBeanBuilder<IndianCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndianCensusCSV>(reader);
				csvToBeanBuilder.withType(IndianCensusCSV.class);
				csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
				CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
				Iterator<IndianCensusCSV> censusCSVItertor = csvToBean.iterator();
				int numOfEntries = 0;
				
				while(censusCSVItertor.hasNext()) {
					numOfEntries++;
					IndianCensusCSV censusData = censusCSVItertor.next();
				}
				return numOfEntries;
			} catch (IOException e) {
				throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
			}
			
		}
}

