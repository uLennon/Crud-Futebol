package repositorio;

import conn.Conexao;
import dominio.Jogador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JogadorRepositorio {

    public static void salvar(Jogador jogador){
        try(Connection con = Conexao.getConnection();
            PreparedStatement ps = conSalvar(con, jogador)){
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static PreparedStatement conSalvar(Connection con,Jogador jogador) throws SQLException {
        String sql = "INSERT INTO `futebol`.`jogadores` (`nome`)  VALUES (?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,jogador.getNome());
        return ps;
    }

    public static void deletar(int id){
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = conDeletar(con, id)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static PreparedStatement conDeletar(Connection con, Integer id) throws SQLException {
        String sql = "DELETE FROM `futebol`.`jogadores` WHERE (`id` = ?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void atualizar(Jogador jogador){
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = conAtualizar(con, jogador)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static PreparedStatement conAtualizar(Connection con, Jogador jogador) throws SQLException {
        String sql = "UPDATE `futebol`.`jogadores` SET `nome`=?, `camisa`=? WHERE (`id`=?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, jogador.getNome());
        ps.setInt(2, jogador.getCamisa());
        ps.setInt(3, jogador.getId());
        return ps;
    }


    public static Optional<Jogador> buscaID(Integer id){
        try(Connection con = Conexao.getConnection();
            PreparedStatement ps = conBuscaID(con, id);
            ResultSet rs = ps.executeQuery()) {
            if(!rs.next())return Optional.empty();
            return Optional.of(Jogador.JogadorBuilder
                    .builder()
                    .id(rs.getInt("id"))
                    .nome(rs.getString("nome"))
                    .camisa(rs.getInt("camisa"))
                    .timeId(rs.getInt("timeId"))
                    .build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    private static PreparedStatement conBuscaID(Connection con, Integer id ) throws SQLException {
        String sql = "SELECT * FROM futebol.jogadores where id = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        return ps;
    }
}
