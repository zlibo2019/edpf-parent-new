package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.entity.RptInfoEntity;
import com.weds.edpf.core.service.RptInfoService;
import com.weds.rpt.constants.RptParams;
import com.weds.rpt.utils.JasperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jasperreports.engine.JRException;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/jasper")
@Api(value = "报表展示", description = "报表展示")
public class JasperController {
    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    protected SqlSessionTemplate sqlSessionTemplate;

    @Resource
    private RptInfoService rptInfoService;

    // @Autowired
    // private DataSource dataSource;

    @Resource
    private RptParams rptParams;

    @Logs
    @ApiOperation(value = "报表展现", notes = "报表展现")
    @RequestMapping(value = "/showRpt", method = RequestMethod.GET)
    public void showRpt(@RequestParam String rptId, @RequestParam int pageIndex, String rptParams) {
        //JRBeanCollectionDataSource通过构造注入collection类型的参数，这里我们用的是list结构
        // JRDataSource jrDataSource = new JRBeanCollectionDataSource(reports);

        // //构建参数map
        // Map<String, Object> map = new HashMap<>();
        // Enumeration<?> params = request.getParameterNames();
        // while (params.hasMoreElements()) {
        //     String paramName = params.nextElement().toString();
        //     String paramValue = request.getParameter(paramName);
        //     map.put(paramName, paramValue);
        // }
        JSONObject jsonObject = JSONObject.parseObject(rptParams);
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }

        jsonObject.put("rptId", rptId);
        jsonObject.put("pageShow", true);
        if (!StringUtils.isBlank(rptParams)) {
            jsonObject.put("rptParams", URLEncoder.encode(rptParams));
        }

        RptInfoEntity rptInfoEntity = rptInfoService.selectByPrimaryKey(rptId);

        //指定模板文件
        File reportFile = new File(this.rptParams.getTemplatePath() + File.separator + rptInfoEntity.getRptTemplate());
        //调用工具类
        try {
            // DataSourceUtils.getConnection(dataSource);
            SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionTemplate.getSqlSessionFactory(),
                    sqlSessionTemplate.getExecutorType(), sqlSessionTemplate.getPersistenceExceptionTranslator());
            Connection connection = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
            JasperUtils.showPdf(reportFile.getPath(), jsonObject, pageIndex, request, response, connection);
            connection.close();
            SqlSessionUtils.closeSqlSession(sqlSession, sqlSessionTemplate.getSqlSessionFactory());
        } catch (JRException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Logs
    @ApiOperation(value = "报表导出", notes = "报表导出")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.GET)
    public void exportRpt(@RequestParam String rptId, String rptParams) {
        JSONObject jsonObject = JSONObject.parseObject(rptParams);
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }

        jsonObject.put("rptId", rptId);
        jsonObject.put("pageShow", false);

        if (!StringUtils.isBlank(rptParams)) {
            jsonObject.put("rptParams", URLEncoder.encode(rptParams));
        }

        RptInfoEntity rptInfoEntity = rptInfoService.selectByPrimaryKey(rptId);
        //指定模板文件
        File reportFile = new File(this.rptParams.getTemplatePath() + File.separator + rptInfoEntity.getRptTemplate());
        try {
            // DataSourceUtils.getConnection(dataSource);
            SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionTemplate.getSqlSessionFactory(),
                    sqlSessionTemplate.getExecutorType(), sqlSessionTemplate.getPersistenceExceptionTranslator());
            Connection connection = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
            JasperUtils.export(JasperUtils.EXCEL_TYPE, rptInfoEntity.getRptName(), reportFile, request, response, jsonObject, connection);
            connection.close();
            SqlSessionUtils.closeSqlSession(sqlSession, sqlSessionTemplate.getSqlSessionFactory());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
