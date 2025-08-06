package Regular_Test._03Test;

public class html {
    public static void main(String[] args) {
        String html = "<a>zheshiafi</a><b>hfaiohefjianf</b><p>fjhaiof</p>";
        html = htmlDispose(html);
        System.out.println(html);
    }
    public static String htmlDispose(String html) {
        String regex = "(<[a-z]>|</[a-z]>)";
        html = html.replaceAll(regex, " ");
        return html;
    }
}
