package mastermind;

import utils.Console;

enum Message {
	TITTLE("--- MASTERMIND ---"),
	SEPARATOR("-------------"),
	PROPOSE_COMBINATION("Propose a combination: "), 
	X_ROW_COLORS("xxxx"),
	PLAYER_WIN(" You've won!!! :-)"), 
	PLAYER_LOSE(" You've lost!!! :-("), 
	RESUME("RESUME"),
	NULL_MESSAGE();
	
	private String message;
	
	private Message() {
		
	}
	
	private Message(String message) {
		this.message = message;
	}
	
	void write() {
		Console.instance().write(this.message);
	}
	
	void writeln() {
		Console.instance().writeln(this.message);
	}
	
	@Override
	public String toString() {
		return message;
	}
}
