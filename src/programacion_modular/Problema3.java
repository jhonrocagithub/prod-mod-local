package programacion_modular;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class Problema3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox cmbCategoria;
	private JTextField txtPromedio;
	private JButton btnBorrar;
	private JTextArea txtAreaResultado;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema3 frame = new Problema3();
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
	public Problema3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(10, 11, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Promedio");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cmbCategoria = new JComboBox();
		cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		cmbCategoria.setBounds(88, 7, 77, 22);
		contentPane.add(cmbCategoria);
		
		txtPromedio = new JTextField();
		txtPromedio.setBounds(88, 33, 77, 20);
		contentPane.add(txtPromedio);
		txtPromedio.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);
		
		txtAreaResultado = new JTextArea();
		txtAreaResultado.setBounds(10, 61, 414, 189);
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
		//declarar variables locales
		int categoria;
		double promedio, descuento, nuevaPen, actualPen;
		
		//entrada de datos
		categoria = getCategoria();
		promedio = getPromedio();
		
		//proceso de calculo
		actualPen = calcularPensionActual(categoria);
		descuento = calcularDescuento(actualPen, promedio);
		nuevaPen = calcularNuevaPension(actualPen, descuento);
		
		//mostrar resultados
		mostrarResultados(actualPen,descuento,nuevaPen);
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtPromedio.setText("");
		txtAreaResultado.setText("");
		txtPromedio.requestFocus();
	}
	
	int getCategoria() {
		return cmbCategoria.getSelectedIndex();
	}
	double getPromedio() {
		return Double.parseDouble(txtPromedio.getText());
	}
	double calcularPensionActual(int categoria) {
		switch(categoria) {
			case 0: return 550;
			case 1: return 500;
			case 2: return 460;
			default: return 400;
		}
	}
	double calcularDescuento(double actualPen, double promedio) {
		if(promedio <= 13.99)
			return 0;
		else if(promedio <= 15.99) 
			return 0.10 * actualPen;
		else if(promedio <= 17.99) 
			return 0.12 * actualPen;
		else 
			return 0.15 * actualPen;
	}
	double calcularNuevaPension(double actualPen, double descuento) {
		return actualPen - descuento;
	}
	void mostrarResultados(double actualPen, double descuento, double nuevaPen) {
		txtAreaResultado.setText("");
		txtAreaResultado.append("Pensión actual : S/. " + actualPen +"\n");
		txtAreaResultado.append("Descuento : S/. " + descuento +"\n");
		txtAreaResultado.append("Nueva pensión : S/. " + nuevaPen);
	}
	void AreaResultado(String cad) {
		txtAreaResultado.append(cad + "\n");
		}

	
}
