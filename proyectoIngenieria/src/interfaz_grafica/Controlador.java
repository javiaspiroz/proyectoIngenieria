package interfaz_grafica;

import proyectoIngenieria.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

//import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
	private Usuario vista;
	private VistaHomeadmin homeAdmin;
	private Hospital modelo_hosp;
	private PowerUser poweruser;
	//private Doctores user;
	
	public Controlador(Usuario vista, Hospital modelo_hosp) {
		this.vista = vista;
		this.modelo_hosp = modelo_hosp;
		this.poweruser = null;
		//this.user = null;

	}
	
	public void actionPerformed(ActionEvent evento) {
		if ( evento.getActionCommand().equals("login_admin")) {
			String user = vista.getUser('d');
			String pass = vista.getPassword('d');
			boolean acceso = false;
			Iterator <PowerUser> itr = modelo_hosp.getPowerUser().iterator();
			while (itr.hasNext()) {
				PowerUser actual = itr.next();
				if ( actual.getDni().equals(user) && actual.getContrasenia().equals(pass)) {
					acceso = true;
					this.poweruser = actual;
				}
			}
			vista.bienvenidaPWUser(acceso);
			if (acceso) {
				homeAdmin = new VistaHomeadmin(poweruser);
				// NUEVO: Se repinta la tabla con los datos del modelo
				this.homeAdmin.refrescarTabla('p');
				this.homeAdmin.refrescarTabla('d');
				homeAdmin.addController(this);
				homeAdmin.crearVista();
			}
		}
		else if ( evento.getActionCommand().equals("login_user")) {
			String user = vista.getUser('p');
			String pass = vista.getPassword('p');
			boolean acceso = false;
			Iterator <Doctores> itr = modelo_hosp.getDoctores().iterator();
			while (itr.hasNext()) {
				Doctores actual = itr.next();
				if ( actual.getDni().equals(user) && actual.getContrasena().equals(pass)) {
					acceso = true;
					//this.user = actual;
				}
			}
			vista.bienvenidaUser(acceso);
			if (acceso) {
				/*homeDoc = new Homedoc(user);
				homeDoc.addController(this);
				homeDoc.setVisible(true);*/
			}
		}
		else if (evento.getActionCommand().equals("pantalla_inicio")) {
			display("pantalla_inicio");
		}
		else if (evento.getActionCommand().equals("pantalla_loginadmin")) {
			display("pantalla_loginadmin");
		}
		else if (evento.getActionCommand().equals("pantalla_logindoc")) {
			display("pantalla_logindoc");
		}
		else if (evento.getActionCommand().equals("pantalla_home")) {
			homeAdmin.display("pantalla_home");
		}
		else if (evento.getActionCommand().equals("pantalla_buscar")) {
			homeAdmin.display("pantalla_buscar");
		}
		else if(evento.getActionCommand().equals("pantalla_pacientes")) {
			homeAdmin.display("pantalla_pacientes");
		}
		else if(evento.getActionCommand().equals("pantalla_doctores")) {
			homeAdmin.display("pantalla_doctores");
		}
		else if(evento.getActionCommand().equals("pantalla_cuenta")) {
			homeAdmin.display("pantalla_cuenta");
		}
		else if (evento.getActionCommand().equals("cerrar_sesion_admin")) {
			poweruser=null;
			homeAdmin.cerrarsesion();
			vista.crearVista();
		}
		
		
	}
	
	//Metodos de vista user
	public void display(String pantalla) {
		this.vista.getCl().show(vista.getCardPanel(), pantalla);
	}
	
	/*public void bienvenidaPWUser(boolean acceso) {
		if(acceso) {
			vista.getSalida_pwuser().setText("Bienvenido!");
			JOptionPane.showMessageDialog(null, "Bienvenido al sistema administrador!");
			//Limpio todos los campos antes de desaparecer para que al cerrar sesion 
			//y vuleva a aparecer esta ventana, no aparezca lo de antes
			vista.getTxtusuario_pwuser().setText("");
			vista.getPasswordField_pwuser().setText("");
			vista.getSalida_pwuser().setText("");
			//Desaparezco la ventana
			this.vista.setVisible(false);
			display("pantalla_inicio");
			
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Error. \nUsuario o contraseña incorrectos");
			vista.getSalida_pwuser().setText("Intente de nuevo");
		}
	}
	public void bienvenidaUser(boolean acceso) {
		if(acceso) {
			vista.getSalida_pwuser().setText("Bienvenido!");
			JOptionPane.showMessageDialog(null, "Bienvenido al sistema Doctor!");
			//Limpio todos los campos antes de desaparecer para que al cerrar sesion 
			//y vuleva a aparecer esta ventana, no aparezca lo de antes
			vista.getTxtusuario_user().setText("");
			vista.getPasswordField_user().setText("");
			vista.getSalida_user().setText("");
			//Desaparezco la ventana
			this.vista.setVisible(false);
			display("pantalla_inicio");
			
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Error. \nUsuario o contraseña incorrectos");
			vista.getSalida_pwuser().setText("Intente de nuevo");
		}
	}*/

}
