package repositorio;

import conn.Conexao;
import dominio.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TimeRepositorio {
    public static void save(Time time){
        try(Connection con = Conexao.getConnection();
            PreparedStatement ps = conSalvar(con, time)){
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static PreparedStatement conSalvar(Connection con,Time time) throws SQLException {
         String sql = "INSERT INTO `futebol`.`times` (`nome`) VALUES (?);";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1,time.getNome());
         return ps;
    }
}
