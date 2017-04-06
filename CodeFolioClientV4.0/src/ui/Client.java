package ui;

import gitHandler.GitPythonCaller;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import settings.CodeFolioSettings;
import utils.AssignmentObject;
import utils.CommentObject;
import utils.ModuleObject;
import utils.NetworkUtils;
import utils.RepoObject;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.UIManager;

import com.google.gson.Gson;

public class Client {

	JFrame frmCodefolioLocalClient;
	private JTextField txtDirectoryPath;
	private JTextField txtComment;
	Gson gson = new Gson();

	/**
	 * @wbp.parser.entryPoint
	 */
	public Client() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {

		frmCodefolioLocalClient = new JFrame();
		frmCodefolioLocalClient.setTitle("CodeFolio Local Client");
		frmCodefolioLocalClient.setBounds(100, 100, 562, 476);
		frmCodefolioLocalClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 101, 155, 223, 0};
		gridBagLayout.rowHeights = new int[]{35, 22, 25, 35, 25, 25, 35, 22, 0, 25, 25, 25, 60, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmCodefolioLocalClient.getContentPane().setLayout(gridBagLayout);

		JTextArea txtConsole = new JTextArea();
		GridBagConstraints gbc_txtConsole = new GridBagConstraints();
		gbc_txtConsole.gridheight = 2;
		gbc_txtConsole.gridwidth = 4;
		gbc_txtConsole.fill = GridBagConstraints.BOTH;
		gbc_txtConsole.gridx = 0;
		gbc_txtConsole.gridy = 11;
		frmCodefolioLocalClient.getContentPane().add(txtConsole, gbc_txtConsole);
		txtConsole.setText("Console");

		JLabel lblModule = new JLabel("Module");
		GridBagConstraints gbc_lblModule = new GridBagConstraints();
		gbc_lblModule.insets = new Insets(0, 0, 5, 5);
		gbc_lblModule.gridx = 0;
		gbc_lblModule.gridy = 0;
		frmCodefolioLocalClient.getContentPane().add(lblModule, gbc_lblModule);

		JComboBox<AssignmentObject> cmbAssignment = new JComboBox<>();
		GridBagConstraints gbc_cmbAssignment = new GridBagConstraints();
		gbc_cmbAssignment.insets = new Insets(0, 0, 5, 0);
		gbc_cmbAssignment.gridx = 3;
		gbc_cmbAssignment.gridy = 0;
		frmCodefolioLocalClient.getContentPane().add(cmbAssignment, gbc_cmbAssignment);

		JComboBox<ModuleObject> cmbModule = new JComboBox<>();
		GridBagConstraints gbc_cmbModule = new GridBagConstraints();
		gbc_cmbModule.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbModule.insets = new Insets(0, 0, 5, 5);
		gbc_cmbModule.gridx = 1;
		gbc_cmbModule.gridy = 0;
		frmCodefolioLocalClient.getContentPane().add(cmbModule, gbc_cmbModule);

		JLabel lblAssignment = new JLabel("Assignment");
		GridBagConstraints gbc_lblAssignment = new GridBagConstraints();
		gbc_lblAssignment.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssignment.gridx = 2;
		gbc_lblAssignment.gridy = 0;
		frmCodefolioLocalClient.getContentPane().add(lblAssignment, gbc_lblAssignment);

		JButton btnSkeleton = new JButton("Download Skeleton Code From Moodle");
		GridBagConstraints gbc_btnSkeleton = new GridBagConstraints();
		gbc_btnSkeleton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSkeleton.insets = new Insets(0, 0, 5, 0);
		gbc_btnSkeleton.gridwidth = 4;
		gbc_btnSkeleton.gridx = 0;
		gbc_btnSkeleton.gridy = 1;
		frmCodefolioLocalClient.getContentPane().add(btnSkeleton, gbc_btnSkeleton);

		txtDirectoryPath = new JTextField();
		txtDirectoryPath.setText("Directory Path");
		GridBagConstraints gbc_txtDirectoryPath = new GridBagConstraints();
		gbc_txtDirectoryPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDirectoryPath.insets = new Insets(0, 0, 5, 5);
		gbc_txtDirectoryPath.gridwidth = 3;
		gbc_txtDirectoryPath.gridx = 0;
		gbc_txtDirectoryPath.gridy = 2;
		frmCodefolioLocalClient.getContentPane().add(txtDirectoryPath, gbc_txtDirectoryPath);
		txtDirectoryPath.setColumns(10);

		JButton btnBrowse = new JButton("Browse");
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowse.gridx = 3;
		gbc_btnBrowse.gridy = 2;
		frmCodefolioLocalClient.getContentPane().add(btnBrowse, gbc_btnBrowse);

		JButton btnInitialiseRepository = new JButton("Initialise  A Personal Repository");
		GridBagConstraints gbc_btnInitialiseRepository = new GridBagConstraints();
		gbc_btnInitialiseRepository.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInitialiseRepository.insets = new Insets(0, 0, 5, 0);
		gbc_btnInitialiseRepository.gridwidth = 4;
		gbc_btnInitialiseRepository.gridx = 0;
		gbc_btnInitialiseRepository.gridy = 3;
		frmCodefolioLocalClient.getContentPane().add(btnInitialiseRepository, gbc_btnInitialiseRepository);

		JLabel lblIgnoreLanguage = new JLabel("Ignore Language:");
		GridBagConstraints gbc_lblIgnoreLanguage = new GridBagConstraints();
		gbc_lblIgnoreLanguage.gridwidth = 2;
		gbc_lblIgnoreLanguage.insets = new Insets(0, 0, 5, 5);
		gbc_lblIgnoreLanguage.gridx = 0;
		gbc_lblIgnoreLanguage.gridy = 4;
		frmCodefolioLocalClient.getContentPane().add(lblIgnoreLanguage, gbc_lblIgnoreLanguage);

		JComboBox cmbIgnore = new JComboBox();
		cmbIgnore.setModel(new DefaultComboBoxModel(new String[] {"Java", "C", "Python"}));
		cmbIgnore.setSelectedIndex(0);
		GridBagConstraints gbc_comboIgnore = new GridBagConstraints();
		gbc_comboIgnore.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboIgnore.insets = new Insets(0, 0, 5, 5);
		gbc_comboIgnore.gridx = 2;
		gbc_comboIgnore.gridy = 4;
		frmCodefolioLocalClient.getContentPane().add(cmbIgnore, gbc_comboIgnore);

		JLabel lblRepo = new JLabel("Repo");
		GridBagConstraints gbc_lblRepo = new GridBagConstraints();
		gbc_lblRepo.gridwidth = 2;
		gbc_lblRepo.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepo.gridx = 0;
		gbc_lblRepo.gridy = 5;
		frmCodefolioLocalClient.getContentPane().add(lblRepo, gbc_lblRepo);

		JComboBox<RepoObject> cmbRepo = new JComboBox<>();
		cmbRepo.setToolTipText("Select A Repository");
		GridBagConstraints gbc_comboRepo = new GridBagConstraints();
		gbc_comboRepo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboRepo.insets = new Insets(0, 0, 5, 0);
		gbc_comboRepo.gridwidth = 2;
		gbc_comboRepo.gridx = 2;
		gbc_comboRepo.gridy = 5;
		frmCodefolioLocalClient.getContentPane().add(cmbRepo, gbc_comboRepo);
		cmbRepo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//repoHomePath = SQLforRepos.getHomePath((String) comboRepo.getSelectedItem());
				//System.out.println(repoHomePath);
			}
		});

		JButton btnArchiveRepository = new JButton("Archive and Submit Repository");
		GridBagConstraints gbc_btnArchiveRepository = new GridBagConstraints();
		gbc_btnArchiveRepository.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnArchiveRepository.insets = new Insets(0, 0, 5, 5);
		gbc_btnArchiveRepository.gridwidth = 3;
		gbc_btnArchiveRepository.gridx = 0;
		gbc_btnArchiveRepository.gridy = 6;
		frmCodefolioLocalClient.getContentPane().add(btnArchiveRepository, gbc_btnArchiveRepository);

		JButton btnSyncRepo = new JButton("Sync Repository");
		GridBagConstraints gbc_btnSyncRepo = new GridBagConstraints();
		gbc_btnSyncRepo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSyncRepo.insets = new Insets(0, 0, 5, 0);
		gbc_btnSyncRepo.gridx = 3;
		gbc_btnSyncRepo.gridy = 6;
		frmCodefolioLocalClient.getContentPane().add(btnSyncRepo, gbc_btnSyncRepo);

		JButton btnDeleteRepository = new JButton("Delete Repository");
		GridBagConstraints gbc_btnDeleteRepository = new GridBagConstraints();
		gbc_btnDeleteRepository.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeleteRepository.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteRepository.gridwidth = 3;
		gbc_btnDeleteRepository.gridx = 0;
		gbc_btnDeleteRepository.gridy = 7;
		frmCodefolioLocalClient.getContentPane().add(btnDeleteRepository, gbc_btnDeleteRepository);
		btnInitialiseRepository.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File p = new File(txtDirectoryPath.getText());
				String name = JOptionPane.showInputDialog(null,"Please enter a name for your project","CodeFolio Project Name");
				System.out.println("n="+name);
				GitPythonCaller g = new GitPythonCaller();
				try {
					
					txtConsole.append(g.initialiseRepo(p, cmbIgnore.toString()));
					RepoObject r = new RepoObject(CodeFolioSettings.userId, name, p.toString(), "30/1/2016");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

		}
	});
		btnDeleteRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtDirectoryPath.getText());
				File p = new File(txtDirectoryPath.getText());
				GitPythonCaller r = new GitPythonCaller();
				try {
					txtConsole.append(r.remove(p));
					RepoObject ro = (RepoObject) cmbRepo.getSelectedItem();
					ro.deleteRepoRecord(ro.id);
					//Need to remote delete repo too
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		});

		txtComment = new JTextField();
		txtComment.setText("Comment To Be Added");
		GridBagConstraints gbc_textComment = new GridBagConstraints();
		gbc_textComment.gridwidth = 3;
		gbc_textComment.fill = GridBagConstraints.HORIZONTAL;
		gbc_textComment.insets = new Insets(0, 0, 5, 5);
		gbc_textComment.gridx = 0;
		gbc_textComment.gridy = 9;
		frmCodefolioLocalClient.getContentPane().add(txtComment, gbc_textComment);
		txtComment.setColumns(10);

		JButton btnAddAComment = new JButton("Add a Comment");
		GridBagConstraints gbc_btnAddAComment = new GridBagConstraints();
		gbc_btnAddAComment.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddAComment.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddAComment.gridx = 3;
		gbc_btnAddAComment.gridy = 9;
		frmCodefolioLocalClient.getContentPane().add(btnAddAComment, gbc_btnAddAComment);
		
		btnAddAComment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int repoId = ((RepoObject)cmbRepo.getSelectedItem()).id;
				System.out.println(repoId);
				CommentObject c = new CommentObject(CodeFolioSettings.userId, repoId, txtComment.getText());
				txtConsole.append(c.toString() + "\n");
			}
		});


		JButton btnCheckForComments = new JButton("Check For Comments");
		GridBagConstraints gbc_btnCheckForComments = new GridBagConstraints();
		gbc_btnCheckForComments.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCheckForComments.insets = new Insets(0, 0, 5, 0);
		gbc_btnCheckForComments.gridx = 3;
		gbc_btnCheckForComments.gridy = 10;
		frmCodefolioLocalClient.getContentPane().add(btnCheckForComments, gbc_btnCheckForComments);
		btnCheckForComments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Desktop.isDesktopSupported())
				{
					try {
						Desktop.getDesktop().browse(new URI(CodeFolioSettings.repos));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		cmbModule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ModuleObject selected = (ModuleObject)((JComboBox<ModuleObject>)e.getSource()).getSelectedItem();
				cmbAssignment.removeAllItems();
				for (AssignmentObject a:selected.assignments){
					cmbAssignment.addItem(a);
				}
			}
		});

		btnBrowse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				File p;
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("C:/"));
				chooser.setDialogTitle("Select a directory to perform CodeFolio operations on");
				chooser.setPreferredSize(new Dimension(600,600));
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				int ok = chooser.showOpenDialog(null);
				if (ok == JFileChooser.APPROVE_OPTION) { 
					txtConsole.append("\ngetCurrentDirectory(): "	+  chooser.getCurrentDirectory()+"\n");
					txtConsole.append("\ngetSelectedFile() : " +  chooser.getSelectedFile()+"\n");
					p = chooser.getSelectedFile();
					txtDirectoryPath.setText(p.getAbsolutePath().toString());
				} else {
					txtConsole.setText("No Selection ");
				}

			}
		});
		btnSkeleton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				File p;
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("C:/"));
				chooser.setDialogTitle("Select where to save new Skeleton Code");
				chooser.setPreferredSize(new Dimension(600,600));
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				int ok = chooser.showOpenDialog(null);
				if (ok == JFileChooser.APPROVE_OPTION) { 
					txtConsole.append("\ngetCurrentDirectory(): "	+  chooser.getCurrentDirectory()+"\n");
					txtConsole.append("\ngetSelectedFile() : " +  chooser.getSelectedFile()+"\n");
					p = chooser.getSelectedFile();
					String n = cmbAssignment.getSelectedItem().toString();
					AssignmentObject a = (AssignmentObject) cmbAssignment.getSelectedItem();
					System.out.println("n="+n);
					GitPythonCaller g = new GitPythonCaller();
					try {
						//Need gather where the archive file is
						txtConsole.append(g.unZipRepo(new File("C:\\FYP\\Archives\\COMP1110_A3_34.zip"),p, n));
						RepoObject r = new RepoObject(CodeFolioSettings.userId, a.name, p.toString(), "30/1/2016", a.id);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					txtConsole.append("\nNo Selection ");

				}


			}
		});

		//Initial Population of ComboBoxes
		String returnedJsonModules=NetworkUtils.getJSON(CodeFolioSettings.modules);
		String returnedJsonRepos=NetworkUtils.getJSON(CodeFolioSettings.repos);
		ModuleObject[] modules = gson.fromJson(returnedJsonModules, ModuleObject[].class);
		RepoObject[] repos = gson.fromJson(returnedJsonRepos, RepoObject[].class);
		for(ModuleObject m:modules){
			cmbModule.addItem(m);
		}
		for (AssignmentObject a:modules[0].assignments){
			cmbAssignment.addItem(a);
		}
		for(RepoObject r: repos){
			cmbRepo.addItem(r);
		}
}
public JFrame getFrame(){
	return frmCodefolioLocalClient;
}
public static void main(String[] args) {
	if (NetworkUtils.sendLogin("rob@ucd.ie", "wordpass")) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Client c = new Client();
					c.frmCodefolioLocalClient.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} else {
		System.out.println("Login Failed!");
	}
}
}