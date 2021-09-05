package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @author a2008q
 * @since 2021/9/5 18:00
 */
public interface SpitDao extends MongoRepository<Spit, String> {
}
