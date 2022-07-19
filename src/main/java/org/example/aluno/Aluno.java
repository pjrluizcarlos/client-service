package org.example.aluno;

public class Aluno {

    private Integer id;
    private String nome;
    private String email;
    private Integer ciclo;

    public Aluno() {

    }

    public Aluno(Integer id, String nome, String email, Integer ciclo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ciclo = ciclo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", ciclo=" + ciclo +
                '}';
    }
}
