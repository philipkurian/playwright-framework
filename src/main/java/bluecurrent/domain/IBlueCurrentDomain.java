package bluecurrent.domain;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;

import java.lang.reflect.Constructor;

import static org.hamcrest.MatcherAssert.assertThat;

public interface IBlueCurrentDomain {

    public void Defaults();
        public static IBlueCurrentDomain newInstance(String className) {
        IBlueCurrentDomain result;
        try {
            Class<?> clazz = Class.forName(className);
            System.out.println("Found Class " + clazz.getName());
            Constructor<?> constructor = clazz.getConstructor();
            Object myObject = constructor.newInstance();
            result = (IBlueCurrentDomain) myObject;
        } catch (Exception e) {
            result = null;
            //assertThat("Unable to find a class with the name " + className,className, Fail());
        }
        return result;
    }

    String SpecialPreProcessing(String arg0);
    String SpecialPostProcessing(String arg0);
    String Serialize() throws JsonProcessingException;
}
