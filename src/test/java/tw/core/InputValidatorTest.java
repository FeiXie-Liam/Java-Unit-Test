package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static org.junit.Assert.assertFalse;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator;

    public InputValidatorTest() {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_returnFalse_when_inputSizeIsNot4() {
        String input = "1 2 3 5 8";
        assertFalse(inputValidator.validate(input));

        input = "1 4 3";
        assertFalse(inputValidator.validate(input));
    }

    @Test
    public void should_returnFalse_when_inputNumberBiggerThan9(){
        String input = "13 3 4 5";
        assertFalse(inputValidator.validate(input));
    }
}
