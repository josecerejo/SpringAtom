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

import org.agatom.springatom.model.types.meta.SMetaDataEnum;
import org.agatom.springatom.model.types.meta.SMetaDataHolder;
import org.agatom.springatom.model.types.meta.SMetaDataType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * {@code SContact} is an interface marking the entity, which implements it,
 * as being
 *
 * @author kornicameister
 * @version 0.0.1
 * @since 0.0.1
 */
public interface SContact<SC_H extends SContactable<PK>, MD extends SMetaDataType, PK extends Serializable>
        extends SContactAware<PK>,
                SMetaDataHolder<MD> {
    String getContact();

    SContact setContact(final
                        @NotNull
                        @NotEmpty
                        String contact);

    SMetaDataEnum getType();

    SC_H getAssigned();

    SContact setAssigned(final
                         @NotNull
                         SC_H assigned);
}
