package command;

/**
 * Command invoker. Runs one command at a time; if one fails it reports the problem
 * and the next command can still run.
 */
public class CommandInvoker {

    public void invoke(Command command) {
        try {
            System.out.println("[OK]     " + command.execute());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("[FAILED] " + e.getMessage());
        }
    }
}