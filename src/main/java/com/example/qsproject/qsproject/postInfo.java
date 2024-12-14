package com.example.qsproject.qsproject;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * This class posts course and subject information to the server, checking if they already exist before sending data as JSON.
 */


public class postInfo {

    private static final String COURSE_URL = "http://localhost:8080/app/courses";
    private static final String SUBJECT_URL = "http://localhost:8080/app/subjects";
    private static final RestTemplate restTemplate = new RestTemplate();


    /**
     * Checks if a course with the specified name already exists.
     * @param courseName the name of the course to check
     * @return true if the course exists, false otherwise
     */

    private static boolean courseExists(String courseName) {
        ResponseEntity<List> response = restTemplate.exchange(
                COURSE_URL,
                HttpMethod.GET,
                null,
                List.class
        );

        List<?> courses = response.getBody();

        return courses != null && courses.stream().anyMatch(course ->
                ((String) ((java.util.Map) course).get("courseName")).equals(courseName)
        );
    }


    /**
     * Posts a list of courses to the server.
     * If a course already exists, it is skipped.
     */

    public static void postCourses() {
        List<String> courses = Arrays.asList(
                "Engenharia Informática",
                "Engenharia e Gestão Industrial",
                "Sistemas de Informação para Gestão"
        );

        for (String course : courses) {
            if (courseExists(course)) {
                System.out.println("Curso já existe: " + course);
                continue;
            }

            String courseJson = "{"
                    + "\"courseName\": \"" + course + "\","
                    + "\"courseDuration\": 3"
                    + "}";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> courseRequest = new HttpEntity<>(courseJson, headers);
            ResponseEntity<String> courseResponse = restTemplate.exchange(COURSE_URL, HttpMethod.POST, courseRequest, String.class);
        }
    }



    /**
     * Checks if a subject with the specified name already exists for a given course.
     * @param courseId the ID of the course
     * @param subjectName the name of the subject to check
     * @return true if the subject exists, false otherwise
     */

    private static boolean subjectExists(int courseId, String subjectName) {
        ResponseEntity<List> response = restTemplate.exchange(
                SUBJECT_URL + "?courseId=" + courseId,
                HttpMethod.GET,
                null,
                List.class
        );

        List<?> subjects = response.getBody();

        return subjects != null && subjects.stream().anyMatch(subject ->
                ((String) ((java.util.Map) subject).get("subjectName")).equals(subjectName)
        );
    }



    /**
     * Posts a list of subjects to the server for different academic years and semesters.
     * If a subject already exists, it is skipped.
     */

    public static void postSubjects() {
        List<String> year1Semester1Subjects = Arrays.asList(
                "Álgebra Linear e Geometria Analítica",
                "Algoritmia e Programação",
                "Análise Matemática",
                "Arquitetura e Organização de Computadores",
                "Competências Comportamentais"
        );

        List<String> year1Semester2Subjects = Arrays.asList(
                "Fundamentos de Física",
                "Matemática Discreta",
                "Programação Orientada a Objetos",
                "Redes de Computadores",
                "Sistemas de Informação",
                "Sociedade da Informação e do Conhecimento"
        );

        List<String> year2Semester1Subjects = Arrays.asList(
                "Algoritmos e Estruturas de Dados",
                "Engenharia de Requisitos",
                "Estatística Aplicada",
                "Laboratório de Programação",
                "Sistemas Operativos"
        );

        List<String> year2Semester2Subjects = Arrays.asList(
                "Bases de Dados",
                "Compiladores",
                "Engenharia de Software",
                "Laboratório de Aplicações Multimédia",
                "Laboratório de Tecnologias Web"
        );

        List<String> year3Semester1Subjects = Arrays.asList(
                "Laboratório de Aplicações Móveis",
                "Inteligência Artificial",
                "Qualidade de Software",
                "Empreendedorismo",
                "Gestão de Projetos"
        );

        List<String> year3Semester2Subjects = Arrays.asList(
                "Sistemas Distribuídos",
                "Laboratório de Análise de Dados",
                "Segurança Informática",
                "Internet das Coisas",
                "Visão por Computador"
        );


        int engineeringCourseId = 1;

        postSubjectForYearAndSemester(engineeringCourseId, year1Semester1Subjects, 1, 1);
        postSubjectForYearAndSemester(engineeringCourseId, year1Semester2Subjects, 1, 2);
        postSubjectForYearAndSemester(engineeringCourseId, year2Semester1Subjects, 2, 1);
        postSubjectForYearAndSemester(engineeringCourseId, year2Semester2Subjects, 2, 2);
        postSubjectForYearAndSemester(engineeringCourseId, year3Semester1Subjects, 3, 1);
        postSubjectForYearAndSemester(engineeringCourseId, year3Semester2Subjects, 3, 2);
    }



    /**
     * Posts a list of subjects for a given course, year, and semester to the server.
     * If a subject already exists, it is skipped.
     * @param courseId the ID of the course
     * @param subjects the list of subjects to post
     * @param year the academic year of the subject
     * @param semester the semester of the subject
     */

    private static void postSubjectForYearAndSemester(int courseId, List<String> subjects, int year, int semester) {
        for (String subject : subjects) {
            if (subjectExists(courseId, subject)) {
                System.out.println("Subject já existe: " + subject);
                continue;
            }

//            String subjectJson = "{"
//                    + "\"subjectName\": \"" + subject + "\","
//                    + "\"courseId\": " + courseId + ","
//                    + "\"studentsEnrolled\": 10,"
//                    + "\"subjectEvaluationType\": \"Mista\","
//                    + "\"subjectAttendance\": \"20\","
//                    + "\"subjectYear\": " + year + ","
//                    + "\"subjectSemester\": " + semester
//                    + "}";

            String subjectJson = "{"
                    + "\"subjectName\": \"" + subject + "\","
                    + "\"courseId\": " + courseId + ","
                    + "\"studentsEnrolled\": 10,"
                    + "\"subjectEvaluationType\": \"Mista\","
                    + "\"subjectYear\": " + year + ","
                    + "\"subjectSemester\": " + semester
                    + "}";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> subjectRequest = new HttpEntity<>(subjectJson, headers);
            ResponseEntity<String> subjectResponse = restTemplate.exchange(SUBJECT_URL, HttpMethod.POST, subjectRequest, String.class);
        }
    }
}
