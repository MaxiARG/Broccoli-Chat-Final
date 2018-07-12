package inet;

import java.util.ArrayList;

import util.NineGag;

public class NineGagInet extends Internet {

	
	public NineGagInet(String palabraClave, int indice) {
		super(palabraClave, indice);
	}
	
	
	public boolean jsonValido() {
		String json = obtenerJson();
		int principio, fin;
		String direccion="";
		if(json != null){
			if (json.indexOf("\"data\":") != -1) {
				while (json.contains("\"type\":\"Photo\"") ){
					json = json.substring(json.indexOf("\"type\":\"Photo\""));
					fin = json.indexOf(".jpg") + 4;
					principio = json.indexOf("\"url\":\"");
					direccion = json.substring(principio+7, fin);
					direccion = direccion.replace("\\", "") ;
					json = json.substring(fin);
					if(direccion.equals(""))
						return false;
				}
			}
		}
		return true;
	}
	
	public ArrayList<NineGag> obtenerImgNineGag(){
		ArrayList<NineGag> listaImgs = new ArrayList<>();
		String json = obtenerJson();
		int principio, fin;
		String direccion="";
		if(json != null){
			if (json.indexOf("\"data\":") != -1) {
				while (json.contains("\"type\":\"Photo\"") ){
					json = json.substring(json.indexOf("\"type\":\"Photo\""));
					fin = json.indexOf(".jpg") + 4;
					principio = json.indexOf("\"url\":\"");
					direccion = json.substring(principio+7, fin);
					direccion = direccion.replace("\\", "") ;
					json = json.substring(fin);
					if(direccion.equals("") == false)
						listaImgs.add(new NineGag(direccion));
				}
			}
		}
		return listaImgs;
	}
}	
