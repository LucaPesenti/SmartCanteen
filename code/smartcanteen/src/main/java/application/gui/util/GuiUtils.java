package application.gui.util;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GuiUtils {

    public static void applyAppIcon(JFrame frame) {
        try {
            Image icon = new ImageIcon(
                GuiUtils.class.getResource("/icons/canteen_icon.png")
            ).getImage();
            frame.setIconImage(icon);
        } catch (Exception ignored) {}
    }

    public static ImageIcon loadIcon(String name, int size) {
        URL url = GuiUtils.class.getResource("/icons/" + name);
        if (url == null) {
            return null;
        }

        Image img = new ImageIcon(url).getImage();
        Image scaled = img.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}
