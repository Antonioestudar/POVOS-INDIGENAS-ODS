package dao;

import model.Contribuicao;
import java.sql.*;

public class ContribuicaoDAO {
    private final String URL = "jdbc:mysql://localhost:3306/povos_ods_db";
    private final String USER = "root";
    private final String PASS = "Amor-2829"; // sua senha

    public void listarContribuicoes() {
        String sql = "SELECT * FROM contribuicoes";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n== Lista de Contribuições ==");
            while (rs.next()) {
                System.out.printf("%d - %s [%s]%n    %s - %s%n",
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("ods"),
                        rs.getString("descricao"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar contribuições: " + e.getMessage());
        }
    }

    public void adicionarContribuicao(Contribuicao c) {
        String sql = "INSERT INTO contribuicoes (titulo, descricao, ods, autor) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getTitulo());
            stmt.setString(2, c.getDescricao());
            stmt.setString(3, c.getOds());
            stmt.setString(4, c.getAutor());
            stmt.executeUpdate();
            System.out.println("Contribuição cadastrada!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar contribuição: " + e.getMessage());
        }
    }
}
