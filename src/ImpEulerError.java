import org.jfree.data.xy.XYSeries;

public class ImpEulerError {
    public XYSeries getImpeErrorSeries() {
        return impEerrorSeries;
    }

    private XYSeries impEerrorSeries;

    public ImpEulerError(double x0, double y0, double xf, double h){
        impEerrorSeries = new XYSeries("Imp Euler error");
        //impEerrorSeries.add(0,0);
        double yTemp=y0;
        double c = y0/(Math.pow(Math.E,-Math.sin(x0))) - x0;

        for (double j = x0 + h; j <xf ; j=j+h) {
            impEerrorSeries.add(j,Math.abs((Math.pow(Math.E,-Math.sin(j))*(j+c))-(yTemp + h * (Math.pow(Math.E,-Math.sin(j+(h/2))) -
                    (yTemp + (h/2) *(Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j))) * Math.cos(j)))));
            yTemp = yTemp + h * (Math.pow(Math.E,-Math.sin(j+(h/2))) -
                    (yTemp + (h/2) *(Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j))) * Math.cos(j));
        }
    }
}
