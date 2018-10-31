import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakingGraph {
    private JTextField x0Field = new JTextField(3);
    private Label x0Label = new Label("x0:");
    private JTextField y0Field = new JTextField(3);
    private Label y0Label = new Label("y0:");
    private JTextField xfField = new JTextField(3);
    private Label xfLabel = new Label("xf:");
    private JTextField hField = new JTextField(3);
    private Label hLabel = new Label("h:");
    private JButton updateButton = new JButton("update");

    public MakingGraph(double x0, double y0, double xf, double h){

        XYSeriesCollection xySerColl1 = new XYSeriesCollection();
        XYSeriesCollection xySerColl2 = new XYSeriesCollection();

        EulerMethod eulerMethod = new EulerMethod(x0,y0,xf,h);
        ImpEulerMethod impEulerMethod = new ImpEulerMethod(x0,y0,xf,h);
        RungeKuttaMethod rungeKuttaMethod = new RungeKuttaMethod(x0,y0,xf,h);
        ExactSolution exactSolution = new ExactSolution(x0,y0,xf,h);
        EulerError eulerError = new EulerError(x0,y0,xf,h);
        ImpEulerError impEulerError = new ImpEulerError(x0,y0,xf,h);
        RungeKuttaError rungeKuttaError = new RungeKuttaError(x0,y0,xf,h);

        xySerColl1.addSeries(eulerMethod.getEulerSeries());
        xySerColl1.addSeries(impEulerMethod.getImpEulerSeries());
        xySerColl1.addSeries(rungeKuttaMethod.getRungeKuttaSeries());
        xySerColl1.addSeries(exactSolution.getExactSolSereies());

        xySerColl2.addSeries(eulerError.geteErrorSeries());
        xySerColl2.addSeries(impEulerError.getImpeErrorSeries());
        xySerColl2.addSeries(rungeKuttaError.getRungeKuttaErrorSeries());

        JFreeChart chart1 = ChartFactory.createXYLineChart("y'=e^(-sin(x))-y*cos(x)",
                "x","y",xySerColl1,PlotOrientation.VERTICAL,true,true,true);
        JFreeChart chart2 = ChartFactory.createXYLineChart("Errors",
                "x","y",xySerColl2,PlotOrientation.VERTICAL,true,true,true);

        JFrame jFrame = new JFrame("MathAssignment");
        Container container = jFrame.getContentPane();
        container.setLayout(new FlowLayout());

        ChartPanel chartPanel1 = new ChartPanel(chart1);
        chartPanel1.setSize(new Dimension(500, 220));
        container.add(chartPanel1);

        ChartPanel chartPanel2 = new ChartPanel(chart2);
        chartPanel2.setSize(new Dimension(500, 220));
        container.add(chartPanel2);

        Container container2 = jFrame.getContentPane();
        //container2.setLayout(new GridLayout(5, 2, 2,2));

        container.add(x0Label);
        container.add(x0Field);
        container.add(y0Label);
        container.add(y0Field);
        container.add(xfLabel);
        container.add(xfField);
        container.add(hLabel);
        container.add(hField);

        jFrame.getRootPane().setDefaultButton(updateButton);
        container.add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MakingGraph makingGraph= new MakingGraph(Double.parseDouble(x0Field.getText()),
                        Double.parseDouble(y0Field.getText()),Double.parseDouble(xfField.getText()),
                        Double.parseDouble(hField.getText()));
                jFrame.dispose();
            }
        });


        jFrame.setSize(1400,500);
        jFrame.show();
    }
}
