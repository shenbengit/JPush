package factory;

import impl.JPushImpl;
import listener.JPushListener;

public class JPushFactory {
    public static JPushListener getInstance(){
        return initJPush();
    }

    private static JPushListener initJPush(){
        return JPushImpl.getInstance();
    }
}
