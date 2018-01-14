package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import logic.*;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class MainWindow {

	private JFrame frmBenfordsLaw;
	private JTextField txtSeparator;
	private JFileChooser fc;
	private String extension;
	private JLabel lblpathtofile;
	private String separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmBenfordsLaw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBenfordsLaw = new JFrame();
		frmBenfordsLaw.setResizable(false);
		frmBenfordsLaw.setTitle("Benford's Law");
		frmBenfordsLaw.setBounds(100, 100, 409, 185);
		frmBenfordsLaw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBenfordsLaw.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 407, 68);
		frmBenfordsLaw.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][]"));

		lblpathtofile = new JLabel("/path/to/file");
		lblpathtofile.setMinimumSize(new Dimension(25, 14));
		lblpathtofile.setPreferredSize(new Dimension(25, 14));
		lblpathtofile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblpathtofile.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblpathtofile.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		JButton btnSet = new JButton("Set...");
		btnSet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fc = new JFileChooser(new File(".\\TestData\\"));
				fc.setDialogTitle("upload your are File!");
				fc.setFileFilter(new FileTypeFilter(".csv", "CSV Datei"));
				fc.setFileFilter(new FileTypeFilter(".pdf", "PDF Datei"));
				fc.setFileFilter(new FileTypeFilter(".jpg", "JPEG Datei"));
				fc.setFileFilter(new FileTypeFilter(".png", "PNG Datei"));
				int result = fc.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File fi = fc.getSelectedFile();
					 extension = fc.getFileFilter().getDescription();
					lblpathtofile.setText(fi.getAbsolutePath());
				}
			}
		});
		panel.add(btnSet, "cell 0 0,grow");
		panel.add(lblpathtofile, "cell 1 0,growx,aligny center");
		lblpathtofile.setForeground(Color.BLUE);
		lblpathtofile.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblCsvSeparator = new JLabel("CSV Separator:");
		lblCsvSeparator.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblCsvSeparator, "cell 0 1,alignx trailing");

		txtSeparator = new JTextField();
		txtSeparator.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(txtSeparator, "cell 1 1");
		txtSeparator.setColumns(10);

		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pathtofile = lblpathtofile.getText();
				separator = txtSeparator.getText();
		       if (pathtofile.contains("path/to/file")) {
		    	   JOptionPane.showMessageDialog(null, "Please set the  Path to your File!");	    	   
		       }
		       else {
		   		if (extension.startsWith("CSV")) {
					if (separator.isEmpty()) {
						JOptionPane.showMessageDialog(null, "CVS File need a Separator!");	
					}
					else {
						// Etwas machen mit CSV !
						Benford_Analyzer ba = new Benford_Analyzer();
						AbstractFileReader afr = new CsvReader(pathtofile, separator);
						Vector<Double> occ = ba.analyze_digits(afr.read());
						ba.showBarChart(occ);						
					}
					
				}
				else {
					if (extension.startsWith("PDF")) {
						// Etwas machen mit pdf
						Benford_Analyzer ba = new Benford_Analyzer();
						AbstractFileReader afr = new PdfReader(pathtofile);
						Vector<Double> occ = ba.analyze_digits(afr.read());
						ba.showBarChart(occ);
					}
					else {
						// Etwas machen mit image
						Benford_Analyzer ba = new Benford_Analyzer();
						AbstractFileReader afr = new PicReader(pathtofile);
						Vector<Double> occ = ba.analyze_digits(afr.read());
						ba.showBarChart(occ);
						
					}


				}
		       }
			}
		});

		btnRun.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRun.setBounds(148, 90, 106, 48);
		frmBenfordsLaw.getContentPane().add(btnRun);
	}
}
