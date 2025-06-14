package com.eoa.webapp.common.dac.condition;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SelectByConditionForUserDetailCondition {
    /**
     * ユーザーコード.
     * */
    private String userCode;

    /**
     * パスワード.
     * */
    private String loginPassword;
}
