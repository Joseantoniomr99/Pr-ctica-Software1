package blastGUI;
import java.awt.*;


import javax.swing.*;
public class Panel extends JPanel {
	
	//Elementos para el panel de seleccion de datos de la proteina:
	private JRadioButton rbprot;
	private JRadioButton rbnucleotido;
	private JComboBox<String> cbseq;
	private JLabel Porcentaje;
	private JTextField tpercent;
	private JLabel lprot;
	private JLabel lnucleotido;
	private JLabel listasecuencias;
	private JButton bexecutequery;
	
	//Elementos para el panel de base de datos:
	private JComboBox<String> cb_indices;
	private JComboBox<String> cb_bd;
	private JLabel lindice;
	private JLabel ldatos;
	
	//Panel del resultado
	private JTextArea taresultado;
	private JScrollPane spresultado;
	
	//Paneles
	private JPanel pselectdatos;
	private JPanel pbd;
	private JPanel pprincipal;
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public void crearPanel() {
	//Inicializamos los elementos del panel de seleccion de datos y los añadimos
		
	pselectdatos = new JPanel();
	rbprot = new JRadioButton();
	rbnucleotido = new JRadioButton();
	cbseq = new JComboBox<String>();
	cbseq.setEditable(true);
	Porcentaje = new JLabel("Porcentaje de similaridad");
	tpercent = new JTextField();
	lprot = new JLabel("Pasar a proteinas");
	lnucleotido = new JLabel("Pasar a nucleótidos");
	listasecuencias = new JLabel("Lista de secuencias:");
	
	pselectdatos.setLayout(new GridLayout(4,2));
	pselectdatos.add(lprot);
	pselectdatos.add(lnucleotido);
	pselectdatos.add(rbprot);
	pselectdatos.add(rbnucleotido);
	pselectdatos.add(listasecuencias);
	pselectdatos.add(Porcentaje);
	pselectdatos.add(cbseq);
	pselectdatos.add(tpercent);
	
	
	//inicializamos los elementos del panel de la base de datos y los añadimos
	pbd = new JPanel();
	pbd.setLayout(new GridLayout(2,2));
	cb_indices = new JComboBox<String>();
	cb_indices.addItem("yeast.aa.indexs");
	cb_bd = new JComboBox<String>();
	cb_bd.addItem("yeast.aa");
	lindice = new JLabel("Índices de la base de datos");
	ldatos = new JLabel("Base de datos");
	
	pbd.add(lindice);
	pbd.add(ldatos);
	pbd.add(cb_indices);
	pbd.add(cb_bd);
	
	
	//Botón con el que se lleva a cabo la consulta(Va a estar dentro del panel principal)
	bexecutequery = new JButton("Ejecutar consulta");

	//Se define el panel principal donde se van a introducir los otros dos paneles y el botón de ejecutar consulta
	pprincipal = new JPanel();
	pprincipal.setLayout(new GridLayout(3,1));
	pprincipal.add(pselectdatos);
	pprincipal.add(pbd);
	pprincipal.add(bexecutequery);
	
	//Se inicializa la zona de texto en donde se mostrará el resultado:
	taresultado = new JTextArea(30,30);
	spresultado = new JScrollPane(taresultado);
	
	//Finalmente se añaden a la propia clase los dos paneles:
	this.add(pprincipal);
	this.add(spresultado);
	}
	
	//Getters necesitados:

	public JRadioButton getRbprot() {
		return rbprot;
	}
	public JRadioButton getRbnucleotido() {
		return rbnucleotido;
	}
	public JComboBox<String> getCb() {
		return cbseq;
	}
	public JTextField getTpercent() {
		return tpercent;
	}
	public JButton getBexecutequery() {
		return bexecutequery;
	}
	public JComboBox<String> getCb_indices() {
		return cb_indices;
	}
	public JComboBox<String> getCb_bd() {
		return cb_bd;
	}
	public JTextArea getTaresultado() {
		return taresultado;
	}
}
