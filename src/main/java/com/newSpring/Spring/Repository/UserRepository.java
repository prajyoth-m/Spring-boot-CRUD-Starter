package com.newSpring.Spring.Repository;

import com.newSpring.Spring.hashtagHyderabad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<hashtagHyderabad, String>{
    hashtagHyderabad findByUser(String name);
}
