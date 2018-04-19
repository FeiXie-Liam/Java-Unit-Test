package tw.core;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static tw.core.GameStatus.CONTINUE;
import static tw.core.GameStatus.FAIL;
import static tw.core.GameStatus.SUCCESS;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    @Test
    public void should_return4A0B_when_Input1234() throws OutOfRangeAnswerException {

        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

        Game game = new Game(answerGenerator);

        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        game.guess(inputAnswer);

        assertThat(game.guess(inputAnswer).getResult(), is("4A0B"));
    }

    @Test
    public void should_returnTrue_when_hasInputCorrectAnswer() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

        Game game = new Game(answerGenerator);

        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        game.guess(inputAnswer);

        assertThat(game.checkStatus(), is(SUCCESS));
    }

    @Test
    public void should_returnFAIL_when_inputOver6Times() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

        Game game = new Game(answerGenerator);

        Answer inputAnswer = Answer.createAnswer("1 3 2 4");
        for (int i = 0; i < 6; i++) {
            assertThat(game.checkStatus(), is(CONTINUE));
            game.guess(inputAnswer);
        }
        assertThat(game.checkStatus(), is(FAIL));
    }
}
