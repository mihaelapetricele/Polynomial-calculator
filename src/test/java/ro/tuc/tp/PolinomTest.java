package ro.tuc.tp;

import org.junit.Before;
import org.junit.Test;
import ro.tuc.tp.Model.Monom;
import ro.tuc.tp.Model.Polinom;

import static org.junit.Assert.assertEquals;

public class PolinomTest {
    private Polinom polinom = new Polinom();

    @Before
    public void Before() {
        Monom monom1 = new Monom(1, 2);
        Monom monom2 = new Monom(0, 1);
        Monom monom3 = new Monom(-5, 0);
        polinom.add(monom1);
        polinom.add(monom2);
        polinom.add(monom3);//1x^2+0x-0
    }

    @Test
    public void TestZeroCoefficient() {
        Polinom rezultat = polinom.ZeroCoefficient();
        String stringRezulat = rezultat.toString();
        assertEquals("+1x^2-5", stringRezulat);
    }

}
