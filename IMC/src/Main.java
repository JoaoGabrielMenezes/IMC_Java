import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

public class Main {

    private static JFrame frame;
    private static JButton calc;
    private static JTextField altura_jtf;
    private static JTextField peso_jtf;
    private static JLabel resul;
    private static JLabel result;
    private static JLabel altura_lb;
    private static JLabel peso_lb;
    private static double imc;
    private static double altura;
    private static int peso;

    public static void main(String[] args) {
        
        frame = new JFrame("IMC");
        calc = new JButton("calcular");
        altura_lb = new JLabel("Altura");
        peso_lb = new JLabel("Peso");
        altura_jtf = new JTextField();
        peso_jtf = new JTextField();
        resul = new JLabel();
        result = new JLabel();

        try {
            altura_jtf = new JFormattedTextField(new MaskFormatter("*.**"));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        frame.setSize(500,250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.add(calc);
        frame.add(altura_lb);
        frame.add(peso_lb);
        frame.add(altura_jtf);
        frame.add(peso_jtf);
        frame.add(resul);
        frame.add(result);

        altura_lb.setBounds(50,15,100,10);
        peso_lb.setBounds(50,60,100,10);
        altura_jtf.setBounds(50,30,390,30);
        peso_jtf.setBounds(50,75,390,30);
        calc.setBounds(200,120,90,30);
        resul.setBounds(50,170,390,30);
        result.setBounds(160,170,390,30);

        altura_jtf.setBorder(BorderFactory.createLineBorder(Color.black));
        peso_jtf.setBorder(BorderFactory.createLineBorder(Color.black));
        calc.setBorder(BorderFactory.createLineBorder(Color.black));

        calc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            
               altura = Double.parseDouble(altura_jtf.getText());
               peso = Integer.parseInt(peso_jtf.getText());

               imc = peso / (altura * altura);
               resul.setText(String.format("Seu imc é: %.2f  -", imc));

               if(imc < 18.5){
                    result.setText("magreza - obesidade 0");
               }else{
                if(imc > 18.5 && imc < 24.9){
                    result.setText("Normal - obesidade 0");
                   }else{
                    if (imc > 25 && imc < 29.9 ) {
                        result.setText("Acima do peso - obesidade |");
                       }else{
                        if (imc > 30 && imc < 39.9 ) {
                            result.setText("Obesidade - obesidade ||");
                           }else{
                            if (imc >= 40) {
                                result.setText("Obesidade grave- obesidade |||");
                              }
                           }
                           
                       }
                     
                   }

               }                    

            }      
        } );
        
    }

}