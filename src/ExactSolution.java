import org.jfree.data.xy.XYSeries;

public class ExactSolution {
    private XYSeries exactSolSereies;

    public XYSeries getExactSolSereies() {
        return exactSolSereies;
    }

    public ExactSolution(double x0, double y0, double xf, double h){
        exactSolSereies = new XYSeries("Exact Solution");
        exactSolSereies.add(x0,y0);
        double c = y0/(Math.pow(Math.E,-Math.sin(x0))) - x0;

        for (double j = x0 + h; j <xf ; j=j+h) {
            exactSolSereies.add(j,Math.pow(Math.E,-Math.sin(j))*(j+c));
        }

    }
}
