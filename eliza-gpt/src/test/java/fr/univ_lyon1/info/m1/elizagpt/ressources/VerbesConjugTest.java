package fr.univ_lyon1.info.m1.elizagpt.ressources;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Tests for VerbConjug.
 */
public class VerbesConjugTest {

    /**
     * Test the VerbConjug Ressource.
     */
    @Test
    public void testVerbConjug() {
        VerbesConjug verbConjug = new VerbesConjug();
        assertThat(verbConjug.getVerbsConjug(), is(notNullValue()));

    }
    /**
     * Test the VerbConjug size.
     */
    @Test
    public void testVerbConjugSize() {
        VerbesConjug verbConjug = new VerbesConjug();
        assertThat(verbConjug.getSize(), is(79));
    }
}
