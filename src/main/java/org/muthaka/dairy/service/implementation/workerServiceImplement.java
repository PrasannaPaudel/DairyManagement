package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.Workers;
import org.muthaka.dairy.dao.workersDao;
import org.muthaka.dairy.service.WorkerService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public class workerServiceImplement implements WorkerService {


    private workersDao workersDAO;

    public void setWorkersDao(workersDao workersDAO) {this.workersDAO = workersDAO;
    }

    @Override @Transactional public void addWorker(Workers worker) {
        this.workersDAO.addWorker(worker);
    }

    @Override @Transactional
    public void updateWorker (Workers worker) {
        this.workersDAO.updateWorker(worker);
    }

    @Override @Transactional public List<Workers> listWorker() {
        return this.workersDAO.listWorker();
    }

    @Override @Transactional
    public Workers getWorkerById(Integer healthId) {
        return this.workersDAO.getWorkerById(healthId);
    }
    @Override @Transactional
    public Workers getWorkerByUuid(Integer healthUuid) {
        return this.workersDAO.getWorkerByUuid(healthUuid);
    }
    @Override @Transactional
    public void removeWorker (Workers worker) {
        this.workersDAO.removeWorker(worker);
    }
}
