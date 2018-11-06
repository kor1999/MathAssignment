import org.jfree.data.xy.XYSeries;

public class TotalApproxErrorImpEuler {
    private XYSeries totAprErrSeriesImpEuler;

    public XYSeries getTotAprErrSeriesImpEuler() {
        return totAprErrSeriesImpEuler;
    }

    public TotalApproxErrorImpEuler(double x0, double y0, double xf, int n0, int nf){
        totAprErrSeriesImpEuler = new XYSeries("Total Approximation Imp Euler error");

        int nNow=n0;
        while(nNow<=(nf-1)) {
            double h = (xf-x0)/nNow;
            double yTemp=y0;
            double c = y0/(Math.pow(Math.E,-Math.sin(x0))) - x0;

            double maxErrorY=Double.MIN_VALUE;
            for (double j = x0 + h; j <xf ; j=j+h) {
                if (maxErrorY < Math.abs((Math.pow(Math.E,-Math.sin(j))*(j+c))-(yTemp + h * (Math.pow(Math.E,-Math.sin(j+(h/2))) -
                        (yTemp + (h/2) *(Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j))) * Math.cos(j+(h/2)))))){
                    maxErrorY = Math.abs((Math.pow(Math.E,-Math.sin(j))*(j+c))-(yTemp + h * (Math.pow(Math.E,-Math.sin(j+(h/2))) -
                            (yTemp + (h/2) *(Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j))) * Math.cos(j+(h/2)))));
                }
                yTemp = yTemp + h * (Math.pow(Math.E,-Math.sin(j+(h/2))) -
                        (yTemp + (h/2) *(Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j))) * Math.cos(j+(h/2)));
            }
            totAprErrSeriesImpEuler.add(nNow,maxErrorY);
            nNow++;
        }
    }
}
