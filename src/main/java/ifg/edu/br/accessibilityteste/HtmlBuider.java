package ifg.edu.br.accessibilityteste;

import ifg.edu.br.accessibilityteste.ifg.edu.br.email.EmailSender;

/**
 * Created by root on 23/08/17.
 */

public class HtmlBuider {

    private StringBuilder textBuilder;

    public HtmlBuider() {
        textBuilder = new StringBuilder();
    }

    public void appendHtmlBuilder(String text) {
        textBuilder.append(text);
    }

    public String getTextBuilder() {
        return textBuilder.toString();
    }

}
