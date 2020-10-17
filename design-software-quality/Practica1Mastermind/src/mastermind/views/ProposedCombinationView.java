package mastermind.views;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Color;
import mastermind.models.Combination;
import mastermind.models.ProposedCombination;
import utils.Console;

public class ProposedCombinationView {
    
    private ProposedCombination proposedCombination;

    ProposedCombinationView(ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
    }

    void read() {
        this.proposedCombination = new ProposedCombination(getProposedCombination());
    }

    private static List<Color> getProposedCombination() {
        List<Color> proposedCombination;
		do {
            Message.PROPOSE_COMBINATION.write();
			String combString = Console.instance().readString();
            proposedCombination = parseStringToArrayOfColors(combString);
		} while (!isProposedCombinationComplete(proposedCombination) || !areDifferentAndValidColors(proposedCombination));
		return proposedCombination;
    }

    private static boolean isProposedCombinationComplete(List<Color> proposedCombination) {
		return proposedCombination.size() == Combination.getMaxPegColors();
	}
    
    private static boolean areDifferentAndValidColors(List<Color> proposedCombination) {
        List<Color> proposedCombinationCopy = new ArrayList<>(proposedCombination);
        
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
    
    private static List<Color> parseStringToArrayOfColors(String strCombination) {
		ArrayList<Color> colors = new ArrayList<>(Combination.getMaxPegColors());
		for(int i = 0; i < Combination.getMaxPegColors(); i++) {
			colors.add(Color.getInstance(strCombination.charAt(i)));
		}
		return colors;
	}
}
