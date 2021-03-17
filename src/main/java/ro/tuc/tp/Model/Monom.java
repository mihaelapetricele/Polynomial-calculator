package ro.tuc.tp.Model;

public class Monom{
    Number coeff;
    int degree;
    boolean gasit;
    public Monom(Number coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    public Number getCoeff() {
        return coeff;
    }

    public void setCoeff(Number coeff) {
        this.coeff = coeff;
    }

    public int getDegree() {
        return degree;
    }

    public boolean isFound() {
        return gasit;
    }

    public void setFound(boolean gasit) {
        this.gasit = gasit;
    }
}
