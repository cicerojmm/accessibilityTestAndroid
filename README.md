# Teste de Acessibilidade para Android

## Acessibilidade
Aplicativos para Android devem ser utilizados por todos, incluindo pessoas com deficiência. Isso é acessibilidade!

As deficiências comuns que afetam o uso de um dispositivo Android pela pessoa incluem cegueira ou visão baixa, cegueira de cor, surdez ou deficiência auditiva e habilidades motoras restritas. Quando você desenvolve aplicativos com acessibilidade em mente, você melhora a experiência do usuário. Não só para usuários com essas deficiências, mas também para todos os outros usuários.

Essa bilbioteca em questão realiza a validação para identificar se o seu aplicativo possui acessinilidade para deficientes visuais ou pessoas com baixa visão, através do TalkBack.

O que  o TalkBack?
O TalkBack é um serviço de acessibilidade que ajuda usuários com deficiência visual ou com problemas de visão a interagir com seus respectivos dispositivos. Esse app implementa o feedback falado, audível e por vibração ao seu dispositivo. Ele vem pré-instalado na maioria dos dispositivos Android.


## Library AccessibilityTest

O código se trata de um módulo para Android que através de uma única função faz toda a leitura de uma activity (arquivo xml) e através de uma análise automatica e detalhada, retorna um feedback via e-mail informado, descrendo todos os pontos de melhoria para integrar a app em analise com o talkback.

Itens do Layout que são verificado para saber se estão com suporte a acessibilidade:
- ImageView
- ImageButton
- Button
- EditText
- TextView
- LinearLayout
- RelativeLayout


### Como utilizar a Library para Android
Pré Requisitos
- Gradle 2 ou Superior
- Projeto com SDK 25 ou Superior

No Android Studio siga os seguintes passos:
1. Clique em File > New Module.
2. Clique em Import .JAR/.AAR Package e em Next.
3. Insira a localização do arquivo AAR que está dentro deste projeto e clique em Finish.
4. Clique em File > New > Import Module.
5. Insira a localização do diretório do módulo de biblioteca deste projeto e clique em Finish. 
6. Abra o arquivo build.gradle do módulo de aplicativo e adicione uma nova linha ao bloco dependencies:
<pre><code>dependencies {
    compile project(":accessibilityteste-debug")
}</code></pre>

Com isso a biblioteca e todas as dependências são adicionadas.

Para utilizar o teste basta escolher uma activity e adicionar o seguinte código:

<pre><code>
    AccessibilityTest.validate(context, id_layout_xml, email_para_receber_relatorio);
</code></pre>

Adicione as importaçes necessários e execute sua aplicaço normalmente ou como debugger.

Com isso o teste será realizado e encaminhado um relatório com o resultado por e-mail.
