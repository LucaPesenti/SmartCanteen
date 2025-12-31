package application.gui.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GuiUtils {

    public static void applyAppIcon(JFrame frame) {
        try {
            Image icon = new ImageIcon(
                GuiUtils.class.getResource("/icons/canteen_icon.png")
            ).getImage();
            frame.setIconImage(icon);
        } catch (Exception ignored) {}
    }
    
    private static final Map<String, ImageIcon> ICON_CACHE = new ConcurrentHashMap<>();

    public static ImageIcon loadIcon(String name, int size) {
        String cacheKey = name + "@" + size + "x" + getScaleFactor();
        ImageIcon cached = ICON_CACHE.get(cacheKey);
        if (cached != null) return cached;

        URL url = GuiUtils.class.getResource("/icons/" + name);
        if (url == null) {
            return null;
        }

        try {
            BufferedImage src = ImageIO.read(url);
            double scale = getScaleFactor();
            int targetPx = (int) Math.round(size * scale);

            BufferedImage scaled = new BufferedImage(targetPx, targetPx, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = scaled.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawImage(src, 0, 0, targetPx, targetPx, null);
            g2.dispose();

            ImageIcon icon = new ImageIcon(scaled);
            ICON_CACHE.put(cacheKey, icon);
            return icon;
        } catch (IOException e) {
            return null;
        }
    }

    private static double getScaleFactor() {
        try {
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            AffineTransform t = gc.getDefaultTransform();
            return t.getScaleX();
        } catch (Throwable t) {
            return 1.0;
        }
    }
}
