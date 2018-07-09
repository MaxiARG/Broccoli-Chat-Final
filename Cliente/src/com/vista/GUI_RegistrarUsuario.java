package com.vista;


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
import java.awt.Color;
import java.awt.Font;

public class GUI_RegistrarUsuario extends JFrame {

	private static final long serialVersionUID = 1218498309310645564L;
	private JPanel contentPane;
	private JTextField nombreField;
	private JTextField pPasswordField;
	private JButton btnOk;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUI_RegistrarUsuario frame = new GUI_RegistrarUsuario();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_RegistrarUsuario() {
		setTitle("Configuracion");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombreField = new JTextField();
		nombreField.setBounds(122, 52, 175, 20);
		contentPane.add(nombreField);
		nombreField.setColumns(10);
		
		pPasswordField = new JTextField();
		pPasswordField.setColumns(10);
		pPasswordField.setBounds(122, 99, 175, 20);
		contentPane.add(pPasswordField);
		
		JLabel lblIp = new JLabel("Nombre");
		lblIp.setBounds(30, 52, 82, 14);
		contentPane.add(lblIp);
		
		JLabel lblPuerto = new JLabel("Password");
		lblPuerto.setBounds(30, 102, 82, 14);
		contentPane.add(lblPuerto);
		
		btnOk = new JButton("Enviar");

		btnOk.setBounds(183, 137, 82, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(64, 137, 82, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese El Nombre de Usuario y La contraseña que Desea.");
		lblIngreseElNombre.setBounds(30, 11, 317, 14);
		contentPane.add(lblIngreseElNombre);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(122, 83, 175, 14);
		contentPane.add(lblNewLabel);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	
		eventosDeBotones();
	}
	
	private void eventosDeBotones() {
		
		//Boton OK
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//FALTA VALIDAR!
				String nombre=nombreField.getText().trim();
				String password= nombreField.getText().trim();
				if(nombre!=null && password!=null) {
					//EnviarAlServidorYEsperarRespuesta.
					//Si respuesta Correcta, dispose y mostrar login denuevo.
					//Sino quedarse aca.
				}
					setVisible(false);
					dispose();
			}
		});
		
	}
}
