package mybatis.service;

import mybatis.model.ScoreRecord;

import java.util.List;

public interface ScoreRecordService {

    /**
     * 插入一条积分记录
     * @param scoreRecord
     * @return
     */
    Integer insert(ScoreRecord scoreRecord);

    /**
     * 管理员获取自己的加分记录
     * 非管理员获取自己的被加分记录
     * @param userAccount
     * @param role
     * @return
     */
    List<ScoreRecord> getMyScoreRecordList(String userAccount, Integer role);



}
