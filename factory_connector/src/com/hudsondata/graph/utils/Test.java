package com.hudsondata.graph.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h"))){
			System.out.println("Argument Options Usage");
			System.out.println("======================");
			System.out.println("-a <Graph API address>");
			System.out.println("-i <Input type> <Input path> <additional input args>");
			System.out.println("-o <Output type> <Output path> <additional output args>");
			System.exit(1);
		}
		
		if (args.length < 8){
			throw new IllegalArgumentException("Too few arguments!Usage: "
					+ "'-a <API address> -i <Input source type> <Source path> "
					+ "-o <Output source type> <Output path>' "
					+ "use '--help | -h' for detailed usgae.");
		}
		
		
		
		List<String> argsList = new ArrayList<String>();
		Map<String, ArrayList<String>> argumentOpts = null;
		argumentOpts = parseArgs(args);
		
		ConnectionFactory connection = new ConnectionFactory();
		
		Connector con1 = connection.getConnection(argumentOpts.get("i").get(0));
		Reader read = null;
		try {
			//"/home/mbhanu/Downloads/C2ImportStaffSample.csv"
			read = con1.connect(argumentOpts.get("i"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		read.readSource();
	}
	
	private static Map<String, ArrayList<String>> parseArgs(String[] args){
		ArrayList<String> keyArgs = new ArrayList<String>();
		keyArgs.add("a");
		keyArgs.add("i");
		keyArgs.add("o");
		
		Map<String, ArrayList<String>> argumentOpts = new HashMap<String, ArrayList<String>>();
		String key = null;
		for (int i = 0; i < args.length; i++){
			switch (args[i].charAt(0)){
			case '-':
				
				if (!(args[i].length() == 2 && keyArgs.contains(Character.toString(args[i].charAt(1))))){
					throw new IllegalArgumentException("Not a valid argument: " + args[i]);
				}
				else {
					key = Character.toString(args[i].charAt(1));
					argumentOpts.put(key, new ArrayList<String>());
				}
				break;
			default:
				argumentOpts.get(key).add(args[i]);
				break;
			}
		}
		return argumentOpts;
	}

}
