package co.com.automationexercise.compra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

/**
 * Interacción de espera explícita robusta hasta que el elemento esté visible.
 * Maneja automáticamente sobrecargas temporales del servidor de Automation Exercise
 * (ej. "This website is under heavy load (queue full)") y reintentos con recarga de página.
 */
public class EsperarElemento implements Interaction {

    private final Target target;
    private final int segundos;

    public EsperarElemento(Target target, int segundos) {
        this.target = target;
        this.segundos = segundos;
    }

    public static EsperarElemento seaVisible(Target target) {
        return Tasks.instrumented(EsperarElemento.class, target, 20);
    }

    public static EsperarElemento seaVisible(Target target, int segundos) {
        return Tasks.instrumented(EsperarElemento.class, target, segundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        long fin = System.currentTimeMillis() + (segundos * 1000L);

        while (System.currentTimeMillis() < fin) {
            try {
                if (target.resolveFor(actor).isVisible()) {
                    return;
                }

                String source = driver.getPageSource().toLowerCase();
                if (source.contains("heavy load") || source.contains("queue full") || driver.getTitle().toLowerCase().contains("un momento")) {
                    Thread.sleep(3000);
                    driver.navigate().refresh();
                    try {
                        driver.switchTo().alert().accept();
                    } catch (Exception ignored) {}
                    Thread.sleep(2000);
                }
            } catch (Exception ignored) {
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Si tras el tiempo límite no fue visible, Serenity ejecuta su aserción estándar para generar reporte y screenshot
        actor.attemptsTo(
                WaitUntil.the(target, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds()
        );
    }
}
