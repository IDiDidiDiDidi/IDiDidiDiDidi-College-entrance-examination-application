package ${package.Controller};
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import cn.zhenghe.framework.core.utils.obj.BeanCopyUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.zhenghe.framework.core.utils.message.Message;
import java.util.ArrayList;

<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import ${package.Entity}.${entity};
import ${cfg.pageDto}.dto.${entity}Dto;
import ${package.Service}.${table.serviceName} ;
import java.util.List;


 /**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
</#if>
@RequestMapping("${table.entityPath}")
@Api(tags = "${table.entityPath}", description = "${table.entityPath}")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
   protected final Logger logger = LoggerFactory.getLogger( ${table.controllerName}.class);

     @Autowired
     private ${table.serviceName} ${table.entityPath}Service;

     @ApiOperation(value="保存")
     @PostMapping("")
     public Message add${entity}(@RequestBody ${entity}Dto ${table.entityPath}Dto) {
         try {
             ${entity} ${table.entityPath} = BeanCopyUtil.convertBean(${table.entityPath}Dto, ${entity}.class);
             return Success(${table.entityPath}Service.save(${table.entityPath}));
         }catch (Exception e){
              logger.error("保存异常：===》" + e);
              return Error(e.getMessage());
         }
     }
     @ApiOperation(value="查询所有")
     @GetMapping()
     public Message get${entity}List() {
        try {
            return Success(${table.entityPath}Service.list());
        }catch (Exception e){
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
     }
     @ApiOperation(value = "查询列表-分页")
     @GetMapping("${table.entityPath}ListPage")
     public Message ${table.entityPath}ListPage(${entity}Dto ${table.entityPath}Dto) {
         try {
              Integer pageSize = ${table.entityPath}Dto.getPageSize();
              Integer pageNum = ${table.entityPath}Dto.getPageNum();
              Page<${entity}> page = startPage(pageNum,pageSize);
              QueryWrapper<${entity}> wrapper = new QueryWrapper<${entity}>();
              IPage<${entity}> pageResult = ${table.entityPath}Service.page(page,wrapper);
              List<${entity}> list = pageResult.getRecords();
              return Success( getPageResult(list,pageNum,pageSize,(int)pageResult.getTotal()));
         }catch (Exception e){
              logger.error("查询异常：===》" + e);
              return Error(e.getMessage());
         }
     }
     @ApiOperation(value = "数据详情")
     @GetMapping("/{id}")
     public Message get${entity}Info(@PathVariable("id") String id){
          try {
               ${entity} ${table.entityPath} = ${table.entityPath}Service.getById(id);
               return Success(${table.entityPath});
          }catch (Exception e){
               logger.error("查询异常：===》" + e);
               return Error(e.getMessage());
          }
     }

     @ApiOperation(value = "根据id更新")
     @PutMapping()
     public Message update${table.entityPath}(@RequestBody ${entity}Dto ${table.entityPath}Dto){
           try{
               ${entity} ${table.entityPath} = BeanCopyUtil.convertBean(${table.entityPath}Dto, ${entity}.class);
               ${table.entityPath}Service.updateById(${table.entityPath});
               return Success();
           }catch(Exception e){
               logger.error("更新异常：===》" + e);
               return Error(e.getMessage());
           }
     }
     @ApiOperation(value = "根据baseId逻辑删除")
     @DeleteMapping("/{id}")
     public Message updateByIsDelete(@PathVariable("id") String id){
           try{
                List<String> strings = StringUtil.splitStr(id, ",");
                return Success(${table.entityPath}Service.removeByIds(strings));
           }catch(Exception e){
               logger.error("删除异常：===》" + e);
               return Error(e.getMessage());
           }
     }
      @ApiOperation(value = "自定义查询列表-分页")
      @GetMapping("find${entity}ListPage")
      @ApiIgnore
    public Message find${entity}ListPage(${entity}Dto ${table.entityPath}Dto) {
            try {
                    Integer pageSize = ${table.entityPath}Dto.getPageSize();
                    Integer pageNum = ${table.entityPath}Dto.getPageNum();
                    Page<${entity}> page = startPage(pageNum,pageSize);
                    ${entity} ${table.entityPath} = BeanCopyUtil.convertBean(${table.entityPath}Dto, ${entity}.class);
                    List<${entity}> list = ${table.entityPath}Service.findListPage(page,${table.entityPath});
                    return Success( getPageResult(list,pageNum,pageSize,(int)page.getTotal()));
                }catch (Exception e){
                    logger.error("查询异常：===》" + e);
                    return Error(e.getMessage());
            }
      }
}
</#if>
