package com.salas;

import static com.Cliente.Cliente.nombreCliente;
import com.Cliente.EntradaSalida;
import com.mensajes.Comandos;
import com.mensajes.Mensaje;
import com.vista.GUI_Sala;

public class HiloOutputSala implements Runnable {

	GUI_Sala salaGUI;
	EntradaSalida entradaSalida;
	Sala sala;
	private boolean sigueCorriendo;

	public HiloOutputSala(GUI_Sala _salaGUI, Sala sala) {
		this.salaGUI = _salaGUI;
		this.sala = sala;
		entradaSalida = EntradaSalida.getInstance();
	}

	@Override
	public void run() {
		sigueCorriendo = true;
		StringBuilder strBuildrTexto;
		while (sigueCorriendo) {

			synchronized (this) {
				try {
					wait();
						
						String textoAEnviar =salaGUI.getChatTextBoxSala().getText();
						if(!textoAEnviar.trim().equals("")) {
						strBuildrTexto = new StringBuilder();
						strBuildrTexto.append(textoAEnviar.trim());
						
						Mensaje msjAEnviar=new Mensaje(Comandos.MensajeASala,
													   strBuildrTexto.toString(),
													   sala.getSalaID(),
													   nombreCliente);
						
						entradaSalida.escribirMensaje(msjAEnviar);
						salaGUI.getChatTextBoxSala().setText("");
						}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public boolean isSigueCorriendo() {
		return sigueCorriendo;
	}

	public void setSigueCorriendo(boolean sigueCorriendo) {
		this.sigueCorriendo = sigueCorriendo;
	}
	
	public void mandarMensaje(){
		synchronized(this){
			notify();
		}
	}

}