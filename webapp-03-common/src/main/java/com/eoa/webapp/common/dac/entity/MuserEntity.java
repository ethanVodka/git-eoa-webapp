package com.eoa.webapp.common.dac.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class MuserEntity {

    /**
     * ユーザーコード.
     * */
    private String userCode;

    /**
     * ユーザー名.
     * */
    private String userName;

    /**
     * パスワード.
     * */
    private String loginPassword;

    /**
     * アカウントロックフラグ.
     * */
    private String userAccountLockFlag;

    /**
     * 初ログインフラグ.
     * */
    private String firstLoginFlag;

    /**
     * ログイン失敗回数.
     * */
    private BigDecimal loginFailureCount;
}
