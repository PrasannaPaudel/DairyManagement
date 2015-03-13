package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.CowRegistration;
import org.muthaka.dairy.dao.registerCowDao;
import org.muthaka.dairy.service.RegisterCowService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public class registerCowServiceImplement implements RegisterCowService {
    private registerCowDao regCowDAO;

    public void setRegCowDAO(registerCowDao regCowDAO) {this.regCowDAO = regCowDAO;
    }

    @Override @Transactional public void addCow(CowRegistration cowReg) {

        this.regCowDAO.addCow(cowReg);
    }

    @Override @Transactional public void updateCow(CowRegistration cowReg) {

        this.regCowDAO.updateCow(cowReg);
    }


    @Override @Transactional public List<CowRegistration> listCowReg() {

        return this.regCowDAO.listCowReg();
    }

    @Override @Transactional public CowRegistration getCowById(Integer cowId) {
        return this.regCowDAO.getCowById(cowId);
    }
    @Override @Transactional public CowRegistration getCowByUuid(Integer cowUuid) {
        return this.regCowDAO.getCowByUuid(cowUuid);
    }


    @Override @Transactional public void removeCow(Integer cowId) {

        this.regCowDAO.removeCow(cowId);
    }


}
