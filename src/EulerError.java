import org.jfree.data.xy.XYSeries;

public class EulerError {

    public XYSeries geteErrorSeries() {
        return eErrorSeries;
    }

    private XYSeries eErrorSeries;

    public EulerError(double x0, double y0, double xf, double h){
        eErrorSeries = new XYSeries("Euler error");
        //eErrorSeries.add(0,0);
        double yTemp=y0;
        double c = y0/(Math.pow(Math.E,-Math.sin(x0))) - x0;

        for (double j = x0 + h; j <xf ; j=j+h) {
            eErrorSeries.add(j,Math.abs(Math.pow(Math.E,-Math.sin(j))*(j+c) - (yTemp + h * (Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j)))));
            yTemp = yTemp + h * (Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j));
        }
    }
}
