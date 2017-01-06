package xyz.codingmentor.confusing.andris.main;

import xyz.codingmentor.confusing.andris.annotation.Confusing;
import xyz.codingmentor.confusing.andris.reflection.Reflection;

/**
 *
 * @author brianelete
 */
@Confusing
public class Main {

    private Main() {
        //empty
    }

    public static void main(String[] args) {
        Reflection.analyze(Main.class);
    }
    
    @Confusing
    public static void useless(){
        //im useless
    }
}
