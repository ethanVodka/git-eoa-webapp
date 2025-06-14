SELECT
      mu.user_code
    , mu.login_password
    , mu.user_name
    , mu.user_account_lock_flag
    , mu.first_login_flag
    , mu.login_failure_count
FROM
    m_user mu
WHERE
        mu.user_code = /* condition.userCode */'00001'
    AND mu.login_password = /* condition.loginPassword */'00001'
