package shopProductsList.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import shopProductsList.entity.Family;

public interface FamilyRepository extends CrudRepository<Family, Integer> {
	@Query("SELECT f FROM Family f WHERE f.familyName LIKE :familyName ")
	Family findByName(@Param("familyName") String familyName);
}
