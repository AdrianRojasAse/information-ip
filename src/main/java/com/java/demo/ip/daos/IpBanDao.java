package com.java.demo.ip.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.demo.ip.entities.IpBan;

/**
 * 
 * @author AdrianRojas
 *
 *Dao que busca las ips en la lista negra, en caso de que la ip se encuentre en el blacklist, 
 *no se consulta información sobre la ip, como geolocalización, información del pais y moneda.
 *
 */

@Repository
public interface IpBanDao extends CrudRepository<IpBan, Long> {

	IpBan findByIp(String ip);
}
