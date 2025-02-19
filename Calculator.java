import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600,400);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel cardPanel = new JPanel(new CardLayout());

        JPanel simplePanel = new JPanel();
        simplePanel.setLayout(new BoxLayout(simplePanel, BoxLayout.Y_AXIS));
        simplePanel.add(new JLabel("Simple Calculator"));
        JLabel disSim = new JLabel("Result: ");
        JButton plusBtn = new JButton("+");
        JButton minusBtn = new JButton("-");
        JButton multi = new JButton("*");
        JButton divi = new JButton("/");
        JTextField firstVar = new JTextField();
        JTextField secondVar = new JTextField();
        simplePanel.add(disSim);
        simplePanel.add(plusBtn);
        simplePanel.add(minusBtn);
        simplePanel.add(multi);
        simplePanel.add(divi);
        simplePanel.add(firstVar);
        simplePanel.add(secondVar);

        plusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                double num1 = Double.parseDouble(firstVar.getText());
                double num2 = Double.parseDouble(secondVar.getText());

                double result = num1 + num2;
                disSim.setText("Result: "+result);
            }
        });
        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    double num1 = Double.parseDouble(firstVar.getText());
                double num2 = Double.parseDouble(secondVar.getText());

                double result = num1 - num2;
                disSim.setText("Result: "+result);
                } catch (NumberFormatException ex) {
                    disSim.setText("Invalid input");
                }
            }
        });
        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    double num1 = Double.parseDouble(firstVar.getText());
                double num2 = Double.parseDouble(secondVar.getText());

                double result = num1 * num2;
                disSim.setText("Result: "+result);
                } catch (NumberFormatException ex) {
                    disSim.setText("Invalid input");
                }
            }
        });
        divi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    double num1 = Double.parseDouble(firstVar.getText());
                double num2 = Double.parseDouble(secondVar.getText());

                double result = num1 / num2;
                disSim.setText("Result: "+result);
                } catch (ArithmeticException ex) {
                    disSim.setText("Can't divide by zero");
                }
            }
        });

        JPanel scientificPanel = new JPanel();
        scientificPanel.setLayout(new BoxLayout(scientificPanel, BoxLayout.Y_AXIS));
        scientificPanel.add(new JLabel("Scientific Calculator"));
        JLabel disSci = new JLabel("Result: ");
        JButton sine = new JButton("sin");
        JButton cos = new JButton("cos");
        JButton tan = new JButton("tan");
        JButton log = new JButton("log");
        scientificPanel.add(disSci);
        scientificPanel.add(sine);
        scientificPanel.add(cos);
        scientificPanel.add(tan);
        scientificPanel.add(log);
        
        JTextField value = new JTextField();
        scientificPanel.add(value);
        
        sine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    double calculated = Double.parseDouble(value.getText());
                double result = Math.sin(Math.toRadians(calculated));
                disSci.setText("Result: "+result);
                } catch (NumberFormatException ex) {
                    disSci.setText("Invalid Input");
                }
            }
        });
        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                double calculated = Double.parseDouble(value.getText());
                double result = Math.cos(Math.toRadians(calculated));
                disSci.setText("Result: "+result);
                } catch (NumberFormatException ex) {
                    disSci.setText("Invalid Input");
                }
            }
        });
        tan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                double calculated = Double.parseDouble(value.getText());
                double result = Math.tan(Math.toRadians(calculated));
                disSci.setText("Result: "+result);
                } catch (NumberFormatException ex) {
                    disSci.setText("Invalid Input");
                }
            }
        });
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    double calculated = Double.parseDouble(value.getText());
                double result = Math.log(Math.toRadians(calculated));
                disSci.setText("Result: "+result);
                } catch (NumberFormatException ex) {
                    disSci.setText("Invalid Input");
                }
            }
        });

        // Add both panels to cardPanel
        cardPanel.add(simplePanel, "Simple");
        cardPanel.add(scientificPanel, "Scientific");

        // Buttons for Switching Panels
        JButton simpleBtn = new JButton("Simple Calculator");
        JButton scientificBtn = new JButton("Scientific Calculator");

        JPanel menuPanel = new JPanel(); // Panel for buttons
        menuPanel.add(simpleBtn);
        menuPanel.add(scientificBtn);

        simpleBtn.addActionListener(e -> {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.show(cardPanel, "Simple");
        });

        scientificBtn.addActionListener(e -> {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.show(cardPanel, "Scientific");
        });

        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}