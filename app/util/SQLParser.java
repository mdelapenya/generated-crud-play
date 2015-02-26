package util;

import codegeneration.db.Field;
import codegeneration.db.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Manuel de la Peña
 */
public class SQLParser {

	public static final String REGEXP_CREATE_DATABASE = ".*(create\\s+database)\\s+(\\w+).*";
	public static final String REGEXP_CREATE_TABLE = ".*(create\\s+table)\\s+(\\w+).*";
	public static final String REGEXP_END_CREATE_TABLE = ".*(\\);).*";

	public static List<Model> parse(List<String> sqls) {

		List<Model> models = new ArrayList<>();

		for (int i = 0; i < sqls.size(); i++) {
			String sql = sqls.get(i);

			if (hasCreateDatabase(sql)) {
				throw new IllegalArgumentException(
					"Create database must not be present");
			}

			MatcherWrapper matchCreateTable =  _getMatcherWrapper(
				REGEXP_CREATE_TABLE, sql);

			if (matchCreateTable.matches()) {
				Matcher matcher = matchCreateTable.getMatcher();

				String tableName = matcher.group(2);

				Model model = new Model();

				model.name = _sanitizelName(tableName.toLowerCase());

				// look for fields

				List<Field> fields = new ArrayList<>();

				i++;

				if (i == sqls.size()) {
					continue;
				}

				sql = sqls.get(i);

				while(!_regexp(REGEXP_END_CREATE_TABLE, sql)) {
					Field field = new Field();

					String[] fieldTokens = sql.trim().split("\\s+");

					// two first elements are fixed: fieldName and fieldType
					field.name = _sanitizelName(fieldTokens[0]);

					String fieldType = fieldTokens[1];

					// verify if the field type is the last token

					String[] fieldTypeTokens = fieldType.split(",");

					fieldType = fieldTypeTokens[0];

					field.type = _convertType(fieldType);

					// is varchar with custom length??

					MatcherWrapper fieldTypeWrapper = _getMatcherWrapper(
						"(.*)\\((\\d*)\\)", fieldType);

					if (fieldTypeWrapper.matches()) {
						field.type = _convertType(fieldTypeWrapper.getGroup(1));

						field.maxLength = Integer.valueOf(
							fieldTypeWrapper.getGroup(2));
					}

					field.typeUppercase =
						field.type.substring(0, 1).toUpperCase() +
							field.type.substring(1);

					field.minLength = 0;
					field.isRequired = _regexp(".*(not\\snull).*", sql);
					field.isPrimaryKey = _regexp(".*(primary\\skey).*", sql);

					if (field.isPrimaryKey) {
						model.primaryKey = field.name;
					}

					fields.add(field);

					i++;

					sql = sqls.get(i);
				}

				model.fields = fields;

				models.add(model);
			}
		}

		return models;
	}

	public static boolean hasCreateDatabase(String line) {
		return _getMatcherWrapper(REGEXP_CREATE_DATABASE, line).matches();
	}

	public static boolean hasCreateTable(String line) {
		return _getMatcherWrapper(REGEXP_CREATE_TABLE, line).matches();
	}

	public static String getDatabaseName(String line) {
		MatcherWrapper matcherWrapper = _getMatcherWrapper(
			REGEXP_CREATE_DATABASE, line);

		return matcherWrapper.getGroup(2);
	}

	private static String _convertType(String type) {
		if (type.equalsIgnoreCase("bigint")) {
			return "long";
		}
		else if (type.equalsIgnoreCase("int")) {
			return "int";
		}
		else if (type.equalsIgnoreCase("double")) {
			return "double";
		}
		else if (type.equalsIgnoreCase("varchar") ||
			type.equalsIgnoreCase("longvarchar")) {

			return "String";
		}
		else if (type.equalsIgnoreCase("bit")) {
			return "boolean";
		}
		else if (type.equalsIgnoreCase("timestamp")) {
			return "Date";
		}

		return type;
	}

	private static MatcherWrapper _getMatcherWrapper(
		String regexp, String line) {

		Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(line);

		MatcherWrapper wrapper = new MatcherWrapper(matcher);

		return wrapper;
	}

	private static boolean _regexp(String regexp, String line) {
		Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(line);

		return matcher.matches();
	}

	private static String _sanitizelName(String name) {
		return name.trim().replace("_", "");
	}
}
