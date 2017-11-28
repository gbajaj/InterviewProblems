package com.letsdecode.problems.recursion;

import sun.org.mozilla.javascript.internal.json.JsonParser;
import sun.org.mozilla.javascript.internal.json.JsonParser.ParseException;

public class BuildTreeForDiameter {

	String str = "";

	public BuildTreeForDiameter(String str) {
		this.str = str;
	}
	
	public void call () throws ParseException {
		
		JsonParser js = new JsonParser(null, null);
		js.parseValue(str);
	}
}
