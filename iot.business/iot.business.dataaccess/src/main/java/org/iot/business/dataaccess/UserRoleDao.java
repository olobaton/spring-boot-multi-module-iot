/**
 * 
 */
package org.iot.business.dataaccess;

import org.iot.business.model.dataaccess.UserRolePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author loboo
 *
 */
public interface UserRoleDao extends JpaRepository<UserRolePO, Integer>{

}
