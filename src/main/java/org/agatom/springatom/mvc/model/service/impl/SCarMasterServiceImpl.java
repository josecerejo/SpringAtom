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

package org.agatom.springatom.mvc.model.service.impl;

import com.mysema.query.types.expr.BooleanExpression;
import org.agatom.springatom.jpa.repositories.SCarMasterRepository;
import org.agatom.springatom.jpa.repositories.SCarRepository;
import org.agatom.springatom.model.beans.car.QSCar;
import org.agatom.springatom.model.beans.car.QSCarMaster;
import org.agatom.springatom.model.beans.car.SCar;
import org.agatom.springatom.model.beans.car.SCarMaster;
import org.agatom.springatom.model.beans.car.embeddable.QSCarMasterManufacturingData;
import org.agatom.springatom.mvc.model.service.SCarMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author kornicameister
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
@Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE, propagation = Propagation.SUPPORTS)
public class SCarMasterServiceImpl
        extends SBasicServiceImpl<SCarMaster, Long, SCarMasterRepository>
        implements SCarMasterService {
    @Autowired
    SCarRepository carRepository;
    private SCarMasterRepository repository;

    @Override
    @Autowired
    public void autoWireRepository(final SCarMasterRepository repo) {
        super.autoWireRepository(repo);
        this.repository = repo;
    }

    @Override
    public List<SCarMaster> findByBrand(@NotNull final String... brand) {
        return (List<SCarMaster>) this.repository.findAll(QSCarMaster.sCarMaster.manufacturingData.brand.in(brand));
    }

    @Override
    public List<SCarMaster> findByModel(@NotNull final String... model) {
        return (List<SCarMaster>) this.repository.findAll(QSCarMaster.sCarMaster.manufacturingData.model.in(model));
    }

    @Override
    public SCarMaster findOne(@NotNull final String brand, @NotNull final String model) {
        final QSCarMasterManufacturingData manufacturingData = QSCarMaster.sCarMaster.manufacturingData;
        final BooleanExpression brandEq = manufacturingData.brand.eq(brand);
        final BooleanExpression modelEq = manufacturingData.model.eq(model);
        return this.repository.findOne(brandEq.and(modelEq));
    }

    @Override
    public List<SCar> findChildren(@NotNull final Long... masterId) {
        return (List<SCar>) this.carRepository.findAll(QSCar.sCar.carMaster.id.in(masterId));
    }
}
