package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AdsUtils {
    public static void removeAds() {
        String javaScriptCode =
                "var shadowHostElement = document.querySelector('.grippy-host');" +
                        "if (shadowHostElement) {" +
                        "   var elementToRemove = shadowHostElement.offsetParent;" +
                        "   if (elementToRemove) {" +
                        "       elementToRemove.remove();" +
                        "   }" +
                        "}";

        executeJavaScript(javaScriptCode);
    }
}
