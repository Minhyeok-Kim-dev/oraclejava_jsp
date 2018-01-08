package com.oraclejava.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	private static final String DB_DRIVER_CLASS="driver.classname";
	private static final String DB_URL="db.url";
	private static final String DB_USERNAME="db.username";
	private static final String DB_PASSWORD="db.password";
	
	private static Properties properties = null;
	private static BasicDataSource dataSource = null;
	
	// Init static members
	static {
		properties = new Properties();
		try {
			// 프로퍼티 파일로부터 DB Load 정보 가져옴			
			InputStream in = DBUtil.class.getResourceAsStream("/db.properties");	// path: src/db.properties
			properties.load(in);
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(properties.getProperty(DB_DRIVER_CLASS));
			dataSource.setUrl(properties.getProperty(DB_URL));
			dataSource.setUsername(properties.getProperty(DB_USERNAME));
			dataSource.setPassword(properties.getProperty(DB_PASSWORD));
			
			// Connection pool 개수 설정 - TODO:적절한 갯수가 몇개인지?
			dataSource.setMinIdle(100);
			dataSource.setMaxIdle(1000);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	
}
