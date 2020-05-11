package codegeneration.db;

/**
 * @author Manuel de la Peña
 */
public class Field {

	public String name;
	public boolean primaryKey;
	public boolean required;
	public int maxLength;
	public int minLength;
	public String type;
	public String typeUppercase;

	public boolean getPrimaryKey() {
		return this.primaryKey;
	}

	public boolean getRequired() {
		return this.required;
	}

	public boolean hasMaxLength() {
		return (maxLength > 0);
	}

	public boolean hasMinLength() {
		return (minLength > 0);
	}

	public int getMaxLength() {
		return this.maxLength;
	}

	public int getMinLength() {
		return this.minLength;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public String getTypeUppercase() {
		return this.typeUppercase;
	}
}
