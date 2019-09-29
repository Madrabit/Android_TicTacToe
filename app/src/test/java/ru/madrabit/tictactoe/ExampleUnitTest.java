package ru.madrabit.tictactoe;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

//    @Test
//    public void whenButtons9ThenTableFill9() {
//        Logic logic = new Logic( Arrays.asList(R.id.button, R.id.button2, R.id.button3,
//                R.id.button4, R.id.button5, R.id.button6,
//                R.id.button7, R.id.button8,  R.id.button9));
//        Integer[][] result =  logic.getTable();
//        assertThat(result, is (0 ));
//    }
    
}