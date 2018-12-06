package com.hudsondata.graph.utils;

import java.util.ArrayList;

public class ConnectCsv implements Connector{
	
	@Override
	public Reader connect(ArrayList<String> input){
		return new ReadCsv(input.get(1));
	}
	
}