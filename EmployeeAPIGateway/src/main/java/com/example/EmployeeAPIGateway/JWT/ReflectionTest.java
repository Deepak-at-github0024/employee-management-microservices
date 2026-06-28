package com.example.EmployeeAPIGateway.JWT;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {

    public static void main(String as[]) {


        IIMSCalender instance1 = IIMSCalender.getInstance();

        try {
            Constructor<IIMSCalender>   declaredConstructor = IIMSCalender.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            IIMSCalender instance2 = declaredConstructor.newInstance();

            System.out.println("1" + instance1.hashCode());
            System.out.println("2" + instance2.hashCode());


        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }




    }

}
