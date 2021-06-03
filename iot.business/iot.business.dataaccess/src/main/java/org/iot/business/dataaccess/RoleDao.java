/**
 * 
 */
package org.iot.business.dataaccess;

import java.util.Optional;

import org.iot.business.model.dataaccess.RolePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author loboo
 *
 */
public interface RoleDao  extends JpaRepository<RolePO, Integer> {
	
	@Query("select rolpo from RolePO rolpo WHERE rolpo.idrole =:id")
    public Optional<RolePO> findCustomById(@Param("id") Integer id);

}
