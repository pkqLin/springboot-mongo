package com.lin.mongo.demo.system.datasource;
//@Slf4j
//@Configuration
//@MapperScan(basePackages = "com.demo.mapper.db1.**", sqlSessionFactoryRef = "sqlSessionFactoryDB1")
public class DataSourceMasterConfig {
//
//    @Primary
//    @Bean(name = "dataSourceDB1")
//    @ConfigurationProperties(prefix = "spring.datasource.db1")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().type(HikariDataSource.class)
//                .build();
//    }
//
//    @Bean(name = "sqlSessionFactoryDB1")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceDB1") DataSource dataSource) throws Exception {
//        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:mapper/db1/*.xml"));
//        log.info("------dataSource db12 配置成功");
//        return sessionFactoryBean.getObject();
//    }
//
//    @Bean(name = "sqlSessionTemplateDB1")
//    public SqlSessionTemplate sqlSessionFactoryTemplate(@Qualifier("sqlSessionFactoryDB1") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean(name = "txManagerDB1")
//    public PlatformTransactionManager txManager(@Qualifier("dataSourceDB1") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
