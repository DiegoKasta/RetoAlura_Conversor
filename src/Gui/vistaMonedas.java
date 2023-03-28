package Gui;

import Class.clsMoneda;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.DropMode;
import javax.swing.JTextField;

public class vistaMonedas extends JFrame implements KeyListener, ActionListener {

	private JPanel contentPane;
	private JFormattedTextField TextValorA, TextValorB;
	private JComboBox cbCambioA,cbCambioB;
	private clsMoneda moneda;
	private boolean ctrlfalla=false;
	footer pie=new footer();
	private JLabel lblNewLabel_4;
	private JTextField textField;
	
	public vistaMonedas() {
		setFont(new Font("Arial", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(vistaMonedas.class.getResource("/img/logo.png")));
		setResizable(false);
		incioComponentes();
		setLocationRelativeTo(null);
	}
	private void incioComponentes() {
		setBounds(100, 100, 410, 239);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(vistaMonedas.class.getResource("/img/money.png")));
		lblNewLabel_4.setBounds(31, 0, 68, 55);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Ingresa el valor deseado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 374, 25);
		contentPane.add(lblNewLabel);
		
		TextValorA = new JFormattedTextField();
		TextValorA.setDropMode(DropMode.INSERT);
		TextValorA.setToolTipText("Ingrese el valor");
		TextValorA.setText("0");
		TextValorA.addKeyListener(this);
		TextValorA.setBounds(33, 78, 120, 22);
		contentPane.add(TextValorA);
		
		TextValorB = new JFormattedTextField();
		TextValorB.setDropMode(DropMode.INSERT);
		TextValorB.setEditable(false);
		TextValorB.setToolTipText("Dato de salida");
		TextValorB.setBounds(33, 121, 120, 22);
		contentPane.add(TextValorB);
		
		cbCambioA = new JComboBox();
		cbCambioA.setModel(new DefaultComboBoxModel(new String[] {
				"Peso Colombiano", "Dólar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won sul-coreano"}));
		cbCambioA.setSelectedIndex(0);
		cbCambioA.addActionListener(this);
		cbCambioA.setBounds(248, 78, 120, 22);
		contentPane.add(cbCambioA);
		
		cbCambioB = new JComboBox();
		cbCambioB.setModel(new DefaultComboBoxModel(new String[] {
				"Peso Colombiano", "Dólar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won sul-coreano"}));
		cbCambioB.setSelectedIndex(1);
		cbCambioB.addActionListener(this);
		cbCambioB.setBounds(248, 121, 120, 22);
		contentPane.add(cbCambioB);
		
		JLabel lblNewLabel_1 = new JLabel("Valor en");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(153, 82, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel footer = new JLabel(pie.getFooter());
		footer.setFont(new Font("Tahoma", Font.PLAIN, 9));
		footer.setHorizontalAlignment(SwingConstants.CENTER);
		footer.setBounds(10, 175, 374, 14);
		footer.setForeground(new Color(64, 224, 208));
		contentPane.add(footer);
			
		JLabel lblNewLabel_2 = new JLabel("Cambiado a");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(153, 125, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Conversor de Monedas");
		lblNewLabel_3.setIcon(null);
		lblNewLabel_3.setForeground(new Color(64, 224, 208));
		lblNewLabel_3.setFont(new Font("Consolas", lblNewLabel_3.getFont().getStyle() | Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 374, 29);
		contentPane.add(lblNewLabel_3);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub teclas especiales como F1, F2
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub presiona una tecla
		
	}
	@Override
	public void keyReleased(KeyEvent e) { 
		// TODO Auto-generated method stub libera una tecla
		try {
			if (e.getSource()==TextValorA) {
				moneda = new clsMoneda(Double.parseDouble(TextValorA.getText()));
				ctrlfalla=true;
				ejecuta();
			}
		} catch (Exception es ) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(this,"Datos invalidos");
			ctrlfalla=false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (moneda!=null & ctrlfalla) {
			if (e.getSource()==cbCambioA|e.getSource()==cbCambioB) {
				ejecuta();
			}
		}	
	}
	
	private void ejecuta() {
		moneda.validacion(cbCambioA.getSelectedIndex());
		moneda.pesoColombiano();				
		moneda.validacion(cbCambioB.getSelectedIndex());
		moneda.otraMoneda();
		TextValorB.setText(moneda.otraMoneda());
		TextValorB.setToolTipText(moneda.getMensaje());
		//TextValorA.setText(String.valueOf(moneda.getMoneda()));
	}
}
