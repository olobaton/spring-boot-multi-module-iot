/**
 * 
 */
package org.iot.business.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import org.iot.business.model.dataaccess.UserPO;

/**
 * @author loboo
 *
 */
@Repository
@Transactional(readOnly = true)
public interface UserDao extends JpaRepository<UserPO, Integer>{
	
	@Query("select userpo from UserPO userpo WHERE userpo.user =:user")
    public UserPO findByUser(@Param("user") String user);

}
