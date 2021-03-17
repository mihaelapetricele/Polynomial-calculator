package ro.tuc.tp.Logica;

import ro.tuc.tp.Model.Monom;

import java.util.Comparator;

public class Sort implements Comparator<Monom> {
    public int compare(Monom a, Monom b) {
        return b.getDegree() - a.getDegree();
    }
}
