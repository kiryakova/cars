package kiryakova.cars.repository;

import kiryakova.cars.domain.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
    Optional<Model> findByName(String name);

    Optional<Model> findById(String id);

    @Query(value = "SELECT * FROM models ORDER BY model_name ASC"
            , nativeQuery = true)
    List<Model> findAllModels();

    @Query(value = "SELECT * FROM models WHERE brand_id = :brandId " +
            "ORDER BY model_name ASC"
            , nativeQuery = true)
    List<Model> findAllModelsByBrandId(@Param("brandId") String brandId);

}