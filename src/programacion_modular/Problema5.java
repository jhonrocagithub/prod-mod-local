package programacion_modular;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema5 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtMonto;
	private JButton btnBorrar;
	private JButton btnProcesar;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema5 frame = new Problema5();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Problema5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Monto del pr\u00E9stamo");
		lblNewLabel.setBounds(10, 11, 101, 14);
		contentPane.add(lblNewLabel);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(120, 8, 86, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(255, 7, 77, 23);
		contentPane.add(btnBorrar);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(345, 7, 79, 23);
		contentPane.add(btnProcesar);
		
		txtAreaResultado = new JTextArea();
		txtAreaResultado.setBounds(10, 54, 414, 196);
		contentPane.add(txtAreaResultado);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if(e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}
	public void actionPerformedBtnProcesar(ActionEvent e) {
		//declarar variables
		double montoPrestamo, tasaInteres, interesTotal, cuotaMensual; 
		int numeroCuotas;
		
		//entrada de datos
		montoPrestamo = getMonto();
		
		//proceso de calculo
		numeroCuotas = calcularNumeroCuotas(montoPrestamo);
		tasaInteres = calcularTasaInteres(montoPrestamo);
		interesTotal = calcularInteresTotal(montoPrestamo,tasaInteres, numeroCuotas);
		cuotaMensual = calcularCuotaMensual(montoPrestamo, interesTotal, numeroCuotas);
		
		//mostrar resultados
		mostrarResultados(numeroCuotas, tasaInteres, interesTotal, cuotaMensual);
		
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtMonto.setText("");
		txtAreaResultado.setText("");
		txtMonto.requestFocus();
	}
	//pedidomos datos
	double getMonto() {
		return  Double.parseDouble(txtMonto.getText()); 
	}
	//calcularmos las cuotas
	int calcularNumeroCuotas(double montoPrestamo) {
		if(montoPrestamo <= 5000)
			return 2;
		else if(montoPrestamo <= 10000)
			return 4;
		else if(montoPrestamo <= 15000)
			return 6;
		else
			return 10;
	}
	//hallamos tasa de interes
	double calcularTasaInteres(double montoPrestamo) {
	if(montoPrestamo > 10000)
		return 0.03;
	else
		return 0.05;
	}
	
	//calculamos y retornamos el monto del interes total
	double calcularInteresTotal(double montoPrestamo, double tasaInteres, int numeroCuotas) {
		return montoPrestamo * tasaInteres * numeroCuotas;
	}
	//calculamos y retorna el monot de la cuota
	double calcularCuotaMensual(double montoPrestamo, double interesTotal, int numeroCuotas) {
		return (montoPrestamo + interesTotal) / numeroCuotas;
	}
	//muestra los resultados obtenidos
	void mostrarResultados(int numeroCuotas, double tasaInteres, double interesTotal, double cuotaMensual) {
		txtAreaResultado.setText(""); 
		txtAreaResultado.append("Número de cuotas : " + numeroCuotas +"\n"); 
		txtAreaResultado.append("Tasa de interés  : " + tasaInteres +"\n"); 
		txtAreaResultado.append("Cuota mensual    : S/. " + cuotaMensual +"\n"); 
		txtAreaResultado.append("Interés total    : S/. " + interesTotal); 
	}
	
	// Imprime una línea de texto incluyendo un salto de línea al final 
	void txtAreaResultado(String cad) { 
	txtAreaResultado.append(cad + "\n"); 
	} 
	
}









