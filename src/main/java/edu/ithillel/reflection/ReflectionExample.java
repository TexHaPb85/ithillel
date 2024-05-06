package edu.ithillel.reflection;

import edu.ithillel._common.person.Human;
import edu.ithillel._common.person.PersonWorker;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.Arrays;

@SuppressWarnings({"PMD.NPE", "PMD."})
public class ReflectionExample {
    public static void main(String[] args) throws
        ClassNotFoundException,
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException, NoSuchFieldException {

        reflectionExampleMethod();

    }

    private static void reflectionExampleMethod() throws NoSuchMethodException {
        PersonWorker humanPersonWorker = new PersonWorker();
        Class<? extends Human> humanPersonWorkerClass = humanPersonWorker.getClass();
        Method[] methods = humanPersonWorkerClass.getMethods();
        Method[] declaredMethods = humanPersonWorkerClass.getDeclaredMethods();
        Method somePrivateMethodPersonWorker = humanPersonWorkerClass.getDeclaredMethod("somePrivateMethodPersonWorker", int.class);
        int modifier = somePrivateMethodPersonWorker.getModifiers(); // binary mask public=1 private=2 final=16
        Modifier.isPrivate(modifier);
        Arrays.stream(declaredMethods).forEach(method -> System.out.println(method.getName() + " modifier: " + method.getModifiers()));
    }

    private static void reflectionExampleField() throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        Human humanPersonWorker = new PersonWorker();
        Class<? extends Human> humanPersonWorkerClass = humanPersonWorker.getClass();
        Class<PersonWorker> personWorkerClass = PersonWorker.class;
        Class<?> personWorkerClassByName = Class.forName("edu.ithillel._common.person.PersonWorker"); //if class is not generated yet

        Field[] fields = humanPersonWorkerClass.getFields();
        Field[] declaredFields = humanPersonWorkerClass.getDeclaredFields();

        PersonWorker pw =
            new PersonWorker("fn", "ln", "id", null, "wId", 400.0);
        Method setWorkedId = personWorkerClass.getMethod("setWorkedId", String.class);
        setWorkedId.invoke(pw, "dataFromReflection");

        Field declaredField = pw.getClass().getDeclaredField("workedId");
        declaredField.setAccessible(true);
        String s = (String) declaredField.get(pw);
        System.out.println(declaredField.getName() + ": " + declaredField.get(pw));
    }

    private static void reflectionExampleConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        PersonWorker pw =
            new PersonWorker("fn", "ln", "id", null, "wId", 400.0);
        Class<? extends PersonWorker> aClass = pw.getClass();
        Constructor<? extends PersonWorker> constructor = aClass.getConstructor();

        PersonWorker personWorker = constructor.newInstance();
    }
}
