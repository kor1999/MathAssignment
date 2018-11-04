import org.jfree.data.xy.XYSeries;

public class TotalApproxErrorEuler {
    private XYSeries totAprErrSeries;

    public XYSeries getTotAprErrSeries() {
        return totAprErrSeries;
    }

    public TotalApproxErrorEuler(double x0, double y0, double xf, int n0, int nf){
        totAprErrSeries = new XYSeries("Total Approximation Euler error");

        int nNow=n0;
        while(nNow<=(nf-1)) {
            double h = (xf-x0)/nNow;
            double yTemp=y0;
            double c = y0/(Math.pow(Math.E,-Math.sin(x0))) - x0;

            double maxErrorY=Double.MIN_VALUE;
            for (double j = x0 + h; j <xf ; j=j+h) {
                if (maxErrorY < (Math.abs(Math.pow(Math.E,-Math.sin(j))*(j+c) - (yTemp + h * (Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j)))))){
                    maxErrorY = (Math.abs(Math.pow(Math.E,-Math.sin(j))*(j+c) - (yTemp + h * (Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j)))));
                    //maxErrorY = ((yTemp + h * (Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j))));
                }
                yTemp = yTemp + h * (Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j));
            }
            totAprErrSeries.add(nNow,maxErrorY);
            nNow++;
        }

    }
}
