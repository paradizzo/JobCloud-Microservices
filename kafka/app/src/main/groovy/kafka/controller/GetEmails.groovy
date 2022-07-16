package kafka.controller

import kafka.model.Candidato
import kafka.connection.connection
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class GetEmails {
    static ArrayList<String> getAllEmails() throws ClassNotFoundException, SQLException {
        Connection conn = connection.conexao();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select email From candidatos";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<String> candidatoList = new ArrayList<>();
        while (rst.next()) {
            String email = rst.getString(1)
            candidatoList.add(email)
        }
        return candidatoList
    }
}
