package ro.tuc.tp.Logica;

import ro.tuc.tp.Model.Monom;
import ro.tuc.tp.Model.Polinom;
import java.util.Collections;
import java.util.List;

public class Operation {

    // operatia de adunare
    public static Polinom adunare(Polinom polinom1, Polinom polinom2) {
        List<Monom> listaPol1;
        List<Monom> listaPol2;
        listaPol1 = polinom1.getListmnom();
        listaPol2 = polinom2.getListmnom();
        Monom monres;
        Polinom result = new Polinom();
        for (Monom mon1 : listaPol1) {
            for (Monom mon2 : listaPol2) {
                if (mon1.getDegree() == mon2.getDegree()) {//am gasit monoame cu acelasi grad
                    monres = new Monom(mon1.getCoeff().intValue() + mon2.getCoeff().intValue(), mon1.getDegree());
                    result.add(monres);
                    mon1.setFound(true);
                    mon2.setFound(true);
                }
            }
        }
        for (Monom mon1 : listaPol1) {
            if (!mon1.isFound()) {
                result.add(mon1);
            }
        }
        for (Monom mon2 : listaPol2) {
            if (!mon2.isFound()) {
                {
                    result.add(mon2);
                }
            }
        }
        Collections.sort(result.getListmnom(), new Sort()); //Sortez monoamele in ordinea descrescatoare a gradelor
        return result;
    }

    //operatia de scadere
    public static Polinom scadere(Polinom polinom1, Polinom polinom2) {
        List<Monom> listaPol1;
        List<Monom> listaPol2;
        listaPol1 = polinom1.getListmnom();
        listaPol2 = polinom2.getListmnom();
        Monom monres;
        Polinom result = new Polinom();
        for (Monom mon1 : listaPol1) {
            for (Monom mon2 : listaPol2) {
                if (mon1.getDegree() == mon2.getDegree()) {//am gasit monoame cu acelasi grad
                    monres = new Monom(mon1.getCoeff().intValue() - mon2.getCoeff().intValue(), mon1.getDegree());
                    result.add(monres);
                    mon1.setFound(true);
                    mon2.setFound(true);
                }
            }
        }
        for (Monom mon1 : listaPol1) {
            if (!mon1.isFound()) {
                result.add(mon1);
            }
        }
        for (Monom mon2 : listaPol2) {
            if (!mon2.isFound()) {
                mon2.setCoeff(- mon2.getCoeff().intValue());
                result.add(mon2);
            }
        }
        Collections.sort(result.getListmnom(), new Sort()); //Sortez monoamele in ordinea descrescatoare a gradelor
        return result;
    }

    //operatia de inmultire
    public static Polinom inmultire(Polinom polinom1, Polinom polinom2) {
        List<Monom> listaPol1;
        List<Monom> listaPol2;
        listaPol1 = polinom1.getListmnom();
        listaPol2 = polinom2.getListmnom();
        Monom monres;
        Polinom result = new Polinom();
        for (Monom mon1 : listaPol1) {
            for (Monom mon2 : listaPol2) {
                boolean cond = false;
                for (Monom mon3 : result.getListmnom()) { //parcurg polinomul result
                    if (mon1.getDegree() + mon2.getDegree() == mon3.getDegree()) //verific daca am un monom in result de acelasi degree
                    {
                        cond = true;
                        mon3.setCoeff(mon3.getCoeff().intValue() + (mon1.getCoeff().intValue() * mon2.getCoeff().intValue())); //actualizez coeficientul monomului
                        break;
                    }
                }
                if (!cond) { // daca nu am nici un monom cu degree-ul cautat
                    monres = new Monom(mon1.getCoeff().intValue() * mon2.getCoeff().intValue(),
                            mon1.getDegree() + mon2.getDegree()); // creez un monom nou
                    result.add(monres);
                }
            }
        }
        Collections.sort(result.getListmnom(), new Sort()); //Sortez monoamele in ordinea descrescatoare a gradelor
        return result;
    }

