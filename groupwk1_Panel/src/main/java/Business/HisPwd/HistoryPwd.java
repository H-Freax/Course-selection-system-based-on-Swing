/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.HisPwd;

import Tools.MySQLConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 15469
 */
public class HistoryPwd {
    private Connection connection;
    private List<History> historyList;
    
    public HistoryPwd() {
        connection=MySQLConnectionUtil.getConnection();
        this.historyList = new ArrayList<>();
        readHistoryFromDatabase();
    }
    
    private void readHistoryFromDatabase() {
        String sql = "SELECT personid, password FROM historypwd";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String personId = resultSet.getString("personid");
                String password = resultSet.getString("password");
                History history = new History(personId, password);
                historyList.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 处理数据库异常，可以根据实际情况进行修改
        }
    }
    
    
    public static class History {
        private String pId;
        private String his;

        public History(String pId, String his) {
            this.pId = pId;
            this.his = his;
        }

        public String getpId() {
            return pId;
        }

        public void setpId(String pId) {
            this.pId = pId;
        }

        public String getHis() {
            return his;
        }

        public void setHis(String his) {
            this.his = his;
        }
        
        
        
    }
    
}
