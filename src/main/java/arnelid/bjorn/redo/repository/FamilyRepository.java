package arnelid.bjorn.redo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import arnelid.bjorn.redo.model.Family;

public interface FamilyRepository extends MongoRepository<Family, String> {
	@Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
	public Family findByName(String name);

}
