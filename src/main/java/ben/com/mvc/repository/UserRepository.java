package ben.com.repository;

import ben.com.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByName(String name);
    User findById(Long id);
}
