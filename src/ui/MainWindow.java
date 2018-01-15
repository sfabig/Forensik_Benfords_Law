package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import org.apache.commons.io.FilenameUtils;
import org.jfree.io.FileUtilities;

import logic.AbstractFileReader;

public class MainWindow {

	private JFrame frmBenfordsLaw;
	private JTextField txtSeparator;
	private AbstractFileReader fileReader;

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
		frmBenfordsLaw.setTitle("Benford's Law");
		frmBenfordsLaw.setBounds(100, 100, 450, 268);
		frmBenfordsLaw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBenfordsLaw.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 407, 68);
		frmBenfordsLaw.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][]"));

		JLabel lblFile = new JLabel("File:");
		panel.add(lblFile, "cell 0 0");
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblpathtofile = new JLabel("/path/to/file");
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
		panel.add(lblpathtofile, "cell 1 0,growx,aligny center");
		lblpathtofile.setForeground(Color.BLUE);
		lblpathtofile.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnSet = new JButton("Set...");
		btnSet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnSet, "cell 2 0,grow");

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
				switch(FilenameUtils.getExtension(lblpathtofile.getText())) {
				}
			}
		});
		btnRun.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRun.setBounds(10, 169, 106, 48);
		frmBenfordsLaw.getContentPane().add(btnRun);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 90, 407, 68);
		frmBenfordsLaw.getContentPane().add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][]", "[][]"));

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox, "cell 0 0");

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox_2, "cell 1 0");

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox_1, "cell 2 0");
	}
}
