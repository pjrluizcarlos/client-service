package org.example;

import org.example.aluno.Aluno;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.List;

public class Main {

    private static final WebTarget simpleServiceClient = ClientBuilder.newClient().target("http://localhost:8080");

    public static void main(String[] args) {
        List<Aluno> alunos = simpleServiceClient.path("alunos")
                .request()
                .get()
                .readEntity(new GenericType<List<Aluno>>() { });

        System.out.println("Todos os alunos (GET https://localhost:8080/alunos):");
        for(Aluno aluno: alunos) System.out.println(aluno);

        Integer[] ids = { 1, 2, 3, 4, 5 };
        System.out.println("Cada aluno por ID (GET https://localhost:8080/alunos/{id}):");
        for(Integer id: ids) printAlunoById(id);
    }

    private static void printAlunoById(Integer id) {
        Aluno aluno = getAluno(id);

        if (aluno == null) {
            System.out.printf("Aluno with ID [%s]: [NOT FOUND]\n", id);
            return;
        }

        System.out.printf("Aluno with ID [%s]: [%s]\n", id, aluno);
    }

    private static Aluno getAluno(Integer id) {
        try {
            return simpleServiceClient
                    .path(String.format("alunos/%s", id))
                    .request()
                    .get(Aluno.class);
        } catch (NotFoundException e) {
            return null;
        }
    }

}
