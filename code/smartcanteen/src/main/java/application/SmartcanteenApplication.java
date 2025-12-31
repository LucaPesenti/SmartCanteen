package application;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import application.gui.MainWindow;


@SpringBootApplication
public class SmartcanteenApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SmartcanteenApplication.class);
        app.setHeadless(false);
        app.run(args);
		
		SwingUtilities.invokeLater(() -> {
	        new MainWindow().setVisible(true);
	    });
	}

}
