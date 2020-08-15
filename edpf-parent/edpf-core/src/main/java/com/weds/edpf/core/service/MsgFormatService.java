package com.weds.edpf.core.service;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.entity.MsgFunctionEntity;
import com.weds.edpf.core.entity.MsgTemplateEntity;
import com.weds.edpf.core.mapper.MsgFunctionMapper;
import com.weds.edpf.core.mapper.MsgTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MsgFormatService extends BaseService {

    @Autowired
    private MsgTemplateMapper msgTemplateMapper;

    @Autowired
    private MsgFunctionMapper msgFunctionMapper;

    /**
     * @param id
     * @param params
     * @return
     * @throws ScriptException
     * @throws NoSuchMethodException
     */
    public String parseTemplate(String id, String type, Map<String, Object> params) throws ScriptException, NoSuchMethodException {
        MsgTemplateEntity msgTemplateEntity = msgTemplateMapper.selectByPrimaryKey(id, type);
        String content = "";
        if (msgTemplateEntity != null) {
            content = msgTemplateEntity.getTemplateContent();
            Pattern pattern = Pattern.compile("#([\\w,:]+)#");
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                String paramName = matcher.group(1);
                String param = matcher.group();
                // if (paramName.toUpperCase().startsWith("P_")) {
                //     content = content.replace(param, params.get(paramName));
                // } else
                if (paramName.toUpperCase().startsWith("F_")) {
                    String[] temp = paramName.split(":");
                    String funResult;
                    if (temp.length > 1) {
                        String[] strParams = temp[1].split(",");
                        Object[] funParams = new Object[strParams.length];
                        for (int i = 0; i < strParams.length; i++) {
                            funParams[i] = params.get(strParams[i]);
                        }
                        funResult = parseFunction(temp[0], funParams);
                    } else {
                        funResult = parseFunction(temp[0]);
                    }
                    content = content.replace(param, funResult);
                } else {
                    // System.out.println("param type not defined");
                    if (params.get(paramName) != null) {
                        content = content.replace(param, params.get(paramName).toString());
                    }
                }
            }
        }

        // MSG_TEMPLATE
        // 001	测试	{name:#P_NAME#, age:#F_001:P_A,P_B#}	1	1
        // MSG_FUNCTION
        // F_001	aaaaa	paramFun	function paramFun(name, age){return name+age;}	js	1
        return content;
    }

    private String parseFunction(String id, Object... params) throws ScriptException, NoSuchMethodException {
        MsgFunctionEntity msgFunctionEntity = msgFunctionMapper.selectByPrimaryKey(id);
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        // 初始化脚本引擎
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByExtension(msgFunctionEntity.getFunctionType());
        // 取得调用接口
        Invocable invocable = (Invocable) scriptEngine;
        scriptEngine.eval(msgFunctionEntity.getFunctionContent());
        Object obj = invocable.invokeFunction(msgFunctionEntity.getFunctionName(), params);
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }
}
