package command;

import utils.Format;

import java.util.Queue;

import exceptions.command.IllegallPrecisionNumberException;

class Precision implements Command {

    private String precision;

    public Precision(Queue<String> args) {
        this.precision = args.poll();
    }

    @Override
    public void run() {
        try {
            Format.setPrecision(Integer.valueOf(precision));
        } catch (Exception e) {
            throw new IllegallPrecisionNumberException();
        }
    }
}
