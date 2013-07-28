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

package org.agatom.springatom.model.beans.car;

import org.agatom.springatom.model.beans.PersistentVersionedObject;
import org.agatom.springatom.model.beans.person.client.SClient;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

/**
 * @author kornicamaister
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity(name = "SCar")
@Table(name = "SCar")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "idSCar",
                updatable = false,
                nullable = false)
)
// TODO is business model update required ?
public class SCar extends PersistentVersionedObject {

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "carMaster",
            referencedColumnName = "idSCarMaster",
            updatable = true
    )
    private SCarMaster carMaster;
    @Audited(
            targetAuditMode = RelationTargetAuditMode.AUDITED
    )
    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(
            name = "owner",
            referencedColumnName = "idSClient",
            updatable = false
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SClient    owner;
    @NaturalId(
            mutable = true
    )
    @Column(
            nullable = false,
            length = 45,
            name = "licencePlate",
            unique = true
    )
    private String     licencePlate;
    @NaturalId(
            mutable = true
    )
    @Column(
            nullable = false,
            length = 45,
            name = "vinNumber",
            unique = true
    )
    private String     vinNumber;

    public SCarMaster getCarMaster() {
        return carMaster;
    }

    public void setCarMaster(final SCarMaster carMaster) {
        this.carMaster = carMaster;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(final String registrationNumber) {
        this.licencePlate = registrationNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(final String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public SClient getOwner() {
        return owner;
    }

    public void setOwner(final SClient client) {
        this.owner = client;
    }
}
