package codegeneration.db;

import java.util.List;

/**
 * @author Manuel de la Peña
 */
public class Model {

	public String name;
	public Field primaryKey;
	public List<Field> fields;

	public String getName() {
		return this.name;
	}

	public Field getPrimaryKey() {
		return this.primaryKey;
	}

	public List<Field> getFields() {
		return this.fields;
	}

}
