import java.util.Scanner;
public class game {
		int keys;
		String name;
		int color;
		String os;

		int[] upgrades;                 // buy_keytype,buy_auto,buy_range,

		int boost_remaining;

		// La idea seria jugar amb el colors i ferl-los com a rangos, ja que tenim la var this.color podem fer-ho
		// també fer el contador de keys en M, k, i infinito

		// colors
		public static String[] colors = {
				"\u001b[0m", "\u001b[37;1m", "\u001b[31;1m", "\u001b[32;1m", "\u001b[33;1m", "\u001b[35;1m"
		};

		public game(int startingkeys, String name) {
				this.os = System.getProperty("os.name").toLowerCase();
				this.keys = startingkeys;
				this.boost_remaining = 60;
				this.upgrades = new int[3];
				this.upgrades[2]++;             // li posem lo color default al principi en range 1
				this.upgrades[0]++;             // li posem que cada click que fa li sumem 1 minim
				this.name = name;
				this.color = this.upgrades[2];  // color no es un color, es un valor que lo linkeem amb colors
				this.start();
		}

		public void start() {
				boolean running = true;
				Scanner sc = new Scanner(System.in);
				String input;

				welcome();
				this.reload();
				while (running) {
						// this.autoUpdate();
						this.printuser(this.printmenu());
						input = sc.nextLine();
						switch (input) {
						case "":
								this.printuser("+" + this.upgrades[0] + " Keys");
								this.keys += this.upgrades[0];
								break;

						case "buy_keytype":
								System.out.println("How many times you want to buy ? ");
								input = sc.nextLine();
								for (int e = 0; e < Integer.parseInt(input); e++) {
										this.buy_keytype();
								}
								break;
						case "buy_range":
								this.buy_range();
								break;
						case "buy_auto":
								this.buy_auto();
								break;
						case "boost":
								this.boost();
								break;
						case "exit":
								saver.save(this.keys, this.upgrades, this.color, this.name);
								exit();
						default:
								this.printuser("Not a valid input");
								break;
						}
				}
		}
		public void boost() {
				if (this.boost_remaining < 1) {
						this.keys += this.upgrades[0] * 1000;
						this.boost_remaining = 60;
				}
		}
		public static void welcome() {
				System.out.println("Welcome back !!\nLoading ...\n\n\n");
				System.out.println(
					"  ad8888888888ba\n dP\'         `\"8b,\n 8  ,aaa,       \"Y888a     ,aaaa,     ,aaa,  ,aa,\n 8  8\' `8           \"88baadP \"\"\"\"YbaaadP\"\"\"YbdP\"\"Yb\n 8  8   8              \"\"\"        \"\"\"      \"\"    8b\n 8  8, ,8         ,aaaaaaaaaaaaaaaaaaaaaaaaddddd88P\n 8  `\"\"\"\'       ,d8\"\"\n Yb,         ,ad8\"    Alberto Dos Santos\n  \"Y8888888888P\"\n");
				System.out.println("Done!");
		}
		public void buy_auto() {
				if (this.keys >= this.getPrice("auto")) {
						this.keys -= this.getPrice("auto");
						this.upgrades[1]++;
				} else {
						System.out.println("Not enough keys.");
				}
		}
		public static void exit() {
				System.exit(0);
		}
		public void reload() {
				String[] reloaded = saver.reload();
				if (this.name.equals(reloaded[5])) {
						this.keys = Integer.parseInt(reloaded[0]);
						this.upgrades[0] = Integer.parseInt(reloaded[1]);
						this.upgrades[1] = Integer.parseInt(reloaded[2]);
						this.upgrades[2] = Integer.parseInt(reloaded[3]);
						this.color = Integer.parseInt(reloaded[4]);
						this.name = reloaded[5];
						System.out.println("Loaded " + reloaded[5]);

						int minutes_elapsed = ((saver.secondsBetween(reloaded[6])) / 60);

						this.printuser("Minutes elapsed : " + minutes_elapsed); // calcular segons pasats desde les dues dates
						this.keys += minutes_elapsed * this.upgrades[1];
						System.out.println("Last played: " + reloaded[6]);
						this.boost_remaining -= minutes_elapsed;
				} else {
						this.printuser("Not data found for this game.");
				}
		}
		public void buy_range() {
				if (this.keys >= this.getPrice("range")) {
						this.keys -= this.getPrice("range");
						if (this.color < colors.length) {
								this.color++;
						}
						this.upgrades[2]++;
				} else {
						System.out.println("Not enough keys.");
				}
		}
		public void buy_keytype() {
				if (this.keys >= this.getPrice("keytype")) {
						this.keys -= this.getPrice("keytype");
						this.upgrades[0]++;
				} else {
						System.out.println("Not enough keys.");
				}
		}
		public void printuser(String text) {
				if (this.os.contains("win")) {
						System.out.println(text);
				} else {
						System.out.println(colors[this.color] + text + game.colors[0]);
				}
		}
		public int getPrice(String type) {
				switch (type) {
				case "keytype":
						return ((int)Math.ceil(this.upgrades[0] * 100));
				// break;
				case "range":
						return ((int)Math.ceil(this.upgrades[2] * 1000));
				// break;
				case "auto":
						if ((int)Math.ceil(this.upgrades[1] * 10000) == 0) {
								return ((int)Math.ceil(this.upgrades[1] + 1 * 10000));
						} else {
								return ((int)Math.ceil(this.upgrades[1] * 10000));
						}
				// break;

				default:
						return (99999999);
				}
		}
		public String printmenu() {
				String help = "\nCodes:" + "\n \"boost\" : Instant 1000 key preses " + "Cooldown: 1h Offline  Remaining: " + this.boost_remaining +
					"\n \"buy_keytype\" : Increases key gain by 1. " + "Price: " + this.getPrice("keytype") + " Actual: " + this.upgrades[0] +
					"\n \"buy_range\" : Increases range. " + "Price: " + this.getPrice("range") + " Actual: " + this.upgrades[2] +
					"\n \"buy_auto\" : Increases automatic keys by 1 every minute. " + "Price: " + this.getPrice("auto") + " Actual: " + this.upgrades[1] +
					"\n \"exit\" : Exit and Save.";

				help += "\nKeys: " + this.keys;

				return (help);
		}
		public static void main(String[] args) {
				game partidademo = new game(1, "Partida1");
		}
}
