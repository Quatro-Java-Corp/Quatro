package command;

import utils.Dictionary;
import utils.Dictionary.Language;

class ChangeLanguage implements Command {

    Language language;

    public ChangeLanguage(Language language) {
        this.language = language;
    }

    @Override
    public void run() {
        Dictionary.activeLanguage = language;

    }
}
