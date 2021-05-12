package kiryakova.cars.repository;

import kiryakova.cars.domain.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {
    Optional<Owner> findByEgn(Long egn);

    Optional<Owner> findById(String id);

    @Query(value = "SELECT * FROM owners ORDER BY egn ASC"
            , nativeQuery = true)
    List<Owner> findAllOwners();

}
