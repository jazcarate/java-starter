package com.tenpines.starter;

import com.tenpines.starter.integracion.SpringTestBase;
import com.tenpines.starter.modelo.Mensaje;
import com.tenpines.starter.servicios.ServicioDeMensajes;
import com.tenpines.starter.web.Endpoints;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class MensajesApiTest extends SpringTestBase {

    @MockBean
    private ServicioDeMensajes servicioDeMensajes;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void agregar() throws Exception {
        Mensaje unMensaje = new Mensaje("lala");
        when(servicioDeMensajes.buscarTodos()).thenReturn(Collections.singletonList(unMensaje));


        ResponseEntity<Mensaje[]> respuesta = this.restTemplate.getForEntity(
                Endpoints.OBTENER_MENSAJES, Mensaje[].class);


        assertThat(respuesta.getStatusCode(), is(HttpStatus.OK));
        //assertThat(respuesta.getBody(), hasItems("lala"));

        verify(servicioDeMensajes, times(1)).buscarTodos();
        verifyNoMoreInteractions(servicioDeMensajes);
    }

}