package ro.tuc.tp;

import ro.tuc.tp.GUI.View;
import ro.tuc.tp.GUI.ViewController;
import ro.tuc.tp.Logica.Operation;
import ro.tuc.tp.Model.Monom;
import ro.tuc.tp.Model.Polinom;

import javax.management.monitor.Monitor;

public class Main {
    public static void main(String args[]){
        View view = new View();
        ViewController viewController = new ViewController(view);
        Operation operation = new Operation();

    }
}
