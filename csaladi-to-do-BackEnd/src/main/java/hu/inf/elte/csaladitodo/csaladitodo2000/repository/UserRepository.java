package hu.inf.elte.csaladitodo.csaladitodo2000.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    public List<User> findAll();

    Optional<User> findByUsername(String username);
}
