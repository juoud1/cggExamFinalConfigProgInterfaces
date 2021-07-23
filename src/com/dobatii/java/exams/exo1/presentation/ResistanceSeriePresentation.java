package com.dobatii.java.exams.exo1.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import com.dobatii.java.exams.exo1.utils.enums.CouleurEnum;

public class ResistanceSeriePresentation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton buttonQuitter;
	private JButton buttonPartie1;
	private JButton buttonPartie2;
	private JButton buttonPartie3;
	
	public ResistanceSeriePresentation() {
		resistanceFormInit();
	}
	
	public void resistanceFormInit() {
		
		buttonPartie1 = new JButton();
		buttonPartie2 = new JButton();
		buttonPartie3 = new JButton();
		buttonQuitter = new JButton();
		EmptyBorder border = new EmptyBorder(10, 10, 10, 10);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension screenSize,frameSize;
		Float x,y;
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		x= screenSize.width/1.5f;
		y=screenSize.height/2.5f;
		setSize(x.intValue(), y.intValue());
		setLocationRelativeTo(null);
		
		buttonQuitter.setText("Quitter");
		buttonQuitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				quitterActionPerformed(e);
			}
		});
		
		buttonPartie1.setText("Partie 1 de l'examen");
		buttonPartie1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				partie1ActionPerformed(e);
			}
		});
		
		buttonPartie2.setText("Partie 2 de l'examen");
		buttonPartie2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				partie2ActionPerformed(e);
			}
		});
		
		buttonPartie3.setText("Partie 3 de l'examen");
		buttonPartie3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				partie3ActionPerformed(e);
			}
		});
		
		JPanel panelButtonsPartiesExamen = new JPanel();
		JPanel panelButtons = new JPanel();

		buttonPartie1.setBorder(border);
		buttonPartie2.setBorder(border);
		buttonPartie3.setBorder(border);
		panelButtonsPartiesExamen.setBorder(border);
		panelButtons.setBorder(border);
		
		panelButtonsPartiesExamen.add(buttonPartie1);
		panelButtonsPartiesExamen.add(buttonPartie2);
		panelButtonsPartiesExamen.add(buttonPartie3);
		panelButtons.add(buttonQuitter);
		
		getContentPane().add(BorderLayout.CENTER, panelButtonsPartiesExamen);
		getContentPane().add(BorderLayout.SOUTH, panelButtons);
		setTitle("Solution de l'examen final en Java");
		setVisible(true); 
		
	}
	
	private void partie1ActionPerformed (ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ResistanceSeriePresentation1();
			}
		}); 
	}
	
	private void partie2ActionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ResistanceSeriePresentation2();
			}
		}); 
	}
	
	private void partie3ActionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ResistanceSeriePresentation3();
			}
		}); 
	}

	private void quitterActionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
}
