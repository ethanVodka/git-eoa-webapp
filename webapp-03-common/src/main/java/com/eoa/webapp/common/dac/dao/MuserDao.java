package com.eoa.webapp.common.dac.dao;


import com.eoa.webapp.common.dac.condition.SelectByConditionForUserDetailCondition;
import com.eoa.webapp.common.dac.entity.MuserEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface MuserDao {

    @Select
    MuserEntity selectByConditionForUserDetail(SelectByConditionForUserDetailCondition condition);
}
