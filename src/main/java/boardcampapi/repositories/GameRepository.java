package boardcampapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boardcampapi.models.GameModel;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long>{
}
