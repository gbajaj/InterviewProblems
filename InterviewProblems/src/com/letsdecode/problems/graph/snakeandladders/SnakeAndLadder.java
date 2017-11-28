package com.letsdecode.problems.graph.snakeandladders;

import java.util.HashMap;

import com.letsdecode.problems.graph.snakeandladders.SnakeAndLadderBuilder.Cell;

public class SnakeAndLadder {
	private HashMap<Integer, com.letsdecode.problems.graph.snakeandladders.SnakeAndLadderBuilder.Cell> map;
	int MAX_CELL_ID = -1;

	public SnakeAndLadder(
			HashMap<Integer, com.letsdecode.problems.graph.snakeandladders.SnakeAndLadderBuilder.Cell> map,
			int last) {
		this.map = map;
		MAX_CELL_ID = last;
	}

	public int findSteps() {
		int res = findExit(map.get(1));
		// System.out.println(path);
		return res;
	}

	public int findExit(Cell cell) {
		int max = Integer.MAX_VALUE;

		for (int i = 1; i <= 6; i++) {
			Cell nextCell = map.get(cell.id + i);
			if (nextCell == null) {
				continue;
			}
			if (nextCell.id == MAX_CELL_ID) {
				return 1;
			}
			if (nextCell.desinationId != -1
					&& nextCell.desinationId > nextCell.id) {
				nextCell = map.get(nextCell.desinationId);
			} else if (nextCell.desinationId != -1
					&& nextCell.desinationId < nextCell.id) {
				continue;
			}
			int steps = findExit(nextCell);
			if (steps < max) {
				max = steps;
			}
		}
		return 1 + max;
	}
}
