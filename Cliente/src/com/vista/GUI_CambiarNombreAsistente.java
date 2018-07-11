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

public class GUI_CambiarNombreAsistente extends JFrame {

	private static final long serialVersionUID = 1218498309310645564L;
	private JPanel contentPane;
	private JTextField nombreField;
	private JButton btnOk;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_CambiarNombreAsistente frame = new GUI_CambiarNombreAsistente();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_CambiarNombreAsistente() {
		setTitle("Configuracion");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombreField = new JTextField();
		nombreField.setBounds(64, 53, 145, 20);
		contentPane.add(nombreField);
		nombreField.setColumns(10);
		
		JLabel lblIp = new JLabel("Nombre Nuevo que desea:");
		lblIp.setBounds(64, 28, 156, 14);
		contentPane.add(lblIp);
		
		btnOk = new JButton("OK");

		btnOk.setBounds(63, 103, 145, 55);
		contentPane.add(btnOk);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	
		eventosDeBotones();
	}
	
	private void eventosDeBotones() {
		
		//Boton OK
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre= nombreField.getText();
				
				try {
					Properties prop = new Properties();
					FileOutputStream out = new FileOutputStream("PropiedadNombreAsistente");
					prop.setProperty("NombreAsistente", nombre);
					prop.store(out, "--Nombre Asistente--");
					System.out.println("Se escribio el nombre del Asistente");
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
