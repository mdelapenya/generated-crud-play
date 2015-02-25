package util;

import org.apache.commons.io.FilenameUtils;

/**
 * @author Manuel de la Peña
 */
public class FileValidator {

	public static boolean hasSQLExtension(String fileName) {
		return FilenameUtils.isExtension(fileName, "sql");
	}

}