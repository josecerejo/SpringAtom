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

package org.agatom.springatom.model.beans.person.contact;

import org.agatom.springatom.model.types.meta.SMetaDataEnum;
import org.agatom.springatom.model.validators.CellPhoneNumber;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author kornicameister
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@DiscriminatorValue(value = SPersonCellPhoneContact.DISC)
final public class SPersonCellPhoneContact
        extends SPersonContact {
    public static final String DISC = "p>cellphone";

    @Override
    protected String setWithValidation(final
                                       @CellPhoneNumber
                                       String contact) {
        return contact;
    }

    @Override
    public SMetaDataEnum getType() {
        return SMetaDataEnum.SCT_CELL_PHONE;
    }
}
