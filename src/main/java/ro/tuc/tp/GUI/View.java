package ro.tuc.tp.GUI;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private final JTextField firstPolinom = new JTextField(20);
    private final JTextField secondPolinom = new JTextField(20);
    private final JTextField rezultat = new JTextField(30);
    private final JTextField thirdPolinom = new JTextField(20);
    private final JTextField rezultat1 = new JTextField(30);

    private final JButton addition = new JButton("Adunare");
    private final JButton difference = new JButton("Diferenta");
    private final JButton multiply = new JButton("Inmultire");
    private final JButton division = new JButton("Impartire");
    private final JButton derivation = new JButton("Derivare");
    private final JButton integration = new JButton("Integrare");


    public final JLabel text1 = new JLabel("POLINOM 1:");
    public final JLabel text2 = new JLabel("POLINOM 2:");
    public final JLabel text3 = new JLabel("REZULTAT:");
    public final JLabel text4 = new JLabel("POLINOM:");
    public final JLabel text5 = new JLabel("REZULTAT:");
    public final JLabel op = new JLabel("OPERATII CU POLINOAME");
    public final JLabel op1 = new JLabel(" ALTE OPERATII CU POLINOAME");
    public static final Color purple = new Color(190,180, 240);
    public static final Color purple1 = new Color(240,225, 255);

    ViewController viewController = new ViewController(this);

    public View(){

        JFrame frame = new JFrame("Calculator de Polinoame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);

        JPanel panel3 = new JPanel();
        panel3.setBackground(purple1);
        panel3.add(op);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.add(text1);
        panel.add(firstPolinom);
        panel.add(text2);
        panel.add(secondPolinom);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.add(addition);
        panel1.add(difference);
        panel1.add(multiply);
        panel1.add(division);
        panel1.add(derivation);
        panel1.add(integration);

        addition.addActionListener(viewController);
        addition.setBackground(purple);
        difference.addActionListener(viewController);
        difference.setBackground(purple);
        multiply.addActionListener(viewController);
        multiply.setBackground(purple);
        division.addActionListener(viewController);
        division.setBackground(purple);
        derivation.addActionListener(viewController);
        derivation.setBackground(purple);
        integration.addActionListener(viewController);
        integration.setBackground(purple);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.add(text3);
        panel2.add(rezultat);
        rezultat.setEditable(false);

        JPanel panel4 = new JPanel();
        panel4.setBackground(purple1);
        panel4.add(op1);

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.white);
        panel5.add(text4);
        panel5.add(thirdPolinom);

        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.white);
        panel6.add(derivation);
        panel6.add(integration);
        derivation.addActionListener(viewController);
        derivation.setBackground(purple);
        integration.addActionListener(viewController);
        integration.setBackground(purple);

        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.white);
        panel7.add(text5);
        panel7.add(rezultat1);
        rezultat1.setEditable(false);

        JPanel calcPanel = new JPanel();
        calcPanel.add(panel3);
        calcPanel.add(panel);
        calcPanel.add(panel1);
        calcPanel.add(panel2);
        calcPanel.add(panel4);
        calcPanel.add(panel5);
        calcPanel.add(panel6);
        calcPanel.add(panel7);
        calcPanel.setLayout(new BoxLayout(calcPanel, BoxLayout.Y_AXIS));
        frame.setContentPane(calcPanel);
        frame.setVisible(true);

    }

    public JTextField getFirstPolinom(){
        return firstPolinom;
    }

    public JTextField getSecondPolinom(){
        return secondPolinom;
    }

    public JTextField getThirdPolinom() {
        return thirdPolinom;
    }

    public JTextField getRezultat1() {
        return rezultat1;
    }

    public JTextField getRezultat() {
        return rezultat;
    }

    public JButton getAddition() {
        return addition;
    }

    public JButton getDiference() {
        return difference;
    }

    public JButton getMultiply() {
        return multiply;
    }

    public JButton getDivision() {
        return division;
    }

    public JButton getDerivation() {
        return derivation;
    }

    public JButton getIntegration() {
        return integration;
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

}
