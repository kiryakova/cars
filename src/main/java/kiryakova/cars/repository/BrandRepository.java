package kiryakova.cars.repository;

import kiryakova.cars.domain.entities.Brand;
import kiryakova.cars.domain.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    Optional<Brand> findByName(String name);

    @Query(value = "SELECT * FROM brands ORDER BY brand_name ASC"
            , nativeQuery = true)
    List<Brand> findAllBrands();

    @Query(value = "SELECT * FROM brands WHERE id = :brandId " +
            "ORDER BY brand_name ASC"
            , nativeQuery = true)
    List<Brand> findAllBrandsByBrandId(@Param("brandId") String brandId);
}