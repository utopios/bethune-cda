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
            /*if(rolls.size() >=2 ) {
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
            return true;*/
            if(rolls.size() == 0 || (rolls.size() < 2 && rolls.get(0).getPins() < 10)) {
                max = rolls.size() == 0 ? 10 : 10 - rolls.get(0).getPins();
                Roll roll = new Roll(_generateur.randomPin(max));
                rolls.add(roll);
                return true;
            }
            return false;
        }
        else {
            /*if(rolls.size() <= 2 && (rolls.get(0).getPins() == 10 || (rolls.get(1).getPins() +rolls.get(0).getPins() == 10))) {
                int firstRollPins = rolls.get(0).getPins();
                if(rolls.size()<= 1) {
                    max = (firstRollPins == 10) ? 10 : 10 - firstRollPins;
                }
                else {
                    max = (rolls.get(1).getPins() == 10 || (rolls.get(1).getPins() +rolls.get(0).getPins() == 10)) ? 10 : 10 - rolls.get(1).getPins();
                }

                int s = _generateur.randomPin(max);
                Roll roll = new Roll(s);
                rolls.add(roll);
                return true;
            }*/
            if(rolls.size() <= 2 && (rolls.get(0).getPins() == 10 || (rolls.get(1).getPins() +rolls.get(0).getPins() == 10))) {
                max = (rolls.size() == 2 && rolls.get(1).getPins() +rolls.get(0).getPins() != 10) ? (10 - rolls.get(1).getPins()) : 10;
                Roll roll = new Roll(_generateur.randomPin(max));
                rolls.add(roll);
                return true;
            }
            return false;
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