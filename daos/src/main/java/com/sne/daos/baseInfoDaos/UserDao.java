package com.sne.daos.baseInfoDaos;

import com.sne.entrys.basicInfo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Yan liang
 * @create 2019/1/24
 * @since 1.0.0
 */
public interface UserDao {
    void Insert (User user);

    User Get (@Param("RowId") long RowId);
}