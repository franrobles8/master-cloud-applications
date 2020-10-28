package usantatecla.utils;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final String OPTION = "Option? [1-#size]: ";
    private List<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<>();
    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList<>();
        for(int i = 0; i < this.commandList.size(); i++) {
            if(this.commandList.get(i).isActive()) {
                commands.add(this.commandList.get(i));
            }
        }

        int option;
        Console console = new Console();
        boolean error;

        do {
            console.writeln();
            for(int i = 0; i < commands.size(); i++) {
                console.writeln((i + 1) + ") " + commands.get(i).getTitle());
            }
            option = console.readInt(Menu.OPTION.replace("#size", "" + commands.size())) - 1;
            error = !new ClosedInterval(0, commands.size() - 1).includes(option);
        } while (error);
        commands.get(option).execute();
    }

    protected void add(Command command) {
        this.commandList.add(command);
    }
}
