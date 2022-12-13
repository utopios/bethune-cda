package org.example;

public class Year {
    public boolean isLeap(int y) throws Exception {
        /*if(y%4000 == 0) {
            return true;
        }
        if(y%400 == 0) {
            return true;
        }
        if(y%100 == 0) {
            return false;
        }
        if(y%4 == 0) {
            return true;
        }
        return false;*/
        return (y%4000 == 0 || y%400 == 0 || (y%4 == 0 && y%100 != 0));
    }
}
