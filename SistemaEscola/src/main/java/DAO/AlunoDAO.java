package DAO;

import DTO.AlunoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlunoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AlunoDTO> lista = new ArrayList<>();
    
    public void cadastrarAluno(AlunoDTO objalunodto){
        String sql = "INSERT INTO tbl_Aluno (id_Aluno, matricula_Aluno, nome_Aluno, cpf_Aluno, senha_Aluno, ano_Aluno) VALUES (?, ?, ?, ?, ?, ?)";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objalunodto.getId());
            pstm.setInt(2, objalunodto.getMatricula());
            pstm.setString(3, objalunodto.getNome());
            pstm.setString(4, objalunodto.getCpf());
            pstm.setString(5, objalunodto.getSenha());
            pstm.setString(6, objalunodto.getAno());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<AlunoDTO> pesquisarAluno(){
        String sql = "SELECT * FROM tbl_Aluno";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery(sql);
            
            while(rs.next()) {
                AlunoDTO objalunodto = new AlunoDTO();
                objalunodto.setId(rs.getInt("id_Aluno"));
                objalunodto.setMatricula(rs.getInt("matricula_Aluno"));
                objalunodto.setNome(rs.getString("nome_Aluno"));
                objalunodto.setCpf(rs.getString("cpf_Aluno"));
                objalunodto.setSenha(rs.getString("senha_Aluno"));
                objalunodto.setAno(rs.getString("ano_Aluno"));
                
                lista.add(objalunodto);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
    
    public void alterarAluno(AlunoDTO objalunodto){
        String sql = "UPDATE tbl_Aluno SET matricula_Aluno = ?, nome_Aluno = ?, cpf_Aluno = ?, senha_Aluno = ?, ano_Aluno = ? WHERE id_Aluno = ?";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objalunodto.getMatricula());
            pstm.setString(2, objalunodto.getNome());
            pstm.setString(3, objalunodto.getCpf());
            pstm.setString(4, objalunodto.getSenha());
            pstm.setString(5, objalunodto.getAno());
            pstm.setInt(6, objalunodto.getId());
            
            pstm.execute();
            pstm.close();  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void exluirAluno(AlunoDTO objalunodto) {
        String sql = "DELETE FROM tbl_Aluno WHERE id_Aluno = ?";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objalunodto.getId());
           
            pstm.execute();
            pstm.close();  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}