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

package org.agatom.springatom.model.types.contact;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * {@code SMultiContactable} means that the type that extends such type
 * can be accessed in that or another way.
 * For example it could be an <b>email</b> or <b>phone number</b>.
 * Generally all kind of {@link SContact} are valid for this interface to serve as contact points.
 *
 * @author kornicameister
 * @version 0.0.1
 * @since 0.0.1
 */
public interface SMultiContactable<PK extends Serializable>
        extends SContactable<PK> {
    <SC extends SContact<?, ?, ?>> List<SC> getContacts();

    <SC extends SContact<?, ?, ?>> SMultiContactable addContact(final Collection<SC> contacts);

    <SC extends SContact<?, ?, ?>> SMultiContactable removeContact(final Collection<SC> contacts);
}
