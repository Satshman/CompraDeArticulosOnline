package co.com.automationexercise.compra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Interacción para desplazar la vista (scroll) hasta un elemento objetivo.
 */
public class ScrollTo implements Interaction {

    private final Target target;

    public ScrollTo(Target target) {
        this.target = target;
    }

    public static ScrollTo element(Target target) {
        return Tasks.instrumented(ScrollTo.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }
}
