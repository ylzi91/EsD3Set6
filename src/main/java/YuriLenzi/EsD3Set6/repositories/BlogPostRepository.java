package YuriLenzi.EsD3Set6.repositories;

import YuriLenzi.EsD3Set6.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
