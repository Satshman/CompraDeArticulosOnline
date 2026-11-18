package co.com.automationexercise.compra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

/**
 * Interacción de espera explícita robusta hasta que el elemento esté visible.
 */
public class EsperarElemento implements Interaction {

    private final Target target;
    private final int segundos;

    public EsperarElemento(Target target, int segundos) {
        this.target = target;
        this.segundos = segundos;
    }

    public static EsperarElemento seaVisible(Target target) {
        return Tasks.instrumented(EsperarElemento.class, target, 10);
    }

    public static EsperarElemento seaVisible(Target target, int segundos) {
        return Tasks.instrumented(EsperarElemento.class, target, segundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, WebElementStateMatchers.isVisible()).forNoMoreThan(segundos).seconds()
        );
    }
}
