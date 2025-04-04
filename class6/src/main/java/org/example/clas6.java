package org.example;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class clas6 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Student student = new Student("A", 2, "null", List.of("Math", "Science"));

        String json = mapper.writeValueAsString(student);
        System.out.println(json);

        Student student2 = mapper.readValue(json, Student.class);
        System.out.println("Student: name: " +student2.getName());

    }
    static class Student{
        String name;
        int age;
        @JsonProperty("email_address")
        String email;

        @JsonIgnore
        List<String> courses;

        public Student() {}

        public Student(String name, int age, String email, List<String> courses){
            this.name = name;
            this.age = age;
            this.email = email;
            this.courses = courses;
        }

        public List<String> getCourses() {
            return courses;
        }

        public void setCourses(List<String> courses) {
            this.courses = courses;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
         @JsonInclude(JsonInclude.Include.NON_NULL)
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}

