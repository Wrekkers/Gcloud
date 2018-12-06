package com.hudsondata.graph.utils;

import java.util.ArrayList;

public interface Connector {
	Reader connect(ArrayList<String> input) throws Exception;
}
