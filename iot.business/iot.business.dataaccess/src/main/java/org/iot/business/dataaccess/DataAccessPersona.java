/**
 * 
 */
package org.iot.business.dataaccess;

import org.iot.business.model.dataaccess.DataPersonaPO;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author loboo
 *
 */
@Transactional(readOnly = true)
public interface DataAccessPersona extends JpaRepository<DataPersonaPO, Integer> {
	
	@Query("select p from DataPersonaPO p INNER JOIN p.usuario WHERE p.id =:id")
    public Optional<DataPersonaPO> findCustomById(@Param("id") Integer id);
	
	@Query("select p from DataPersonaPO p INNER JOIN p.usuario as users WHERE users.usuario =:user")
	public DataPersonaPO findCustomByUserName(@Param("user") String user);
}
