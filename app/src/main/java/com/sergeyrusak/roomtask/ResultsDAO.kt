package com.sergeyrusak.roomtask

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sergeyrusak.roomtask.ResultEntity

@Dao
interface ResultsDao {
    @Query("SELECT * FROM results ORDER BY :order")
    fun getAll(order: String): LiveData<List<ResultEntity>>
    @Insert
    fun insert(vararg result: ResultEntity)
    @Delete
    fun delete(result: ResultEntity)
    @Update
    fun update(vararg result: ResultEntity)

    @Query("DELETE FROM `results`")
    fun deleteAll()

    @Query("SELECT SUM(`result`) FROM `results`")
    fun getTotal(): LiveData<Int>

    @Query ("SELECT COUNT(*) FROM (SELECT * FROM `results` WHERE `result` > (SELECT AVG(`result`) FROM `results`))")
    fun getGreaterAVG(): LiveData<Int>

    @Query("SELECT COUNT(*) FROM `results` WHERE `name` < 'А'")
    fun getEnglishNameCount(): LiveData<Int>

    @Query("SELECT `name` FROM `results` ORDER BY `result` DESC, `name` LIMIT 1")
    fun getTopCompany(): LiveData<String>

    @Query("SELECT `name` FROM `results` ORDER BY LENGTH(`name`) DESC, `name` LIMIT 1")
    fun getLongestCompany(): LiveData<String>

    @Query("DELETE FROM `results` WHERE `name` LIKE '%' || :substring || '%'")
    fun deleteBySubstr(substring: String)
}