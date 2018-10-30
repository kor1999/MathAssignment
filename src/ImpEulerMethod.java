import org.jfree.data.xy.XYSeries;

public class ImpEulerMethod {
    private XYSeries impEulerSeries;

    public XYSeries getImpEulerSeries() {
        return impEulerSeries;
    }

    public ImpEulerMethod(double x0, double y0, double xf, double h){
        impEulerSeries = new XYSeries("Improved Euler method");
        impEulerSeries.add(x0,y0);
        for (double j = x0 + h; j <xf ; j=j+h) {
            impEulerSeries.add(j,j + h * Math.pow(Math.E,-Math.sin(j+h/2))
                    - (j+(h/2)*Math.pow(Math.E,-Math.sin(j)) - j*Math.cos(j))*Math.cos(j+h/2));
        }
    }
}
