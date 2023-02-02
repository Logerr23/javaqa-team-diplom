package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameStoreTest {
    GameStore store = new GameStore();


    @Test
    public void shouldAddGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Assertions.assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddGames() {

        Game game1 = store.publishGame("Нетология Баттл 1", "РПГ");
        Game game2 = store.publishGame("Нетология Баттл 2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл 3", "Гонки");
        Game game4 = store.publishGame("Нетология Баттл 4", "Спорт");

        Assertions.assertTrue(store.containsGame(game1));
        Assertions.assertTrue(store.containsGame(game2));
        Assertions.assertTrue(store.containsGame(game3));
        Assertions.assertTrue(store.containsGame(game4));
    }

    @Test
    public void addingTwoIdenticalGames() {

        Game game1 = store.publishGame("Нетология Баттл 1", "РПГ");
        Game game2 = store.publishGame("Та же игра", "тот же жанр");
        Game game3 = store.publishGame("Та же игра", "тот же жанр");
        Game game4 = store.publishGame("Нетология Баттл 4", "Спорт");

        Assertions.assertTrue(store.containsGame(game2));
        Assertions.assertFalse(store.containsGame(game3));
    }


    @Test
    public void addPlayTimeTest() {

        store.addPlayTime("Logerr23", 5 );
        store.addPlayTime("Logerr23", 6 );


        int expected = 11;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getMostPlayerTest() {

        store.addPlayTime("a", 6);
        store.addPlayTime("b", 6);
        store.addPlayTime("c",5);

        String expected = "a";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getMostPlayerTestAllplayedOneHour() {

        store.addPlayTime("a", 1);
        store.addPlayTime("b", 1);
        store.addPlayTime("c",1);

        String expected = "a";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getMostPlayerTestNoGamesPlayed() {

        String expected = null;
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void getSumPlayedTimeTest() {

        store.addPlayTime("Logerr23", 5 );
        store.addPlayTime("Yosya", 6);
        store.addPlayTime("Neekron",6);

        int expected = 17;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getSumPlayedTimeTestNoGamesPlayed() {

        int expected = 0;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

}
