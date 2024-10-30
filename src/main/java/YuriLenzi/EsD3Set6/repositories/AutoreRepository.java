package YuriLenzi.EsD3Set6.repositories;

import YuriLenzi.EsD3Set6.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {

    boolean existsByemail(String email);
}
