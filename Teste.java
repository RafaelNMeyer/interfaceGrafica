package interfaceG;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.Icon;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teste extends JFrame {
	private JLabel label1;
	private JLabel label2;
	private JTextField texto5;
	private JTextField texto15;
	private JTextField textoNaoEditavel;
	private JTextField senha;
	
	
	
	public Teste() {
		super("teste frame");
		setLayout(new FlowLayout());

		label1 = new JLabel("Exercício");
		label1.setToolTipText("label1");
		add(label1);

		Icon floresta = new ImageIcon(getClass().getResource("flop.jpg"));
		label2 = new JLabel("Floresta", floresta, SwingConstants.LEFT);
		label2.setToolTipText("label2");
		add(label2);
		texto5 = new JTextField(5);
		add(texto5);

		texto15 = new JTextField(15);
		add(texto15);

		textoNaoEditavel = new JTextField("Não editável", 15);
		textoNaoEditavel.setEditable(false);
		add(textoNaoEditavel);

		senha = new JPasswordField(22);
		add(senha);

		TextFieldHandler handler = new TextFieldHandler();
		texto5.addActionListener(handler);
		texto15.addActionListener(handler);
		textoNaoEditavel.addActionListener(handler);
		senha.addActionListener(handler);
		
		ButtonHandler bh = new ButtonHandler();
		JButton b1 = new JButton("botao1");
		JButton b2 = new JButton("botao2",floresta);
		add(b1);
		add(b2);
		b1.addActionListener(bh);
		b2.addActionListener(bh);
		
	}
	
	

	private class TextFieldHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String a = "";
			if (e.getSource() == texto5) {
				a = String.format("campo de texto: %s", e.getActionCommand());
			} else {
				if (e.getSource() == texto15) {
					a = String.format("campo de texto: %s", e.getActionCommand());
				} else {
					if (e.getSource() == textoNaoEditavel) {
						a = String.format("campo de texto: %s", e.getActionCommand());
					} else {
						if (e.getSource() == senha) {
							a = String.format("campo de senha: %s", e.getActionCommand());
						}
					}
				}
			}

			JOptionPane.showMessageDialog(null, a);

		}

	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(Teste.this,String.format("pressionado : %s", e.getActionCommand()));
		}

	}

}
