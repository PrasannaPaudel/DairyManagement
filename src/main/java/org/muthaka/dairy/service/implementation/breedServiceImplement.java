package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.Breeding;
import org.muthaka.dairy.dao.breedDao;
import org.muthaka.dairy.service.BreedService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
public class breedServiceImplement implements BreedService {

    private breedDao breedDAO;

    public void setBreedDao(breedDao breed) {
        this.breedDAO = breed;
    }

    @Override @Transactional public void addBreed(Breeding breed) {
        this.breedDAO.addBreed(breed);
    }

    @Override @Transactional public void updateBreed(Breeding breed) {
        this.breedDAO.updateBreed(breed);
    }

    @Override @Transactional public List<Breeding> listBreed() {
        return this.breedDAO.listBreed();
    }

    @Override @Transactional public Breeding getBreedById(Integer breedId) {
        return this.breedDAO.getBreedById(breedId);
    }

    @Override @Transactional public void removeBreed(Integer breedId) {

        this.breedDAO.removeBreed(breedId);
    }

}
