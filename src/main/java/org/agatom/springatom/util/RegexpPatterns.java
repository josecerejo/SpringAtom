/**************************************************************************************************
 * This file is part of [SpringAtom] Copyright [kornicameister@gmail.com][2013]                   *
 *                                                                                                *
 * [SpringAtom] is free software: you can redistribute it and/or modify                           *
 * it under the terms of the GNU General Public License as published by                           *
 * the Free Software Foundation, either version 3 of the License, or                              *
 * (at your option) any later version.                                                            *
 *                                                                                                *
 * [SpringAtom] is distributed in the hope that it will be useful,                                *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of                                 *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                                  *
 * GNU General Public License for more details.                                                   *
 *                                                                                                *
 * You should have received a copy of the GNU General Public License                              *
 * along with [SpringAtom].  If not, see <http://www.gnu.org/licenses/gpl.html>.                  *
 **************************************************************************************************/

package org.agatom.springatom.util;

import java.util.regex.Pattern;

/**
 * {@code RegexpPatterns} is a base for custom patterns that may be used in the application.
 *
 * @author kornicameister
 * @version 0.0.1
 * @since 0.0.1
 */
public class RegexpPatterns {
    public static final String BIG_FIRST_LETTER_PATTERN = "^[A-Z].*$";

    public static boolean matches(final String value, final String regex) {
        final Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(value).matches();
    }
}
