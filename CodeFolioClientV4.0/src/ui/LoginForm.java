package ui;

import javax.swing.*;

import utils.NetworkUtils;

import java.awt.*;
import java.awt.event.*;

public class LoginForm {

	private JFrame frmMoodleLogin;
	private JTextField textUserName;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 310, 120);
		getFrame().setResizable(false);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 300, 120);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		frmMoodleLogin.getContentPane().setLayout(null);
		frmMoodleLogin.getContentPane().add(panel);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {75, 125};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gridBagLayout);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.insets = new Insets(5, 5, 5, 5);
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 0;
		panel.add(lblUserName, gbc_lblUserName);
		
		textUserName = new JTextField();
		GridBagConstraints gbc_textUserName = new GridBagConstraints();
		gbc_textUserName.fill = GridBagConstraints.BOTH;
		gbc_textUserName.insets = new Insets(5, 0, 5, 5);
		gbc_textUserName.gridx = 1;
		gbc_textUserName.gridy = 0;
		panel.add(textUserName, gbc_textUserName);
		textUserName.setHorizontalAlignment(SwingConstants.LEFT);
		textUserName.setColumns(20);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(5, 5, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		panel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(5, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		panel.add(passwordField, gbc_passwordField);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setColumns(20);
		
		final JLabel lblLoginError = new JLabel("Error:");
		GridBagConstraints gbc_lblLoginError = new GridBagConstraints();
		gbc_lblLoginError.insets = new Insets(0, 5, 5, 5);
		gbc_lblLoginError.gridwidth = 2;
		gbc_lblLoginError.fill = GridBagConstraints.BOTH;
		gbc_lblLoginError.gridx = 0;
		gbc_lblLoginError.gridy = 3;
		panel.add(lblLoginError, gbc_lblLoginError);
		lblLoginError.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(5, 5, 5, 5);
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 2;
		panel.add(btnLogin, gbc_btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean success = NetworkUtils.sendLogin(textUserName.getText(), String.valueOf(passwordField.getPassword()));
				System.out.println(success);
				if (success) {

					getFrame().dispose();
					Client c = new Client();
					c.frmCodefolioLocalClient.setVisible(true);
				} else {

					lblLoginError.setText("Error: Invalid Username/Password!");

					frmMoodleLogin.setSize(315, 150);
				}
			}
		});
		btnLogin.setMnemonic('L');

	}

	public JFrame getFrame() {
		return frmMoodleLogin;
	}

	public void setFrame(JFrame frame) {
		this.frmMoodleLogin = frame;
		frmMoodleLogin.setTitle("Moodle Login");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm lf= new LoginForm();
					lf.getFrame().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}