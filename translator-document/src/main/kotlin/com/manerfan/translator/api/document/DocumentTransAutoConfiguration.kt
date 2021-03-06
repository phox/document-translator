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
 *
 */

package com.manerfan.translator.api.document

import info.monitorenter.cpdetector.io.CodepageDetectorProxy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import info.monitorenter.cpdetector.io.UnicodeDetector
import info.monitorenter.cpdetector.io.ASCIIDetector
import info.monitorenter.cpdetector.io.JChardetFacade



/**
 * @author manerfan
 * @date 2017/12/19
 */

@Configuration
@ComponentScan("com.manerfan.translator.api.document")
class DocumentTransAutoConfiguration {
    @Bean
    fun codePageDetectorProxy(): CodepageDetectorProxy {
        val detectorProxy = CodepageDetectorProxy.getInstance()
        detectorProxy.add(JChardetFacade.getInstance())
        detectorProxy.add(ASCIIDetector.getInstance())
        detectorProxy.add(UnicodeDetector.getInstance())
        return detectorProxy
    }
}