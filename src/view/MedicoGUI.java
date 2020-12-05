package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;

import connection.ConnectionFactory;
import controller.MedicoController;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class MedicoGUI extends JFrame {
	private JTextField txtCrm;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JLabel lblCrm;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEspecialidade;
	private JLabel lblTelefone;
	private JButton btnLimpar;
	private JButton btnEnviar;
	private JComboBox cmbEspecialidade;

	public MedicoGUI() {
		setTitle("Cadastro de M\u00E9dicos");
		setBounds(100, 100, 339, 440);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Handler ouvinte = new Handler();
		
		lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCrm.setBounds(51, 34, 35, 19);
		getContentPane().add(lblCrm);
		
		txtCrm = new JTextField();
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCrm.setBounds(51, 52, 217, 30);
		getContentPane().add(txtCrm);
		txtCrm.setColumns(10);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(51, 92, 47, 19);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(51, 111, 217, 30);
		getContentPane().add(txtNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCpf.setBounds(51, 151, 35, 19);
		getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(51, 170, 217, 30);
		getContentPane().add(txtCpf);
		
		lblEspecialidade = new JLabel("ESPECIALIDADES");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEspecialidade.setBounds(51, 210, 134, 19);
		getContentPane().add(lblEspecialidade);
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefone.setBounds(51, 269, 80, 19);
		getContentPane().add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(51, 288, 217, 30);
		getContentPane().add(txtTelefone);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpar.setBounds(46, 342, 100, 21);
		btnLimpar.addActionListener(ouvinte);

		getContentPane().add(btnLimpar);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnviar.setBounds(168, 344, 100, 21);
		btnEnviar.addActionListener(ouvinte);
		getContentPane().add(btnEnviar);
		
		cmbEspecialidade = new JComboBox();
		cmbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbEspecialidade.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE A ESPECIALIDADE", "Cardiologista", "Cl\u00EDnico Geral", "Dermatologista", "Endocrinologista", "Neurologista"}));
		cmbEspecialidade.setSelectedIndex(0);
		cmbEspecialidade.setBounds(51, 229, 217, 30);
		getContentPane().add(cmbEspecialidade);
		
		//Torna visivel a tela
		setVisible(true);
	}
	public void limpar() {
		txtCrm.setText("");
		txtNome.setText("");
		txtCpf.setText("");
		txtTelefone.setText("");
		cmbEspecialidade.setSelectedIndex(0);
	
		
	}
	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnEnviar) {
				String crm = txtCrm.getText();
				String nome = txtNome.getText();
				String cpf = txtCpf.getText();
				String telefone = txtTelefone.getText();
				int especialidade = cmbEspecialidade.getSelectedIndex();
				if(crm.equals("")||(nome.equals("")||(cpf.equals("")||(telefone.equals("")||(especialidade==0))))) {
					JOptionPane.showMessageDialog(getContentPane(),"Todos os campos devem ser preenchidos","Atenção", 1);
				}else {
					MedicoController mcontrol = new MedicoController();
					if(mcontrol.cadastrar(Integer.parseInt(crm), nome, cpf, especialidade)==1) {
						JOptionPane.showMessageDialog(getContentPane(),"Produto cadastrado com sucesso!!!","Sucesso", 1);
						limpar();	
					}
					else {
						JOptionPane.showMessageDialog(null, "Não foi posiivel cadastrar!");
					}
									

				}
				
			}
			else {
				if(e.getSource()==btnLimpar) {
					limpar();
				}
			}
		}
		
		
	}
	
}
