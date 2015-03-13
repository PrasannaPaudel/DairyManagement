package org.muthaka.dairy.dao;

import org.muthaka.dairy.Models.Workers;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public interface workersDao {

    public void addWorker(Workers worker);

    public void updateWorker(Workers worker);

    public List<Workers> listWorker();

    public Workers getWorkerById(Integer workerId);
    public Workers getWorkerByUuid(Integer workerUuid);
    public void removeWorker(Workers worker);
}
