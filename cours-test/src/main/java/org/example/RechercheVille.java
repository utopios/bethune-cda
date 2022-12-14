package org.example;

import org.example.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class RechercheVille {
    private List<String> villes;

    public List<String> getVilles() {
        return villes;
    }

    public void setVilles(List<String> villes) {
        this.villes = villes;
    }

    public List<String> rechercher(String mot) throws Exception {
        if(mot.length() < 2) {
            throw new NotFoundException();
        }
        else {
            List<String> result = new ArrayList<>();
            for(String v : villes) {
                if(v.toLowerCase().startsWith(mot.toLowerCase())) {
                    result.add(v);
                }
            }
            return result;
        }

    }
}
