package application.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setSize(new Dimension(400, 250));
		setResizable(false);
		setTitle("SmartCanteen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("SmartCanteen");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnCheckIn = new JButton("Check-in Dipendente");
		GridBagConstraints gbc_btnCheckIn = new GridBagConstraints();
		gbc_btnCheckIn.insets = new Insets(10, 10, 10, 10);
		gbc_btnCheckIn.gridx = 0;
		gbc_btnCheckIn.gridy = 0;
		panel.add(btnCheckIn, gbc_btnCheckIn);
		
		JButton btnServeMeal = new JButton("Servizio Pasto");
		GridBagConstraints gbc_btnServeMeal = new GridBagConstraints();
		gbc_btnServeMeal.insets = new Insets(10, 10, 10, 10);
		gbc_btnServeMeal.gridx = 0;
		gbc_btnServeMeal.gridy = 1;
		panel.add(btnServeMeal, gbc_btnServeMeal);
		
		JLabel lblStatus = new JLabel("Stato: Backend attivo su http://localhost:8080");
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		
		btnCheckIn.addActionListener(e -> {
		    new CheckInFrame().setVisible(true);
		});

		btnServeMeal.addActionListener(e -> {
		    new ServeMealFrame().setVisible(true);
		});

	}

}
