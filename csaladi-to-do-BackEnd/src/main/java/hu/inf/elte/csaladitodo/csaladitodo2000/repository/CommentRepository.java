package hu.inf.elte.csaladitodo.csaladitodo2000.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    @Override
    public List<Comment> findAll();
}
