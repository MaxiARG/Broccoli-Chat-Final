package com.dataAccess;
//jdbc:h2:D:\Chat Iteracion Final Workspace 2\Servidor/ChatDB
public class TestHibernateORM {

	public static void main(String[] args) throws ClassNotFoundException {
			
		DAUsuario s= new DAUsuario();
		//s.almacenarUsuarioNuevo(new Usuario(88,"Gato", "Gato"));
		s.usuarioExistente("a");
	}

}