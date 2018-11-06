package com.purchase.mapper.admin;

import com.purchase.pojo.admin.TbMenus;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface AdminMenusMapper {
	@Select({"<script>",
				"SELECT DISTINCT m.menu_id as menuId,m.title,m.icon,m.href,m.spread,m.parent_id as parentId,m.perms " +
					    "	FROM tb_roles_menus r LEFT JOIN tb_menus m ON r.menu_id = m.menu_id" +
						"  WHERE r.role_id in " +
						" <foreach collection='roleIds' item='id' open='(' separator=',' close=')'>",
							"#{id}",
						" </foreach>",
			  "</script>"
			})
	List<TbMenus> getMenus(@Param("roleIds") List<Long> roleId);
}
