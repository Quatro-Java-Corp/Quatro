public class CommandPrintException implements Command{
    String message;

    public CommandPrintException(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }
}
