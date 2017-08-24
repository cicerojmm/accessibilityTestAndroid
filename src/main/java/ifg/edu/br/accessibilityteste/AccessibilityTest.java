package ifg.edu.br.accessibilityteste;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Build;

import org.xmlpull.v1.XmlPullParser;
import java.io.IOException;

import ifg.edu.br.accessibilityteste.ifg.edu.br.email.EmailSender;


/**
 * Created by cicero.moura on 03/08/17.
 * Modicated by: saulo.oliveira
 *
 * Faz a leitura do arquivo XML do layout passado para a função
 * reliza a leitura linha por linha e retira o nome das tags e valores
 * associados
 */

public class AccessibilityTest {

    private static String activityName;
    private static ValidateAccessibleTag validateAccessibleTag;
    private static StringBuilder htmlBuilder;

    public static void validate(Context context, int idLayout, String mailReceiver) {

        htmlBuilder = new StringBuilder();

        validateAccessibleTag = new ValidateAccessibleTag();
        getTagsXmlLayout(context, idLayout, mailReceiver);
    }


    @TargetApi(Build.VERSION_CODES.N)
    private static void getTagsXmlLayout(Context context, int idLayout, String mailReceiver) {

        activityName = context.getResources().getResourceName(idLayout);

        XmlResourceParser xmlParser = context.getResources().getXml(idLayout);

        try {
            StringBuilder stringBuilder = new StringBuilder();

            xmlParser.next();
            xmlParser.next();

            int eventType = xmlParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if(eventType!=3) {
                String nameTag = xmlParser.getName();

                for(int i =0; i < xmlParser.getAttributeCount(); i++){

                    stringBuilder.append(xmlParser.getAttributeName(i));
                    stringBuilder.append(":");
                    stringBuilder.append(xmlParser.getAttributeValue(i));
                    stringBuilder.append("\n");

                }

                analyzeTags(nameTag, stringBuilder.toString());
                }
                xmlParser.next();

                eventType = xmlParser.getEventType();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        sendMailRepporting(mailReceiver);

    }


    /*
        Verifica qual é a tag a ser tratada e faz a chamado do método para tratamento
        em outra classe
     */
    private static void analyzeTags(String nameTag, String contentTag) throws IOException {
        validateAccessibleTag = new ValidateAccessibleTag();

        switch (nameTag) {

            case "LinearLayout":
                validateAccessibleTag.validateTagLinearLayout(contentTag, htmlBuilder);
                break;

            case "RelativeLayout":
                validateAccessibleTag.validateTagRelativeLayout(contentTag, htmlBuilder);
                break;

            case "TextView":
                validateAccessibleTag.validateTagTextView(contentTag, htmlBuilder);
                break;

            case "EditText":
                validateAccessibleTag.validateTagEditText(contentTag, htmlBuilder);
                break;

            case "Button":
                validateAccessibleTag.validateTagButton(contentTag, htmlBuilder);
                break;

            case "ImageView":
                validateAccessibleTag.validateTagImageView(contentTag, htmlBuilder);
                break;

            case "ImageButton":
                validateAccessibleTag.validateTagImageButton(contentTag, htmlBuilder);
                break;


        }



    }

    private static void sendMailRepporting(String emailReciever) {
        EmailSender es = new EmailSender(htmlBuilder.toString(), emailReciever, activityName);
        es.execute();
    }

    /*
        Retorna o nome da Activity em analise
     */
    public static String getActivityName() {
        return activityName;
    }
}