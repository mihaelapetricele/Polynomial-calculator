package ro.tuc.tp.GUI;

import ro.tuc.tp.Logica.Operation;
import ro.tuc.tp.Model.Monom;
import ro.tuc.tp.Model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewController implements ActionListener {

    private final View view;

    public ViewController(View view) {
        this.view = view;
    }

    public int getCoeffMatch(Matcher match) {
        int result;
        if (match.group(2) != null) { // group2 returneaza coeficientul unui monom cu x
            result = Integer.parseInt(match.group(2));
        } else { // daca avem termen liber sau x fara coeficient
            if (match.group(3) != null) { // daca exista x
                if (match.group(3).charAt(0) == '-') {
                    result = -1;
                } else {
                    result = 1;
                }
            } else {
                result = Integer.parseInt(match.group(8)); // avem termen liber
            }
        }
        return result;
    }

    public int getDegreeMatch(Matcher match) {
        int result;
        if (match.group(5) != null) { //aflam degree-ul polinomului
            result = Integer.parseInt(match.group(5));
        } else {//daca nu exista
            if (match.group(3) == null) {//avem element liber, degree 0
                result = 0;
            } else {
                result = 1;//avem element simplu x cu degree 1
            }
        }
        return result;
    }

    public Polinom ExtractCoefandDegree(String polinom) throws ExceptionPolinom {
        Polinom resultPolinom = new Polinom();
        Pattern pattern = Pattern.compile("((-?\\d+(?=x))?(-?[x])(\\^(-?\\d+))?)|((-?)[x])|(-?\\d+)");
        Matcher match = pattern.matcher(polinom);
        List<Integer> coeffpol = new ArrayList<>();
        List<Integer> degreepol = new ArrayList<>();
        int i = 0;
        if (!match.find() || (!Pattern.matches("[+\\-x^\\d]+", polinom))) {//match full
            throw new ExceptionPolinom("Polinomul introdus nu este valid");
        }
        match = pattern.matcher(polinom);
        while (match.find()) {
            coeffpol.add(getCoeffMatch(match));
            degreepol.add(getDegreeMatch(match));
        }
        while (i < coeffpol.size()) {
            Monom monin = new Monom(coeffpol.get(i), degreepol.get(i));
            resultPolinom.add(monin);
            i++;
        }
        return resultPolinom;
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == view.getAddition()) {
            String firstPolinom = String.valueOf(view.getFirstPolinom().getText());
            String secondPolinom = String.valueOf(view.getSecondPolinom().getText());
            Polinom pol1;
            Polinom pol2;
            try {
                pol1 = ExtractCoefandDegree(firstPolinom);
                pol2 = ExtractCoefandDegree(secondPolinom);
                Polinom result = Operation.adunare(pol1, pol2);
                view.getRezultat().setText(result.toString());
            } catch (ExceptionPolinom exceptionPolinom) {
                view.showError(exceptionPolinom.getMessage());
            }
        }
        if (src == view.getDiference()) {
            String firstPolinom = String.valueOf(view.getFirstPolinom().getText());
            String secondPolinom = String.valueOf(view.getSecondPolinom().getText());
            Polinom pol1;
            Polinom pol2;
            try {
                pol1 = ExtractCoefandDegree(firstPolinom);
                pol2 = ExtractCoefandDegree(secondPolinom);
                Polinom result = Operation.scadere(pol1, pol2);
                view.getRezultat().setText(result.toString());
            } catch (ExceptionPolinom exceptionPolinom) {
                view.showError(exceptionPolinom.getMessage());
            }
        }
        if (src == view.getMultiply()) {
            String firstPolinom = String.valueOf(view.getFirstPolinom().getText());
            String secondPolinom = String.valueOf(view.getSecondPolinom().getText());
            Polinom pol1;
            Polinom pol2;
            try {
                pol1 = ExtractCoefandDegree(firstPolinom);
                pol2 = ExtractCoefandDegree(secondPolinom);
                Polinom result = Operation.inmultire(pol1, pol2);
                view.getRezultat().setText(result.toString());
            } catch (ExceptionPolinom exceptionPolinom) {
                view.showError(exceptionPolinom.getMessage());
            }
        }
        if (src == view.getDivision()) {
            String firstPolinom = String.valueOf(view.getFirstPolinom().getText());
            String secondPolinom = String.valueOf(view.getSecondPolinom().getText());
            Polinom pol1;
            Polinom pol2;
            try {
                pol1 = ExtractCoefandDegree(firstPolinom);
                pol2 = ExtractCoefandDegree(secondPolinom);
                String result = Operation.impartire(pol1, pol2);
                view.getRezultat().setText(result);
            } catch (ExceptionPolinom exceptionPolinom) {
                view.showError(exceptionPolinom.getMessage());
            }
        }
        if (src == view.getDerivation()) {
            String thirdPolinom = String.valueOf(view.getThirdPolinom().getText());
            Polinom pol;
            try {
                pol = ExtractCoefandDegree(thirdPolinom);
                Polinom result = Operation.derivare(pol);
                view.getRezultat1().setText((result.toString()));
            } catch (ExceptionPolinom exceptionPolinom) {
                view.showError(exceptionPolinom.getMessage());
            }
        }
        if (src == view.getIntegration()) {
            String thirdPolinom = String.valueOf(view.getThirdPolinom().getText());
            Polinom pol;
            try {
                pol = ExtractCoefandDegree(thirdPolinom);
                Polinom result = Operation.integrare(pol);
                view.getRezultat1().setText((result.toString()));
            } catch (ExceptionPolinom exceptionPolinom) {
                view.showError(exceptionPolinom.getMessage());
            }
        }
    }
}
