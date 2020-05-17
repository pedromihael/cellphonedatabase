package com.pedromihael.cellphonedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CellPhoneOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cellphone";

    // Table Names
    private static final String TABLE_CELULAR = "celular";
    private static final String TABLE_MARCA = "marca";

    // Celular Table Columns
    private static final String COLUMN_CELULAR_ID = "celularId";
    private static final String COLUMN_MARCA_FK = "marcaId";
    private static final String COLUMN_MODELO = "modelo";

    //Marca Table Columns
    private static final String COLUMN_MARCA_ID = "marcaId";
    private static final String COLUMN_MARCA = "marca";


    public CellPhoneOpenHelper(){
        super(null, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public CellPhoneOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        // Create Table Celular
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_CELULAR +
                "(" +
                COLUMN_CELULAR_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MARCA_FK + "INTERGER REFERENCES" + TABLE_MARCA + ", " +
                COLUMN_MODELO + "TEXT" +
                ")"
        );

        //Create Table Marca
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_MARCA +
                "(" +
                COLUMN_MARCA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MARCA + "TEXT" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CELULAR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARCA);
    }

    public boolean addModel(Model model){
        // This line makes the insertion possible
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
//        values.put(COLUMN_MARCA_FK, model.getMarcaId());
        values.put(COLUMN_MODELO, model.getModelo());

        // Add values to database
        db.insert(TABLE_CELULAR, null, values);
//        Log.i("AddModel", "Added to databaase");
        return true;
    }

    public boolean AddMarca(Marca marca){
        // This line makes the insertion possible
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(COLUMN_MARCA, marca.getMarca());

        // Add values to database
        db.insert(TABLE_MARCA, null, values);

        return true;
    }
}
