package command;

class Exit implements Command {
    @Override
    public void run() {
        System.exit(0);
    }
}
