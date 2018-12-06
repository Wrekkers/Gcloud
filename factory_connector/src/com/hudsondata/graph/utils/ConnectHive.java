package com.hudsondata.graph.utils;

import java.util.ArrayList;

public class ConnectHive implements Connector{

	@Override
	public Reader connect(ArrayList<String> input) throws Exception {
		// TODO Auto-generated method stub
		
		return new ReadHive();
	}

}
