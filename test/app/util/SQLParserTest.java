package app.util;

import static org.fest.assertions.Assertions.assertThat;

import codegeneration.db.Field;
import codegeneration.db.Model;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import util.SQLParser;

import java.io.File;
import java.net.URL;
import java.util.List;

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

	@Test
	public void testParse() throws Exception {
		URL url = getClass().getResource("/tables-hypersonic.sql");

		File tables = new File(url.getPath());

		List<String> tablesSql = FileUtils.readLines(tables);

		List<Model> models = SQLParser.parse(tablesSql);

		assertThat(models.size()).isEqualTo(143);

		Model model1 = models.get(0);

		assertThat(model1.name).isEqualTo("account");
		assertThat(model1.primaryKey.name).isEqualTo("accountId");
		assertThat(model1.fields).hasSize(17);

		Field field3 = model1.fields.get(2);
		assertThat(field3.name).isEqualTo("companyId");
		assertThat(field3.type).isEqualTo("long");

		Field field5 = model1.fields.get(4);
		assertThat(field5.name).isEqualTo("userName");
		assertThat(field5.type).isEqualTo("String");
		assertThat(field5.maxLength).isEqualTo(75);
	}

}
