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

public abstract class SQLStoredProcedure {
	protected String name;
	protected HashMap<String, String> parameters;
	protected String comments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, String> getParameters() {
		return parameters;
	}

	public String printParameters() {
		String para = "";
		int i = 0;
		for (String key : parameters.keySet()) {
			if (i == 0) {
				para = para.concat(String.format("in %s %s", key, parameters.get(key)));
			} else {
				para = para.concat(String.format(", in %s %s", key, parameters.get(key)));
			}
			i++;
		}
		return para;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
