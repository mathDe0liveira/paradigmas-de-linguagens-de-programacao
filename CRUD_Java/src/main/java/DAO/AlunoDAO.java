package DAO;

import DTO.AlunoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class AlunoDAO {
    Connection conn;
    PreparedStatement pstm;
    public void cadastrarAluno(AlunoDTO objalunodto){
        String sql = "INSERT INTO tbl_Aluno (id_Aluno, matricula_Aluno, nome_Aluno, cpf_Aluno, senha_Aluno, ano_Aluno) VALUES (?, ?, ?, ?, ?, ?)";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objalunodto.getId_Aluno());
            pstm.setInt(2, objalunodto.getMatricula_Aluno());
            pstm.setString(3, objalunodto.getNome_Aluno());
            pstm.setString(4, objalunodto.getCpf_Aluno());
            pstm.setString(5, objalunodto.getSenha_Aluno());
            pstm.setString(6, objalunodto.getAno_Aluno());
            
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
