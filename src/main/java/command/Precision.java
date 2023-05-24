package command;

import utils.Format;

class Precision implements Command {
    private final int precision;

    public Precision(int precision) {
        this.precision = precision;
    }

    @Override
    public void run() {
        Format.setPrecision(precision);
    }
}
