package ru.madrabit.tictactoe;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void addAnswer() {
        Logic logic = new Logic(Arrays.asList(R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9));
        logic.addAnswer(logic.getTable()[2][2]);
        Integer result = logic.getAnswers()[2][2];
        assertThat(result, is(1));
    }

    @Test
    public void isDiagonal() {
        Logic logic = new Logic(Arrays.asList(R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9));
        logic.addAnswer(logic.getTable()[0][0]);
        logic.addAnswer(logic.getTable()[1][1]);
        logic.addAnswer(logic.getTable()[2][2]);
        assertThat(true, is(logic.isDiagonal()));
    }

    @Test
    public void isHorizontal() {
        Logic logic = new Logic(Arrays.asList(R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9));
        logic.addAnswer(logic.getTable()[0][0]);
        logic.addAnswer(logic.getTable()[0][1]);
        logic.addAnswer(logic.getTable()[0][2]);
        assertThat(true, is(logic.isHorizontal()));
    }

    @Test
    public void isVertical() {
        Logic logic = new Logic(Arrays.asList(R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9));
        logic.addAnswer(logic.getTable()[0][0]);
        logic.addAnswer(logic.getTable()[1][0]);
        logic.addAnswer(logic.getTable()[2][0]);
        assertThat(true, is(logic.isVertical()));
    }

    @Test
    public void hasNoGap() {
        Logic logic = new Logic(Arrays.asList(R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9));
        for (int i = 0; i < logic.getTable().length; i++) {
            for (int j = 0; j < logic.getTable()[i].length; j++) {
                logic.addAnswer(logic.getTable()[i][j]);
            }
        }
        assertThat(false, is(logic.hasGap()));
    }

    @Test
    public void botMove() {
        Logic logic = new Logic(Arrays.asList(R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9));
        Integer move = logic.botMove();
        int result = logic.getSize();
        assertThat(result, is(1));
    }



}