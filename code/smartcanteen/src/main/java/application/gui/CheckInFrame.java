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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class CheckInFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtEmployeeId;
	private JButton btnCheckIn;
	private JTextArea txtResult;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInFrame frame = new CheckInFrame();
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
	public CheckInFrame() {
		setResizable(false);
		setSize(new Dimension(450, 250));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Check-in Dipendente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("ID Dipendente:");
		GridBagConstraints gbc_txtEmployeeId = new GridBagConstraints();
		gbc_txtEmployeeId.insets = new Insets(5, 10, 5, 5);
		gbc_txtEmployeeId.anchor = GridBagConstraints.EAST;
		gbc_txtEmployeeId.gridx = 0;
		gbc_txtEmployeeId.gridy = 0;
		panel.add(txtEmployeeId, gbc_txtEmployeeId);
		
		txtEmployeeId = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(5, 5, 5, 10);
		gbc_textField.weightx = 1.0;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(15);
		
		btnCheckIn = new JButton("Check-in");
		GridBagConstraints gbc_btnCheckIn = new GridBagConstraints();
		gbc_btnCheckIn.gridwidth = 2;
		gbc_btnCheckIn.insets = new Insets(10, 10, 10, 10);
		gbc_btnCheckIn.gridx = 0;
		gbc_btnCheckIn.gridy = 1;
		panel.add(btnCheckIn, gbc_btnCheckIn);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(5, 10, 10, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		txtResult = new JTextArea();
		txtResult.setWrapStyleWord(true);
		txtResult.setRows(3);
		txtResult.setLineWrap(true);
		txtResult.setEditable(false);
		scrollPane.setViewportView(txtResult);
		
		JButton btnBack = new JButton("Torna al menu");
		contentPane.add(btnBack, BorderLayout.SOUTH);
		
		btnBack.addActionListener(e -> {
		    dispose();
		    new MainWindow().setVisible(true);
		});

		
		btnCheckIn.addActionListener(e -> handleCheckIn());
	}

	private void handleCheckIn() {
	    try {
	        String employeeId = txtEmployeeId.getText().trim();

	        if (employeeId.isEmpty()) {
	            txtResult.setText("Inserire un ID dipendente valido.");
	            return;
	        }

	        String response = RestClient.post(
	                "/employees/" + employeeId + "/check-in",
	                ""
	        );

	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode root = mapper.readTree(response);

	        String id = root.get("employeeId").asText();
	        String time = root.get("checkInTime").asText();

	        LocalDateTime dateTime = LocalDateTime.parse(time);
	        DateTimeFormatter formatter =
	                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	        txtResult.setText(
	                "Check-in completato con successo\n\n" +
	                "Dipendente: " + id + "\n" +
	                "Orario: " + dateTime.format(formatter)
	        );

	    } catch (Exception ex) {
	        txtResult.setText(
	                "Errore durante il check-in:\n" +
	                ex.getMessage()
	        );
	    }
	}


}
