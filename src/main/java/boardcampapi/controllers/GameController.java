package boardcampapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boardcampapi.dtos.GameDTO;
import boardcampapi.models.GameModel;
import boardcampapi.repositories.GameRepository;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/games")
public class GameController {
    final GameRepository gameRepository;

    GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public List<GameModel> olaSpring () {
        return this.gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<GameModel> getGameById(@PathVariable("id") Long id) {
        Optional<GameModel> game = this.gameRepository.findById(id);

        if(!game.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(game.get());
    }

    @PostMapping
    public GameModel createGame(@RequestBody @Valid GameDTO body) {
        GameModel game = new GameModel(body);
        return this.gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable("id") Long id) {
        Optional<GameModel> game = this.gameRepository.findById(id);

        if(!game.isPresent()) {
            return;
        }

        this.gameRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public GameModel updateGame(@PathVariable("id") Long id, @RequestBody GameDTO body) {
        Optional<GameModel> game = this.gameRepository.findById(id);

        if(!game.isPresent()) {
            return null;
        }

        GameModel gameModel = game.get();
        gameModel.setName(body.getName());
        gameModel.setImage(body.getImage());
        gameModel.setStockTotal(body.getStockTotal());
        gameModel.setPricePerDay(body.getPricePerDay());

        return this.gameRepository.save(gameModel);
    }
    
}
