/*
 * ManerFan(http://manerfan.com). All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.manerfan.translator.jpa.repositories;

import com.manerfan.translator.jpa.entities.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author manerfan
 * @date 2017/11/1
 */

@Repository
@Transactional(rollbackFor = Exception.class)
public interface StatisticsRepository extends JpaRepository<StatisticsEntity, String> {
    @Query("select stat from Statistics stat where stat.key='trans-statistics'")
    Optional<StatisticsEntity> getStatistics();

    @Modifying
    @Query("update Statistics stat set stat.textTransNum = stat.textTransNum + 1")
    void increaseTextNum();

    @Modifying
    @Query("update Statistics stat set stat.docTransNum = stat.docTransNum + 1")
    void increaseDocNum();

    @Modifying
    @Query("update Statistics stat set stat.sbdNum = stat.sbdNum + 1")
    void increaseSbdNum();

    @Modifying
    @Query("update Statistics stat set stat.byteTransNum = stat.byteTransNum + ?1")
    void increaseBytesNum(long num);
}
