package example;

import forms.FormPrincipal;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrincipalTest {

    @Test
    public void iniciarTest() {
        FormPrincipal formPrincipal = new FormPrincipal();

        int unNumero = 0;

        assertEquals(0,unNumero);

    }
}
