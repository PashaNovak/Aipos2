package controller;

import controller.gen.TechnologiesOfLocalNetworksService;
import model.DbConnection;
import org.apache.thrift.TException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by G710 on 25.03.2017.
 */
public class RpcHandler implements TechnologiesOfLocalNetworksService.Iface {
    private static final String msg_create = "create";
    private static final String msg_delete = "delete";
    private static final String msg_update = "update";

    private java.sql.Statement state;

    public String deleteDefinition(String response) throws TException {
        String sql;
        Connection connection = DbConnection.connection;
        try{
            state = connection.createStatement();
            if (Objects.equals(response, "ALL")){
                 sql = "DELETE FROM local_nets";
            } else {
                sql = "DELETE FROM local_nets WHERE name ='" + response + "';";
            }
            state.executeUpdate(sql);
//            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return msg_delete;
    }

    public String updateDefinition(String response, String definition) throws IOException{
        Connection connection = DbConnection.connection;
        try {
            state = connection.createStatement();
            String sql = "UPDATE local_nets SET definition = '" +
                    definition + "' WHERE name ='"+response+"';";
            state.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return msg_update;
    }

    public String readDefinition(String response) throws TException{
        Connection connection = DbConnection.connection;
        String definition = "";
        ResultSet resultSet;
        String sql;
        try{
            state = connection.createStatement();
            if (response.equals("ALL")){
                sql = "SELECT * FROM local_nets";
                resultSet = state.executeQuery(sql);
                while (resultSet.next()){
                    definition = definition + "\n" + resultSet.getString("name")+ " " + "---" + " " + resultSet.getString("definition");
                }
                resultSet.close();
            } else {
                sql = "SELECT * FROM local_nets WHERE name='"+response+"';";
                resultSet = state.executeQuery(sql);
                while (resultSet.next()){
                    definition = resultSet.getString("definition");
                }
                    resultSet.close();
                }
        } catch (SQLException e){
            //e.printStackTrace();
        }
        return definition;
    }

    public String createDefinition(String response, String definition) throws TException{
        Connection connection = DbConnection.connection;
        try {
            state = connection.createStatement();
            if (response.equals("ALL")){
                System.err.print(0);
            } else {
                String sql = "INSERT INTO local_nets (name, definition)" +
                        " VALUES ('"+response+"', '"+definition+"');";
                state.executeUpdate(sql);
            }
//            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return msg_create;
    }
}
