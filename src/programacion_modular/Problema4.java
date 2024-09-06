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
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema4 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtMinutosTardanza;
	private JTextField txtNumeroObservaciones;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema4 frame = new Problema4();
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
	public Problema4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minutos de tardanza");
		lblNewLabel.setBounds(10, 11, 121, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de observacioones");
		lblNewLabel_1.setBounds(10, 31, 142, 14);
		contentPane.add(lblNewLabel_1);
		
		txtMinutosTardanza = new JTextField();
		txtMinutosTardanza.setBounds(158, 8, 86, 20);
		contentPane.add(txtMinutosTardanza);
		txtMinutosTardanza.setColumns(10);
		
		txtNumeroObservaciones = new JTextField();
		txtNumeroObservaciones.setBounds(158, 28, 86, 20);
		contentPane.add(txtNumeroObservaciones);
		txtNumeroObservaciones.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 27, 89, 23);
		contentPane.add(btnBorrar);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 71, 414, 179);
		contentPane.add(scpScroll);
		
		txtAreaResultado = new JTextArea();
		scpScroll.setViewportView(txtAreaResultado);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnProcesar) 
			actionPerformedBtnProcesar(e);
		if(e.getSource() == btnBorrar)
			actionPerformedBtnBorrar(e);
	}
	public void actionPerformedBtnProcesar(ActionEvent e) {
		//declarar variables
		int minutosTar, numeroObs, puntajePun, puntajeRen, puntajeTot;
		double bonificacion;
		
		//entrada de datos
		minutosTar = getMinutos();
		numeroObs = getNumero();
		
		//proceso calculo
		puntajePun = calcularPuntajePuntualidad(minutosTar);
		puntajeRen = calcularPuntajeRendimiento(numeroObs);
		puntajeTot = calcularPuntajeTotal(puntajePun, puntajeRen);
		bonificacion = calcularBonificacion(puntajeTot);
		
		//mostrar resultados
		mostrarResultados(puntajePun, puntajeRen, puntajeTot, bonificacion);
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		
		txtMinutosTardanza.setText("");
		txtNumeroObservaciones.setText("");
		txtAreaResultado.setText("");
		txtMinutosTardanza.requestFocus();
	}
	int getMinutos() {
		return Integer.parseInt(txtMinutosTardanza.getText());
	}
	int getNumero() {
		return Integer.parseInt(txtNumeroObservaciones.getText());
	}
	int calcularPuntajePuntualidad(int minutosTar) {
		if(minutosTar == 0)
			return 10;
		else if(minutosTar <= 2)
			return 8;
		else if(minutosTar <= 5)
			return 6;
		else if(minutosTar <= 9)
			return 4;
		else
			return 0;
	}
	int calcularPuntajeRendimiento(int numeroObs) {
		if(numeroObs == 0)
			return 10;
		else if(numeroObs == 1)
			return 8;
		else if(numeroObs == 2)
			return 5;
		else if(numeroObs == 3)
			return 1;
		else
			return 0;
	}
	int calcularPuntajeTotal(int puntajePun, int puntajeRen) {
		return puntajePun + puntajeRen;
	}
	double calcularBonificacion(int puntajeTot) {
		if(puntajeTot < 11)
			return 2.5 * puntajeTot;
		else if(puntajeTot <= 13)
			return 5.0 * puntajeTot;
		else if(puntajeTot <= 16)
			return 7.5 * puntajeTot;
		else if(puntajeTot <= 19)
			return 10.0 * puntajeTot;
		else
			return 12.5 * puntajeTot;
	}
	
	void mostrarResultados(int puntajePun, int puntajeRen, int puntajeTot, double bonificacion) {
		txtAreaResultado.setText("");
		txtAreaResultado.append("Puntaje puntualidad: " + puntajePun + "\n");
		txtAreaResultado.append("Puntaje rendimiento: " + puntajeRen + "\n");
		txtAreaResultado.append("Puntaje puntaje total: " + puntajeTot + "\n");
		txtAreaResultado.append("Bonificacion: " + bonificacion);
	}
	
	// Imprime una línea de texto incluyendo un salto de línea al final
	void txtAreaResultado(String cad) {
	txtAreaResultado.append(cad + "\n");
	}
	
	
	
	
	
	
	
	
	
}
