package org.muthaka.dairy.dao;

import org.muthaka.dairy.Models.Breeding;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
public interface breedDao {

    public void addBreed(Breeding breed);

    public void updateBreed(Breeding breed);

    public List<Breeding> listBreed();

    public Breeding getBreedById(Integer breedId);


    public void removeBreed (Integer breedId);
}
