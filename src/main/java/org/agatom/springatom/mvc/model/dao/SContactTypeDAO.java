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

package org.agatom.springatom.mvc.model.dao;

import org.agatom.springatom.model.beans.meta.SContactType;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author kornicameister
 * @version 0.0.1
 * @since 0.0.1
 */

@NoRepositoryBean
public interface SContactTypeDAO
        extends DAORepository<SContactType, Long> {

    SContactType findByType(final ContactType type);

    public static enum ContactType {
        FAX_TYPE("fax"),
        CELL_PHONE_TYPE("cellPhone"),
        MAIL_TYPE("mail"),
        PHONE_TYPE("phone");

        private final String type;

        ContactType(final String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return this.type;
        }
    }

}
