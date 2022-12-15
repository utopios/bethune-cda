package org.example;

import org.example.exception.ErrorWordException;
import org.example.interfaces.IGenerateur;

public class LePendu {
    private int nbEssai;
    private String masque;
    private String motATrouve;

    public LePendu() {
        nbEssai = 10;
    }

    public int getNbEssai() {
        return nbEssai;
    }

    public String getMasque() {
        return masque;
    }

    public void genererMasque(IGenerateur generateurMot) throws Exception {
        motATrouve = generateurMot.generer();
        if(motATrouve == null || motATrouve.equals("")) {
            throw new ErrorWordException();
        }
        String tmpMasque = "";
        for(int i=0; i < motATrouve.length(); i++) {
            tmpMasque += "*";
        }
        masque = tmpMasque;
    }

    public boolean testChar(char c) throws Exception {
        if(motATrouve.contains(String.valueOf(c))) {
            return true;
        }
        else {
            this.nbEssai--;
            return false;
        }
    }

    public boolean testWin() throws Exception {
        throw new Exception();
    }
}
