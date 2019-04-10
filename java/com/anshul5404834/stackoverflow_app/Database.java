package com.anshul5404834.stackoverflow_app;


import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = question_identity.class,version = 5)
public abstract class Database extends RoomDatabase {
    public abstract stack_overflow stack_overflow();


}
