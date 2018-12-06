package com.hudsondata.graph.utils;

public class ConnectionFactory {
	
	public Connector getConnection (String connType){
		if (connType == null){
			return null;
		}
		if (connType.equalsIgnoreCase("CSV")){
			return new ConnectCsv();
		}
		else if (connType.equalsIgnoreCase("hive")){
			return new ConnectHive();
		}
		
		return null;
	}

}
