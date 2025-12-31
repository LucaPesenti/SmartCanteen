package application.gui;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.gui.client.RestClient;
import application.gui.util.GuiUtils;

public class CheckInFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField txtEmployeeId;
    private JTextArea txtResult;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new CheckInFrame().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CheckInFrame() {
        setTitle("Check-in Dipendente");
        GuiUtils.applyAppIcon(this);
        setResizable(false);
        setSize(new Dimension(480, 340));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Check-in Dipendente");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        contentPane.add(centerPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);

        JLabel lblEmployeeId = new JLabel("ID Dipendente:");
        lblEmployeeId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(lblEmployeeId, gbc);

        txtEmployeeId = new JTextField(15);
        txtEmployeeId.setToolTipText("Inserire un ID valido (es. E1)");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        centerPanel.add(txtEmployeeId, gbc);

        JButton btnCheckIn = new JButton("Check-in Dipendente");
        btnCheckIn.setIcon(GuiUtils.loadIcon("checkin.png", 22));
        btnCheckIn.setHorizontalAlignment(SwingConstants.CENTER);
        btnCheckIn.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnCheckIn.setVerticalTextPosition(SwingConstants.CENTER);
        btnCheckIn.setIconTextGap(10);
        btnCheckIn.setMargin(new Insets(8, 16, 8, 16));
        btnCheckIn.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(btnCheckIn, gbc);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(BorderFactory.createTitledBorder("Esito operazione"));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        centerPanel.add(scrollPane, gbc);

        txtResult = new JTextArea();
        txtResult.setEditable(false);
        txtResult.setLineWrap(true);
        txtResult.setWrapStyleWord(true);
        txtResult.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtResult.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane.setViewportView(txtResult);

        JButton btnBack = new JButton("Torna al menu");
        contentPane.add(btnBack, BorderLayout.SOUTH);

        btnCheckIn.addActionListener(e -> handleCheckIn());
        btnBack.addActionListener(e -> {
            dispose();
            new MainWindow().setVisible(true);
        });
    }

    private void handleCheckIn() {
        try {
            String employeeId = txtEmployeeId.getText().trim();

            if (employeeId.isEmpty()) {
                txtResult.setForeground(java.awt.Color.RED);
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

            txtResult.setForeground(new java.awt.Color(0, 120, 0));
            txtResult.setText(
                    "Check-in completato con successo.\n\n" +
                    "ID Dipendente: " + id + "\n" +
                    "Orario: " + dateTime.format(formatter)
            );

        } catch (Exception ex) {
            txtResult.setForeground(java.awt.Color.RED);
            txtResult.setText(
                    "Errore durante il check-in:\n" +
                    ex.getMessage()
            );
        }
    }
}
