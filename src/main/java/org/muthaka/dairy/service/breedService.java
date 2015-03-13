package org.muthaka.dairy.service;

import org.muthaka.dairy.Models.Breeding;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
public interface BreedService {

    public void addBreed(Breeding breed);

    public void updateBreed(Breeding breed);

    public List<Breeding> listBreed();

    public Breeding getBreedById(Integer breedId);


    public void removeBreed(Integer breedId);


}
