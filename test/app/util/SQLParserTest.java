package app.util;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import util.SQLParser;

/**
 * @author Manuel de la Peña
 */
public class SQLParserTest {

	@Test
	public void testHasCreateDatabase1() throws Exception {
		String sql = "create database foo";

		boolean matches = SQLParser.hasCreateDatabase(sql);

		assertThat(matches).isTrue();

		String databaseName = SQLParser.getDatabaseName(sql);

		assertThat(databaseName).isEqualToIgnoringCase("foo");
	}

	@Test
	public void testHasCreateDatabase2() throws Exception {
		String sql = "    CREATE DATABASE FOO";

		boolean matches = SQLParser.hasCreateDatabase(sql);

		assertThat(matches).isTrue();

		String databaseName = SQLParser.getDatabaseName(sql);

		assertThat(databaseName).isEqualToIgnoringCase("foo");
	}

	@Test
	public void testHasCreateDatabase3() throws Exception {
		String sql = "CREATE     DATABASE FOO";

		boolean matches = SQLParser.hasCreateDatabase(sql);

		assertThat(matches).isTrue();

		String databaseName = SQLParser.getDatabaseName(sql);

		assertThat(databaseName).isEqualToIgnoringCase("foo");
	}

	@Test
	public void testHasCreateTable1() throws Exception {
		boolean matches = SQLParser.hasCreateTable("create table foo");

		assertThat(matches).isTrue();
	}

	@Test
	public void testHasCreateTable2() throws Exception {
		boolean matches = SQLParser.hasCreateTable("   CREATE TABLE FOO");

		assertThat(matches).isTrue();
	}

	@Test
	public void testHasCreateTable3() throws Exception {
		boolean matches = SQLParser.hasCreateTable("CREATE     TABLE FOO");

		assertThat(matches).isTrue();
	}

}