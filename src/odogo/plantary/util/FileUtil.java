package odogo.plantary.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

	public static void copyFile(File source, File dest) {
		InputStream is = null;
		OutputStream os = null;

		try { try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];
			int length;

			while((length = is.read(buffer)) > 0) os.write(buffer, 0, length);
		} finally {
			is.close();
			os.close();
		}} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
