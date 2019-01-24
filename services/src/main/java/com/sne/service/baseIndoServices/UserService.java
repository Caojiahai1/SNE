package com.sne.service.baseIndoServices;

import com.sne.daos.baseInfoDaos.UserDao;
import com.sne.entrys.basicInfo.User;
import com.sne.utils.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Yan liang
 * @create 2019/1/24
 * @since 1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public CallResult add () {
        CallResult callResult = new CallResult();

        User user = new User();
        user.setRowId(123124342123L);
        user.setName("test");
        user.setCode("test");
        user.setCreater("test");
        user.setCreateDate(new Date());
        userDao.Insert(user);

        callResult.setSuccess(true);
        callResult.setMessage("添加成功");
        return callResult;
    }
}