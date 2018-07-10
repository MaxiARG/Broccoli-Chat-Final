package com.vista;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JTextField ipField;
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
		setBounds(100, 100, 282, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipField = new JTextField();
		ipField.setBounds(86, 49, 145, 20);
		contentPane.add(ipField);
		ipField.setColumns(10);
		
		puertoField = new JTextField();
		puertoField.setColumns(10);
		puertoField.setBounds(86, 96, 145, 20);
		contentPane.add(puertoField);
		
		JLabel lblIp = new JLabel("IP: ");
		lblIp.setBounds(30, 52, 46, 14);
		contentPane.add(lblIp);
		
		JLabel lblPuerto = new JLabel("Puerto: ");
		lblPuerto.setBounds(30, 102, 67, 14);
		contentPane.add(lblPuerto);
		
		btnOk = new JButton("OK");

		btnOk.setBounds(149, 137, 82, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(30, 137, 82, 23);
		contentPane.add(btnCancelar);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	
		eventosDeBotones();
	}
	
	private void eventosDeBotones() {
		
		//Boton OK
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ip= ipField.getText();
				String puerto= puertoField.getText();
				
				try {
					Properties prop = new Properties();
					FileOutputStream out = new FileOutputStream("PropiedadesDelCliente");
					prop.setProperty("IP", ip);
					prop.setProperty("Puerto", puerto);
					prop.store(out, "--Sin Comentarios--");
					System.out.println("Se escribio el archivo de properties");
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
