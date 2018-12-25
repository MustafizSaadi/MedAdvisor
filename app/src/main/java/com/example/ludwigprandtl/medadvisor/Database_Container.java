package com.example.ludwigprandtl.medadvisor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

public class Database_Container implements Parcelable {

    MyDatabase myDatabase ;
    public Database_Container(Context context) {
        myDatabase = new MyDatabase(context);
        SQLiteDatabase sqLiteDatabase = myDatabase.getWritableDatabase();
    }
    MyDatabase get_myDatabase()
    {
        return myDatabase;
    }

    protected Database_Container(Parcel in) {
        myDatabase = (MyDatabase) in.readValue(MyDatabase.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(myDatabase);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Database_Container> CREATOR = new Parcelable.Creator<Database_Container>() {
        @Override
        public Database_Container createFromParcel(Parcel in) {
            return new Database_Container(in);
        }

        @Override
        public Database_Container[] newArray(int size) {
            return new Database_Container[size];
        }
    };
}