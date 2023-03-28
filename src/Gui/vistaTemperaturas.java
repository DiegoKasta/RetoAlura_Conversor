package Gui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Class.clsTemperatura;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class vistaTemperaturas extends JFrame implements KeyListener, ActionListener {

	private JPanel contentPane;
	private JFormattedTextField TextValorA, TextValorB;
	private JComboBox cbCambioA,cbCambioB;
	private clsTemperatura temperatura;
	private boolean ctrlfalla=false;
	footer pie=new footer();
	private JLabel lblIcono;
	
	public vistaTemperaturas() {
		setFont(new Font("Arial", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(vistaTemperaturas.class.getResource("/img/logo.png")));
		setResizable(false);
		incioComponentes();
		setLocationRelativeTo(null);
	}
	private void incioComponentes() {
		setBounds(100, 100, 410, 239);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextValorA = new JFormattedTextField();
		TextValorA.setDropMode(DropMode.INSERT);
		TextValorA.setToolTipText("Ingrese el valor");
		//TextValorA.setText("0");
		TextValorA.addKeyListener(this);
		
		lblIcono = new JLabel("");
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setIcon(new ImageIcon(vistaTemperaturas.class.getResource("/img/temperatura.png")));
		lblIcono.setBounds(30, 11, 65, 55);
		contentPane.add(lblIcono);
		TextValorA.setBounds(33, 86, 120, 22);
		contentPane.add(TextValorA);
		
		JLabel lblNewLabel = new JLabel("Ingresa el valor deseado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 50, 330, 25);
		contentPane.add(lblNewLabel);
		
		TextValorB = new JFormattedTextField();
		TextValorB.setDropMode(DropMode.INSERT);
		TextValorB.setEditable(false);
		TextValorB.setToolTipText("Dato de salida");
		TextValorB.setBounds(33, 131, 120, 22);
		contentPane.add(TextValorB);
		
		cbCambioA = new JComboBox();
		cbCambioA.setModel(new DefaultComboBoxModel(new String[] {
				"Celcius","Fahrenheit","Kelvin"}));
		cbCambioA.setSelectedIndex(0);
		cbCambioA.addActionListener(this);
		cbCambioA.setBounds(248, 86, 120, 22);
		contentPane.add(cbCambioA);
		
		cbCambioB = new JComboBox();
		cbCambioB.setModel(new DefaultComboBoxModel(new String[] {
				"Celcius","Fahrenheit","Kelvin"}));
		cbCambioB.setSelectedIndex(1);
		cbCambioB.addActionListener(this);
		cbCambioB.setBounds(248, 131, 120, 22);
		contentPane.add(cbCambioB);
		
		JLabel lblNewLabel_1 = new JLabel("Valor en");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(153, 90, 96, 14);
		
		contentPane.add(lblNewLabel_1);
		
		JLabel footer = new JLabel(pie.getFooter());
		footer.setFont(new Font("Tahoma", Font.PLAIN, 9));
		footer.setHorizontalAlignment(SwingConstants.CENTER);
		footer.setBounds(10, 175, 374, 14);
		footer.setForeground(new Color(64, 224, 208));
		contentPane.add(footer);
			
		JLabel lblNewLabel_2 = new JLabel("Cambiado a");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(153, 135, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Conversor de Temperatura");
		lblNewLabel_3.setIcon(null);
		lblNewLabel_3.setForeground(new Color(64, 224, 208));
		lblNewLabel_3.setFont(new Font("Consolas", lblNewLabel_3.getFont().getStyle() | Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(20, 24, 374, 29);
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
				temperatura = new clsTemperatura(Double.parseDouble(TextValorA.getText()));
				ejecuta();
				ctrlfalla=true;
			}
		} catch (Exception es ) {
			//es.printStackTrace();
			ctrlfalla=false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (temperatura!=null & ctrlfalla) {
			if (e.getSource()==cbCambioA |e.getSource()==cbCambioB) {
				ejecuta();
			}
		}	
	}
	private void ejecuta() {
		temperatura.validacionA(cbCambioA.getSelectedIndex());
		String datoTemp = String.format("%.1f",(temperatura.validacionB(cbCambioB.getSelectedIndex())));
		String dato=temperatura.getDato();
		TextValorB.setToolTipText(dato);
		TextValorB.setText(datoTemp+dato);
	}
}
