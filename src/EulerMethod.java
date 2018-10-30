import org.jfree.data.xy.XYSeries;

import java.util.ArrayList;

public class EulerMethod {
    private XYSeries eulerSeries;


    public XYSeries getEulerSeries() {
        return eulerSeries;
    }

    public EulerMethod(double x0, double y0, double xf, double h){
        eulerSeries = new XYSeries("Euler method");
        eulerSeries.add(x0,y0);
        for (double j = x0 + h; j <xf ; j=j+h) {
            eulerSeries.add(j,j + h * Math.pow(Math.E,-Math.sin(j)) - j*Math.cos(j));
        }

    }
}
