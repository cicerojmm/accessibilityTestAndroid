package ifg.edu.br.accessibilityteste;


import ifg.edu.br.accessibilityteste.ifg.edu.br.email.EmailSender;

/**
 * Created by cicero.moura on 17/08/17.
 * Classe para implementar as validações do layout XML,
 * Pegando as tags e seu conteudo, verificando e validando
 * conforme orientações  para boas práticas de acessibilidade
 */

public class ValidateAccessibleTag {
    private EmailSender emailSender;


    /*
        Método para validar a tag TextView conforme boas práticas de Acessibilidade
     */
    public void validateTagTextView(String contentTag, StringBuilder htmlBuilder) {
        String warning;

        if(!contentTag.contains("contentDescription")) {

            warning = "<h3>TextView</h3>";
            warning += "<p>Não contém o atributo <b>contentDescription</b></p>";

            htmlBuilder.append(warning);
        }

        if(!contentTag.contains("accessibilityLiveRegion")) {

            warning = "<h3>TextView</h3>";
            warning += "<p>Não contém o atributo <b>accessibilityLiveRegion</b> para identificar texto que passam a surgir na tela</p>";

            htmlBuilder.append(warning);
        }
    }

    /*
        Método para validar a tag EditText conforme boas práticas de Acessibilidade
     */
    public void validateTagEditText(String contentTag, StringBuilder htmlBuilder)  {
        String warning;

        if(!contentTag.contains("hint")) {
            warning = "<h3>EditText</h3>";
            warning += "Não contém o atributo <b>hint</b> para descrever o conteúdo a ser inserido no campo";

            htmlBuilder.append(warning);

        }

        if(!contentTag.contains("labelFor")) {
            warning = "<h3>EditText</h3>";
            warning += "Não contém o atributo <b>labelFor</b> para agrupar a descrição com o EditText";

            htmlBuilder.append(warning);
        }


    }

    /*
        Método para validar a tag ImageView conforme boas práticas de Acessibilidade
     */
    public void validateTagImageView(String contentTag, StringBuilder htmlBuilder) {
        String warning;

        if(!contentTag.contains("contentDescription")) {
            warning = "<h3>ImageView</h3>";
            warning += "<p>Não contém o atributo <b>contentDescription</b> para descrever a imagem</p>";

            htmlBuilder.append(warning);

        }
    }

    /*
        Método para validar a tag Button conforme boas práticas de Acessibilidade
     */
    public void validateTagButton(String contentTag, StringBuilder htmlBuilder) {
        String warning;

        if(!contentTag.contains("contentDescription")) {
            warning = "<h3>Button</h3>";
            warning += "<p>Não contém o <b>contentDescription</b> para descrever ação do botão</p>";

            htmlBuilder.append(warning);

        }


        validateAtributeMin(contentTag, "Button", htmlBuilder);

    }

    /*
        Método para validar a tag ImageButton conforme boas práticas de Acessibilidade
     */
    public void validateTagImageButton(String contentTag, StringBuilder htmlBuilder) {
        String warning;

        if(!contentTag.contains("contentDescription")) {
            warning = "<h3>ImageButton</h3>";
            warning += "<p>Não contém o atributo <b>contentDescription</b> para descrever a ação da imagem</p>";
            htmlBuilder.append(warning);
        }

        validateAtributeMin(contentTag, "ImageButton", htmlBuilder);

    }

    /*
        Método para validar a tag LinearLayout conforme boas práticas de Acessibilidade
     */
    public void validateTagLinearLayout(String contentTag, StringBuilder htmlBuilder) {
        String warning;

        if(!contentTag.contains("focusable")) {
            warning = "<h3>LinearLayout</h3>";
            warning += "<p>O layout não possui o atributo <b>focusable</b> para agrupamento de layouts e colocar destaque no atual</p>";

            htmlBuilder.append(warning);
        }

        validateAtributeVisibility(contentTag, "LinearLayout", htmlBuilder);
    }

    /*
        Método para validar a tag RelativeLayout conforme boas práticas de Acessibilidade
     */
    public void validateTagRelativeLayout(String contentTag, StringBuilder htmlBuilder) {
        String warning;

        if(!contentTag.contains("focusable")) {

            warning = "<h3>RelativeLayout</h3>";
            warning += "<p>O layout de estilo RelativeLayout não possui o atributo <b>focusable</b> para destaque do layout atual</p>";

            htmlBuilder.append(warning);

        }

        validateAtributeVisibility(contentTag, "RelativeLayout", htmlBuilder);
    }

    /*
        Método utilizado para verificar o minWidth e minHeight de qualquer tag
        e tratando a resposta conforme o valor
     */
    private void validateAtributeMin(String contentTag, String nameTag, StringBuilder htmlBuilder) {
        String warning;

        if(!contentTag.contains("minWidth") || !contentTag.contains("minHeight")) {
            warning = "<h3>" + nameTag + "</h3>";
            warning += "<p>É uma boa prática colocar o <b>minWidth</b> e <b>minHeight</b> no " + nameTag +
                    ", o valor sugerido é de 48dp para os dois</p>";

            htmlBuilder.append(warning);

        }
    }


    /*
        Método utilizado para validar se qualquer tag tem o atributo visibility
        e trata a resposta caso tenha essse valor
     */
    private void validateAtributeVisibility(String contentTag, String nameTag, StringBuilder htmlBuilder) {
        String warning;

        if(!contentTag.contains("visibility")) {
            warning = "<h3>" + nameTag + "</h3>";
            warning += "<p>A tag " + nameTag +" possui o atributo <b>Visibility</b>, o mesmo deve ser tratado e avisado" +
                    "quando ficar visivel na tela<p>";

            htmlBuilder.append(warning);
        }
    }


}

