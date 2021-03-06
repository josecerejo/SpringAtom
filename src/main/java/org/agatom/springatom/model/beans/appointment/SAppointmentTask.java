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

package org.agatom.springatom.model.beans.appointment;

import org.agatom.springatom.model.beans.meta.SAppointmentTaskType;
import org.agatom.springatom.model.beans.meta.holder.SBasicMetaDataHolder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author kornicamaister
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity(name = "SAppointmentTask")
@Table(name = "SAppointmentTask")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "idSAppointmentTask",
                updatable = false,
                nullable = false)
)
public class SAppointmentTask
        extends SBasicMetaDataHolder<SAppointmentTaskType, Long> {
    @NotEmpty
    @Length(min = 10, max = 444)
    @Column(name = "task", nullable = false, length = 444)
    private String task;

    public String getTask() {
        return task;
    }

    public SAppointmentTask setTask(final String task) {
        this.task = task;
        return this;
    }
}
