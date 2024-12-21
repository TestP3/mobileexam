package com.nttdata.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/carrito.feature", glue = "com.nttdata.stepsdefinitions", snippets = CucumberOptions.SnippetType.CAMELCASE, plugin = {
        "pretty" }, tags = "@test")
public class RunnerTest {
}