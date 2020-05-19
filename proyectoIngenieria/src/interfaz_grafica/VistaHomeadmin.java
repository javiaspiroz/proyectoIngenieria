package interfaz_grafica;

import proyectoIngenieria.PowerUser;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class VistaHomeadmin extends JFrame {

	
	private JPanel contentPane;
	private PowerUser user;

	private JTable table;
	private JTable tabledoc;

	// private JPanel contentPane;
	private JPanel cardspanel;
	private CardLayout cl;
	private JTextField txtBsqueda;
	private JButton btn_Home;
	private JButton btn_buscar;
	private JButton btnPacientes;
	private JButton btnCerrarSesin;
	private JButton btnDoctores;
	private JButton btnCuenta;
	private ButtonGroup botones = new ButtonGroup();
	private JTextField txtNombre_Pac;
	private JTextField txtApellido__Pac;
	private JTextField txtDni_Pac;
	private JTextField txtTelefono_Pac;
	private JTextField txtEmail_Pac;
	private JTextField txtDireccion_Pac;
	private JTextField txtNssocial_Pac;
	private JTextField txtDnibusca_Pac;
	private JTextField txtDniagregar_pac;
	private JTextField txtDiagnostici_Pac;
	private JTextField txtMedicina_Pac;
	private JTextField txtNombre_Doc;
	private JTextField txtApellido_Doc;
	private JTextField txtDni_Doc;
	private JTextField txtTelefono_Doc;
	private JTextField txtEmail_Doc;
	private JTextField txtDireccion_Doc;
	private JTextField txtDnibuscar_Doc;
	private JTextField txtDniPacAgregar_Doc;
	private JTextField txtDniDocAgregar_Doc;

	/**
	 * Create the frame.
	 */
	public VistaHomeadmin(PowerUser user) {
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel bg = new JPanel();
		bg.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bg.setBackground(new Color(192, 192, 192));
		contentPane.add(bg);
		bg.setLayout(null);

		JPanel sidemenu = new JPanel();
		sidemenu.setBackground(new Color(128, 0, 0));
		sidemenu.setBounds(6, 6, 225, 527);
		bg.add(sidemenu);
		sidemenu.setLayout(null);

		JLabel lblBienvenido = new JLabel("BIENVENIDO Al SISTEMA");
		lblBienvenido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setBounds(6, 22, 213, 27);
		sidemenu.add(lblBienvenido);

		btn_Home = new JButton("Home");
		btn_Home.setActionCommand("pantalla_home");
		btn_Home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Home.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btn_Home.setIcon(new ImageIcon(VistaHomeadmin.class.getResource("/interfaz_grafica/home.png")));
		btn_Home.setBounds(25, 90, 174, 38);
		sidemenu.add(btn_Home);

		btn_buscar = new JButton("Buscar");
		btn_buscar.setActionCommand("pantalla_buscar");
		btn_buscar.setIcon(new ImageIcon(VistaHomeadmin.class.getResource("/interfaz_grafica/search.png")));
		btn_buscar.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btn_buscar.setBounds(25, 150, 174, 38);
		sidemenu.add(btn_buscar);

		btnPacientes = new JButton("Pacientes");
		btnPacientes.setActionCommand("pantalla_pacientes");
		btnPacientes.setIcon(new ImageIcon(VistaHomeadmin.class.getResource("/interfaz_grafica/icons8-user-male-25.png")));
		btnPacientes.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnPacientes.setBounds(25, 211, 174, 38);
		sidemenu.add(btnPacientes);

		JLabel lblName = new JLabel(user.getNombre().toUpperCase() + " " + user.getApellido().toUpperCase());
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(6, 41, 213, 27);
		sidemenu.add(lblName);

		btnDoctores = new JButton("Doctores");
		btnDoctores.setActionCommand("pantalla_doctores");
		btnDoctores.setIcon(new ImageIcon(VistaHomeadmin.class.getResource("/interfaz_grafica/icons8-medical-doctor-25.png")));
		btnDoctores.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnDoctores.setBounds(25, 273, 174, 38);
		sidemenu.add(btnDoctores);

		btnCuenta = new JButton("Cuenta");
		btnCuenta.setActionCommand("pantalla_cuenta");
		btnCuenta.setIcon(new ImageIcon(VistaHomeadmin.class.getResource("/interfaz_grafica/configuracion.png")));
		btnCuenta.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnCuenta.setBounds(25, 335, 174, 38);
		sidemenu.add(btnCuenta);

		btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.setActionCommand("cerrar_sesion_admin");
		btnCerrarSesin.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnCerrarSesin.setBounds(25, 437, 174, 38);
		sidemenu.add(btnCerrarSesin);

		cardspanel = new JPanel();
		cardspanel.setBounds(241, 6, 576, 527);
		bg.add(cardspanel);
		cardspanel.setLayout(new CardLayout(0, 0));
		cl = (CardLayout) cardspanel.getLayout();

		JPanel panel_Home = new JPanel();
		cardspanel.add(panel_Home, "pantalla_home");
		panel_Home.setLayout(null);

		JLabel lblHome = new JLabel("HOME");
		lblHome.setFont(new Font("Thonburi", Font.BOLD, 30));
		lblHome.setBounds(239, 6, 98, 42);
		panel_Home.add(lblHome);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 221, 513, 300);
		panel_Home.add(tabbedPane);

		JPanel mostrarDocs = new JPanel();
		tabbedPane.addTab("Doctores", null, mostrarDocs, null);
		mostrarDocs.setLayout(null);

		tabledoc = new JTable(10, 10);
		// --------------- Scroll para la tabla --------------- //
		tabledoc.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Sin esto, el scroll no va
		JScrollPane scrollPane = new JScrollPane(tabledoc);
		// --------------- Scroll para la tabla --------------- //
		scrollPane.setBounds(0, 0, 485, 220);
		mostrarDocs.add(scrollPane, "cell 1 1 31 21,grow");

		JButton btnExportar = new JButton("Exportar csv");
		btnExportar.setBounds(368, 225, 117, 29);
		mostrarDocs.add(btnExportar);

		JPanel mostrarPac = new JPanel();
		tabbedPane.addTab("Pacientes", null, mostrarPac, null);
		mostrarPac.setLayout(null);

		table = new JTable(10, 10);
		// --------------- Scroll para la tabla --------------- //
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Sin esto, el scroll no va
		JScrollPane scrollPane_1 = new JScrollPane(table);
		// --------------- Scroll para la tabla --------------- //
		scrollPane_1.setBounds(0, 0, 485, 220);
		mostrarPac.add(scrollPane_1, "cell 1 1 31 21,grow");

		JButton button = new JButton("Exportar csv");
		button.setBounds(368, 225, 117, 29);
		mostrarPac.add(button);

		JButton btnImportarCsv = new JButton("Importar csv");
		btnImportarCsv.setBounds(252, 225, 117, 29);
		mostrarPac.add(btnImportarCsv);

		JLabel lblEstadisticas = new JLabel("Estadísticas:");
		lblEstadisticas.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblEstadisticas.setBounds(38, 51, 114, 16);
		panel_Home.add(lblEstadisticas);

		JLabel lblNumeroTotalDoc = new JLabel("Numero total de doctores: " + user.getHospital().getDoctores().size());
		lblNumeroTotalDoc.setBounds(38, 71, 229, 16);
		panel_Home.add(lblNumeroTotalDoc);

		JLabel lblNumeroTotalPac = new JLabel("Numero total de pacientes: " + user.getHospital().getPacientes().size());
		lblNumeroTotalPac.setBounds(38, 91, 229, 16);
		panel_Home.add(lblNumeroTotalPac);

		JLabel lblPacientesPorrea = new JLabel("-Pacientes por área:");
		lblPacientesPorrea.setBounds(38, 119, 229, 16);
		panel_Home.add(lblPacientesPorrea);

		JLabel lblOncologia = new JLabel("ONCOLOGIA:");
		lblOncologia.setBounds(48, 138, 139, 16);
		panel_Home.add(lblOncologia);

		JLabel lblOftalmologia = new JLabel("OFTALMOLOGIA:");
		lblOftalmologia.setBounds(48, 156, 139, 16);
		panel_Home.add(lblOftalmologia);

		JLabel lblTraumatologa = new JLabel("TRAUMATOLOGÍA:");
		lblTraumatologa.setBounds(48, 174, 154, 16);
		panel_Home.add(lblTraumatologa);

		JLabel lblPediatria = new JLabel("PEDIATRIA:");
		lblPediatria.setBounds(283, 138, 154, 16);
		panel_Home.add(lblPediatria);

		JLabel lblCardiologia = new JLabel("CARDIOLOGIA:");
		lblCardiologia.setBounds(283, 156, 154, 16);
		panel_Home.add(lblCardiologia);

		JLabel lblDermatologia = new JLabel("DERMATOLOGIA:");
		lblDermatologia.setBounds(283, 174, 154, 16);
		panel_Home.add(lblDermatologia);

		JLabel lblGinecologa = new JLabel("GINECOLOGÍA:");
		lblGinecologa.setBounds(48, 193, 154, 16);
		panel_Home.add(lblGinecologa);

		JLabel lblGeriatria = new JLabel("GERIATRIA:");
		lblGeriatria.setBounds(283, 193, 154, 16);
		panel_Home.add(lblGeriatria);

		JPanel panel_Pacientes = new JPanel();
		cardspanel.add(panel_Pacientes, "pantalla_pacientes");
		panel_Pacientes.setLayout(null);

		JLabel lblPacientes = new JLabel("PACIENTES");
		lblPacientes.setFont(new Font("Thonburi", Font.BOLD, 30));
		lblPacientes.setBounds(204, 6, 168, 42);
		panel_Pacientes.add(lblPacientes);

		JLabel lblDarDeAlta = new JLabel("Dar de alta de paciente: ");
		lblDarDeAlta.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDarDeAlta.setBounds(22, 62, 216, 16);
		panel_Pacientes.add(lblDarDeAlta);

		JLabel lblIngresarDni = new JLabel("Nombre:");
		lblIngresarDni.setBounds(22, 92, 60, 16);
		panel_Pacientes.add(lblIngresarDni);

		txtNombre_Pac = new JTextField();
		txtNombre_Pac.setBounds(81, 87, 195, 26);
		panel_Pacientes.add(txtNombre_Pac);
		txtNombre_Pac.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(22, 120, 60, 16);
		panel_Pacientes.add(lblApellido);

		txtApellido__Pac = new JTextField();
		txtApellido__Pac.setColumns(10);
		txtApellido__Pac.setBounds(81, 115, 195, 26);
		panel_Pacientes.add(txtApellido__Pac);

		JLabel lblFechaDeNacimiento = new JLabel("Dia de nacimiento:");
		lblFechaDeNacimiento.setBounds(22, 148, 123, 16);
		panel_Pacientes.add(lblFechaDeNacimiento);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(288, 92, 34, 16);
		panel_Pacientes.add(lblDni);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		comboBox_1.setBounds(149, 144, 72, 27);
		panel_Pacientes.add(comboBox_1);

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre" }));
		comboBox_2.setBounds(224, 144, 126, 27);
		panel_Pacientes.add(comboBox_2);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] { "Año", "2020", "2019", "2018", "2017", "2016",
				"2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "1995", "1994",
				"1993", "1992", "1991", "1990" }));
		comboBox_3.setBounds(350, 144, 88, 27);
		panel_Pacientes.add(comboBox_3);

		txtDni_Pac = new JTextField();
		txtDni_Pac.setColumns(10);
		txtDni_Pac.setBounds(356, 87, 160, 26);
		panel_Pacientes.add(txtDni_Pac);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(288, 115, 62, 16);
		panel_Pacientes.add(lblTelefono);

		txtTelefono_Pac = new JTextField();
		txtTelefono_Pac.setColumns(10);
		txtTelefono_Pac.setBounds(356, 110, 160, 26);
		panel_Pacientes.add(txtTelefono_Pac);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(22, 208, 60, 16);
		panel_Pacientes.add(lblEmail);

		txtEmail_Pac = new JTextField();
		txtEmail_Pac.setColumns(10);
		txtEmail_Pac.setBounds(91, 203, 292, 26);
		panel_Pacientes.add(txtEmail_Pac);

		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(22, 236, 72, 16);
		panel_Pacientes.add(lblDireccin);

		txtDireccion_Pac = new JTextField();
		txtDireccion_Pac.setColumns(10);
		txtDireccion_Pac.setBounds(91, 231, 292, 26);
		panel_Pacientes.add(txtDireccion_Pac);

		JLabel lblNSeguridadSocial = new JLabel("N seguridad social:");
		lblNSeguridadSocial.setBounds(22, 181, 126, 16);
		panel_Pacientes.add(lblNSeguridadSocial);

		txtNssocial_Pac = new JTextField();
		txtNssocial_Pac.setColumns(10);
		txtNssocial_Pac.setBounds(149, 176, 234, 26);
		panel_Pacientes.add(txtNssocial_Pac);

		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setBounds(399, 231, 117, 29);
		panel_Pacientes.add(btnDarDeAlta);

		JLabel lblDarDeBaja = new JLabel("Dar de baja a paciente: ");
		lblDarDeBaja.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDarDeBaja.setBounds(22, 269, 216, 16);
		panel_Pacientes.add(lblDarDeBaja);

		JLabel label = new JLabel("DNI:");
		label.setBounds(22, 297, 34, 16);
		panel_Pacientes.add(label);

		txtDnibusca_Pac = new JTextField();
		txtDnibusca_Pac.setColumns(10);
		txtDnibusca_Pac.setBounds(55, 292, 160, 26);
		panel_Pacientes.add(txtDnibusca_Pac);

		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setBounds(222, 292, 117, 29);
		panel_Pacientes.add(btnBuscar_1);

		JTextPane textPane = new JTextPane();
		textPane.setText("Resultado de la busqueda...");
		textPane.setForeground(Color.LIGHT_GRAY);
		textPane.setEditable(false);
		textPane.setBounds(22, 325, 514, 26);
		panel_Pacientes.add(textPane);

		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.setBounds(350, 292, 117, 29);
		panel_Pacientes.add(btnDarDeBaja);

		JLabel lblAsignarDoctorA = new JLabel("Agregar cita al paciente:");
		lblAsignarDoctorA.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblAsignarDoctorA.setBounds(22, 371, 216, 16);
		panel_Pacientes.add(lblAsignarDoctorA);

		JLabel lblDniPaciente = new JLabel("DNI Paciente:");
		lblDniPaciente.setBounds(22, 394, 88, 16);
		panel_Pacientes.add(lblDniPaciente);

		txtDniagregar_pac = new JTextField();
		txtDniagregar_pac.setColumns(10);
		txtDniagregar_pac.setBounds(107, 389, 160, 26);
		panel_Pacientes.add(txtDniagregar_pac);

		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(279, 389, 117, 29);
		panel_Pacientes.add(button_1);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Resultado de la busqueda...");
		textPane_1.setForeground(Color.LIGHT_GRAY);
		textPane_1.setEditable(false);
		textPane_1.setBounds(22, 422, 514, 26);
		panel_Pacientes.add(textPane_1);

		JButton btnAgregarCita = new JButton("Agregar cita");
		btnAgregarCita.setBounds(419, 492, 117, 29);
		panel_Pacientes.add(btnAgregarCita);

		JLabel lblDniCita = new JLabel("Fecha cita: ");
		lblDniCita.setBounds(22, 498, 72, 16);
		panel_Pacientes.add(lblDniCita);

		txtDiagnostici_Pac = new JTextField();
		txtDiagnostici_Pac.setColumns(10);
		txtDiagnostici_Pac.setBounds(107, 456, 169, 26);
		panel_Pacientes.add(txtDiagnostici_Pac);

		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setModel(new DefaultComboBoxModel<String>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		comboBox_4.setBounds(91, 494, 72, 27);
		panel_Pacientes.add(comboBox_4);

		JComboBox <String>comboBox_5 = new JComboBox<String>();
		comboBox_5.setModel(new DefaultComboBoxModel<String>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre" }));
		comboBox_5.setBounds(166, 494, 126, 27);
		panel_Pacientes.add(comboBox_5);

		JComboBox<String> comboBox_6 = new JComboBox<String>();
		comboBox_6.setModel(new DefaultComboBoxModel<String>(new String[] { "Año", "2020", "2019", "2018", "2017", "2016",
				"2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "1995", "1994",
				"1993", "1992", "1991", "1990" }));
		comboBox_6.setBounds(292, 494, 88, 27);
		panel_Pacientes.add(comboBox_6);

		JLabel lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setBounds(22, 460, 88, 16);
		panel_Pacientes.add(lblDiagnostico);

		txtMedicina_Pac = new JTextField();
		txtMedicina_Pac.setColumns(10);
		txtMedicina_Pac.setBounds(371, 454, 168, 26);
		panel_Pacientes.add(txtMedicina_Pac);

		JLabel lblMedicamento = new JLabel("Medicamento:");
		lblMedicamento.setBounds(279, 461, 88, 16);
		panel_Pacientes.add(lblMedicamento);

		JPanel panel_Buscar = new JPanel();
		cardspanel.add(panel_Buscar, "pantalla_buscar");
		panel_Buscar.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "-Elegir Filtro-", "Apellido", "Nombre", "Fecha de nacimiento", "Area", "DNI" }));
		comboBox.setBounds(27, 156, 155, 27);
		panel_Buscar.add(comboBox);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setFont(new Font("Thonburi", Font.BOLD, 30));
		lblBuscar.setBounds(223, 16, 129, 42);
		panel_Buscar.add(lblBuscar);

		JLabel lblElegirlista = new JLabel("Elegir en qué lista desea buscar:");
		lblElegirlista.setBounds(17, 67, 256, 16);
		panel_Buscar.add(lblElegirlista);

		JRadioButton rdbtnDoctores = new JRadioButton("Doctores");
		rdbtnDoctores.setBounds(27, 95, 141, 23);
		panel_Buscar.add(rdbtnDoctores);

		JRadioButton rdbtnPacientes = new JRadioButton("Pacientes");
		rdbtnPacientes.setBounds(173, 95, 141, 23);
		panel_Buscar.add(rdbtnPacientes);

		botones.add(rdbtnPacientes);
		botones.add(rdbtnDoctores);

		JLabel lblElegirElFiltro = new JLabel("Elegir el filtro para realizar la búsqueda:");
		lblElegirElFiltro.setBounds(17, 130, 256, 16);
		panel_Buscar.add(lblElegirElFiltro);

		JLabel lblEscribirLaBsqueda = new JLabel("Escribir la búsqueda:");
		lblEscribirLaBsqueda.setBounds(17, 195, 256, 16);
		panel_Buscar.add(lblEscribirLaBsqueda);

		txtBsqueda = new JTextField();
		txtBsqueda.setForeground(Color.LIGHT_GRAY);
		txtBsqueda.setBounds(27, 216, 246, 26);
		panel_Buscar.add(txtBsqueda);
		txtBsqueda.setColumns(10);

		JLabel lblResultadoDeLa = new JLabel("Resultado de la búsqueda: ");
		lblResultadoDeLa.setBounds(17, 295, 256, 16);
		panel_Buscar.add(lblResultadoDeLa);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(19, 254, 117, 29);
		panel_Buscar.add(btnBuscar);

		JTextPane txtpnResultadoDeLa = new JTextPane();
		txtpnResultadoDeLa.setEditable(false);
		txtpnResultadoDeLa.setForeground(Color.LIGHT_GRAY);
		txtpnResultadoDeLa.setText("Resultado de la busqueda...");
		txtpnResultadoDeLa.setBounds(27, 323, 514, 179);
		panel_Buscar.add(txtpnResultadoDeLa);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaHomeadmin.class.getResource("/interfaz_grafica/ClinicIcon.png")));
		lblNewLabel.setBounds(326, 67, 215, 207);
		panel_Buscar.add(lblNewLabel);

		JPanel panel_Doctor = new JPanel();
		panel_Doctor.setLayout(null);
		cardspanel.add(panel_Doctor, "pantalla_doctores");

		JLabel lblDoctores = new JLabel("DOCTORES");
		lblDoctores.setFont(new Font("Thonburi", Font.BOLD, 30));
		lblDoctores.setBounds(204, 6, 168, 42);
		panel_Doctor.add(lblDoctores);

		JLabel lblDarDeAlta_1 = new JLabel("Dar de alta a doctor: ");
		lblDarDeAlta_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDarDeAlta_1.setBounds(22, 62, 216, 16);
		panel_Doctor.add(lblDarDeAlta_1);

		JLabel label_3 = new JLabel("Nombre:");
		label_3.setBounds(22, 92, 60, 16);
		panel_Doctor.add(label_3);

		txtNombre_Doc = new JTextField();
		txtNombre_Doc.setColumns(10);
		txtNombre_Doc.setBounds(81, 87, 195, 26);
		panel_Doctor.add(txtNombre_Doc);

		JLabel label_4 = new JLabel("Apellido:");
		label_4.setBounds(22, 120, 60, 16);
		panel_Doctor.add(label_4);

		txtApellido_Doc = new JTextField();
		txtApellido_Doc.setColumns(10);
		txtApellido_Doc.setBounds(81, 115, 195, 26);
		panel_Doctor.add(txtApellido_Doc);

		JLabel label_5 = new JLabel("Dia de nacimiento:");
		label_5.setBounds(22, 148, 123, 16);
		panel_Doctor.add(label_5);

		JLabel label_6 = new JLabel("DNI:");
		label_6.setBounds(288, 92, 34, 16);
		panel_Doctor.add(label_6);

		JComboBox<String> comboBox_7 = new JComboBox<String>();
		comboBox_7.setModel(new DefaultComboBoxModel<String>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		comboBox_7.setBounds(149, 144, 72, 27);
		panel_Doctor.add(comboBox_7);

		JComboBox<String> comboBox_8 = new JComboBox<String>();
		comboBox_8.setModel(new DefaultComboBoxModel<String>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre" }));
		comboBox_8.setBounds(224, 144, 126, 27);
		panel_Doctor.add(comboBox_8);

		JComboBox<String> comboBox_9 = new JComboBox<String>();
		comboBox_9.setModel(new DefaultComboBoxModel<String>(new String[] { "Año", "2020", "2019", "2018", "2017", "2016",
				"2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "1995", "1994",
				"1993", "1992", "1991", "1990" }));
		comboBox_9.setBounds(350, 144, 88, 27);
		panel_Doctor.add(comboBox_9);

		txtDni_Doc = new JTextField();
		txtDni_Doc.setColumns(10);
		txtDni_Doc.setBounds(356, 87, 160, 26);
		panel_Doctor.add(txtDni_Doc);

		JLabel label_7 = new JLabel("Telefono:");
		label_7.setBounds(288, 115, 62, 16);
		panel_Doctor.add(label_7);

		txtTelefono_Doc = new JTextField();
		txtTelefono_Doc.setColumns(10);
		txtTelefono_Doc.setBounds(356, 110, 160, 26);
		panel_Doctor.add(txtTelefono_Doc);

		JLabel label_8 = new JLabel("Email:");
		label_8.setBounds(22, 208, 60, 16);
		panel_Doctor.add(label_8);

		txtEmail_Doc = new JTextField();
		txtEmail_Doc.setColumns(10);
		txtEmail_Doc.setBounds(91, 203, 292, 26);
		panel_Doctor.add(txtEmail_Doc);

		JLabel label_9 = new JLabel("Dirección:");
		label_9.setBounds(22, 236, 72, 16);
		panel_Doctor.add(label_9);

		txtDireccion_Doc = new JTextField();
		txtDireccion_Doc.setColumns(10);
		txtDireccion_Doc.setBounds(91, 231, 292, 26);
		panel_Doctor.add(txtDireccion_Doc);

		JLabel lblEspecializacin = new JLabel("Especialización:");
		lblEspecializacin.setBounds(22, 181, 106, 16);
		panel_Doctor.add(lblEspecializacin);

		JButton button_2 = new JButton("Dar de alta");
		button_2.setBounds(399, 231, 117, 29);
		panel_Doctor.add(button_2);

		JLabel lblDarDeBaja_1 = new JLabel("Dar de baja a doctor: ");
		lblDarDeBaja_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDarDeBaja_1.setBounds(22, 269, 216, 16);
		panel_Doctor.add(lblDarDeBaja_1);

		JLabel label_12 = new JLabel("DNI:");
		label_12.setBounds(22, 297, 34, 16);
		panel_Doctor.add(label_12);

		txtDnibuscar_Doc = new JTextField();
		txtDnibuscar_Doc.setColumns(10);
		txtDnibuscar_Doc.setBounds(55, 292, 160, 26);
		panel_Doctor.add(txtDnibuscar_Doc);

		JButton button_3 = new JButton("Buscar");
		button_3.setBounds(222, 292, 117, 29);
		panel_Doctor.add(button_3);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Resultado de la busqueda...");
		textPane_2.setForeground(Color.LIGHT_GRAY);
		textPane_2.setEditable(false);
		textPane_2.setBounds(22, 325, 514, 26);
		panel_Doctor.add(textPane_2);

		JButton button_4 = new JButton("Dar de baja");
		button_4.setBounds(350, 292, 117, 29);
		panel_Doctor.add(button_4);

		JLabel lblAgregarPacienteA = new JLabel("Agregar/Eliminar paciente a doctor:");
		lblAgregarPacienteA.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblAgregarPacienteA.setBounds(22, 371, 283, 16);
		panel_Doctor.add(lblAgregarPacienteA);

		JLabel label_14 = new JLabel("DNI Paciente:");
		label_14.setBounds(22, 394, 88, 16);
		panel_Doctor.add(label_14);

		txtDniPacAgregar_Doc = new JTextField();
		txtDniPacAgregar_Doc.setColumns(10);
		txtDniPacAgregar_Doc.setBounds(107, 389, 160, 26);
		panel_Doctor.add(txtDniPacAgregar_Doc);

		JTextPane textPane_busquedaAgregar = new JTextPane();
		textPane_busquedaAgregar.setText("Resultado de la busqueda...");
		textPane_busquedaAgregar.setForeground(Color.LIGHT_GRAY);
		textPane_busquedaAgregar.setEditable(false);
		textPane_busquedaAgregar.setBounds(22, 448, 514, 42);
		panel_Doctor.add(textPane_busquedaAgregar);

		JButton btnAgregarPaciente = new JButton("Asignar paciente");
		btnAgregarPaciente.setBounds(398, 492, 138, 29);
		panel_Doctor.add(btnAgregarPaciente);

		JComboBox<String> comboBox_13 = new JComboBox<String>();
		comboBox_13.setModel(new DefaultComboBoxModel<String>(new String[] { "-Escoger área-", "Oncología", "Oftalmología",
				"Traumatología", "Ginecología", "Pediatria", "Cardiología", "Dermatología", "Geriatría" }));
		comboBox_13.setBounds(126, 176, 205, 27);
		panel_Doctor.add(comboBox_13);

		JLabel lblDniDoctor = new JLabel("DNI Doctor:");
		lblDniDoctor.setBounds(22, 418, 88, 16);
		panel_Doctor.add(lblDniDoctor);

		txtDniDocAgregar_Doc = new JTextField();
		txtDniDocAgregar_Doc.setColumns(10);
		txtDniDocAgregar_Doc.setBounds(107, 413, 160, 26);
		panel_Doctor.add(txtDniDocAgregar_Doc);

		JButton button_7 = new JButton("Buscar");
		button_7.setBounds(279, 413, 117, 29);
		panel_Doctor.add(button_7);

		JButton btnEliminarPaciente = new JButton("Eliminar paciente");
		btnEliminarPaciente.setBounds(258, 492, 138, 29);
		panel_Doctor.add(btnEliminarPaciente);

		JPanel panel_Cuenta = new JPanel();
		panel_Cuenta.setLayout(null);
		cardspanel.add(panel_Cuenta, "pantalla_cuenta");

		JLabel lblCuenta = new JLabel("CUENTA");
		lblCuenta.setFont(new Font("Thonburi", Font.BOLD, 30));
		lblCuenta.setBounds(223, 16, 129, 42);
		panel_Cuenta.add(lblCuenta);

		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(VistaHomeadmin.class.getResource("/interfaz_grafica/ClinicIcon.png")));
		label_15.setBounds(326, 67, 215, 207);
		panel_Cuenta.add(label_15);
	}

	// MVC
	public void addController(Controlador controlador) {
		btn_buscar.addActionListener(controlador);
		btn_Home.addActionListener(controlador);
		btnPacientes.addActionListener(controlador);
		btnDoctores.addActionListener(controlador);
		btnCuenta.addActionListener(controlador);

		btnCerrarSesin.addActionListener(controlador);
	}

	public void crearVista() {
		this.setVisible(true);
	}

	public void display(String pantalla) {
		cl.show(cardspanel, pantalla);
	}

	public void cerrarsesion() {
		JOptionPane.showMessageDialog(null, "Ha solicitado cerrar sesión.");
		this.setVisible(false);
	}

	public void refrescarTabla(char c) {

		String[][] data = user.getDatostabla(c);
		// Se genera array con los nombres de columnas
		String[] col_names = new String[data[0].length];
		for (int i = 0; i < col_names.length; i++) {
			col_names[i] = "" + (i + 1);
		}
		if (c == 'd') {
			// La clave para actualizar datos!
			DefaultTableModel model = (DefaultTableModel) this.tabledoc.getModel();
			model.setDataVector(data, col_names);
			this.tabledoc.repaint();

		} else if (c == 'p') {
			// La clave para actualizar datos!
			DefaultTableModel model = (DefaultTableModel) this.table.getModel();
			model.setDataVector(data, col_names);
			this.table.repaint();
		}
	}

}
