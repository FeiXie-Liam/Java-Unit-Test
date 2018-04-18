package tw.controllers;

import com.google.inject.Injector;
import org.junit.Test;
import tw.GuessNumberModule;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static com.google.inject.Guice.createInjector;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    @Test
    public void should_showBegin_when_game_start() throws IOException {
        ByteArrayOutputStream systemOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOut));

        Injector injector = createInjector(new GuessNumberModule());
        GameController gameController = injector.getInstance(GameController.class);

        gameController.beginGame();

        String expectedOutput = "------Guess Number Game, You have 6 chances to guess!  ------\r\n";
        assertThat(systemOut.toString(), is(expectedOutput));
    }


}