    //operatia de inmultire pentru operatia de impartire
    public static Polinom inmultirePolinom(Polinom polinom1, Polinom polinom2) {
        List<Monom> listaPol1;
        List<Monom> listaPol2;
        listaPol1 = polinom1.getListmnom();
        listaPol2 = polinom2.getListmnom();
        Monom monres;
        Polinom result = new Polinom();
        for (Monom mon1 : listaPol1) {
            for (Monom mon2 : listaPol2) {
                boolean cond = false;
                for (Monom mon3 : result.getListmnom()) { //parcurg polinomul result
                    if (mon1.getDegree() + mon2.getDegree() == mon3.getDegree()) //verific daca am un monom in result de acelasi degree
                    {
                        cond = true;
                        mon3.setCoeff(mon3.getCoeff().doubleValue() + (mon1.getCoeff().doubleValue() * mon2.getCoeff().doubleValue())); //actualizez coeficientul monomului
                        break;
                    }
                }
                if (!cond) { // daca nu am nici un monom cu degree-ul cautat
                    monres = new Monom(mon1.getCoeff().doubleValue() * mon2.getCoeff().doubleValue(),
                            mon1.getDegree() + mon2.getDegree()); // creez un monom nou
                    result.add(monres);
                }
            }
        }
        Collections.sort(result.getListmnom(), new Sort()); //Sortez monoamele in ordinea descrescatoare a gradelor
        return result;
    }

    //operatia de impartire
    public static String impartire(Polinom polinom1, Polinom polinom2) {
        List<Monom> listaPol1,listaPol2;
        listaPol1 = polinom1.getListmnom();
        listaPol2 = polinom2.getListmnom();
        Polinom result = new Polinom();
        Collections.sort(listaPol1, new Sort());
        Collections.sort(listaPol2, new Sort());
        String rezultatImpartire;
        while (listaPol1.get(0).getDegree() >= listaPol2.get(0).getDegree()) {
            double coeffPolinom1 = listaPol1.get(0).getCoeff().doubleValue();
            double coeffPolinom2 = listaPol2.get(0).getCoeff().doubleValue();
            double coeffFirstTerm = coeffPolinom1 / coeffPolinom2;
            int degreePolinom1 = listaPol1.get(0).getDegree();
            int degreePolinom2 = listaPol2.get(0).getDegree();
            int degreeFirstTerm = degreePolinom1 - degreePolinom2;
            Monom quotient = new Monom(coeffFirstTerm, degreeFirstTerm); // monomul rezultat dupa impartirea primului polinom la al doilea
            Polinom intermediate = new Polinom(); // polinomul cu un singur monom
            intermediate.add(quotient);
            result.add(quotient);
            intermediate = inmultirePolinom(intermediate, polinom2); // inmultesc catul cu deimpartitul
            polinom1 = scadere(polinom1, intermediate); // scad din impartitor
            polinom1 = polinom1.ZeroCoefficient(); // in caz ca am monom cu coeficientul 0
            listaPol1 = polinom1.getListmnom(); // actualizez polinom1(restul)
            if (listaPol1.size() == 0) { // daca restul ajunge 0 iesim din bucla
                break;
            }
        }
        Collections.sort(result.getListmnom(), new Sort()); //Sortez monoamele in ordinea descrescatoare a gradelor
        rezultatImpartire = result.toString() + " rest: " + polinom1.toString(); //formez afisarea pentru impartire
        return rezultatImpartire;
    }

    //operatia de derivare
    public static Polinom derivare(Polinom polinom) {
        List<Monom> listaPol;
        listaPol = polinom.getListmnom();
        Monom monres;
        Polinom result = new Polinom();
        for (Monom mon : listaPol) {
            monres = new Monom(mon.getCoeff().intValue() * mon.getDegree(), mon.getDegree() - 1);
            result.add(monres);
        }
        Collections.sort(result.getListmnom(), new Sort()); //Sortez monoamele in ordinea descrescatoare a gradelor
        return result;
    }

    //operatia de integrare
    public static Polinom integrare(Polinom polinom) {
        List<Monom> listaPol;
        listaPol = polinom.getListmnom();
        Monom monres;
        Polinom result = new Polinom();
        for (Monom mon : listaPol) {
            monres = new Monom(((mon.getCoeff().doubleValue())/ (mon.getDegree() + 1)), mon.getDegree() + 1);
            result.add(monres);
        }
        Collections.sort(result.getListmnom(), new Sort()); //Sortez monoamele in ordinea descrescatoare a gradelor
        return result;
    }

}
