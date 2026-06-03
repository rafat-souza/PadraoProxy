package FiltroDeTrafego;

import java.util.Arrays;
import java.util.List;

public class RegrasFirewall {

    private static List<String> sitesBloqueados = Arrays.asList(
            "youtube.com",
            "facebook.com",
            "instagram.com"
    );

    public static boolean isBloqueado(String url) {
        return sitesBloqueados.contains(url);
    }

}
