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

		repository.put(1L, new GameModel(1,
				"https://simstime.com.br/wp-content/uploads/2019/07/Nova-Capa-The-Sims-4.jpg", "The Sims 4",
				"Simulador de Vida", 199.90,
				"Os jogadores criam um Sim e controlam sua vida de modo semelhante ao da vida real, de forma não linear, já que não há um objetivo específico a ser realizado.",
				"https://bit.ly/35sTARz"));

		repository.put(2L, new GameModel(2, "https://images-na.ssl-images-amazon.com/images/I/81gXqxyFrxL.jpg",
				"God Of War", "Ação e Aventura", 49.90,
				"É uma série de jogos eletrônicos de ação-aventura vagamente baseado nas mitologias grega e nórdica sendo criado originalmente por David Jaffe da Santa Monica Studio.",
				"https://amzn.to/2SkXM0l"));

		repository.put(3L, new GameModel(3,
				"https://upload.wikimedia.org/wikipedia/pt/a/aa/The_Elder_Scrolls_5_Skyrim_capa.png",
				"The Elder Scrolls V: Skyrim", "RPG", 52.80,
				"Os acontecimentos do jogo passam-se duzentos anos depois da, já quase esquecida, crise de Oblivion, no ano 201 da quarta era (4E 201) na província de Skyrim, no norte de Tamriel.",
				"https://bit.ly/2KMZfbu"));

		repository.put(4L, new GameModel(4,
				"https://upload.wikimedia.org/wikipedia/pt/8/80/Grand_Theft_Auto_V_capa.png", "Grand Theft Auto V",
				"Ação e Aventura", 80.54,
				"Os jogadores controlam três protagonistas e podem alternar entre eles durante e fora das missões. A história é centrada em sequências de assaltos, com muitas missões envolvendo a jogabilidade de tiro e direção.",
				"https://bit.ly/3aQ6dH2"));
	}

	public List<GameModel> findAll() {
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
