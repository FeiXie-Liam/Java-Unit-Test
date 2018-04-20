package tw.core;


import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    public RandomIntGeneratorTest(){
        randomIntGenerator = mock(RandomIntGenerator.class);
    }

    @Test
    public void should_returnNumberString_when_generateNums(){
        when(randomIntGenerator.generateNums(10, 4)).thenReturn("1 2 3 4");
        String result = randomIntGenerator.generateNums(10, 4);
        assertThat(result, is("1 2 3 4"));
    }
}
