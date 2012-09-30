package com.sjunejo.quadraticsolver;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Basic Swing App for solving quadratic equations
 * @author Sadruddin Junejo
 *
 */
public class QuadraticEqnSolverMain extends JFrame implements ActionListener {
		
	private static final int NUMBEROFCOLUMNS = 3;
	
	private static final String STRXSQUARED = "x^2 + ";
	private static final String STRX = "x +";
	private static final String STREQUALSZERO = "= 0";
	private static final String STRJBSOLVE = "Solve!";
	private static final String STRNOREALROOTS = "NO REAL ROOTS ";
	private static final String STRANSWERPARTONE = "x = ";
	private static final String STRANSWERPARTTWO = "OR x = ";
	
	private JTextField jtfCoeffA;
	private JTextField jtfCoeffB;
	private JTextField jtfCoeffC;
	
	private JPanel jpMainPanel;
	
	private JPanel jpSubPanelUpper;
	
	private JButton jbSolve;
	
	private double discriminant;
	
	private JLabel jlSolution;
	
	/**
	 * Constructor class
	 */
	public QuadraticEqnSolverMain(){
		setTitle("Quadratic Equation Solver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialiseComponents();
		pack();
	}
	
	/**
	 * Sets up GUI
	 */
	void initialiseComponents(){
		jpMainPanel = new JPanel(new GridLayout(4,1));
		
		jpSubPanelUpper = new JPanel();
		
		jtfCoeffA = new JTextField(NUMBEROFCOLUMNS);
		jpSubPanelUpper.add(jtfCoeffA);
		
		jpSubPanelUpper.add(new JLabel(STRXSQUARED));
		
		jtfCoeffB = new JTextField(NUMBEROFCOLUMNS);
		jpSubPanelUpper.add(jtfCoeffB);

		jpSubPanelUpper.add(new JLabel(STRX));
		
		jtfCoeffC = new JTextField(NUMBEROFCOLUMNS);
		jpSubPanelUpper.add(jtfCoeffC);
		
		jpSubPanelUpper.add(new JLabel(STREQUALSZERO));
		
		jpMainPanel.add(jpSubPanelUpper);
		
		jbSolve = new JButton(STRJBSOLVE);
		jbSolve.addActionListener(this);
		
		jpMainPanel.add(jbSolve);
		
		jlSolution = new JLabel("");
		
		jpMainPanel.add(jlSolution);
		
		setAllTextFieldsToZero();
		
		this.add(jpMainPanel);
	}
	
	/**
	 * Self-explanatory
	 */
	void setAllTextFieldsToZero(){
		jtfCoeffA.setText("0");
		jtfCoeffB.setText("0");
		jtfCoeffC.setText("0");
	}
	
	/**
	 * Method invoked upon button press
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Calculate discriminant
		
		double b = Integer.parseInt(jtfCoeffB.getText());
		double a = Integer.parseInt(jtfCoeffA.getText());
		
		discriminant = (b * b) - (4 * a
				* Integer.parseInt(jtfCoeffC.getText()));
		
		if (discriminant >= 0){
			discriminant = Math.sqrt(discriminant);
			
			String answer = STRANSWERPARTONE + (-b + discriminant)/(2 * a);
			answer = answer + STRANSWERPARTTWO + (-b - discriminant)/(2 * a);
			
			jlSolution.setText(answer);
		}
		else {
			jlSolution.setText(STRNOREALROOTS);
		}
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new QuadraticEqnSolverMain().setVisible(true);
			}
		});
	}

}
