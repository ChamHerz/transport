package transport.util;

import javax.swing.ImageIcon;

public class ImagenUtil {
	
	/** Devuelve un error si la imagen no la encuentra */
    public static ImageIcon createImageIcon(String path) {

        java.net.URL imgURL = ImagenUtil.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se puede encontra la imagen: " + path);
            return null;
        }
    }
}
