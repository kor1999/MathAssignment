import org.jfree.data.xy.XYSeries;

public class RungeKuttaMethod {
    private XYSeries rungeKuttaSeries;

    public XYSeries getRungeKuttaSeries() {
        return rungeKuttaSeries;
    }

    public RungeKuttaMethod(double x0, double y0, double xf, double h) {
        rungeKuttaSeries = new XYSeries("Runge-Kutta method");
        rungeKuttaSeries.add(x0, y0);
        double yTemp=y0;

        for (double j = x0 + h; j < xf; j = j + h) {

            double k1 = Math.pow(Math.E,-Math.sin(j)) - yTemp*Math.cos(j);
            double k2 = Math.pow(Math.E,-Math.sin(j+(h/2))) - (yTemp+(h*k1/2))*Math.cos(j + (h/2));
            double k3 = Math.pow(Math.E,-Math.sin(j+(h/2))) - (yTemp+(h*k2/2))*Math.cos(j + (h/2));
            double k4 = Math.pow(Math.E,-Math.sin(j+h)) - (yTemp+h*k3)*Math.cos(j+h);
            rungeKuttaSeries.add(j,yTemp+(h/6)*(k1+2*k2+2*k3+k4));

            yTemp = yTemp+(h/6)*(k1+2*k2+2*k3+k4);
        }
    }
}
