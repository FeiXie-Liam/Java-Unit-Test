package tw.core.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.mockito.MockitoAnnotations;

import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    @Test
    public void should_returnRandomAnswer_when_generateAnswer() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = new AnswerGenerator(new RandomIntGenerator());
        Answer answer = answerGenerator.generate();
        assertThat(answer.toString().split(" ").length, is(4));
    }

}

