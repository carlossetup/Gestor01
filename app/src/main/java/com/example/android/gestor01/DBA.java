package com.example.android.gestor01;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.oss.datahelper.DataBaseManager;

import java.sql.SQLException;

/**
 * Created by Android on 14/09/2016.
 */

public class DBA {
    private static  final String DB_NAME = "agenda.sqlite";
    private static final int DB_VERSION = 1;


    public static void init(Context context){

        DataBaseManager.init(context,DB_NAME,DB_VERSION);
        ConnectionSource source = DataBaseManager.getInstance().getHelper().getConnectionSource();
        try {
            TableUtils.createTableIfNotExists(source,Contacto.class);
            //Demas tablas
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Dao<Contacto, Integer> getContactoDao(){
        try {
            return DataBaseManager.getInstance().getHelper().getDao(Contacto.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
