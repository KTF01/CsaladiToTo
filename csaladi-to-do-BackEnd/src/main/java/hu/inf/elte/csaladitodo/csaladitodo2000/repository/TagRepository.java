package hu.inf.elte.csaladitodo.csaladitodo2000.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {

    @Override
    public List<Tag> findAll();
}
