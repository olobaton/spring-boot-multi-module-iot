/**
 * 
 */
package org.iot.business.dataaccess;

import org.iot.business.model.dataaccess.PersonalDataPO;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author loboo
 *
 */
@Transactional(readOnly = true)
@Repository
public interface PersonalDataDao extends JpaRepository<PersonalDataPO, Integer> {
	
	@Query("select personaldatapo from PersonalDataPO personaldatapo INNER JOIN personaldatapo.user WHERE personaldatapo.id =:id")
    public Optional<PersonalDataPO> findCustomById(@Param("id") Integer id);
	
	@Query("select personaldatapo from PersonalDataPO personaldatapo INNER JOIN personaldatapo.user as user WHERE user.user =:user")
	public PersonalDataPO findCustomByUserName(@Param("user") String user);
}
