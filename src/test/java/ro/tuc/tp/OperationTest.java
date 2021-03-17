package ro.tuc.tp;


import org.junit.Before;
import org.junit.Test;
import ro.tuc.tp.Logica.Operation;
import ro.tuc.tp.Model.Monom;
import ro.tuc.tp.Model.Polinom;

import static org.junit.Assert.assertEquals;

public class OperationTest {
    private Polinom polinom1 = new Polinom();
    private Polinom polinom2 = new Polinom();
    private Polinom polinom3 = new Polinom();
    private Polinom polinom4 = new Polinom();
    private Operation operation = new Operation();

    @Before
    public void Before() {
        Monom monom1 = new Monom(1, 2);
        Monom monom2 = new Monom(3, 1);
        Monom monom3 = new Monom(-5, 0);
        Monom monom4 = new Monom(9, 1);
        Monom monom5 = new Monom(4, 0);
        Monom monom6 = new Monom(5, 1);
        Monom monom7 = new Monom(1, 1);
        polinom1.add(monom1);
        polinom1.add(monom2);
        polinom1.add(monom3);//1x^2+3x-5
        polinom2.add(monom7);
        polinom2.add(monom5);//x+4
        polinom3.add(monom6);
        polinom3.add(monom5);//5x+4
        polinom4.add(monom4);
        polinom4.add(monom3);//9x-5
    }

    @Test
    public void TestAdunare() {
        Polinom rezultat = Operation.adunare(polinom1, polinom2);
        String stringRezulat = rezultat.toString();
        assertEquals("+1x^2+4x-1", stringRezulat);
    }

    @Test
    public void TestScadere() {
        Polinom rezultat = Operation.scadere(polinom1, polinom2);
        String stringRezulat = rezultat.toString();
        assertEquals("+1x^2+2x-9", stringRezulat);
    }

    @Test
    public void TestInmultire() {
        Polinom rezultat = Operation.inmultire(polinom3, polinom4);
        String stringRezulat = rezultat.toString();
        assertEquals("+45x^2+11x-20", stringRezulat);
    }

    @Test
    public void TestInmultirePolinom() {
        Polinom rezultat = Operation.inmultire(polinom3, polinom4);
        String stringRezulat = rezultat.toString();
        assertEquals("+45x^2+11x-20", stringRezulat);
    }

    @Test
    public void TestImpartire() {
        String rezultat = Operation.impartire(polinom1, polinom2);
        String stringRezulat = rezultat.toString();
        assertEquals("+1.0x-1.0 rest: -1", stringRezulat);
    }

    @Test
    public void TestDerivare() {
        Polinom rezultat = Operation.derivare(polinom1);
        String stringRezulat = rezultat.toString();
        assertEquals("+2x+3", stringRezulat);
    }

    @Test
    public void TestIntegrare() {
        Polinom rezultat = Operation.integrare(polinom3);
        String stringRezulat = rezultat.toString();
        assertEquals("+2.5x^2+4.0x", stringRezulat);
    }
}
