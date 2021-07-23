package com.dobatii.java.exams.exo1.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.dobatii.java.exams.exo1.service.ResistanceSerieService;
import com.dobatii.java.exams.exo1.utils.enums.CouleurEnum;

public class ResistanceSeriePresentation3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResistanceSerieService resistanceService;
	
	private JButton buttonQuitter;
	private JButton buttonCalculer;
	
	private JComboBox<String> comboChoixCouleur;
	private JTextField txtTensionLed;
	private JTextField txtIntensiteLed;
	private JTextField txtTensionAlimentation;
	private JTextField txtResistance;
	
	private JLabel labelChoixCouleurLed;
	private JLabel labelTensionLed;
	private JLabel labelIntensiteLed;
	private JLabel labelTensionAlimentation;
	private JLabel labelAlimentation;
	private JLabel labelResistanceSerie;
	
	private JRadioButton radioButton5V;
	private JRadioButton radioButton12V;
	private ButtonGroup buttonGroupAlimentation;
	
	public ResistanceSeriePresentation3() {
		resistanceFormInit();
		resistanceService = new ResistanceSerieService();
	}
	
	public void resistanceFormInit() {
		
		EmptyBorder border = new EmptyBorder(10, 10, 10, 10);
		JPanel panelLed = new JPanel();
		JPanel panelResistance = new JPanel();
		JPanel panelRadioButtons = new JPanel();
		JPanel panelButtons = new JPanel();
		
		buttonCalculer = new JButton();
		buttonQuitter = new JButton();
		
		comboChoixCouleur = new JComboBox<>();
		
		txtTensionAlimentation = new JTextField(2);
		txtTensionLed = new JTextField(5);
		txtIntensiteLed = new JTextField(5);
		txtResistance = new JTextField(5);
		
		labelChoixCouleurLed = new JLabel();
		labelTensionLed = new JLabel();
		labelIntensiteLed = new JLabel();
		labelTensionAlimentation = new JLabel();
		labelResistanceSerie = new JLabel();
		labelAlimentation = new JLabel();
		
		buttonGroupAlimentation = new ButtonGroup();
		radioButton12V = new JRadioButton();
		radioButton5V = new JRadioButton();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension screenSize;
		int x,y;
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		x=screenSize.width/2;
		y=screenSize.height/4;
		setSize(x, y);
		setLocationRelativeTo(null);
		
		labelChoixCouleurLed.setText("Couleur Led :");
		labelTensionLed.setText("Tension Led :");
		labelIntensiteLed.setText("Intensité Led :");
		labelTensionAlimentation.setText("Tension alimentation :");
		labelResistanceSerie.setText("Résistance");
		labelAlimentation.setText("Alimentation :");
		
		radioButton12V.setText("12V");
		radioButton12V.setSelected(Boolean.TRUE);
		radioButton5V.setText("5V");
		
		buttonQuitter.setText("Quitter");
		buttonQuitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				quitterActionPerformed(e);
			}
		});
		
		buttonCalculer.setText("Calculer");
		buttonCalculer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculerActionPerformed(e);
			}
		});
		
		List<String> comboChoixElts = Arrays.asList(CouleurEnum.values()).stream()
				.map(c -> c.getCouleurName().toString())
				.collect(Collectors.toList());
		
		comboChoixCouleur.setModel(new DefaultComboBoxModel<>(comboChoixElts.toArray(new String[8])));
		comboChoixCouleur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		panelLed.setBorder(border);
		panelResistance.setBorder(border);
		panelButtons.setBorder(border);
		panelRadioButtons.setBorder(border);
		
		panelRadioButtons.add(radioButton12V);
		panelRadioButtons.add(radioButton5V);
		
		panelLed.add(labelChoixCouleurLed);
		panelLed.add(comboChoixCouleur);
		panelLed.add(BorderLayout.AFTER_LAST_LINE, labelTensionLed);
		panelLed.add(txtTensionLed);
		panelLed.add(BorderLayout.AFTER_LAST_LINE, labelIntensiteLed);
		panelLed.add(txtIntensiteLed);

		
		panelResistance.add(labelResistanceSerie);
		panelResistance.add(txtResistance);
		
		panelButtons.add(buttonCalculer);
		panelButtons.add(buttonQuitter);
		
		getContentPane().add(BorderLayout.WEST, panelLed);
		getContentPane().add(BorderLayout.EAST, panelResistance);
		getContentPane().add(BorderLayout.CENTER, panelRadioButtons);
		getContentPane().add(BorderLayout.SOUTH, panelButtons);
		
		buttonGroupAlimentation.add(radioButton12V);
		buttonGroupAlimentation.add(radioButton5V);
		setTitle("Partie 3 : Amélioration du calcul la valeur de la résistance en fonction de la couleur de la LED. La source d’alimentation est soit 12V ou soit 5V");
		setVisible(true); 
		
	}
	
	private void calculerActionPerformed(ActionEvent e) {
		txtResistance.setText(String.valueOf(calculerResistance().intValue()));
	}
	
	private void quitterActionPerformed(ActionEvent e) {
		this.hide();
	}
	
	private Float calculerResistance() {
		
		String tAlimentation = "";
		String couleur = comboChoixCouleur.getSelectedItem().toString();
		String tLed = txtTensionLed.getText();
		String iLed = txtIntensiteLed.getText();
		
		if (radioButton12V.isSelected()) {
			tAlimentation = radioButton12V.getText().substring(0, radioButton12V.getText().length()-1);
		}
		
		if (radioButton5V.isSelected()) {
			tAlimentation = radioButton5V.getText().substring(0, radioButton5V.getText().length()-1);
		}
		
		System.out.println("tAlimentation : " + tAlimentation);
		System.out.println("couleur : " + couleur);
		System.out.println("tLed : " + tLed);
		System.out.println("iLed : " + iLed);
		
		return resistanceService.calculerValeurResistanceEnfonctionDeCouleurLedTensAlimentTensLedEtIntLed(couleur, tAlimentation, tLed, iLed);
	}
	
}
