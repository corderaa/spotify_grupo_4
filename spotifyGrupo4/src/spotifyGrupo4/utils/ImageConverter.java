package spotifyGrupo4.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class ImageConverter {

	/**
	 * Takes an image and converts it on to a Blob
	 * 
	 * @return
	 */
	public static BufferedImage imageToBlob(String image) throws IOException {

		byte[] blobBytes = Base64.getDecoder().decode(image);

		ByteArrayInputStream blobArrayInputStream = new ByteArrayInputStream(blobBytes);
		BufferedImage blob = ImageIO.read(blobArrayInputStream);

		return blob;
	}
	/**
	 * Takes a String and converts it on to a image
	 * 
	 * @param blob String from database
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage BlobToImage(String blob) throws IOException {

		byte[] imageBytes = Base64.getDecoder().decode(blob);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
		BufferedImage image = ImageIO.read(byteArrayInputStream);

		return image;
	}
}
