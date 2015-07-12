package modal.studyaid;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by johnanderson1 on 6/29/15.
 */
public class Registration extends SQLiteOpenHelper {
private Context context;
    private String name;
    private SQLiteDatabase.CursorFactory factory;
    private int version;
    private SQLiteDatabase db;



public Registration(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
{

  super(context,name,factory,version) ;

}

    public void onCreate (SQLiteDatabase db)
    {
        db=db;
        String query="CREATE TABLE REGISTRATION(id INTEGER PRIMARY KEY,NAME username,NAME email,NAME password,NAME passwordHint)";
        db.execSQL(query);
    }

    public  void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void insertDatas(int number,String username,String Password,String email,String password,String passwordhint)
    {
        String query="INSERT INTO REGISTRATION(id number,email email,password password,passwordhint passwordhint)";
        db.execSQL(query);

    }
    public void collectDatas()
    {



    }

}
