package sg.edu.mad.madpractical3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "Users.db";
    private static final int DATABASE_VERSION = 1;

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory,
                     int version)
    {
        super(context, DATABASE_NAME, factory,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_DATABASE = "CREATE TABLE Users (NAME TEXT, " +
                "DESCRIPTION TEXT, " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FOLLOWED BOOLEAN)";

        db.execSQL(CREATE_DATABASE);

        for (int i = 0 ; i < 20; i++)
        {

            User user = new User();

            ContentValues values = new ContentValues();
            values.put("ID", user.getId());
            values.put("Name", user.getName());
            values.put("Description", user.getDescription());
            values.put("Followed", user.isFollow());

            db.insert("Users", null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + "users");
        onCreate(db);
    }

    public ArrayList<User> getUsers()
    {
        ArrayList<User> userArrayList = new ArrayList<User>();
        String query = "SELECT * FROM Users";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            User user = new User();
            user.setId(Integer.parseInt(cursor.getString(0)));
            user.setName(cursor.getString(1));
            user.setDescription(cursor.getString(2));
            user.setFollow(Boolean.parseBoolean(cursor.getString(3)));
            userArrayList.add(user);
        }
        cursor.close();
        db.close();
        return userArrayList;
    }

    public void updateUser(User user)
    {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        if(user.isFollow() == false)
        {
            values.put("Followed", false);
            db.update("Users", values,"Id = ?", new String[]{""+user.getId()});
        }

        else
        {
            values.put("Followed", true);
            db.update("Users", values,"Id = ?", new String[]{""+user.getId()});
        }
    }
}
