package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.model.Record;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer answer;

    @Before
    public void setUp() {
        answer = new Answer();
        answer.setNumList(Arrays.asList("1", "2", "3", "4"));
    }

    @Test
    public void should_getListString_when_toString() {
        assertThat(answer.toString(), is("1 2 3 4"));
    }

    @Test
    public void should_getAnswerList_when_createAnswer(){
        answer = Answer.createAnswer("1 3 4 5");
        assertThat(answer.toString(), is("1 3 4 5"));
    }

    @Test
    public void should_return10_when_input1567(){
        Answer inputAnswer = Answer.createAnswer("1 5 6 7");
        Record record = answer.check(inputAnswer);
        int[] expectedResult = {1, 0};
        assertThat(record.getValue(), is(expectedResult));
    }
}