package main.java.core.exceptions;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-15 22:16:16
 * @Modified By:
 */
class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning{
    public Inning() throws BaseballException{}
    public void event() throws BaseballException{}
    public abstract void atBat() throws Foul, Strike;
    public void walk(){}
}

class StormException extends Exception{}
class RainedOut extends  StormException{}
class PopFoul extends Foul{}

interface Storm{
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
    public StormyInning() throws RainedOut, BaseballException {

    }
    public StormyInning(String s) throws RainedOut, BaseballException{
    }

    @Override
    public void atBat() throws Foul, Strike {

    }

    @Override
    public void rainHard() throws RainedOut {

    }

    @Override
    public void event(){

    }
}
