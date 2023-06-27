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

package modeling.templates;

public class SQLTemplate {
	public static final String CREATE_DATABASE = 
	"CREATE DATABASE %1$s \r\n" + 
	" DEFAULT CHARACTER SET utf8 \r\n" +
	" DEFAULT COLLATE utf8_general_ci";
	
	public static final String CREATE_FUNCTION = 
	"/* FUNC: %2$s */\r\n" + 
	"DELIMITER %1$s\r\n" + 
	"CREATE FUNCTION %2$s(%3$s)\r\n" + 
	"RETURNS INT DETERMINISTIC\r\n" + 
	"%4$s" + 
	"DELIMITER ;\r\n";
	
	public static final String CREATE_PROC = 
	"/* %1$s */\r\n" + 
	"DELIMITER %5$s\r\n" + 
	"CREATE PROCEDURE %2$s(%3$s)\r\n" +
	"%4$s\r\n" + 
	"DELIMITER ;\r\n";
}
