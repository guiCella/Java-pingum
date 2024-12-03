/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Estagiario;
import model.Funcionario;

public class PinguimDAO {
    public void adicionarFuncionario(Funcionario funcionario) {
        try (Connection conn = ConexaoMySQL.conectar()) {
            // Inserir na tabela Pinguim
            String sqlPinguim = "INSERT INTO pinguim (nome, idade, endereco, sexo, altura, telefone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqlPinguim, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getIdade());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getSexo());
            stmt.setFloat(5, funcionario.getAltura());
            stmt.setString(6, funcionario.getTelefone());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int pinguimId = rs.getInt(1);

                // Inserir na tabela Funcionario
                String sqlFuncionario = "INSERT INTO funcionario (id, registro, salario_peixes) VALUES (?, ?, ?)";
                PreparedStatement stmtFuncionario = conn.prepareStatement(sqlFuncionario);
                stmtFuncionario.setInt(1, pinguimId);
                stmtFuncionario.setInt(2, funcionario.getRegistro());
                stmtFuncionario.setInt(3, funcionario.getSalarioPeixes());
                stmtFuncionario.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void adicionarEstagiario(Estagiario estagiario) {
    String sqlPinguim = "INSERT INTO pinguim (nome, idade, endereco, sexo, altura, telefone) VALUES (?, ?, ?, ?, ?, ?)";
    String sqlEstagiario = "INSERT INTO estagiario (id, registro, salario_peixes) VALUES (?, ?, ?)";
    
    // Start a transaction
    try (Connection conn = ConexaoMySQL.conectar()) {
        // Disable auto-commit for transaction handling
        conn.setAutoCommit(false);

        try {
            // Inserir na tabela Pinguim
            PreparedStatement stmtPinguim = conn.prepareStatement(sqlPinguim, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtPinguim.setString(1, estagiario.getNome());
            stmtPinguim.setInt(2, estagiario.getIdade());
            stmtPinguim.setString(3, estagiario.getEndereco());
            stmtPinguim.setString(4, estagiario.getSexo());
            stmtPinguim.setFloat(5, estagiario.getAltura());
            stmtPinguim.setString(6, estagiario.getTelefone());
            stmtPinguim.executeUpdate();

            // Get the generated ID from the Pinguim insert
            ResultSet rs = stmtPinguim.getGeneratedKeys();
            int pinguimId = -1;
            if (rs.next()) {
                pinguimId = rs.getInt(1);  // Retrieve the generated pinguimId
            }

            if (pinguimId != -1) {
                // Inserir na tabela Estagiario, associando ao pinguimId
                PreparedStatement stmtEstagiario = conn.prepareStatement(sqlEstagiario);
                stmtEstagiario.setInt(1, pinguimId);  // Link Estagiario to Pinguim using pinguimId
                stmtEstagiario.setInt(2, estagiario.getRegistro());
                stmtEstagiario.setInt(3, estagiario.getSalarioPeixes());
                stmtEstagiario.executeUpdate();
            }

            // Commit transaction
            conn.commit();
        } catch (Exception e) {
            conn.rollback();  // Rollback in case of an error
            e.printStackTrace();
            throw e;  // Re-throw exception to handle it properly
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT p.id, p.nome, p.telefone, f.registro, f.salario_peixes " +
                     "FROM pinguim p JOIN funcionario f ON p.id = f.id";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                funcionarios.add(new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        0, null, null, 0, rs.getString("telefone"),
                        rs.getInt("registro"),
                        rs.getInt("salario_peixes")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return funcionarios;
    }
    public List<Estagiario> listarEstagiarios() {
        List<Estagiario> estagiarios = new ArrayList<>();
        String sql = "SELECT p.id, p.nome, p.telefone, f.registro, f.salario_peixes " +
                     "FROM pinguim p JOIN estagiario f ON p.id = f.id";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                estagiarios.add(new Estagiario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        0, null, null, 0, rs.getString("telefone"),
                        rs.getInt("registro"),
                        rs.getInt("salario_peixes")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return estagiarios;
    }
}
