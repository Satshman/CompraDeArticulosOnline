package co.com.automationexercise.compra.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Runner principal para ejecutar la batería completa de pruebas BDD con Serenity.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/compra_articulos_online.feature",
        glue = "co.com.automationexercise.compra.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty"}
)
public class CompraArticulosRunner {
}
