package com.anshul5404834.stackoverflow_app;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface stack_overflow {

    @Insert
    public void addquestions(question_identity question_identity);
    @Insert
    public void addentityList(List<question_identity> question_identities);

    @Query("SELECT * FROM question_identity ")
    List<question_identity>  getAll();


}
