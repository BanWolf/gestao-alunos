/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AlunoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jasib
 */
public class AlunoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AlunoDTO> lista = new ArrayList<>();

    public void cadastrarAluno(AlunoDTO alunodto) {

        String sql = "insert into cadastro (nome, cpf, celular, curso) values (?,?,?,?)";

        conn = new ConnectionDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, alunodto.getNome());
            pstm.setString(2, alunodto.getCpf());
            pstm.setString(3, alunodto.getCelular());
            pstm.setString(4, alunodto.getCurso());

            pstm.execute();

            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO cadastrar: " + e.getMessage());
        }
    }

    public ArrayList<AlunoDTO> listarAluno() {

        String sql = "select * from cadastro";

        conn = new ConnectionDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                AlunoDTO alunodto = new AlunoDTO();

                alunodto.setId(rs.getInt("id"));
                alunodto.setNome(rs.getString("nome"));
                alunodto.setCpf(rs.getString("cpf"));
                alunodto.setCelular(rs.getString("celular"));
                alunodto.setCurso(rs.getString("curso"));

                lista.add(alunodto);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO listar: " + e.getMessage());
        }

        return lista;
    }

    public void alterarAluno(AlunoDTO alunodto) {

        String sql = "update cadastro set nome = ?, cpf = ?, celular = ?, curso = ? where id = ?";

        conn = new ConnectionDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, alunodto.getNome());
            pstm.setString(2, alunodto.getCpf());
            pstm.setString(3, alunodto.getCelular());
            pstm.setString(4, alunodto.getCurso());
            pstm.setInt(5, alunodto.getId());

            pstm.execute();

            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO alterar: " + e.getMessage());
        }
    }

    public void excluirAluno(AlunoDTO alunodto) {

        String sql = "delete from cadastro where id = ?";

        conn = new ConnectionDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, alunodto.getId());

            pstm.execute();

            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO excluir: " + e.getMessage());
        }
    }
}
