package interfaz_grafica;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.CardLayout;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Usuario extends JFrame {
	
	private JPanel cardPanel;
	private CardLayout cl;
	private JTextField txtusuario_pwuser;
	private JTextField txtusuario_user;
	private JPasswordField passwordField_user;
	private JPasswordField passwordField_pwuser;
	private JLabel salida_pwuser;
	private JLabel salida_user;
	private JButton btn_Admin;
	private JButton btn_doc;
	private JButton btn_entrar_pwuser;
	private JButton btn_volver_pwuser;
	private JButton btn_entrar_user;
	private JButton btn_volver_user;

	/**
	 * Create the frame.
	 */
	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 335);
		getContentPane().setLayout(null);
		
		cardPanel = new JPanel();
		cardPanel.setBounds(0, 0, 531, 313);
		getContentPane().add(cardPanel);
		cardPanel.setLayout(new CardLayout(0, 0));
		cl = (CardLayout) cardPanel.getLayout();
		
		
		JPanel escoger_user = new JPanel();
		cardPanel.add(escoger_user, "pantalla_inicio");
		escoger_user.setLayout(null);
		
		btn_Admin = new JButton("");
		btn_Admin.setActionCommand("pantalla_loginadmin");
		btn_Admin.setBounds(54, 100, 139, 129);
		escoger_user.add(btn_Admin);
		btn_Admin.setVerticalAlignment(SwingConstants.TOP);
		btn_Admin.setIcon(new ImageIcon(Usuario.class.getResource("/interfaz_grafica/admin.png")));
		
		btn_doc = new JButton("");
		btn_doc.setIcon(new ImageIcon(Usuario.class.getResource("/interfaz_grafica/userdoc.jpg")));
		btn_doc.setActionCommand("pantalla_logindoc");
		btn_doc.setVerticalAlignment(SwingConstants.TOP);
		btn_doc.setBounds(305, 100, 139, 129);
		escoger_user.add(btn_doc);
		
		JLabel lblHagaClickEn = new JLabel("Haga click en el perfil que desea acceder para inicar sesión");
		lblHagaClickEn.setBounds(63, 72, 381, 16);
		escoger_user.add(lblHagaClickEn);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(351, 229, 52, 16);
		escoger_user.add(lblDoctor);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setBounds(64, 231, 108, 16);
		escoger_user.add(lblAdministrador);
		lblAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel background = new JLabel("New label");
		background.setBounds(0, 0, 531, 313);
		escoger_user.add(background);
		background.setIcon(new ImageIcon(Usuario.class.getResource("/interfaz_grafica/Clinic.png")));
		
		JPanel login_admin = new JPanel();
		cardPanel.add(login_admin, "pantalla_loginadmin");
		login_admin.setLayout(null);
		
		JLabel label_pwuser = new JLabel("Usuario:");
		label_pwuser.setBounds(64, 104, 61, 16);
		login_admin.add(label_pwuser);
		
		JLabel lblpass_pwuser = new JLabel("Contraseña:");
		lblpass_pwuser.setBounds(64, 147, 81, 16);
		login_admin.add(lblpass_pwuser);
		
		txtusuario_pwuser = new JTextField();
		txtusuario_pwuser.setColumns(10);
		txtusuario_pwuser.setBounds(157, 99, 130, 26);
		login_admin.add(txtusuario_pwuser);
		
		passwordField_pwuser = new JPasswordField();
		passwordField_pwuser.setBounds(157, 142, 130, 26);
		login_admin.add(passwordField_pwuser);
		
		btn_entrar_pwuser = new JButton("Entrar");
		btn_entrar_pwuser.setActionCommand("login_admin");
		btn_entrar_pwuser.setBounds(218, 202, 117, 29);
		login_admin.add(btn_entrar_pwuser);
		
		btn_volver_pwuser = new JButton("Volver");
		btn_volver_pwuser.setActionCommand("pantalla_inicio");
		btn_volver_pwuser.setBounds(48, 202, 117, 29);
		login_admin.add(btn_volver_pwuser);
		
		salida_pwuser = new JLabel("");
		salida_pwuser.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		salida_pwuser.setBackground(new Color(128, 128, 128));
		salida_pwuser.setBounds(117, 253, 188, 26);
		login_admin.add(salida_pwuser);
		
		JLabel lbl_pic_pwuser = new JLabel("");
		lbl_pic_pwuser.setIcon(new ImageIcon(Usuario.class.getResource("/interfaz_grafica/admin.png")));
		lbl_pic_pwuser.setBounds(374, 82, 117, 122);
		login_admin.add(lbl_pic_pwuser);
		
		JLabel label_bg_pwuser = new JLabel("");
		label_bg_pwuser.setIcon(new ImageIcon(Usuario.class.getResource("/interfaz_grafica/Clinic.png")));
		label_bg_pwuser.setBounds(0, 0, 531, 313);
		login_admin.add(label_bg_pwuser);
		
		JPanel panel_doc = new JPanel();
		panel_doc.setLayout(null);
		cardPanel.add(panel_doc, "pantalla_logindoc");
		
		JLabel label_user = new JLabel("Usuario:");
		label_user.setBounds(64, 104, 61, 16);
		panel_doc.add(label_user);
		
		JLabel lblpass_user = new JLabel("Contraseña:");
		lblpass_user.setBounds(64, 147, 81, 16);
		panel_doc.add(lblpass_user);
		
		txtusuario_user = new JTextField();
		txtusuario_user.setColumns(10);
		txtusuario_user.setBounds(157, 99, 130, 26);
		panel_doc.add(txtusuario_user);
		
		passwordField_user = new JPasswordField();
		passwordField_user.setBounds(157, 142, 130, 26);
		panel_doc.add(passwordField_user);
		
		btn_entrar_user = new JButton("Entrar");
		btn_entrar_user.setActionCommand("login_user");
		btn_entrar_user.setBounds(218, 202, 117, 29);
		panel_doc.add(btn_entrar_user);
		
		btn_volver_user = new JButton("Volver");
		btn_volver_user.setActionCommand("pantalla_inicio");
		btn_volver_user.setBounds(48, 202, 117, 29);
		panel_doc.add(btn_volver_user);
		
		salida_user = new JLabel("");
		salida_user.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		salida_user.setBackground(Color.GRAY);
		salida_user.setBounds(117, 253, 188, 26);
		panel_doc.add(salida_user);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Usuario.class.getResource("/interfaz_grafica/userdoc.jpg")));
		label.setBounds(373, 82, 117, 122);
		panel_doc.add(label);
		
		JLabel label_bg_user = new JLabel("");
		label_bg_user.setIcon(new ImageIcon(Usuario.class.getResource("/interfaz_grafica/Clinic.png")));
		label_bg_user.setBounds(0, 0, 531, 313);
		panel_doc.add(label_bg_user);
		
		
	}
	
	//Getters y setters
	public JPanel getCardPanel() {
		return cardPanel;
	}

	public void setCardPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public CardLayout getCl() {
		return cl;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	public JTextField getTxtusuario_pwuser() {
		return txtusuario_pwuser;
	}

	public void setTxtusuario_pwuser(JTextField txtusuario_pwuser) {
		this.txtusuario_pwuser = txtusuario_pwuser;
	}

	public JTextField getTxtusuario_user() {
		return txtusuario_user;
	}

	public void setTxtusuario_user(JTextField txtusuario_user) {
		this.txtusuario_user = txtusuario_user;
	}

	public JPasswordField getPasswordField_user() {
		return passwordField_user;
	}

	public void setPasswordField_user(JPasswordField passwordField_user) {
		this.passwordField_user = passwordField_user;
	}

	public JPasswordField getPasswordField_pwuser() {
		return passwordField_pwuser;
	}

	public void setPasswordField_pwuser(JPasswordField passwordField_pwuser) {
		this.passwordField_pwuser = passwordField_pwuser;
	}

	public JLabel getSalida_pwuser() {
		return salida_pwuser;
	}

	public void setSalida_pwuser(JLabel salida_pwuser) {
		this.salida_pwuser = salida_pwuser;
	}

	public JLabel getSalida_user() {
		return salida_user;
	}

	public void setSalida_user(JLabel salida_user) {
		this.salida_user = salida_user;
	}

	public JButton getBtn_Admin() {
		return btn_Admin;
	}

	public void setBtn_Admin(JButton btn_Admin) {
		this.btn_Admin = btn_Admin;
	}

	public JButton getBtn_doc() {
		return btn_doc;
	}

	public void setBtn_doc(JButton btn_doc) {
		this.btn_doc = btn_doc;
	}

	public JButton getBtn_entrar_pwuser() {
		return btn_entrar_pwuser;
	}

	public void setBtn_entrar_pwuser(JButton btn_entrar_pwuser) {
		this.btn_entrar_pwuser = btn_entrar_pwuser;
	}

	public JButton getBtn_volver_pwuser() {
		return btn_volver_pwuser;
	}

	public void setBtn_volver_pwuser(JButton btn_volver_pwuser) {
		this.btn_volver_pwuser = btn_volver_pwuser;
	}

	public JButton getBtn_entrar_user() {
		return btn_entrar_user;
	}

	public void setBtn_entrar_user(JButton btn_entrar_user) {
		this.btn_entrar_user = btn_entrar_user;
	}

	public JButton getBtn_volver_user() {
		return btn_volver_user;
	}

	public void setBtn_volver_user(JButton btn_volver_user) {
		this.btn_volver_user = btn_volver_user;
	}

	// MVC
	public void addController(Controlador controlador) {
		btn_Admin.addActionListener(controlador);
		btn_doc.addActionListener(controlador);
		btn_entrar_pwuser.addActionListener(controlador);
		btn_volver_pwuser.addActionListener(controlador);
		btn_entrar_user.addActionListener(controlador);
		btn_volver_user.addActionListener(controlador);
	}

	public void crearVista() {
		this.setVisible(true);
	}
	
	public String getUser(char c) {
		if (c == 'd') {
			return txtusuario_pwuser.getText();
		} else if (c == 'p') {
			return txtusuario_user.getText();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public String getPassword(char c) {
		if (c == 'd') {
			return passwordField_pwuser.getText();
		} else if (c == 'p') {
			return passwordField_user.getText();
		}
		return null;
	}
	
	public void display(String pantalla) {
		cl.show(cardPanel, pantalla);
	}
	
	public void bienvenidaPWUser(boolean acceso) {
		if(acceso) {
			salida_pwuser.setText("Bienvenido!");
			JOptionPane.showMessageDialog(null, "Bienvenido al sistema administrador!");
			//Limpio todos los campos antes de desaparecer para que al cerrar sesion 
			//y vuleva a aparecer esta ventana, no aparezca lo de antes
			txtusuario_pwuser.setText("");
			passwordField_pwuser.setText("");
			salida_pwuser.setText("");
			//Desaparezco la ventana
			this.setVisible(false);
			display("pantalla_inicio");
			
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Error. \nUsuario o contraseña incorrectos");
			salida_pwuser.setText("Intente de nuevo");
		}
	}
	public void bienvenidaUser(boolean acceso) {
		if(acceso) {
			salida_pwuser.setText("Bienvenido!");
			JOptionPane.showMessageDialog(null, "Bienvenido al sistema Doctor!");
			//Limpio todos los campos antes de desaparecer para que al cerrar sesion 
			//y vuleva a aparecer esta ventana, no aparezca lo de antes
			txtusuario_user.setText("");
			passwordField_user.setText("");
			salida_user.setText("");
			//Desaparezco la ventana
			this.setVisible(false);
			display("pantalla_inicio");
			
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Error. \nUsuario o contraseña incorrectos");
			salida_pwuser.setText("Intente de nuevo");
		}
	}
}
