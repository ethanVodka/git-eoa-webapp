package com.eoa.webapp.ea.ic.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TestOutDto {
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
