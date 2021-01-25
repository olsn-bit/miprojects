def main():
		inputa = int(input())
		text = ""
		ho = "o"
		ast = 0
		while ast < inputa:
			i = 0;
			while i < inputa:
				if ho == "h":
					text += "H"
					ho = "o"
				elif ho == "o":
					text += "O"
					ho = "h"
				i += 1
			if (inputa % 2) == 0:
				if ho == "o":
					ho = "h"
				elif ho == "h":
					ho = "o"
			ast += 1
			text += "\n"

		print(text)
while True:
	main()
