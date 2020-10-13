package mastermind;

import java.util.ArrayList;

import utils.Console;

class ProposedCombination extends Combination {
	
	ProposedCombination() {
		super(getProposedCombination());
	}
	
	private static ArrayList<Color> getProposedCombination() {
		ArrayList<Color> proposedCombination = new ArrayList<>(Board.MAX_PEG_COLORS);
		do {
			String combString = Console.instance().readString();
			proposedCombination = parseStringToArrayOfColors(combString);
		} while (!isProposedCombinationComplete(proposedCombination));
		return proposedCombination;
	}
	
	private static boolean isProposedCombinationComplete(ArrayList<Color> proposedCombination) {
		return proposedCombination.size() == Board.MAX_PEG_COLORS 
				&& areDifferentAndValidColors(proposedCombination);
	}
	
	private static ArrayList<Color> parseStringToArrayOfColors(String strCombination) {
		ArrayList<Color> colors = new ArrayList<>(Board.MAX_PEG_COLORS);
		for(int i = 0; i < Board.MAX_PEG_COLORS; i++) {
			colors.add(Color.getInstance(strCombination.charAt(i)));
		}
		return colors;
	}
	
	private static boolean areDifferentAndValidColors(ArrayList<Color> proposedCombination) {
		ArrayList<Color> proposedCombinationCopy = new ArrayList<>(proposedCombination);
		for(Color color: proposedCombination) {
			proposedCombinationCopy.remove(color);
			if(proposedCombinationCopy.contains(color)) {
				Error.MUST_CONTAIN_DIFFERENT_COLORS.writeln();
				Message.PROPOSE_COMBINATION.write();
				return false;
			}
			if(Color.getInstance(color.getColor()) == Color.NULL_COLOR) {
				Error.MUST_CONTAIN_VALID_COLORS.writeln();
				Message.PROPOSE_COMBINATION.write();
				return false;
			}
		}
		return true;
	}
}
