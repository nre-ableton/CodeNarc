/*
 * Copyright 2011 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codenarc.tool

import org.codenarc.test.AbstractTestCase

/**
 * Tests for GenerateRuleSetAllRulesByRuleSetName
 *
 * @author Chris Mair
 * @version $Revision: 619 $ - $Date: 2011-02-27 15:38:33 -0500 (Sun, 27 Feb 2011) $
 */
class GenerateRuleSetAllRulesByRuleSetNameTest extends AbstractTestCase {

    void testMain_GeneratesSampleRuleSetFile() {
        GenerateRuleSetAllRulesByRuleSetName.main(null)

        def outputFile = new File(GenerateRuleSetAllRulesByRuleSetName.RULESET_FILE)
        def outputFileText = outputFile.text
        log("contents=$outputFileText")

        assertContainsAll(outputFileText, ['// ', 'unnecessary', 'UnnecessaryBigDecimalInstantiation'])
    }

}