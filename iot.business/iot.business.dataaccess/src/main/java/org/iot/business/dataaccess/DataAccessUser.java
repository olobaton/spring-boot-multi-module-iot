/**
 * 
 */
package org.iot.business.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import org.iot.business.model.dataaccess.UsuarioPO;

/**
 * @author loboo
 *
 */
@Repository
@Transactional(readOnly = true)
public interface DataAccessUser extends JpaRepository<UsuarioPO, Integer>{
	
	@Query("select user from UsuarioPO user WHERE user.usuario =:usuario")
    public UsuarioPO findByUsuario(@Param("usuario") String usuario);

}
