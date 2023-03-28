package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

public class vistaPpal extends JFrame implements ActionListener {

	private JPanel panelPpal;
	private JButton btnInicio;
	private JComboBox comboBox;
	footer pie=new footer();
	private JLabel footer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaPpal viewPpal = new vistaPpal();
					viewPpal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vistaPpal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(vistaPpal.class.getResource("/img/logo.png")));
		setType(Type.POPUP);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		incioComponentes();
		setLocationRelativeTo(null);
	}
	
	private void incioComponentes () {
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
		
		setResizable(false);
		
		
		setBounds(100, 100, 363, 212);
		panelPpal = new JPanel();
		panelPpal.setBackground(SystemColor.windowBorder);
		panelPpal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPpal);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Conversor de Temperatura","Conversor de Monedas"}));
		comboBox.setSelectedIndex(1);
		
		JLabel lblNewLabel = new JLabel("Selecciona la Conversion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnInicio = new JButton("Iniciar");
		btnInicio.addActionListener(this);
		
		footer = new JLabel(pie.getFooter());
		footer.setFont(new Font("Tahoma", Font.PLAIN, 9));
		footer.setHorizontalAlignment(SwingConstants.CENTER);
		footer.setForeground(new Color(64, 224, 208));
		
		GroupLayout gl_panelPpal = new GroupLayout(panelPpal);
		gl_panelPpal.setHorizontalGroup(
			gl_panelPpal.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
				.addGroup(gl_panelPpal.createSequentialGroup()
					.addGap(85)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(gl_panelPpal.createSequentialGroup()
					.addGap(134)
					.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(gl_panelPpal.createSequentialGroup()
					.addContainerGap()
					.addComponent(footer, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelPpal.setVerticalGroup(
			gl_panelPpal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPpal.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnInicio)
					.addGap(18)
					.addComponent(footer)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelPpal.setLayout(gl_panelPpal);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	switch (comboBox.getSelectedIndex()) {
	case 1:
		vistaMonedas monedas=new vistaMonedas();
		monedas.setVisible(true);
		break;
	default:
		vistaTemperaturas temperatura = new vistaTemperaturas();
		temperatura.setVisible(true);
		break;
	}
		
	}
}