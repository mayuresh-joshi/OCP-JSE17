package org.mj.enthuware_tests.test2;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Student2(int id, String name) {
    public Student2() { //a non-canonical constructor
        this(10); //this line or a call to the canonical constructor is required
    }

    public Student2(int id) { //another non-canonical constructor
        this(id, ""); //this line is required . Calling compiler provided canonical constructor.
    }
    /*public Student(int id, String name){ //regular form canonical constructor
        this.id = id; this.name=name;
    }*/
}


class Super {
    static String ID = "QBANK";
}

class Sub extends Super {
    //static String ID = "QBANK"; //uncomment and run
    static {
        System.out.print("In Sub");
    }
}


class Student {
    public static enum Grade {A, B, C, D, F}

    private String name;
    private Grade grade;

    public Student(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return name + ":" + grade;
    }
    //getters and setters not shown

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Test2 {
    public static void main(String[] args) {
        //new Student(20, "Mj");
        System.out.println(Sub.ID); // only prints QBANK, not In Sub!!!


        List<Student> ls = Arrays.asList(
                new Student("S1", Student.Grade.A),
                new Student("S2", Student.Grade.A),
                new Student("S3", Student.Grade.C));

        Map<Student.Grade, List<Student>> grouping = ls.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        System.out.println(grouping);


    }


    public static void copy(String records1, String records2) {
        try (InputStream is = new FileInputStream(records1); OutputStream os = new FileOutputStream(records2);) {
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
                System.out.println("Read and written bytes " + bytesRead);
            }
        } catch (IOException |
                 RuntimeException e) { //LINE 100 , There should be no inheritance relation between Exceptions mentioned in multi-catch
        }
    }
}