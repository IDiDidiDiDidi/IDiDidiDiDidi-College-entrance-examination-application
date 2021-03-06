package cn.zheng.generator;

import cn.zheng.generator.util.ConfigUtil;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author chl
 */
public class Test {
    private static final String ENTITY_DTO_TEMPLATE_PATH = "/templates/entityDto.java.ftl";
    private static final String ENTITY_VO_TEMPLATE_PATH = "/templates/entityVo.java.ftl";

    /**
     * <p>
     * 输入表名
     * </p>
     */
    public static String scannerTable() {
        return "technical_economist";
    }

    /**
     * 是否只生成BaseId ；
     * 0  继承baseEntity 只生成baseId entity
     * 1 继承InfoEntity  生成baseCreatime 、baseUpdateTime、creator、isDelete
     * 2 继承BaseInfoEntity  生成baseCreatime 跟baseUpdateTime
     */
    public static String isAll() {
        return "1";
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        String packName = ConfigUtil.getConfiguration().getPackageName();
        final String packNameStr = packName.replace(".", "/");
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + ConfigUtil.getConfiguration().getFilePath());
        gc.setAuthor(ConfigUtil.getConfiguration().getAuthor());
        gc.setOpen(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        //是否覆盖文件
        gc.setFileOverride(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(ConfigUtil.getConfiguration().getDb().getUrl());
        // dsc.setSchemaName("public");
        dsc.setDriverName(ConfigUtil.getConfiguration().getDb().getDriver());
        dsc.setUsername(ConfigUtil.getConfiguration().getDb().getUsername());
        dsc.setPassword(ConfigUtil.getConfiguration().getDb().getPassword());
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if ("datetime".equals(fieldType.toLowerCase())) {
                    return DbColumnType.DATE;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent(ConfigUtil.getConfiguration().getPackageName());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("pageDto", packName);
                map.put("baseIdStr", "#{baseId}");
                map.put("baseIdsStr", "#{baseIds}");
                map.put("item", "#{item}");
                map.put("SymbolStr", "#");
                //setMap进去
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + ConfigUtil.getConfiguration().getFileMapperPath()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig(ENTITY_DTO_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + ConfigUtil.getConfiguration().getFilePath() + "/" +
                        packNameStr + "/dto" + "/" + tableInfo.getEntityName() + "Dto" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(ENTITY_VO_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + ConfigUtil.getConfiguration().getFilePath() + "/" +
                        packNameStr + "/vo" + "/" + tableInfo.getEntityName() + "Vo" + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //表名生成策略  下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        /自动填充设置
//        strategy.setTableFillList();
        strategy.setRestControllerStyle(true); //配置是否启用restController
        // 自定义 实体 父类
        if ("0".equals(isAll())) {
            strategy.setSuperEntityClass("cn.zhenghe.framework.core.base.entity.BaseEntity");
        } else if ("1".equals(isAll())) {
            strategy.setSuperEntityClass("cn.zhenghe.framework.core.base.entity.InfoEntity");
        } else if ("2".equals(isAll())) {
            strategy.setSuperEntityClass("cn.zhenghe.framework.core.base.entity.BaseInfoEntity");
        }
        strategy.setEntityLombokModel(true);
        // 自定义 controller 父类
        strategy.setSuperControllerClass("cn.zhenghe.framework.core.base.controller.WebController");
        // 自定义 mapper 父类
        strategy.setSuperMapperClass("cn.zhenghe.framework.core.base.mapper.SuperMapper");
        // 自定义 service 父类
        strategy.setSuperServiceClass("cn.zhenghe.framework.core.base.service.BaseService");
        // 自定义 serviceImpl 父类
        strategy.setSuperServiceImplClass("cn.zhenghe.framework.core.base.service.iml.BaseSerivceImpl");

        strategy.setInclude(scannerTable());
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
       /* TemplateConfig tc = new TemplateConfig();
        tc.setEntity("tpl/entity.java.vm");
        tc.setMapper("tpl/mapper.java.vm");
        tc.setXml("tpl/mapper.xml.vm");
        tc.setService("tpl/service.java.vm");
        tc.setController("tpl/controller.java.vm");
        mpg.setTemplate(tc);*/

        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
