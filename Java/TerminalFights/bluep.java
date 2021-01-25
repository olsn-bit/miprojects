public class bluep {
	public static int enemy = 2;
	public static final int[][] movement_one_radius = { { -1, -1 }, { -1, 0 }, { -1, +1 }, { 0, +1 }, { +1, +1 },
			{ +1, 0 }, { +1, -1 }, { 0, -1 } };

	public static void main(String[] args) {
	}

	public static void spawn(int x, int y, int[][] grid) {
		int random = (int) (Math.random() * 8);
		try {
			grid[x + movement_one_radius[random][0]][y + movement_one_radius[random][1]] = 1;
		} catch (Exception IndexOutOfBoundsException) {
		}
	}

	public static void setSpawn(int[][] grid, int size) {
		grid[size / 2][0] = 3;

	}

	public static void moveSelected(int x, int y, int[][] grid) {
		boolean moved = false;
		int tries = 0;
		while (!moved) {
			if (tries > 10) {
				moved = true;
				break;
			}
			for (int e = 8; e > 0; e--) {
				try {
					if (moved == false && grid[x + movement_one_radius[e][0]][y + movement_one_radius[e][1]] == enemy) {
						grid[x + movement_one_radius[e][0]][y + movement_one_radius[e][1]] = 1;
						grid[x][y] = 0;
						main.final_data[0]++;
						moved = true;
						break;
					}
				} catch (Exception IndexOutOfBoundsException) {
				}
			}
			try {
				if (moved == false) {
					int random = (int) (Math.random() * 8);
					if (grid[x + movement_one_radius[random][0]][y + movement_one_radius[random][1]] == 0) {
						grid[x + movement_one_radius[random][0]][y + movement_one_radius[random][1]] = 1;
						grid[x][y] = 0;
						moved = true;
					}
				}
			} catch (Exception IndexOutOfBoundsException) {
			}
			tries++;
		}
	}
}
