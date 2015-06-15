/*
 * This program was produced for the U.S. Agency for International Development. It was prepared by the USAID | DELIVER PROJECT, Task Order 4. It is part of a project which utilizes code originally licensed under the terms of the Mozilla Public License (MPL) v2 and therefore is licensed under MPL v2 or later.
 * + *
 * This program is free software: you can redistribute it and/or modify it under the terms of the Mozilla Public License as published by the Mozilla Foundation, either version 2 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the Mozilla Public License for more details.
 *
 * You should have received a copy of the Mozilla Public License along with this program. If not, see http://www.mozilla.org/MPL/
 */

package org.openlmis.report.builder;

import org.openlmis.report.model.params.UserSummaryParams;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserSummaryExQueryBuilder {

    public static String getQuery(Map params) {
        UserSummaryParams filter = (UserSummaryParams) params.get("filterCriteria");
        BEGIN();
        SELECT("rolename,roleid, count(*) totalRoles");
        FROM("vw_user_role_assignments");
        writepredicates(filter);
        GROUP_BY("rolename,roleid");
        String sql = SQL();
        return sql;

    }

    public static void writepredicates(UserSummaryParams filter) {
        if (filter != null) {
            if (filter.getProgramId() != 0 && filter.getProgramId() != -1) {
                WHERE("programid= #{filterCriteria.programId}");

            }
            if (filter.getRoleId() != 0 && filter.getRoleId() != -1) {
                WHERE("roleid= #{filterCriteria.roleId}");

            }
            if (filter.getSupervisoryNodeId() != 0 && filter.getSupervisoryNodeId() != -1) {
                WHERE("supervisorynodeid= #{filterCriteria.supervisoryNodeId}");

            }
        }

    }


}