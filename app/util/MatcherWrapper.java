package util;

import java.util.regex.Matcher;

/**
 * Wraps a regexp matcher to have access to groups in the regexp.
 *
 * @author Manuel de la Peña
 */
public class MatcherWrapper {

	/**
	 * Creates a MatcherWrapper from a matcher, defining if the matcher matches
	 * its regexp, and the groups in the regexp.
	 *
	 * @param matcher
	 */
	public MatcherWrapper(Matcher matcher) {
		_matches = matcher.matches();

		if (_matches) {
			_groups = new String[matcher.groupCount() + 1];

			for (int i = 0; i < _groups.length; i++) {
				_groups[i] = matcher.group(i);
			}
		}
	}

	/**
	 * Returns the group in an specific position
	 *
	 * @param pos the position of the group
	 * @return the group in the position index
	 */
	public String getGroup(int pos) {
		if (_groups == null || pos < 0 || pos >= _groups.length) {
			return null;
		}

		return _groups[pos];
	}

	/**
	 * Returns the groups of the matcher
	 *
	 * @return the groups of the matcher
	 */
	public String[] getGroups() {
		return _groups;
	}

	/**
	 * Returns if the matcher matches after the regexp is processed
	 *
	 * @return if the matcher matches after the regexp is processed
	 */
	public boolean matches() {
		return _matches;
	}

	/**
	 * The groups contained in a matched regexp. If the regexp is not matched,
	 * then the array is null
	 */
	private String[] _groups;

	/**
	 * The result of a matching pattern of a regexp.
	 */
	private boolean _matches;

}
