/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author freax
 */
public class User {


    private String username;
    private String nowpwd;
    private ArrayList<String> pwds;
    private Boolean enabled;
    private String role;
   
    public User(){
        
    }
    public User(String username, String nowpwd, ArrayList<String> pwds, Boolean enabled, String role) {
        this.username = username;
        this.nowpwd = nowpwd;
        this.pwds = pwds;
        this.enabled = enabled;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNowpwd() {
        return nowpwd;
    }

    public Boolean setNowpwd(String nowpwd) {
            System.out.println("nowpwd:");        
        System.out.println(nowpwd);
        for(String pwd:pwds){
            System.out.println("pwds:");
            System.out.println(pwd);
        }
        this.nowpwd = nowpwd;
        if (!pwds.contains(nowpwd)) {
            pwds.add(nowpwd);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nowpwd);
        return hash;
    }

    
    public ArrayList<String> getPwds() {
        return pwds;
    }
    
    public void addNewPwd(String pwd){
        pwds.add(hashPassword(pwd));
    }
    
    
    public void deletePwd(String s){
        pwds.remove(s);
    }
            

    public void setPwds(ArrayList<String> pwds) {
        this.pwds = pwds;
    }


    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

            
 
    public String toText() {
        StringBuilder text = new StringBuilder();
        text.append("username:").append(username).append("\n");
        text.append("nowpwd:").append(nowpwd).append("\n");
        text.append("pwds:\n");
        for (String pwd : pwds) {
            if(pwd!=""){
                text.append(pwd).append("\n");
            }
        }
        text.append("pwdsend:").append("\n");
        text.append("enabled:").append(enabled).append("\n");
        text.append("role:").append(role).append("\n");
        return text.toString();
    }
    
    public boolean validatePassword(String password) {
        System.out.println(password);
        System.out.println(hashPassword(password));
        System.out.println(nowpwd);
        return nowpwd.equals(hashPassword(password));
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}


