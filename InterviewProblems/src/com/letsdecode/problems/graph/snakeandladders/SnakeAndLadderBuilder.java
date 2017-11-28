package com.letsdecode.problems.graph.snakeandladders;

import java.util.HashMap;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class SnakeAndLadderBuilder {
	private String data = "{\"id\": \"\", \"ladder\":\"\", \"snake\":\"\", \"desination\":}";

	class Cell {
		int id;
		int desinationId;
	}

	HashMap<Integer, Cell> map = new HashMap<>();

	public SnakeAndLadderBuilder build() {
		for (int i = 1; i <= 36; i++) {
			Cell cell = new Cell();
			cell.id = i;
			switch (i) {
			case 2:
				cell.desinationId = 15;
				break;
			case 5:
				cell.desinationId = 7;
				break;
			case 9:
				cell.desinationId = 27;
				break;
			case 17:
				cell.desinationId = 4;
				break;
			case 18:
				cell.desinationId = 29;
				break;
			case 20:
				cell.desinationId = 6;
				break;
			case 24:
				cell.desinationId = 16;
				break;
			case 25:
				cell.desinationId = 35;
				break;
			case 32:
				cell.desinationId = 30;
				break;
			case 34:
				cell.desinationId = 12;
				break;
			default:
				cell.desinationId = -1;
			}
			map.put(cell.id, cell);
		}

		return this;
	}

	public SnakeAndLadderBuilder build2() {
		for (int i = 1; i <= 30; i++) {
			Cell cell = new Cell();
			cell.id = i;
			switch (i) {
			// ladders
			case 3:
				cell.desinationId = 22;
				break;
			case 5:
				cell.desinationId = 8;
				break;
			case 11:
				cell.desinationId = 26;
				break;
			case 20:
				cell.desinationId = 29;
				break;
			// Snakes
			case 27:
				cell.desinationId = 11;
				break;
			case 21:
				cell.desinationId = 9;
				break;
			case 17:
				cell.desinationId = 4;
				break;
			case 19:
				cell.desinationId = 7;
				break;
			default:
				cell.desinationId = -1;
			}
			map.put(cell.id, cell);
		}
		
		return this;

		// // Ladders
		// moves[2] = 21;
		// moves[4] = 7;
		// moves[10] = 25;
		// moves[19] = 28;
		// // Snakes
		// moves[26] = 11;
		// moves[20] = 8;
		// moves[16] = 3;
		// moves[18] = 6;
	}
}
