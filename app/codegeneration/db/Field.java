package codegeneration.db;

/**
 * @author Manuel de la Peña
 */
public class Field {

	public String name;
	public boolean isPrimaryKey;
	public boolean isRequired;
	public int maxLength;
	public int minLength;
	public String type;
	public String typeUppercase;

	public boolean hasMaxLength() {
		return (maxLength > 0);
	}

	public boolean hasMinLength() {
		return (minLength > 0);
	}

}
