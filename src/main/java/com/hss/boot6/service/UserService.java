package com.hss.boot6.service;

import com.hss.boot6.bean.UserEntity;
import com.hss.boot6.common.ExchangeEnum;
import com.hss.boot6.common.QueueEnum;
import com.hss.boot6.jpa.UserJpa;
import com.hss.boot6.message.QueueMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private UserJpa userJpa;

    /**
     * 消息队列业务逻辑实现
     */
    @Autowired
    private QueueMessageService queueMessageService;
    /**
     * 保存用户
     * 并写入消息队列
     * @param userEntity
     * @return
     */
    public Long save(UserEntity userEntity) throws Exception
    {
        /**
         * 保存用户
         */
//        userJpa.save(userEntity);
        /**
         * 将消息写入消息队列
         */
        queueMessageService.send(userEntity.getId(), ExchangeEnum.USER_REGISTER, QueueEnum.USER_REGISTER);

        return userEntity.getId();
    }
}
