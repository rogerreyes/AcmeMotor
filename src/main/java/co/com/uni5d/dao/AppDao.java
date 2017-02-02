package co.com.uni5d.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import co.com.uni5d.anotaciones.AcmeDao;
import co.com.uni5d.domain.Respuesta;

@AcmeDao
public class AppDao {

	
	@Autowired
	MongoTemplate mongoTemplate;

	public void salvarJson(Respuesta respuesta) {
	 mongoTemplate.save(respuesta);
	}
	
	
}
