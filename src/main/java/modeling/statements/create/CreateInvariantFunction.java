/**************************************************************************
Copyright 2019 Vietnamese-German-University
Copyright 2023 ETH Zurich

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author: hoangnguyen (hoang.nguyen@inf.ethz.ch)
***************************************************************************/

package modeling.statements.create;

import modeling.templates.Template;

public class CreateInvariantFunction extends CreateFunction {
    private String sqlInvariant;

    @Override
    public String toString() {
        return String.format(
            Template.CREATE_INVARIANT_FUNCTION, delimiter,
            function.getName(), sqlInvariant);
    }

    public String getSqlInvariant() {
        return sqlInvariant;
    }

    public void setSqlInvariant(String sqlInvariant) {
        this.sqlInvariant = sqlInvariant;
    }

}