package cz.czechitas.java2.lekce09.konzoledb;

import java.sql.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;

public class SpousteciTrida {

    public static void main(String[] args) {

        MariaDbDataSource konfiguraceDB = new MariaDbDataSource();
        try {
            konfiguraceDB.setUserName("student");
            konfiguraceDB.setPassword("password");
            konfiguraceDB.setUrl("jdbc:mysql://localhost:3306/VideoBoss");

            JdbcTemplate dotazovac = new JdbcTemplate(konfiguraceDB);


            RowMapper<Customer> mapovacZkazniku = BeanPropertyRowMapper.newInstance(Customer.class);
            List<Customer> zakaznici = dotazovac.query("SELECT * FROM customers", mapovacZkazniku);

            for (Customer zakaznik : zakaznici){
                System.out.println(zakaznik);
            }

            Customer dvorak = dotazovac.queryForObject("select * from customers where id = ?",mapovacZkazniku, 1);

            long pocetZakaznicku = dotazovac.queryForObject("select count(*) from customers", long.class);
            long pocetJanu = dotazovac.queryForObject("select count(*) from customers where firstname = 'Jan'", long.class);
            System.out.println(pocetZakaznicku);
            System.out.println(pocetJanu);


        } catch (SQLException e) {
            throw new RuntimeException(e);                       //vyhodí jinou vyjímku, když se něco posere
        }



    }

}
