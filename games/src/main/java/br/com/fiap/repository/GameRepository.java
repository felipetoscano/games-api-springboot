package br.com.fiap.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.model.GameModel;

public class GameRepository {
	
	private static GameRepository instance;
	private static Map<Long, GameModel> repository;
	private static long autoID;
	
	public static GameRepository getInstance() {
		if (instance == null)
			instance = new GameRepository();
		return instance;
	}
	
	private GameRepository() {
		repository = new HashMap<Long, GameModel>();
		autoID = 0;
		
		// Criar mocks
	}
	
	public List<GameModel> findAll(){
		return new ArrayList<GameModel>(repository.values());
	}
	
	public GameModel findByID(long id) {
		return repository.get(id);
	}
	
	public void create(GameModel game) {
		game.setId(autoID);
		repository.put(autoID, game);
		autoID++;
	}
	
	public void update(GameModel game) {
		repository.put(game.getId(), game);
	}
	
	public void deleteByID(long id) {
		repository.remove(id);
	}
}
