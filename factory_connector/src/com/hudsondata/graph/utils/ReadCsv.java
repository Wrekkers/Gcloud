package com.hudsondata.graph.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadCsv implements Reader{
	
	private String file;
	
	ReadCsv(String filePath){
		this.file = filePath;
	}

	@Override
	public ArrayList<String> readSource() {
		// TODO Auto-generated method stub
		Path pathToFile = Paths.get(this.file);
		try (BufferedReader br = Files.newBufferedReader(pathToFile,
				StandardCharsets.US_ASCII)) {
			
			String line = br.readLine();
			
			while (line != null){
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
