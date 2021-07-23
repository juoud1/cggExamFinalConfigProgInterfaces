package com.dobatii.java.exams.exo1.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.dobatii.java.exams.exo1.service.ResistanceSerieService;
import com.dobatii.java.exams.exo1.utils.enums.CouleurEnum;

public class ResistanceSeriePresentation1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResistanceSerieService resistanceService;
	
	private JButton buttonQuitter;
	private JButton buttonCalculer;
	
	private JComboBox<String> comboChoixCouleur;
	private JTextField txtResistance;
	
	private JLabel labelChoixCouleurLed;
	private JLabel labelTensionLed;
	private JLabel labelIntensiteLed;
	private JLabel labelTensionAlimentation;
	private JLabel labelResistanceSerie;
	
	public ResistanceSeriePresentation1() {
		resistanceFormInit();
		System.out.println("comboChoixCouleur.getSelectedItem().toString() : " + comboChoixCouleur.getSelectedItem().toString());
		resistanceService = new ResistanceSerieService();
		//resistanceService = new ResistanceSerieService(comboChoixCouleur.getSelectedItem().toString());
	}
	
	public void resistanceFormInit() {
		
		buttonCalculer = new JButton();
		buttonQuitter = new JButton();
		
		comboChoixCouleur = new JComboBox<>();
		txtResistance = new JTextField(5);
		
		labelChoixCouleurLed = new JLabel();
		labelTensionLed = new JLabel();
		labelIntensiteLed = new JLabel();
		labelTensionAlimentation = new JLabel();
		labelResistanceSerie = new JLabel();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension screenSize;
		int x,y;
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		x=screenSize.width/2;
		y=screenSize.height/4;
		//setLocation(600, 200);
		setSize(x, y);
		setLocationRelativeTo(null);
		
		labelChoixCouleurLed.setText("Couleur Led :");
		labelTensionLed.setText("Tension Led :");
		labelIntensiteLed.setText("Intensité Led :");
		labelTensionAlimentation.setText("Tension alimentation :");
		labelResistanceSerie.setText("Résistance");
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
				choixCouleurActionPerformed(e);
			}
		});
		
		EmptyBorder border = new EmptyBorder(10, 10, 10, 10);
		JPanel panelLed = new JPanel();
		JPanel panelResistance = new JPanel();
		JPanel panelButtons = new JPanel();

		panelLed.setBorder(border);
		panelResistance.setBorder(border);
		panelButtons.setBorder(border);
		
		panelLed.add(labelChoixCouleurLed);
		panelLed.add(comboChoixCouleur);
		
		panelResistance.add(labelResistanceSerie);
		panelResistance.add(txtResistance);
		
		panelButtons.add(buttonCalculer);
		panelButtons.add(buttonQuitter);
		
		getContentPane().add(BorderLayout.WEST, panelLed);
		getContentPane().add(BorderLayout.EAST, panelResistance);
		getContentPane().add(BorderLayout.SOUTH, panelButtons);
		setTitle("Partie 1 : Calcul la valeur de la résistance en fonction de la couleur de la LED. La source d’alimentation = 12V");
		setVisible(true); 
		
	}
	
	private void calculerActionPerformed(ActionEvent e) {
		txtResistance.setText(String.valueOf(calculerResistance().intValue()));
	}
	
	private void quitterActionPerformed(ActionEvent e) {
		this.hide();
	}
	
	private void choixCouleurActionPerformed(ActionEvent e) {
		txtResistance.setText(String.valueOf(calculerResistance().intValue()));
	}
	
	private Float calculerResistance() {
		System.out.println("resistanceService.calculerValeurResistanceEnfonctionDeCouleurLed() : " + resistanceService.calculerValeurResistanceEnfonctionDeCouleurLed(comboChoixCouleur.getSelectedItem().toString()));
		return resistanceService.calculerValeurResistanceEnfonctionDeCouleurLed(comboChoixCouleur.getSelectedItem().toString());
	}
}
