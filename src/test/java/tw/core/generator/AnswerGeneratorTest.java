package tw.core.generator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    private RandomIntGenerator randomIntGenerator;
    public AnswerGeneratorTest(){
        randomIntGenerator = mock(RandomIntGenerator.class);
    }
    @Test
    public void should_returnRandomAnswer_when_generateAnswer() throws OutOfRangeAnswerException {
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Answer answer = answerGenerator.generate();
        assertThat(answer.toString(), is("1 2 3 4"));
    }

}

