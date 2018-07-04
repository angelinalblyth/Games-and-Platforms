import db.DBConsole;
import db.DBGame;
import db.DBHelper;
import models.Console;
import models.Game;
import models.Genre;
import models.Owner;

import java.util.List;


public class Runner {
    public Runner() {
    }

    public static void main(String[] args) {
        Console console1 = new Console("Sony", "PS4", "Europe");
        DBHelper.save(console1);
        Console console2 = new Console("Microsoft", "Xbox", "Europe");
        DBHelper.save(console2);
        Console console3 = new Console("Nintendo", "Switch", "Europe");
        DBHelper.save(console3);
        Game game1 = new Game("Fallout New Vegas", Genre.RPG);
        DBHelper.save(game1);
        Game game2 = new Game("Borderlands", Genre.FPS);
        DBHelper.save(game2);
        Game game3 = new Game("Assassins Creed", Genre.ACTION);
        DBHelper.save(game3);
        Owner owner1 = new Owner("Angelina", game1);
        DBHelper.save(owner1);
        Owner owner2 = new Owner("Bob", game1);
        DBHelper.save(owner2);
        Owner owner3 = new Owner("Ben", game2);
        DBHelper.save(owner3);
        List<Console> consoles = DBHelper.getAll(Console.class);
        List<Game> games = DBHelper.getAll(Game.class);
        DBConsole.addGameToConsole(console1, game1);
        DBConsole.addGameToConsole(console1, game2);
        DBConsole.addGameToConsole(console1, game3);
        DBConsole.addGameToConsole(console2, game1);
        DBConsole.addGameToConsole(console2, game2);
        DBConsole.addGameToConsole(console3, game1);
        List<Console> getListOfConsolesForGame = DBGame.getListOfConsolesForGame(game1);
        List<Game> consoleGames = DBConsole.getListOfGamesForConsole(console2);
        List<Owner> listOfOwnersHowLikeGame = DBGame.getOwnersForGame(game2);
    }
}