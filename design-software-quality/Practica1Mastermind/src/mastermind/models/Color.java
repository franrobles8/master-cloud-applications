package mastermind.models;

import java.util.Random;

enum Color {
	RED('r'), 
	BLUE('b'), 
	YELLOW('y'), 
	GREEN('g'), 
	ORANGE('o'), 
	PURPLE('p'), 
	NULL_COLOR;

	private char colorInitial;

	private Color() {

	}

	private Color(char color) {
		this.colorInitial = color;
	}

	public static Color getInstance(char color) {
		for (Color col : Color.values()) {
			if (col.colorInitial == color) {
				return col;
			}
		}
		return NULL_COLOR;
	}

	public static Color getRandomInstance() {
		Random rand = new Random();
		return Color.values()[rand.nextInt((Color.values().length - 2) + 1)];
	}

	public char getColor() {
		return colorInitial;
	}

	public static char[] getAllColorInitials() {
		char[] initials = new char[Color.values().length];
		for (int i = 0; i < initials.length; i++) {
			initials[i] = Color.values()[i].getColor();
		}
		return initials;
	}
}
