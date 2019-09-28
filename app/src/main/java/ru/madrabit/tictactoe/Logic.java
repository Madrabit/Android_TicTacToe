package ru.madrabit.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logic {
    private final List<Integer> btns;
    private final List<Integer> sequence = new ArrayList<>();
    private final List<Integer> answers = new ArrayList<>();

    public Logic(List<Integer> btns) {
        this.btns = btns;
    }

    public List<Integer> rnd() {
        Random rn = new Random();
        sequence.add(btns.get(rn.nextInt(3)));
        return sequence;
    }

    public void addAnswer(Integer id) {
        answers.add(id);
    }

    public boolean check() {
        boolean rsl = true;
        for (int index = 0; index != answers.size(); index++) {
            if (!answers.get(index).equals(sequence.get(index))) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public boolean isFinish() {
        return sequence.size() == answers.size();
    }

    public void cleanAnswers() {
        answers.clear();
    }

    public void cleanSeq() {
        sequence.clear();
    }

    public int level() {
        return sequence.size();
    }
    
    public boolean hasGap() {
        for (Object btn : btns) {
            btn.
        }
    }
    
}
