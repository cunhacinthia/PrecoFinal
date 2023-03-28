package exercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtValorVenda;
	private JRadioButton rdbDinheiro;
	private JRadioButton rdbCheque;
	private JRadioButton rdbCartao;
	private final ButtonGroup btgFormaPagamento = new ButtonGroup();
	private JLabel lblNewLabel_1;
	private JTextField txtValorTotal;
	private JButton btnCalcular;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela1() {
		setTitle("Preço Final");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Entre com o valor da venda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 267, 33);
		contentPane.add(lblNewLabel);
		
		txtValorVenda = new JTextField();
		txtValorVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValorVenda.setBounds(301, 11, 117, 30);
		contentPane.add(txtValorVenda);
		txtValorVenda.setColumns(10);
		
		rdbDinheiro = new JRadioButton("Dinheiro");
		btgFormaPagamento.add(rdbDinheiro);
		rdbDinheiro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbDinheiro.setBounds(62, 78, 103, 21);
		contentPane.add(rdbDinheiro);
		
		rdbCheque = new JRadioButton("Cheque");
		btgFormaPagamento.add(rdbCheque);
		rdbCheque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbCheque.setBounds(189, 81, 103, 21);
		contentPane.add(rdbCheque);
		
		rdbCartao = new JRadioButton("Cartão");
		btgFormaPagamento.add(rdbCartao);
		rdbCartao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbCartao.setBounds(317, 81, 103, 21);
		contentPane.add(rdbCartao);
		
		lblNewLabel_1 = new JLabel("Valor Total");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(145, 150, 115, 39);
		contentPane.add(lblNewLabel_1);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEnabled(false);
		txtValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValorTotal.setColumns(10);
		txtValorTotal.setBounds(301, 154, 117, 30);
		contentPane.add(txtValorTotal);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double valorVenda = Double.parseDouble(txtValorVenda.getText());
				double valorTotal;
				
				if(rdbDinheiro.isSelected()) {
					valorTotal = valorVenda - (5 * valorVenda / 100);
					txtValorTotal.setText(String.valueOf(valorTotal));
				}else if (rdbCheque.isSelected()) {
					valorTotal = valorVenda + (5 * valorVenda / 100);
					txtValorTotal.setText(String.valueOf(valorTotal));
				}else {
					valorTotal = valorVenda + (10 * valorVenda / 100);
					txtValorTotal.setText(String.valueOf(valorTotal));
				}
			}
		});
		btnCalcular.setBounds(155, 208, 85, 21);
		contentPane.add(btnCalcular);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtValorVenda.setText(null);
				txtValorTotal.setText(null);
			}
		});
		btnLimpar.setBounds(320, 208, 85, 21);
		contentPane.add(btnLimpar);
	}
}
