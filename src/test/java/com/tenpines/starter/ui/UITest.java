package com.tenpines.starter.ui;

import com.tenpines.starter.web.Endpoints;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.Test;
import org.openqa.selenium.By;

/*
El driver para Chorme se puede encontrar en:
https://github.com/conductor-framework/conductor
 */

@Config(
        browser = Browser.CHROME,
        url = "http://localhost:8080/"
)
public class UITest extends Locomotive {
    @Test
    public void estaElBotonParaAgregarUnMensaje() {
        navigateTo(Endpoints.HOME);
        validateText(By.id("titulo"), "Mensajes");
    }
}
