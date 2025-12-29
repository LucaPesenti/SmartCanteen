package application.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.gui.client.RestClient;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServeMealFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTicketId;
	private JTextArea txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServeMealFrame frame = new ServeMealFrame();
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
	public ServeMealFrame() {
		setSize(new Dimension(450, 250));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Servizio Pasto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Ticket:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(5, 10, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtTicketId = new JTextField();
		GridBagConstraints gbc_txtTicketId = new GridBagConstraints();
		gbc_txtTicketId.insets = new Insets(5, 5, 5, 10);
		gbc_txtTicketId.weightx = 1.0;
		gbc_txtTicketId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTicketId.gridx = 1;
		gbc_txtTicketId.gridy = 0;
		panel.add(txtTicketId, gbc_txtTicketId);
		txtTicketId.setColumns(15);
		txtTicketId.setToolTipText("Inserire un ID ticket valido (es. T1)");
		
		JButton btnServeMeal = new JButton("Servi Pasto");
		GridBagConstraints gbc_btnServeMeal = new GridBagConstraints();
		gbc_btnServeMeal.gridwidth = 2;
		gbc_btnServeMeal.insets = new Insets(10, 10, 10, 10);
		gbc_btnServeMeal.gridx = 0;
		gbc_btnServeMeal.gridy = 1;
		panel.add(btnServeMeal, gbc_btnServeMeal);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(5, 10, 10, 10);
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		txtResult = new JTextArea();
		txtResult.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtResult.setRows(3);
		txtResult.setWrapStyleWord(true);
		txtResult.setLineWrap(true);
		txtResult.setEditable(false);
		scrollPane.setViewportView(txtResult);
		
		JButton btnBack = new JButton("Torna al menu");
		contentPane.add(btnBack, BorderLayout.SOUTH);
		
		btnBack.addActionListener(e -> {
		    dispose();
		    new MainWindow().setVisible(true);
		});
		
		btnServeMeal.addActionListener(e -> handleServeMeal());
	}
	
	private void handleServeMeal() {
	    try {
	        String ticketId = txtTicketId.getText().trim();

	        if (ticketId.isEmpty()) {
	            txtResult.setText("Inserire un ID ticket valido.");
	            return;
	        }

	        String response = RestClient.post(
	                "/tickets/" + ticketId + "/serve",
	                ""
	        );

	        // Parsing JSON
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode root = mapper.readTree(response);

	        String mealName = root.get("mealName").asText();
	        double price = root.get("price").asDouble();
	        String servedAt = root.get("servedAt").asText();

	        LocalDateTime dateTime = LocalDateTime.parse(servedAt);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	        String formattedDate = dateTime.format(formatter);

	        txtResult.setText(
	        		"Pasto servito correttamente\n" +
	        		"------------------------------------------------------\n" +
	                "Ticket: " + ticketId + "\n" +
	                "Piatto: " + mealName + "\n" +
	                "Prezzo: € " + String.format("%.2f", price) + "\n" +
	                "Orario: " + formattedDate
	        );
	        txtResult.setForeground(new java.awt.Color(0, 120, 0));

	    } catch (Exception ex) {
	        txtResult.setText(
	                "Errore durante il servizio pasto:\n" +
	                ex.getMessage()
	        );
	        txtResult.setForeground(java.awt.Color.RED);
	    }
	}



}
