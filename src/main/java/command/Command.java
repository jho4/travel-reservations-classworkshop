package command;

/** Command: one operation that can be run on its own. Returns a message with the result. */
public interface Command {

    String execute();
}