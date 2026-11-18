package co.com.automationexercise.compra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Interacción para realizar clics mediante JavaScript.
 * Esencial para superar elementos superpuestos (overlays, iframes publicitarios o sticky headers)
 * que pueden bloquear los clics estándar de WebDriver.
 */
public class JavaScriptClick implements Interaction {

    private final Target target;

    public JavaScriptClick(Target target) {
        this.target = target;
    }

    public static JavaScriptClick on(Target target) {
        return Tasks.instrumented(JavaScriptClick.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }
}
