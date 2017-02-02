package co.com.uni5d.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;

@Configuration
public class ConfigMongoDB {

	@Value("${mongoDBName}")
	private String mongoDBName;
	
	@Value("${mongoDBPort}")
	private int mongoDBPort;
	
	@Value("${mongoDBHost}")
	private String mongoDBHost;
	
	
	
	@Bean
	public MongoTemplate getMongo() throws Exception {
		return new MongoTemplate(getMongoDbFactory());
	}

//	@Bean(name="audioGFS")
//	public GridFsTemplate gridFsTemplate() throws Exception {
//		return new GridFsTemplate(getMongoDbFactory(), mongoConverter(), "Audio");
//	}

		
	@Bean
	public MongoDbFactory getMongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(mongoDBHost, mongoDBPort), mongoDBName);
	}

	@Bean
	public MappingMongoConverter mongoConverter() throws Exception {
		MongoMappingContext mappingContext = new MongoMappingContext();
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(getMongoDbFactory());
		MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mappingContext);
		return mongoConverter;
	}
}





