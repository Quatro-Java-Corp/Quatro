package command;

import utils.ActiveLanguage;
import utils.ActiveLanguage.Language;

class ChangeLanguage implements Command {

    Language language;

    public ChangeLanguage(Language language) {
        this.language = language;
    }

    @Override
    public void run() {
        System.out.println(language);
        ActiveLanguage.language = language;
        System.out.println(ActiveLanguage.language);

    }
}
