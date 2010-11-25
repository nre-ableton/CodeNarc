/*
 * Copyright 2009 the original author or authors.
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
package org.codenarc.rule.basic

import org.codenarc.rule.AbstractAstVisitorRule
import org.codehaus.groovy.ast.expr.MethodCallExpression

/**
 * This rule detects when the xor(Object) method is called directly in code instead of using the ^ operator. A groovier way to express this: a.xor(b) is this: a ^ b
 *
 * @author Hamlet D'Arcy
 * @version $Revision$ - $Date$
 */
class ExplicitCallToXorMethodRule extends AbstractAstVisitorRule {
    String name = 'ExplicitCallToXorMethod'
    int priority = 2
    Class astVisitorClass = ExplicitCallToXorMethodAstVisitor
    boolean ignoreThisReference = false
}

class ExplicitCallToXorMethodAstVisitor extends ExplicitCallToMethodAstVisitor {

    def ExplicitCallToXorMethodAstVisitor() {
        super('xor');
    }

    @Override
    String getViolationMessage(MethodCallExpression exp) {
        "Explicit call to ${exp.text} method can be rewritten as ${exp.objectExpression.text} ^ ${exp.arguments.text}"        
    }
}