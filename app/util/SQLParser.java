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

	public static final String REGEXP_CREATE_DATABASE = ".*(create\\s+database)\\s+(\\w+).*";
	public static final String REGEXP_CREATE_TABLE = ".*(create\\s+table)\\s+(\\w+).*";

	public static List<Model> parse(String sql) {
		System.out.println(sql);

		return Collections.emptyList();
	}

	public static boolean hasCreateDatabase(String line) {
		return _regexp(REGEXP_CREATE_DATABASE, line).matches();
	}

	public static boolean hasCreateTable(String line) {
		return _regexp(REGEXP_CREATE_TABLE, line).matches();
	}

	public static String getDatabaseName(String line) {
		MatcherWrapper matcherWrapper = _regexp(REGEXP_CREATE_DATABASE, line);

		return matcherWrapper.getGroup(2);
	}

	private static MatcherWrapper _regexp(String regexp, String line) {
		Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(line);

		MatcherWrapper wrapper = new MatcherWrapper(matcher);

		return wrapper;
	}

}