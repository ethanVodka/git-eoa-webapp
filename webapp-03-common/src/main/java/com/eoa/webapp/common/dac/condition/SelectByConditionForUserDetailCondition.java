package com.eoa.webapp.common.dac.condition;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
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
