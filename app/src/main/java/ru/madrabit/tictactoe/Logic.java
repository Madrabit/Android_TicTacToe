package ru.madrabit.tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Logic {
    private final List<Integer> btns;
    private final List<Integer> sequence = new ArrayList<>();


    private final Integer[][] table = new Integer[3][3];
    private final Integer[][] answers = new Integer[3][3];
    private int size = 0;
    int count = 0;


    public Logic(List<Integer> btns) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = btns.get(count++);
            }
        }
        this.btns = btns;
    }

    public Integer[][] getTable() {
        return table;
    }

    public Integer[][] getAnswers() {
        return answers;
    }

    public int getSize() {
        return size;
    }

    public void addAnswer(Integer id) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == id) {
                    if (answers[i][j] == null) {
                        answers[i][j] = 1;
                        size++;
                    }
                }
            }
        }
        botMove();
    }

    public void botMove() {
        Random rn = new Random();
        int id = btns.get(rn.nextInt(count));
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == id && answers[i][j] != null) {
                    botMove();
                }
                if (table[i][j] == id) {
                    if (answers[i][j] == null) {
                        answers[i][j] = 0;
                        size++;
                    }
                }
            }
        }
    }

    public boolean isDiagonal() {
        boolean flagOne = true;
        boolean flagTwo = true;
        for (int i = 0; i < answers.length - 1; i++) {
            if (answers[i][i] != answers[i + 1][i + 1]) {
                flagOne = false;
            }
            if (answers[i][answers.length - (1 +
                    i)] != answers[i + 1][answers.length - (2 + i)]) {
                flagTwo = false;
            }
        }
        return flagOne || flagTwo;
    }


    public boolean isHorizontal() {
        boolean result = true;
        for (int row = 0; row < answers.length; row++) {
            result = true;
            for (int cell = 0; cell < answers.length - 1; cell++) {
                if (answers[row][cell] == null || answers[row][cell] != answers[row][cell + 1]) {
                    result = false;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    public boolean isVertical() {
        boolean result = true;
        for (int row = 0; row < answers.length; row++) {
            result = true;
            for (int cell = 0; cell < answers.length - 1; cell++) {
                if (answers[cell][row] == null || answers[cell][row] != answers[cell + 1][row]) {
                    result = false;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    public boolean hasGap() {
        return size == count ? false : true;
    }

    public boolean check() {
        boolean rsl = true;
        for (int index = 0; index != answers.length; index++) {
//            if (!answers.get(index).equals(sequence.get(index))) {
//                rsl = false;
//                break;
//            }
        }
        return rsl;
    }



    public void cleanAnswers() {
//        answers.clear();
    }

    public void cleanSeq() {
        sequence.clear();
    }

    public int level() {
        return sequence.size();
    }

    public List<Integer> rnd() {
        Random rn = new Random();
        sequence.add(btns.get(rn.nextInt(3)));
        return sequence;
    }
}
