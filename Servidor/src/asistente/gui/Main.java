package asistente.gui;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import asistente.inet.BusquedaInet;
import asistente.inet.ClimaInet;
import asistente.inet.CotizacionInet;
import asistente.inet.GifInet;
import asistente.inet.Internet;
import asistente.inet.NineGagInet;
import asistente.inet.NoticiaInet;
import asistente.util.Busqueda;
import asistente.util.Ciudad;
import asistente.util.Clima;
import asistente.util.Cotizacion;
import asistente.util.NineGag;
import asistente.util.Noticia;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textCiudad;
	private ArrayList<Noticia> listaNoticias;
	private ArrayList<Ciudad> listaCiudades;
	private ArrayList<String> listaGifs;
	ArrayList<NineGag> listaImgsNine;
	private JTextField textBuscarGif;
	private JTextField textPalabraClave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 590, 360);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Noticias", null, panel_3, null);
		panel_3.setLayout(null);
		
		this.listaCiudades = new ArrayList<>();
		this.listaGifs = new ArrayList<>();
		this.listaImgsNine = new ArrayList<>();
		
		JLabel lblUrl = new JLabel("");
		lblUrl.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblUrl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblUrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ev) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						if (desktop.isSupported(Desktop.Action.BROWSE))
							try {
								desktop.browse(new URI(lblUrl.getText()));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (URISyntaxException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}
		});
		lblUrl.setBounds(10, 262, 567, 14);
		panel_3.add(lblUrl);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 164, 567, 86);
		textArea.setEditable(false);
		panel_3.add(textArea);
		
		JLabel lblGif = new JLabel("");
		lblGif.setBounds(12, 12, 299, 269);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(10, 297, 130, 23);
		panel_3.add(btnActualizar);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Clima", null, panel, null);
		panel.setLayout(null);
		
		JTextArea textAreaClima = new JTextArea();
		textAreaClima.setLineWrap(true);
		textAreaClima.setBounds(12, 39, 559, 138);
		panel.add(textAreaClima);
		
		JLabel lblFotoDia = new JLabel("");
		lblFotoDia.setBounds(445, 11, 159, 151);
		panel.add(lblFotoDia);
		
		textCiudad = new JTextField();
		textCiudad.setBounds(148, 201, 171, 20);
		panel.add(textCiudad);
		textCiudad.setColumns(10);
		
		JLabel lblIngreseLaCiudad = new JLabel("Ingrese la ciudad:");
		lblIngreseLaCiudad.setBounds(12, 201, 122, 20);
		panel.add(lblIngreseLaCiudad);
		
		
		JLabel lblClimaEn = new JLabel("");
		lblClimaEn.setBounds(12, 11, 559, 16);
		panel.add(lblClimaEn);
		
		JList list_2 = new JList();
		list_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int i = list_2.locationToIndex(e.getPoint());
					textAreaClima.setText("");			
					ClimaInet clima = new ClimaInet(Internet.CLIMA);
					clima.setKey_locale(listaCiudades.get(i).getKeyLocation());
					Clima c = clima.obtenerClima();
					lblClimaEn.setText("El clima en " +list_2.getSelectedValue().toString());
					String txtClima = c.getTiempo() + "\n" +
							c.getTemperatura() + "\n" +
							c.getSensacionTermica() + "\n" +
							c.getHumedad() + "\n" +
							c.getVientos() + "\n" +
							c.getNubosidad();
					textAreaClima.setText(txtClima);
				}
			}
		});
		list_2.setBounds(10, 251, 567, 77);
		
		
		JScrollPane scrollPane_1 = new JScrollPane(list_2);
		scrollPane_1.setBounds(10, 251, 567, 77);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane_1);
		
		
		JButton btnBuscar_2 = new JButton("Buscar");
		btnBuscar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textCiudad.getText().equals("")) {
					ClimaInet clima = new ClimaInet(Internet.CLIMA);
					//clima.setKey_locale("7626");
					Clima c = clima.obtenerClima();
					lblClimaEn.setText("Por defecto se obtiene el clima en Buenos Aires");
					String txtClima = c.getTiempo() + "\n" +
							c.getTemperatura() + "\n" +
							c.getSensacionTermica() + "\n" +
							c.getHumedad() + "\n" +
							c.getVientos() + "\n" +
							c.getNubosidad();
					textAreaClima.setText(txtClima);
				}
				else {
					ClimaInet clima = new ClimaInet(textCiudad.getText(), Internet.BUSCAR_CIUDAD);
					if(!listaCiudades.isEmpty()) {
						for(int i = 0;i < listaCiudades.size();i++)
							listaCiudades.remove(i);
					}
					listaCiudades=clima.buscarCiudad();
					if(listaCiudades.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No se encontraron resultados para " + textCiudad.getText(), "Error", JOptionPane.PLAIN_MESSAGE);
					}
					else {
						DefaultListModel<String> listaModelo = new DefaultListModel<>();
						for (Ciudad ciudad : listaCiudades) {
							listaModelo.addElement(ciudad.getNombre() + ", " + ciudad.getRegion() + ", "+ 
													ciudad.getPais() + ", "+ ciudad.getProvincia());
						}
						list_2.setModel(listaModelo);
					}
				}


				
				
			}
		});
		btnBuscar_2.setBounds(337, 200, 89, 23);
		panel.add(btnBuscar_2);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Cotización", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblCompra = new JLabel("Compra:");
		lblCompra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompra.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCompra.setBounds(99, 68, 85, 41);
		panel_4.add(lblCompra);
		
		JLabel lblVenta = new JLabel("Venta:");
		lblVenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVenta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblVenta.setBounds(99, 133, 85, 41);
		panel_4.add(lblVenta);
		
		JLabel lblCotizacinDelDlar = new JLabel("Cotizaci\u00F3n del D\u00F3lar");
		lblCotizacinDelDlar.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCotizacinDelDlar.setBounds(12, 12, 272, 31);
		panel_4.add(lblCotizacinDelDlar);
		
		JLabel lblValorCompra = new JLabel("");
		lblValorCompra.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorCompra.setFont(new Font("Dialog", Font.BOLD, 18));
		lblValorCompra.setBounds(196, 68, 111, 41);
		panel_4.add(lblValorCompra);
		
		JLabel lblValorVenta = new JLabel("");
		lblValorVenta.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorVenta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblValorVenta.setBounds(196, 133, 111, 41);
		panel_4.add(lblValorVenta);
		
		JButton btnNewButton = new JButton("Obtener Cotizaci\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CotizacionInet cotiza = new CotizacionInet(Internet.COTIZACION);
				ArrayList<Cotizacion> listaCotizacion = new ArrayList<>();
				listaCotizacion = cotiza.obtenerCotizacion();
				for (Cotizacion cotizacion : listaCotizacion) {
					lblValorCompra.setText(cotizacion.getCompra());
					lblValorVenta.setText(cotizacion.getVenta());
				}
				
				
			}
		});
		btnNewButton.setBounds(196, 224, 212, 55);
		panel_4.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gifs", null, panel_2, null);
		
		JList list_3 = new JList();
		list_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int i = list_3.locationToIndex(e.getPoint());
					try {
						lblGif.setIcon(new ImageIcon(new URL(listaGifs.get(i))));
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		JScrollPane scrollPane_3 = new JScrollPane(list_3);
		scrollPane_3.setBounds(353, 12, 224, 180);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane_3);
		
		
		textBuscarGif = new JTextField();
		textBuscarGif.setBounds(353, 198, 223, 20);
		textBuscarGif.setColumns(10);
		
		JButton btnBuscarGif = new JButton("Buscar");
		btnBuscarGif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GifInet gif = new GifInet(textBuscarGif.getText(), Internet.GIF);
				
				listaGifs = gif.obtenerGif();
				DefaultListModel<String> listaModelo = new DefaultListModel<>();
				for (String string : listaGifs) {
					listaModelo.addElement(string);
				}
				list_3.setModel(listaModelo);
			}
		});
		btnBuscarGif.setBounds(402, 230, 135, 26);
		panel_2.setLayout(null);
		panel_2.add(scrollPane_3);
		panel_2.add(lblGif);
		panel_2.add(textBuscarGif);
		panel_2.add(btnBuscarGif);
		

		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Imagenes", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(299, 169, 69, 16);
		panel_1.add(lblCategoria);
		
		JLabel lblCategoriaImg = new JLabel("");
		lblCategoriaImg.setBounds(386, 169, 193, 16);
		panel_1.add(lblCategoriaImg);
		
		JLabel label9gag = new JLabel("");
		label9gag.setBounds(10, 11, 262, 239);
		//panel_1.add(label9gag);
		JScrollPane scrollPane_4 = new JScrollPane(label9gag);
		scrollPane_4.setBounds(10, 11, 262, 239);
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane_4);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int i = list.locationToIndex(e.getPoint());
					try {
						ImageIcon meme = new ImageIcon(new URL(listaImgsNine.get(i).getUrl()));
						Image img = meme.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
						meme = new ImageIcon(img);
						label9gag.setIcon(meme);
						
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		list.setBounds(299, 11, 280, 150);
		panel_1.add(list);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NineGag nine = new NineGag();
				NineGagInet nineInet = new NineGagInet(nine.getCategoria(), Internet.NINEGAG);
				listaImgsNine = nineInet.obtenerImgNineGag();
				String categoria = nine.getCategoria();
				if(!listaImgsNine.isEmpty()) {
					DefaultListModel<String> listaModelo = new DefaultListModel<>();
					for (NineGag nineGag : listaImgsNine) {
						listaModelo.addElement(nineGag.getUrl());
					}
					list.setModel(listaModelo);
					lblCategoriaImg.setText(categoria);
				}
				else {
					JOptionPane.showMessageDialog(null, "No se encontraron resultados para " + categoria, "Error", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		btnBuscar.setBounds(410, 211, 89, 23);
		panel_1.add(btnBuscar);
		
		JScrollPane scrollPane_2 = new JScrollPane(list);
		scrollPane_2.setBounds(299, 11, 280, 150);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane_2);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setBounds(300, 21, 273, 14);
		panel_3.add(lblFecha);
		
		JLabel label = new JLabel("");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JList list_1 = new JList();

		JLabel lblPrincipalesTtulos = new JLabel("");
		lblPrincipalesTtulos.setBounds(10, 22, 225, 14);
		panel_3.add(lblPrincipalesTtulos);
		
		JScrollPane scrollPane = new JScrollPane(list_1);
		scrollPane.setBounds(10, 48, 567, 99);

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_3.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Busqueda", null, panel_5, null);
		panel_5.setLayout(null);
		
		JTextArea textAreaResultadoBusqueda = new JTextArea();
		textAreaResultadoBusqueda.setLineWrap(true);
		textAreaResultadoBusqueda.setBounds(12, 12, 561, 85);
		panel_5.add(textAreaResultadoBusqueda);
		JButton btnBuscarInternet = new JButton("Buscar");
		
		btnBuscarInternet.setBounds(253, 178, 167, 26);
		panel_5.add(btnBuscarInternet);
		
		JLabel lblUrlInternet = new JLabel("");
		lblUrlInternet.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblUrlInternet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblUrlInternet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					if (desktop.isSupported(Desktop.Action.BROWSE))
						try {
							desktop.browse(new URI(lblUrlInternet.getText()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		});
		lblUrlInternet.setBounds(12, 133, 561, 16);
		panel_5.add(lblUrlInternet);
		
		textPalabraClave = new JTextField();
		textPalabraClave.setBounds(12, 181, 218, 20);
		panel_5.add(textPalabraClave);
		textPalabraClave.setColumns(10);
		
		btnBuscarInternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BusquedaInet b = new BusquedaInet(textPalabraClave.getText(), Internet.BUSQUEDA);
				ArrayList<Busqueda> resultado = b.obtenerBusqueda();
				
				textAreaResultadoBusqueda.setText(resultado.get(0).getExtracto());
				lblUrlInternet.setText(resultado.get(0).getUrl());
				
			}
		});

		
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList list = (JList)e.getSource();
				if(e.getClickCount() == 2) {
					int i = list.locationToIndex(e.getPoint());
					textArea.setText("");
					textArea.setText(listaNoticias.get(i).getDescripcion());
					lblUrl.setText(listaNoticias.get(i).getUrl());
					lblFecha.setText(listaNoticias.get(i).getFecha());
					lblPrincipalesTtulos.setText("");
					lblPrincipalesTtulos.setText("Principales títulos: " + listaNoticias.get(i).getAutor());
				}
			}
		});

		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaNoticias = new NoticiaInet(Internet.NOTICIA).obtenerNoticias();
				DefaultListModel<String> listaModelo = new DefaultListModel<>();
				for (Noticia noticia : listaNoticias) {
					listaModelo.addElement(noticia.getTitulo());
				}
				list_1.setModel(listaModelo);
			}
		});
		
		JButton btnBuscar_1 = new JButton("Buscar");
	}
}
