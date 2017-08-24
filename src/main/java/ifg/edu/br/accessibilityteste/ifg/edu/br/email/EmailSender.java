package ifg.edu.br.accessibilityteste.ifg.edu.br.email;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by root on 17/08/17.
 */

public class EmailSender extends  AsyncTask<String, Void, String> {

    private String text;
    private String emailReciever;
    private String titleActivity;

    public EmailSender( String text, String emailReciever, String titleActivity){
        this.text = text;
        this.emailReciever = emailReciever;
        this.titleActivity = titleActivity;
    }


    @Override
    protected String doInBackground(String... params) {
//
        try {
            GMailSender sender = new GMailSender("ifg.saulo.cicero@gmail.com", "ifgteste");
            sender.sendMail("AccessibilityTest For Android",
                    "<!-- #######  YAY, I AM THE SOURCE EDITOR! #########-->" +
                            "<div style=\"margin-left: 20px;\">" +
                            "<h1 style=\"color: #5e9ca0;\">AccessibilityTest For Android</h1>" +
                            "<p><small style=\"color: #2e6c80;\">Relat&oacute;rio de Acessibilidade</small></p>" +
                            "</div>" +
                            "<div style=\"background-color: #2e6c80; padding-top: 10px; padding-bottom: 10px;\">" +
                            "  <h3 style=\"color:white;padding-left:20px\">" + titleActivity +"</h3>" +
                            "</div>" +
                            "<div style=\"margin-left: 20px;\">" +
                            text,
                    "email@gmail.com",
                    emailReciever);

        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
            return "Houve falha";
        }
        return "Enviado";
    }

}
