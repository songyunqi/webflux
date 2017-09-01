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

    public List<?> queryForList(String tmpVm, Map<String, Object> model) {
        String wrapSql = wrapQuery(tmpVm, model);
        List<?> list = jdbc.queryForList(wrapSql);
        return list;
    }
}
