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
        int max = 10;
        if(!_lastFrame) {
            if(rolls.size() >=2 ) {
                return false;
            }
            if(rolls.size() > 0) {
                int firstRollPins = rolls.get(0).getPins();
                if(firstRollPins == 10){
                    return false;
                }
                max = 10 -firstRollPins;
            }
            int s = _generateur.randomPin(max);
            Roll roll = new Roll(s);
            rolls.add(roll);
            return true;
        }
        else {
            if(rolls.size() == 1) {
                int firstRollPins = rolls.get(0).getPins();
                max = 10 -firstRollPins;
                int s = _generateur.randomPin(max);
                Roll roll = new Roll(s);
                rolls.add(roll);
                return true;
            }
            return true;
        }
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