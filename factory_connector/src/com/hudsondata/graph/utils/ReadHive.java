package com.hudsondata.graph.utils;

import java.util.ArrayList;

public class ReadHive implements Reader{
	
	//Add variables required for accessing hive (jdbc path, table name)
	private String table;

	@Override
	public ArrayList<String> readSource() {
		// TODO Auto-generated method stub
		System.out.println("Will add code to Read HIVE");
		return null;
	}

}
