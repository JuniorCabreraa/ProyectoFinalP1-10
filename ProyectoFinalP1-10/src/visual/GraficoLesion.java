package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logical.Liga;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class GraficoLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public GraficoLesion() {
		setTitle("Gr\u00E1fico de Lesiones por Tipo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficoLesion.class.getResource("/Imagenes/med.png")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 731, 512);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
        
		int[] x = new int[6];
		x = Liga.getInstance().cantidadLesionesCat();
		
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.setValue(x[0], "Cabeza", "");
        data.setValue(x[1], "Hombro", "");
        data.setValue(x[2], "Brazo", "");
        data.setValue(x[3], "Espalda", "");
        data.setValue(x[4], "Pierna", "");
        data.setValue(x[05], "Pie", "");
 
        JFreeChart chart = ChartFactory.createBarChart3D(
         "Lesiones por Categoria", "Categoria", "Cantidad", 
         data,PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(0, 0, 715, 443);
        getContentPane().add(chartPanel);
	}
	
	public static void main(String args[]) {
		new GraficoLesion().setVisible(true);
	}
}
