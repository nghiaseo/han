package com.han.webservice.Repository;
import com.han.webservice.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PostRepo extends JpaRepository<Post,Long> {
}
