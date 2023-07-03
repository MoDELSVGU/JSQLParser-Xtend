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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import net.sf.jsqlparser.schema.Database;
import net.sf.jsqlparser.schema.MultiPartName;

public class Function implements MultiPartName {

	private Database database;
	private String name;
	private CompoundStatement statement;
	protected ArrayList<Variable> variables;

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

	public Function() {
		variables = new ArrayList<Variable>();
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

	public ArrayList<Variable> getVariables() {
		return variables;
	}

	public void setVariables(ArrayList<Variable> variables) {
		this.variables = variables;
	}

	/*
	 * Output example: kcaller VARCHAR(100), kself VARCHAR(100)
	 */
	public String getFunParametersWithType() {
		String s = "";
		int countPars = variables.size();
//		Collections.sort(variables, new VariableComparator());
		for (Variable v : variables) {
			s = s.concat(String.format("%s %s", v.getName(), v.getType()));
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
		int countPars = variables.size();
//		Collections.sort(variables, new VariableComparator());
		for (Variable v : variables) {
			s = s.concat(String.format("%s", v.getName()));
			countPars = countPars - 1;
			if (countPars > 0) {
				s = String.format("%s, ", s);
			}
		}
		return s;
	}

	public void setDelimiter(String delimiter) {
		this.statement.setDelimiter(delimiter);
	}

	public String getDelimiter() {
		return this.statement.getDelimiter();
	}
}
