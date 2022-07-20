package game.commands;

/**
 * Command framework
 * @author Mazedias
 */
public abstract class Command {

    protected String commandName;
    protected int args;

    public abstract void executeCommand(String[] command);
    
    public String getName() {
        return this.commandName;
    }

    public int getArgumentsAmount() {
        return this.args;
    }
}
