package ro.tuc.tp.Model;

import java.util.ArrayList;
import java.util.List;

public class Polinom {

    List<Monom> listmnom;

    public Polinom() {
        listmnom = new ArrayList<>();
    }

    public List<Monom> getListmnom() {
        return listmnom;
    }

    public void add(Monom mon) {
        listmnom.add(mon);
    }

    public Polinom ZeroCoefficient() {
        Polinom result = new Polinom();
        for (Monom m : this.getListmnom()) {
            if (m.getCoeff().intValue() != 0) {
                result.add(m);
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Monom mon : listmnom) {
            if (mon.getCoeff().doubleValue() == 0 && mon.getDegree() == 0 || (mon.getCoeff().doubleValue() == 0 && mon.getDegree() > 0) || (mon.getCoeff().doubleValue() == 0 && mon.getDegree() < 0)) {
                s.append("");
            }
            if (mon.getCoeff().doubleValue() > 0 && mon.getDegree() == 1) {
                s.append("+").append(mon.getCoeff()).append("x");
            } else {
                if (mon.getCoeff().doubleValue() < 0 && mon.getDegree() == 1) {
                    s.append(mon.getCoeff()).append("x");
                }
            }
            if (mon.getCoeff().doubleValue() > 0 && mon.getDegree() == 0) {
                s.append("+").append(mon.getCoeff());
            } else {
                if (mon.getCoeff().doubleValue() < 0 && mon.getDegree() == 0) {
                    s.append(mon.getCoeff());
                }
            }
            if (mon.getCoeff().doubleValue() > 0 && mon.getDegree() > 0 && mon.getDegree() != 1) {
                s.append("+").append(mon.getCoeff()).append("x^").append(mon.getDegree());
            } else {
                if (mon.getCoeff().doubleValue() < 0 && mon.getDegree() > 0 && mon.getDegree() != 1) {
                    s.append(mon.getCoeff()).append("x^").append(mon.getDegree());
                }
            }
        }
        return s.toString();
    }
}
