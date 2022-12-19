package org.example;

import org.example.interfaces.IGenerateurBowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score;
    private boolean _lastFrame;
    private IGenerateurBowling _generateur;
    private List<Roll> rolls;

    public Frame(IGenerateurBowling generateur, boolean lastFrame) {
        _lastFrame = lastFrame;
        _generateur = generateur;
        rolls = new ArrayList<>();
    }

    public boolean makeRoll() throws Exception {
        Roll roll = new Roll(_generateur.randomPin(10));
        rolls.add(roll);
        return true;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    public int getScore() {
        score = 0;
        for (Roll r : rolls) {
            score += r.getPins();
        }
        return score;
    }
}