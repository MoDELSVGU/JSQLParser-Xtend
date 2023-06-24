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

package modeling.statements;

import java.util.HashMap;

import net.sf.jsqlparser.schema.Database;
import net.sf.jsqlparser.schema.MultiPartName;

public class Function implements MultiPartName {

	private Database database;
	private String name;
	private CompoundStatement statement;
	protected HashMap<String, String> parameters;

	@Override
	public String getFullyQualifiedName() {
		String fqn = "";

		if (database != null) {
			fqn += database.getFullyQualifiedName();
		}
		if (!fqn.isEmpty()) {
			fqn += ".";
		}

		if (name != null) {
			fqn += name;
		}

		return fqn;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String call() {
		return this.getFullyQualifiedName().concat("()");
	}

	public CompoundStatement getStatement() {
		return statement;
	}

	public void setStatement(CompoundStatement statement) {
		this.statement = statement;
	}

	public HashMap<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}

	/*
	 * Output example: kcaller VARCHAR(100), kself VARCHAR(100)
	 */
	public String getFunParametersWithType() {
		String s = "";
		int countPars = parameters.size();
		for (String key : parameters.keySet()) {
			s = s.concat(String.format("%s %s", key, parameters.get(key)));
			countPars = countPars - 1;
			if (countPars > 0) {
				s = String.format("%s, ", s);
			}
		}
		return s;
	}

	/*
	 * Output example: kcaller, kself
	 */
	public String getFunParameters() {
		String s = "";
		int countPars = parameters.size();
		for (String key : parameters.keySet()) {
			s = s.concat(String.format("%s", key));
			countPars = countPars - 1;
			if (countPars > 0) {
				s = String.format("%s, ", s);
			}
		}
		return s;
	}

}
