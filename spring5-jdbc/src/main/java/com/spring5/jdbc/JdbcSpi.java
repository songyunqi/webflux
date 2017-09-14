/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.jdbc;

import java.util.List;
import java.util.Map;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author Yang
 */
public class JdbcSpi {

    private static final String ENCODING_UTF8 = "UTF-8";

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private VelocityEngine velocityEngine;

    public String wrapQuery(String tmpVm, Map<String, Object> model) {
        String sql = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, tmpVm, ENCODING_UTF8, model);
        return sql;
    }

    /**
     * 计数
     *
     * @param sqlScript
     * @param model
     * @return
     */
    public Long count(String sqlScript, Map<String, Object> model) {
        String sql = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, sqlScript, ENCODING_UTF8, model);
        StringBuilder sb = new StringBuilder();
        sb.append("select count(0) as COUNT from ").append("( ").append(sql).append(" )");
        return (Long) jdbc.queryForMap(sql).get("COUNT");
    }

    /**
     * 自动绑定
     *
     * @param sqlScript
     * @param model
     * @param clazz
     * @return
     */
    public List<?> queryForList(String sqlScript, Map<String, Object> model, Class clazz) {
        String wrapSql = wrapQuery(sqlScript, model);
        List<?> list = jdbc.queryForList(wrapSql, clazz);
        return list;
    }

    /**
     * 手动绑定
     *
     * @param sqlScript
     * @param model
     * @param wrapper
     * @return
     */
    public List<?> queryForList(String sqlScript, Map<String, Object> model, RowMapper wrapper) {
        String wrapSql = wrapQuery(sqlScript, model);
        List<?> list = jdbc.queryForList(wrapSql, wrapper);
        return list;
    }
}
