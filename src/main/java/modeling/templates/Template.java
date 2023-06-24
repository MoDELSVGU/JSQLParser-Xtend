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

public class Template {
	public static final String CREATE_DATABASE = "CREATE DATABASE %1$s \r\n" + " DEFAULT CHARACTER SET utf8 \r\n"
			+ " DEFAULT COLLATE utf8_general_ci";
	public static final String CREATE_FUNCTION = "/* FUNC: %1$s */\r\n" + "DELIMITER %4$s\r\n"
			+ "CREATE FUNCTION %1$s(%2$s)\r\n" + "RETURNS INT DETERMINISTIC\r\n" + "%3$s" + "DELIMITER ;\r\n";
	public static final String CREATE_INVARIANT_FUNCTION = "DELIMITER %1$s\r\n" + "CREATE FUNCTION %2$s ()\r\n"
			+ "RETURNS INT DETERMINISTIC\r\n" + "BEGIN\r\n" + "DECLARE result INT DEFAULT 0;\r\n"
			+ "SELECT res INTO result FROM (%3$s) AS TEMP_result;\r\n" + "RETURN (result);\r\n" + "END %1$s\r\n"
			+ "DELIMITER ";
	public static final String CREATE_TRIGGER = "DELIMITER %1$s\r\n" + "CREATE TRIGGER %2$s %3$s %4$s ON %5$s\r\n"
			+ "FOR EACH ROW\r\n" + "%6$s\r\n" + "DELIMITER ";
	public static final String CREATE_INVARIANT_TRIGGER = "DELIMITER %1$s\r\n"
			+ "CREATE TRIGGER %2$s %3$s %4$s ON %5$s\r\n" + "FOR EACH ROW\r\n" + "BEGIN\r\n"
			+ "DECLARE _result INT DEFAULT 0;\r\n" + "SELECT %6$s INTO _result;\r\n" + "IF (_result = 0)\r\n"
			+ "THEN\r\n" + "SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invariant violated';\r\n" + "END IF;\r\n"
			+ "END %1$s\r\n" + "DELIMITER ";
	public static final String THROW_ERROR_BODY = "BEGIN\r\n" + "DECLARE result INT DEFAULT 0;\r\n"
			+ "SIGNAL SQLSTATE '45000'\r\n" + "SET MESSAGE_TEXT = 'Unauthorized access';\r\n" + "RETURN (0);\r\n"
			+ "END //\r\n";
	public static final String AUTH_FUNC = "BEGIN\r\n" + "DECLARE result INT DEFAULT 0;\r\n" + "%1$s" + "END //\r\n";
	public static final String AUTH_FUN_BODY = "IF (_role = '%1$s')\r\n" + "    THEN IF (%2$s(%3$s))\r\n"
			+ "        THEN RETURN (1);\r\n" + "        ELSE RETURN (0);\r\n" + "    END IF;\r\n" + "ELSE %4$s\r\n"
			+ "END IF;\r\n";
	public static final String AUTH_ROLE_FUNC = "BEGIN\r\n" + "DECLARE result INT DEFAULT 0;\r\n"
			+ "SELECT res INTO result FROM \r\n" + "(SELECT \r\n" + "%1$s" + "as res\r\n" + ") AS TEMP;\r\n"
			+ "RETURN (result);\r\n" + "END //\r\n";
	public static final String PROC = "BEGIN\r\n" + "DECLARE _rollback int DEFAULT 0;\r\n"
			+ "DECLARE EXIT HANDLER FOR SQLEXCEPTION\r\n" + "BEGIN\r\n" + "  SET _rollback = 1;\r\n"
			+ "  GET STACKED DIAGNOSTICS CONDITION 1 @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;\r\n"
			+ "  SELECT @p1, @p2;\r\n" + "  ROLLBACK;\r\n" + "END;\r\n" + "START TRANSACTION;\r\n" + "%1$s"
			+ "IF _rollback = 0\r\n" + "THEN SELECT * from %2$s;\r\n" + "END IF;\r\n" + "END //";
	public static final String CREATE_PROC = "/* %1$s */\r\n" + "DELIMITER //\r\n" + "CREATE PROCEDURE %2$s(%3$s)\r\n"
			+ "%4$s\r\n" + "DELIMITER ;\r\n";
}