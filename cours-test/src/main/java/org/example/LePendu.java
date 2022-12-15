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
        String motAtrouve = generateurMot.generer();
        if(motAtrouve == null || motAtrouve.equals("")) {
            throw new ErrorWordException();
        }
        String tmpMasque = "";
        for(int i=0; i < motAtrouve.length(); i++) {
            tmpMasque += "*";
        }
        masque = tmpMasque;
    }

    public boolean testChar(char c) throws Exception {
        throw new Exception();
    }

    public boolean testWin() throws Exception {
        throw new Exception();
    }
}
