import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JMenu;


@SuppressWarnings("serial")
public class Frame extends JFrame
		implements ActionListener {

	private JPanel contentPane;
	JFileChooser chooser;
	String choosertitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
				    frame.addWindowListener(
				      new WindowAdapter() {
				        public void windowClosing(WindowEvent e) {
				          System.exit(0);
				          }
				        }
				      );
				    //frame.getContentPane().add(contentPane,"Center");
				    //frame.setSize(contentPane.getPreferredSize());
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
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		JMenu mnSoubor = new JMenu("Soubor");
		menuBar.add(mnSoubor);
		
		JMenuItem mntmOtevt = new JMenuItem("Otev\u0159\u00EDt");
		mntmOtevt.addActionListener(this);
		mnSoubor.add(mntmOtevt);
		
		JMenuItem mntmNastaven = new JMenuItem("Nastaven\u00ED");
		mnSoubor.add(mntmNastaven);
		
		JMenuItem mntmUkonit = new JMenuItem("Ukon\u010Dit");
		mnSoubor.add(mntmUkonit);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmOProgramu = new JMenuItem("O Programu");
		mnAbout.add(mntmOProgramu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle(choosertitle);
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    //
	    // disable the "All files" option.
	    //
	    chooser.setAcceptAllFileFilterUsed(false);
	    //    
	    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
	      System.out.println("getCurrentDirectory(): " 
	         +  chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " 
	         +  chooser.getSelectedFile());
	      }
	    else {
	      System.out.println("No Selection ");
	      }		
	}

}
