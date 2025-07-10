package dao;

import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    private final String URL = "jdbc:mysql://localhost:3306/povos_ods_db";
    private final String USER = "root";
    private final String PASS = "Amor-2829"; // sua senha

    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n== Lista de Usuários ==");
            while (rs.next()) {
                System.out.printf("%d - %s (%s)%n",
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
        }
    }

    public void adicionarUsuario(Usuario u) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.executeUpdate();
            System.out.println("Usuário cadastrado!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}
