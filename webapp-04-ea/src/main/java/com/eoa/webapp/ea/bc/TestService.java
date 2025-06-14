package com.eoa.webapp.ea.bc;

import com.eoa.webapp.common.dac.condition.SelectByConditionForUserDetailCondition;
import com.eoa.webapp.common.dac.dao.MuserDao;
import com.eoa.webapp.common.dac.entity.MuserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.eoa.webapp.ea.ic.dto.TestInDto;
import com.eoa.webapp.ea.ic.dto.TestOutDto;

@Service
@RequiredArgsConstructor
public class TestService {

    private final MuserDao muserDao;

    public Optional<TestOutDto> test(TestInDto testInDto) {
        SelectByConditionForUserDetailCondition condition = new SelectByConditionForUserDetailCondition();
        condition.setUserCode(testInDto.getUserCode());
        condition.setLoginPassword(testInDto.getLoginPassword());

        MuserEntity muserEntity = muserDao.selectByConditionForUserDetail(condition);
        if (muserEntity == null) {
            return Optional.empty();
        }

        TestOutDto outDto = new TestOutDto();
        outDto.setUserName(muserEntity.getUserName());
        outDto.setUserCode(muserEntity.getUserCode());
        outDto.setLoginPassword(muserEntity.getLoginPassword());
        outDto.setLoginFailureCount(muserEntity.getLoginFailureCount());
        outDto.setUserAccountLockFlag(muserEntity.getUserAccountLockFlag());
        outDto.setFirstLoginFlag(muserEntity.getFirstLoginFlag());
        return Optional.of(outDto);
    }
}
