import org.jfree.data.xy.XYSeries;

public class TotalApproxErrorRungeKutta {
    private XYSeries totAprErrSeriesRungeKutta;

    public XYSeries getTotAprErrSeriesRungeKutta() {
        return totAprErrSeriesRungeKutta;
    }

    public TotalApproxErrorRungeKutta(double x0, double y0, double xf, int n0, int nf){
        totAprErrSeriesRungeKutta = new XYSeries("Total Approximation Runge-Kutta error");

        int nNow=n0;
        while(nNow<=(nf-1)) {
            double h = (xf-x0)/nNow;
            double yTemp=y0;
            double c = y0/(Math.pow(Math.E,-Math.sin(x0))) - x0;

            double maxErrorY=Double.MIN_VALUE;
            for (double j = x0 + h; j <xf ; j=j+h) {
                double k1 = Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j);
                double k2 = Math.pow(Math.E,-Math.sin(j+(h/2))) - (yTemp+(h*k1/2))*Math.cos(j + (h/2));
                double k3 = Math.pow(Math.E,-Math.sin(j+(h/2))) - (yTemp+(h*k2/2))*Math.cos(j + (h/2));
                double k4 = Math.pow(Math.E,-Math.sin(j+h)) - (yTemp+h*k3)*Math.cos(j+h);

                if (maxErrorY < Math.abs(Math.pow(Math.E,-Math.sin(j))*(j+c) - (yTemp+(h/6)*(k1+2*k2+2*k3+k4)))){
                    maxErrorY = Math.abs(Math.pow(Math.E,-Math.sin(j))*(j+c) - (yTemp+(h/6)*(k1+2*k2+2*k3+k4)));
                }
                yTemp = yTemp+(h/6)*(k1+2*k2+2*k3+k4);
            }
            totAprErrSeriesRungeKutta.add(nNow,maxErrorY);
            nNow++;
        }

    }
}
