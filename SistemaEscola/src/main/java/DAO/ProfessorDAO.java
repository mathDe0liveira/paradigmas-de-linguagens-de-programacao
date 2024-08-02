package DAO;

import DTO.ProfessorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProfessorDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProfessorDTO> lista = new ArrayList<>();
    
    public void cadastrarProfessor(ProfessorDTO objprofessordto){
        String sql = "INSERT INTO tbl_Professor (id_Professor, matricula_Professor, nome_Professor, cpf_Professor, senha_Professor, formacao_Professor, disciplina_Professor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objprofessordto.getId());
            pstm.setInt(2, objprofessordto.getMatricula());
            pstm.setString(3, objprofessordto.getNome());
            pstm.setString(4, objprofessordto.getCpf());
            pstm.setString(5, objprofessordto.getSenha());
            pstm.setString(6, objprofessordto.getFormacao());
            pstm.setString(7, objprofessordto.getDisciplina());
            
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<ProfessorDTO> pesquisarProfessor(){
        String sql = "SELECT * FROM tbl_Professor";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery(sql);
            
            while(rs.next()) {
                ProfessorDTO objprofessordto = new ProfessorDTO();
                objprofessordto.setId(rs.getInt("id_Professor"));
                objprofessordto.setMatricula(rs.getInt("matricula_Professor"));
                objprofessordto.setNome(rs.getString("nome_Professor"));
                objprofessordto.setCpf(rs.getString("cpf_Professor"));
                objprofessordto.setSenha(rs.getString("senha_Professor"));
                objprofessordto.setFormacao(rs.getString("formacao_Professor"));
                objprofessordto.setDisciplina(rs.getString("disciplina_Professor"));
                
                lista.add(objprofessordto);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
    
    public void alterarProfessor(ProfessorDTO objprofessordto){
        String sql = "UPDATE tbl_Professor SET matricula_Professor = ?, nome_Professor = ?, cpf_Professor = ?, senha_Professor = ?, formacao_Professor = ?, disciplina_Professor WHERE id_Professor = ?";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objprofessordto.getMatricula());
            pstm.setString(2, objprofessordto.getNome());
            pstm.setString(3, objprofessordto.getCpf());
            pstm.setString(4, objprofessordto.getSenha());
            pstm.setString(5, objprofessordto.getFormacao());
            pstm.setString(6, objprofessordto.getDisciplina());
            pstm.setInt(7, objprofessordto.getId());
            
            pstm.execute();
            pstm.close();  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void excluirProfessor(ProfessorDTO objprofessordto){
        String sql = "DELETE FROM tbl_Professor WHERE id_Professor = ?";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objprofessordto.getId());
           
            pstm.execute();
            pstm.close();  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
