package com.letsdecode.problems.design.deckofcards.filesystem;

import java.util.HashMap;
import java.util.Map;

public class FileSystermRegistory {
	static Map<String, Long> applicationRegistery = new HashMap<>();
	static Map<Long, String> applictionIdToExePath = new HashMap<>();

	public void init() {
		applicationRegistery = buildFileTypeToApplicationId();
		applictionIdToExePath = buildApplicationIdToExePath();

	}

	public Map<String, Long> buildFileTypeToApplicationId() {
		Map<String, Long> fileTypesAndAppliation = new HashMap<>();
		return fileTypesAndAppliation;
	}

	public Map<Long, String> buildApplicationIdToExePath() {
		Map<Long, String> applictionIdToExePath = new HashMap<>();
		return applictionIdToExePath;
	}
}
