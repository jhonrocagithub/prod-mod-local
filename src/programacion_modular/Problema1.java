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

public class Problema1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtBase;
	private JTextField txtAltura;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema1 frame = new Problema1();
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
	public Problema1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Base");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Altura");
		lblNewLabel_1.setBounds(10, 39, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtBase = new JTextField();
		txtBase.setBounds(79, 8, 86, 20);
		contentPane.add(txtBase);
		txtBase.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(79, 36, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 35, 89, 23);
		contentPane.add(btnBorrar);
		
		txtAreaResultado = new JTextArea();
		txtAreaResultado.setBounds(10, 76, 414, 174);
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
		//declaracion de varibles locales
		double base, altura, areaRec;
		
		//llama a getBase
		base = getBase();
		altura = getAltura();
		areaRec = calcularArea(base, altura);
		mostrarArea(areaRec);
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtBase.setText("");
		txtAltura.setText("");
		txtAreaResultado.setText("");
		txtBase.requestFocus();
	}
	//lee y retorna y la base
	double getBase() {
		return Double.parseDouble(txtBase.getText());
	}
	//lee y retorna la altura
	double getAltura() {
		return Double.parseDouble(txtAltura.getText());
	}
	//calcula y retorna el area
	double calcularArea(double base, double altura) {
		return base * altura;
	}
	//mostrar resultados
	void mostrarArea(double areaRec) {
		
		txtAreaResultado.append("Area: " + areaRec);
		
	}
}
