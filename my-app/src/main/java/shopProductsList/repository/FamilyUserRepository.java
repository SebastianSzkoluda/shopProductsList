package shopProductsList.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import shopProductsList.entity.FamilyUser;

public interface FamilyUserRepository extends CrudRepository<FamilyUser,Integer>{
	@Query("SELECT fu FROM FamilyUser fu WHERE fu.email LIKE :email ")
	FamilyUser findByEmail(@Param("email") String email);
	

}
