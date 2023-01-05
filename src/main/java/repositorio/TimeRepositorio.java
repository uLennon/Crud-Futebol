package repositorio;

import conn.Conexao;
import dominio.Time;

import java.sql.*;
import java.util.Optional;

public class TimeRepositorio {
    public static void salvar(Time time){
        try(Connection con = Conexao.getConnection();
            PreparedStatement ps = conSalvar(con, time)){
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static PreparedStatement conSalvar(Connection con,Time time) throws SQLException {
         String sql = "INSERT INTO `futebol`.`times` (`nome`)  VALUES (?);";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1,time.getNome());
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
        String sql = "DELETE FROM `futebol`.`times` WHERE (`id` = ?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void atualizar(Time time){
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = conAtualizar(con, time)) {
             ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static PreparedStatement conAtualizar(Connection con, Time time) throws SQLException {
        String sql = "UPDATE `futebol`.`times` SET `nome`=? WHERE (`id`=?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,time.getNome());
        ps.setInt(2, time.getId());
        return ps;
    }


    public static Optional<Time> buscaID(Integer id){
        try(Connection con = Conexao.getConnection();
            PreparedStatement ps = conBuscaID(con, id);
            ResultSet rs = ps.executeQuery()) {
            if(!rs.next())return Optional.empty();
            return Optional.of(Time.TimeBuilder
                                .builder()
                                .id(rs.getInt("id"))
                                .name(rs.getString("nome"))
                                .build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    private static PreparedStatement conBuscaID(Connection con, Integer id ) throws SQLException {
        String sql = "SELECT * FROM futebol.times where id = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        return ps;
    }
}
