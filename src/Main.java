import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });

        double x0 = 0;
        double y0 = 1;
        double xf = 9.3;
        double h = 0.1;

        System.out.println("alallalalal");
        ArrayList<Double> arrX = new ArrayList();
        ArrayList<Double> arrY = new ArrayList<>();

        arrX.add(x0);
        arrY.add(y0);
        int i = 1;
        while(arrX.get(arrX.size()-1)<xf){
            arrX.add(arrX.get(i-1) + h);
            arrY.add( arrY.get(i-1) + h * Math.pow(Math.E,-Math.sin(arrX.get(i-1))) - arrY.get(i-1)*Math.cos(arrX.get(i-1)) );
            i++;
        }
        System.out.println(arrX);
        System.out.println("---------------------------------");
        System.out.println(arrY);
     }

    public static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setPreferredSize(new Dimension(200, 100));

        frame.pack();
        frame.setVisible(true);
    }

}
