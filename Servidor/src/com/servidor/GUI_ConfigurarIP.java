package com.servidor;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI_ConfigurarIP extends JFrame {

	private static final long serialVersionUID = 1218498309310645564L;
	private JPanel contentPane;
	private JTextField puertoField;
	private JButton btnOk;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ConfigurarIP frame = new GUI_ConfigurarIP();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_ConfigurarIP() {
		setTitle("Configuracion");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		puertoField = new JTextField();
		puertoField.setColumns(10);
		puertoField.setBounds(82, 39, 145, 20);
		contentPane.add(puertoField);
		
		JLabel lblPuerto = new JLabel("Puerto: ");
		lblPuerto.setBounds(30, 42, 67, 14);
		contentPane.add(lblPuerto);
		
		btnOk = new JButton("OK");

		btnOk.setBounds(92, 70, 106, 63);
		contentPane.add(btnOk);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	
		eventosDeBotones();
	}
	
	private void eventosDeBotones() {
		
		//Boton OK
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String puerto= puertoField.getText();
				
				try {
					Properties prop = new Properties();
					FileOutputStream out = new FileOutputStream("PropiedadesDelServidor");
					prop.setProperty("Puerto", puerto);
					prop.store(out, "--Sin Comentarios--");
					out.close();
					setVisible(false);
					dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		});
		
	}
}
