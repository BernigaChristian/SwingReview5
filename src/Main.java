import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 03/05/2022, martedì
 **/

public class Main {
    static int fat(int n){
        int r = 1;
        for(int i = 1 ; i <= n ; i ++)  r *= i;
        return r;
    }
    static void fib(int n, JTextField textField){
        int prec = 1, suc = 1;
        for(int i = 0; i < n; i ++){
            int res = prec + suc;
            textField.setText(textField.getText() + res + " ");
            prec = suc;
            suc = res;
        }
    }
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("ES");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(400,300);
        mainFrame.setLocationRelativeTo(null);

        JPanel fattoriale = new JPanel(new GridLayout(3,2));
        JTextField nFat = new JTextField(5);
        JTextField rFat = new JTextField(5);
        JButton cFat = new JButton("CALCOLA FATTORIALE");
        JButton cancFat = new JButton("CANCELLA");
        rFat.setEditable(false);
        fattoriale.add(new JLabel("INSERIRE NUMERO X FATTORIALE:"));
        fattoriale.add(nFat);
        fattoriale.add(new JLabel("RISULTATO :"));
        fattoriale.add(rFat);
        fattoriale.add(cFat);
        fattoriale.add(cancFat);
        cancFat.addActionListener(e -> {
            nFat.setText("");
            rFat.setText("");
        });
        cFat.addActionListener(e -> {
            rFat.setText(rFat.getText() + fat(Integer.parseInt(nFat.getText())));
        });

        JPanel fibonacci = new JPanel(new GridLayout(3,2));
        JTextField nFib = new JTextField(5);
        JTextField rFib = new JTextField(5);
        JButton cFib = new JButton("CALCOLA FIBONACCI");
        JButton cancFib = new JButton("CANCELLA");
        rFib.setEditable(false);
        fibonacci.add(new JLabel("INSERIRE NUMERO X FIBONACCI:"));
        fibonacci.add(nFib);
        fibonacci.add(new JLabel("RISULTATO :"));
        fibonacci.add(rFib);
        fibonacci.add(cFib);
        fibonacci.add(cancFib);
        cancFib.addActionListener(e -> {
            nFib.setText("");
            rFib.setText("");
        });
        cFib.addActionListener(e -> {
            int n = Integer.parseInt(nFib.getText());
            if(n == 1)  rFib.setText("1 ");
            else {
                rFib.setText("1 1 ");
                if(n > 2)   fib(n - 2, rFib);
            }
        });

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("fattoriale",fattoriale);
        tabbedPane.addTab("fibonacci",fibonacci);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("SCEGLI");
        JMenuItem[] items = new JMenuItem[2];
        JMenuItem i1 = new JMenuItem("FATTORIALE");
        JMenuItem i2 = new JMenuItem("FIBONACCI");
        items[0] = i1;
        items[1] = i2;
        ActionListener switchMenu = e -> {
            String scelta = ((JMenuItem)e.getSource()).getText();
            int indice;
            if(scelta.equalsIgnoreCase("FATTORIALE"))   indice = 0;
            else indice = 1;
            tabbedPane.setSelectedIndex(indice);
        };
        items[0].addActionListener(switchMenu);
        items[1].addActionListener(switchMenu);

        menu.add(i1);
        menu.add(i2);
        menuBar.add(menu);
        
        mainFrame.setJMenuBar(menuBar);
        mainFrame.getContentPane().add(BorderLayout.CENTER,tabbedPane);
        mainFrame.setVisible(true);
    }
}
