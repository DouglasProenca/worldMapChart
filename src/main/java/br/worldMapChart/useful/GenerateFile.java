package main.java.br.worldMapChart.useful;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class GenerateFile {

	public static File getFile(InputStream inStream, String nameTempFile, String fileExtension) throws Exception {
		File targetFile = File.createTempFile(nameTempFile, fileExtension);
		Files.copy(inStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		targetFile.deleteOnExit();
		return targetFile;
	}
}