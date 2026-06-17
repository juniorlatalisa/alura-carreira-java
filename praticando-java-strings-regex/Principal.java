import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {

    public static void main(String[] args) {
        String texto = "Meu email é juniorlatalisa@teste.com";
        Pattern patter = Pattern.compile("\\w+@\\w+.\\w+");
        Matcher matcher = patter.matcher(texto);

        if (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}