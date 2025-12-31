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

public class ServeMealFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField txtTicketId;
    private JTextArea txtResult;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new ServeMealFrame().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ServeMealFrame() {
        setTitle("Servizio Pasto");
        GuiUtils.applyAppIcon(this);
        setResizable(false);
        setSize(new Dimension(480, 370));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Servizio Pasto");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        contentPane.add(centerPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);

        JLabel lblTicketId = new JLabel("ID Ticket:");
        lblTicketId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(lblTicketId, gbc);

        txtTicketId = new JTextField(15);
        txtTicketId.setToolTipText("Inserire un ID ticket valido (es. T1)");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        centerPanel.add(txtTicketId, gbc);

        JButton btnServeMeal = new JButton("Servizio Pasto");
        btnServeMeal.setIcon(GuiUtils.loadIcon("serve-meal.png", 22));
        btnServeMeal.setHorizontalAlignment(SwingConstants.CENTER);
        btnServeMeal.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnServeMeal.setVerticalTextPosition(SwingConstants.CENTER);
        btnServeMeal.setIconTextGap(10);
        btnServeMeal.setMargin(new Insets(8, 16, 8, 16));
        btnServeMeal.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(btnServeMeal, gbc);

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

        btnServeMeal.addActionListener(e -> handleServeMeal());
        btnBack.addActionListener(e -> {
            dispose();
            new MainWindow().setVisible(true);
        });
    }

    private void handleServeMeal() {
        try {
            String ticketId = txtTicketId.getText().trim();

            if (ticketId.isEmpty()) {
                txtResult.setForeground(java.awt.Color.RED);
                txtResult.setText("Inserire un ID ticket valido.");
                return;
            }

            String response = RestClient.post(
                    "/tickets/" + ticketId + "/serve",
                    ""
            );

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            String mealName = root.get("mealName").asText();
            double price = root.get("price").asDouble();
            String servedAt = root.get("servedAt").asText();

            LocalDateTime dateTime = LocalDateTime.parse(servedAt);
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            txtResult.setForeground(new java.awt.Color(0, 120, 0));
            txtResult.setText(
                    "Pasto servito correttamente.\n\n" +
                    "Ticket: " + ticketId + "\n" +
                    "Piatto: " + mealName + "\n" +
                    "Prezzo: € " + String.format("%.2f", price) + "\n" +
                    "Orario: " + dateTime.format(formatter)
            );

        } catch (Exception ex) {
            txtResult.setForeground(java.awt.Color.RED);
            txtResult.setText(
                    "Errore durante il servizio pasto:\n" +
                    ex.getMessage()
            );
        }
    }
}
