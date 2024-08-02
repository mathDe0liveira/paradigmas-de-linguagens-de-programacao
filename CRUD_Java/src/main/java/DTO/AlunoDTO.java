package DTO;

public class AlunoDTO {
    private int id_Aluno, matricula_Aluno;
    private String nome_Aluno, cpf_Aluno, senha_Aluno, ano_Aluno;

    public int getId_Aluno() {
        return id_Aluno;
    }

    public void setId_Aluno(int id_Aluno) {
        this.id_Aluno = id_Aluno;
    }

    public int getMatricula_Aluno() {
        return matricula_Aluno;
    }

    public void setMatricula_Aluno(int matricula_Aluno) {
        this.matricula_Aluno = matricula_Aluno;
    }

    public String getNome_Aluno() {
        return nome_Aluno;
    }

    public void setNome_Aluno(String nome_Aluno) {
        this.nome_Aluno = nome_Aluno;
    }

    public String getCpf_Aluno() {
        return cpf_Aluno;
    }

    public void setCpf_Aluno(String cpf_Aluno) {
        this.cpf_Aluno = cpf_Aluno;
    }

    public String getSenha_Aluno() {
        return senha_Aluno;
    }

    public void setSenha_Aluno(String senha_Aluno) {
        this.senha_Aluno = senha_Aluno;
    }

    public String getAno_Aluno() {
        return ano_Aluno;
    }

    public void setAno_Aluno(String ano_Aluno) {
        this.ano_Aluno = ano_Aluno;
    }   
}