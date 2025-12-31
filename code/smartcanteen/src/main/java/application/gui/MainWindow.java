package application.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.gui.util.GuiUtils;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;

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
		GuiUtils.applyAppIcon(this);
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
		panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
		contentPane.add(panel, BorderLayout.CENTER);

		panel.add(javax.swing.Box.createVerticalGlue());

		JButton btnCheckIn = new JButton("Check-in Dipendente");
		btnCheckIn.setIcon(GuiUtils.loadIcon("checkin.png", 22));
		btnCheckIn.setHorizontalAlignment(SwingConstants.CENTER);
		btnCheckIn.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCheckIn.setVerticalTextPosition(SwingConstants.CENTER);
		btnCheckIn.setIconTextGap(10);
		btnCheckIn.setMargin(new Insets(8, 16, 8, 16));
		btnCheckIn.setFocusable(false);
		btnCheckIn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		panel.add(btnCheckIn);
		
		btnCheckIn.addActionListener(e -> {
		    new CheckInFrame().setVisible(true);
		});

		panel.add(javax.swing.Box.createVerticalStrut(15));

		JButton btnServeMeal = new JButton("Servizio Pasto");
		btnServeMeal.setIcon(GuiUtils.loadIcon("serve-meal.png", 22));
		btnServeMeal.setHorizontalAlignment(SwingConstants.CENTER);
		btnServeMeal.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnServeMeal.setVerticalTextPosition(SwingConstants.CENTER);
		btnServeMeal.setIconTextGap(10);
		btnServeMeal.setMargin(new Insets(8, 16, 8, 16));
		btnServeMeal.setFocusable(false);
		btnServeMeal.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		panel.add(btnServeMeal);

		panel.add(javax.swing.Box.createVerticalGlue());
		
		btnServeMeal.addActionListener(e -> {
		    new ServeMealFrame().setVisible(true);
		});
		
		JLabel lblStatus = new JLabel("Stato: Backend attivo su http://localhost:8080");
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("SansSerif", Font.PLAIN, 12));

	}

}
