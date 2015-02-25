package util;

import codegeneration.db.Model;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Manuel de la Peña
 */
public class SQLParser {

	public static final String REGEXP_CREATE_DATABASE = "(.*)((create)\\s+(database)\\s+(\\w+))(.*)";
	public static final String REGEXP_CREATE_TABLE = "(.*)((create)\\s+(table)\\s+(\\w+))(.*)";

	public static List<Model> parse(String sql) {
		System.out.println(sql);

		return Collections.emptyList();
	}

	public static boolean hasCreateDatabase(String line) {
		return _regexp(REGEXP_CREATE_DATABASE, line);
	}

	public static boolean hasCreateTable(String line) {
		return _regexp(REGEXP_CREATE_TABLE, line);
	}

	private static boolean _regexp(String regexp, String line) {
		Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(line);

		return matcher.matches();
	}

}