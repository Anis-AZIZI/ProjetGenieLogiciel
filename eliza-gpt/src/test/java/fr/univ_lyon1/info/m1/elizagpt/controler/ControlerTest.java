package fr.univ_lyon1.info.m1.elizagpt.controler;

import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
import javax.naming.NameNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Tests for controler.
 */
public class ControlerTest {
    /**
     * Test the controller.
     */
    @Test
    public void testControler() throws InvalidNameException,
            NameNotFoundException {
    Controler controler = new Controler();
    assertThat(controler.getMessages(), is(notNullValue()));
        controler.incomingMessage("Je m'appelle Jean.");
    assertThat(controler.getMessages().findOne(2).getMessage(),
            is("Bonjour Jean."));
    assertThat(controler.getMessages().searchBySubString("Jean").size(),
            is(2));
    }


}
