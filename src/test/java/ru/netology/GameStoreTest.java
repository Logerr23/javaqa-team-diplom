package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class GameStoreTest {
    GameStore store = new GameStore();


    @Test
    public void shouldAddGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddGames() {

        Game game1 = store.publishGame("Нетология Баттл 1", "РПГ");
        Game game2 = store.publishGame("Нетология Баттл 2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл 3", "Гонки");
        Game game4 = store.publishGame("Нетология Баттл 4", "Спорт");

        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));
    }

    @Test
    public void addingTwoIdenticalGames() {

        Game game1 = store.publishGame("Нетология Баттл 1", "РПГ");
        Game game2 = store.publishGame("Та же игра", "тот же жанр");
        Game game3 = store.publishGame("Та же игра", "тот же жанр");
        Game game4 = store.publishGame("Нетология Баттл 4", "Спорт");

        assertTrue(store.containsGame(game2));
        assertFalse(store.containsGame(game3));
    }


    @Test
    public void addPlayTimeTest() {

        store.addPlayTime("Logerr23", 5 );
        store.addPlayTime("Logerr23", 6 );


        int expected = 11;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);

    }

    @Test
    public void getMostPlayerTest() {

        store.addPlayTime("a", 6);
        store.addPlayTime("b", 6);
        store.addPlayTime("c",5);

        String expected = "a";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }

    @Test
    public void getMostPlayerTestAllplayedOneHour() {

        store.addPlayTime("a", 1);
        store.addPlayTime("b", 1);
        store.addPlayTime("c",1);

        String expected = "a";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }

    @Test
    public void getMostPlayerTestNoGamesPlayed() {

        String expected = null;
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }
    @Test
    public void getSumPlayedTimeTest() {

        store.addPlayTime("Logerr23", 5 );
        store.addPlayTime("Yosya", 6);
        store.addPlayTime("Neekron",6);

        int expected = 17;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);

    }

    @Test
    public void getSumPlayedTimeTestNoGamesPlayed() {

        int expected = 0;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);

    }

}
