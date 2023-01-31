package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerTest {
    GameStore store = new GameStore();

    Player player = new Player("Yosya");
    Game game1 = store.publishGame("Битва котиков", "шутер");
    Game game2 = store.publishGame("Собери скворечник", "Стратегия");
    Game game3 = store.publishGame("Найди конфету", "Стратегия");


    @Test
    public void shouldAddPlayedTimeIfOneGame() {

        player.installGame(game1);
        player.play(game1, 3);

        int expected = 4;
        int actual = player.play(game1, 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayedTimeIfTwoGame() {
        player.installGame(game2);
        player.installGame(game3);

        player.play(game2,2);

        int expected = 1;
        int actual = player.play(game3, 1);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSumGenreIfOneGame() {

        player.installGame(game1);
        player.play(game1, 3);

        int expected = 3;
        int actual = player.sumGenre(game1.getGenre());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {

        player.installGame(game2);
        player.installGame(game3);
        player.play(game2, 3);
        player.play(game3, 1);

        int expected = 4;
        int actual = player.sumGenre(game2.getGenre());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroIfNoGameOfGenre() {
        player.installGame(game1);

        int expected = 0;
        int actual = player.sumGenre(game2.getGenre());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMostPlayer() {
        player.installGame(game2);
        player.installGame(game3);

        player.play(game2, 1);
        player.play(game3, 2);


        Game expected = game3;
        Game actual = player.mostPlayerByGenre("Стратегия");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMostPlayerIfSame() {
        player.installGame(game2);
        player.installGame(game3);

        player.play(game2, 2);
        player.play(game3, 2);


        Game expected = game3;
        Game actual = player.mostPlayerByGenre("Стратегия");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMostPlayerIfOne() {
        player.installGame(game2);

        player.play(game2, 2);

        Game expected = game2;
        Game actual = player.mostPlayerByGenre("Стратегия");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMostPlayerIfNotDisiredGenre() {
        player.installGame(game2);
        player.installGame(game1);

        player.play(game2, 2);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("шутер");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMostPlayerIfNone() {

        Game expected = null;
        Game actual = player.mostPlayerByGenre("Стратегия");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMostPlayerIfNotPlay() {
        player.installGame(game1);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("шутер");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotInstallAlreadyExistGame() {
        player.installGame(game2);
        player.play(game2, 2);

        player.installGame(game2);

        int expected = 3;
        int actual = player.play(game2, 1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIfNoInstallWhenPlay() {

        Assertions.assertThrows(RuntimeException.class, () -> player.play(game2, 2));
    }
}