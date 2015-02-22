package controller;

import static org.fest.assertions.Assertions.assertThat;

import controllers.FileValidator;

import org.junit.Test;

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
