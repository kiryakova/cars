package kiryakova.cars.repository;

import kiryakova.cars.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    Optional<Car> findByRegNumber(String regNumber);

    //Optional<Car> findById(String id);

    /*@Query(value = "SELECT * FROM cars WHERE id = :id"
            , nativeQuery = true)
    Optional<Car> findById(@Param("id") String id);*/

    @Query(value = "SELECT * FROM cars ORDER BY reg_number ASC"
            , nativeQuery = true)
    List<Car> findAllCars();

    @Query(value = "SELECT * FROM cars c " +
            "JOIN models m ON(c.model_id = m.id) " +
            "JOIN brands b ON(m.brand_id = b.id) " +
            "WHERE m.brand_id = :brandId " +
            "ORDER BY c.reg_number ASC "
            , nativeQuery = true)
    List<Car> findAllByBrandId(@Param("brandId") String brandId);

    @Query(value = "SELECT * FROM cars c " +
            "JOIN models m ON(c.model_id = m.id) " +
            "JOIN brands b ON(m.brand_id = b.id) " +
            "WHERE m.brand_id = :brandId AND c.model_id = :modelId " +
            "ORDER BY c.reg_number ASC "
            , nativeQuery = true)
    List<Car> findAllByBrandIdAndModelId(@Param("brandId") String brandId,
                                         @Param("modelId") String modelId);

    /*
    @Query(value = "SELECT * FROM cars WHERE brand_id = :brandId " +
            "AND model_id = :modelId ORDER BY reg_number ASC"
            , nativeQuery = true)
    List<Car> findAllByBrandIdAndModelId(@Param("brandId") String brandId,
                                                   @Param("modelId") String modelId);
    */
}
