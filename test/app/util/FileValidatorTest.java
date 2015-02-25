package app.util;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import util.FileValidator;

/**
 * @author Manuel de la Peña
 */
public class FileValidatorTest {

	@Test
	public void testIsNotSQLExtension() {
		assertThat(FileValidator.hasSQLExtension("my-file.jpg")).isFalse();
	}

	@Test
	public void testIsSQLExtension() {
		assertThat(FileValidator.hasSQLExtension("my-file.sql")).isTrue();
	}

}
