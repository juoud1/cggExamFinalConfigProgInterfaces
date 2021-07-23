package com.dobatii.java.exams.exo1;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.dobatii.java.exams.exo1.presentation.ResistanceSeriePresentation;
import com.dobatii.java.exams.exo1.presentation.ResistanceSeriePresentation1;

public class ResistanceSerieMain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	

	public static void main(String[] args) {
	
//		new ResistanceSeriePresentation1();
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ResistanceSeriePresentation();
			}
		});
	}

}
