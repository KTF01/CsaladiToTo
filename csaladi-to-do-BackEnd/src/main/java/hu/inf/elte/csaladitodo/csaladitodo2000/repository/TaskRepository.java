package hu.inf.elte.csaladitodo.csaladitodo2000.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

    @Override
    public List<Task> findAll();
}
