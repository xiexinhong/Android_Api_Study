package com.study.xxh.adnroid.localdata;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.study.xxh.adnroid.utils.AppUitl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiexinhong on 16/2/2.
 */
public class PersonDao {

    private SQLiteDatabase db = new DataBaseHelper(AppUitl.mContext).getWritableDatabase();

    public void insert(Person person) {
        ContentValues values = new ContentValues();
        values.put("name",person.name);
        values.put("age", person.age);
        values.put("phone",person.phone);
        db.insert("person", null, values);
    }

    public void update(Person person) {
        ContentValues values = new ContentValues();
        values.put("name",person.name);
        values.put("age", person.age);
        values.put("phone", person.phone);
        db.update("person", values, "id = ?", new String[]{String.valueOf(person.id)});
    }

    public void delete(int personId) {
        db.delete("person", "id = ?", new String[]{String.valueOf(personId)});
    }

    public List<Person> queryAll() {
        List<Person> persons = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT id,name,age,phone FROM person", null);
        Person person;
        while(cursor != null && cursor.moveToNext()) {
            person = new Person();
            person.id = cursor.getInt(cursor.getColumnIndex("id"));
            person.name = cursor.getString(cursor.getColumnIndex("name"));
            person.age = cursor.getInt(cursor.getColumnIndex("age"));
            person.phone = cursor.getString(cursor.getColumnIndex("phone"));
            persons.add(person);
        }
        return persons;
    }


}
