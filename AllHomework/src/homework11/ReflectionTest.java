package homework11;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author Алена
 */

//Практика с рефлексией
public class ReflectionTest {
    
    public static class MyClassForTest extends ReflectionTest implements Serializable{
        private String myString;
        public int a;

        public MyClassForTest(String myString, int a) {
        }
        
        public void myMethod() {  
        }
    }
    
    public static String getModifiers(int m) {
        String modifiers = "";
        if (Modifier.isPublic(m)) modifiers += "public ";
        if (Modifier.isProtected(m)) modifiers += "protected ";
        if (Modifier.isPrivate(m)) modifiers += "private ";
        if (Modifier.isStatic(m)) modifiers += "static ";
        if (Modifier.isAbstract(m)) modifiers += "abstract ";
        return modifiers;
    }

    public static String getType(Class clazz) {
        String type = clazz.isArray()
                ? clazz.getComponentType().getSimpleName()
                : clazz.getSimpleName();
        if (clazz.isArray()) type += "[]";
        return type;
    }

    public static String getParameters(Class[] params) {
        String p = "";
        for (int i = 0, size = params.length; i < size; i++) {
            if (i > 0) p += ", ";
            p += getType(params[i]) + " param" + i;
        }
        return p;
    }

    public static void main(String[] args) {
        Class clas = MyClassForTest.class;
        Package packag = clas.getPackage();
        int modifier = clas.getModifiers();
        Class[] interfaces = clas.getInterfaces();
        Field[] fields = clas.getDeclaredFields();
        Constructor[] constructors = clas.getDeclaredConstructors();
        Method[] methods = clas.getDeclaredMethods();
        System.out.println("package " + packag.getName() + ";");
        System.out.print(getModifiers(modifier));
        System.out.print("class " + clas.getSimpleName() + " ");
        System.out.print("extends " + clas.getSuperclass().getSimpleName() + " ");
        for (int i = 0, size = interfaces.length; i < size; i++) {
            System.out.print(i == 0 ? "implements " : ", ");
            System.out.print(interfaces[i].getSimpleName());
        }
        System.out.println(" {");
        for (Field field : fields) {
            System.out.println("\t" + getModifiers(field.getModifiers())
                    + getType(field.getType()) + " " + field.getName() + ";");
        }
        for (Constructor c : constructors) {
            System.out.print("\t" + getModifiers(c.getModifiers()) +
                    clas.getSimpleName() + "(");
            System.out.print(getParameters(c.getParameterTypes()));
            System.out.println(") { }");
        }
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            System.out.print("\t");
            for (Annotation a : annotations)
                System.out.print("@" + a.annotationType().getSimpleName() + " ");
            System.out.println();

            System.out.print("\t" + getModifiers(m.getModifiers()) +
                    getType(m.getReturnType()) + " " + m.getName() + "(");
            System.out.print(getParameters(m.getParameterTypes()));
            System.out.println(") { }");
        }
        System.out.println("}");
    } 
}