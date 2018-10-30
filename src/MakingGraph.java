import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class MakingGraph {

    public MakingGraph(double x0, double y0, double xf, double h){

        XYSeriesCollection xySerColl = new XYSeriesCollection();
        EulerMethod eulerMethod = new EulerMethod(x0,y0,xf,h);
        ImpEulerMethod impEulerMethod = new ImpEulerMethod(x0,y0,xf,h);
        xySerColl.addSeries(eulerMethod.getEulerSeries());
        xySerColl.addSeries(impEulerMethod.getImpEulerSeries());
        JFreeChart chart = ChartFactory.createXYLineChart("y=e^(-sin(x))-y*cos(x)",
                "x","y",xySerColl,PlotOrientation.VERTICAL,true,true,true);

        JFrame jFrame = new JFrame("MathAssignment");
        jFrame.getContentPane().add(new ChartPanel(chart));
        jFrame.setSize(500,400);
        jFrame.show();
    }
}
