//package com.liudi.back.controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import cn.zhenghe.framework.core.utils.obj.BeanCopyUtil;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.*;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import cn.zhenghe.framework.core.utils.message.Message;
//import java.util.ArrayList;
//
//import cn.zhenghe.framework.core.base.controller.WebController;
//import com.liudi.back.entity.ShandongBatchDelivery;
//import com.liudi.back.dto.ShandongBatchDeliveryDto;
//import com.liudi.back.service.IShandongBatchDeliveryService ;
//import java.util.List;
//
//
// /**
// * <p>
// * 山东省普通类常规批第一次志愿投档情况 前端控制器
// * </p>
// *
// * @author LiuD
// * @since 2021-08-03
// */
//@RestController
//@RequestMapping("shandongBatchDelivery")
//@Api(tags = "shandongBatchDelivery", description = "shandongBatchDelivery")
//public class ShandongBatchDeliveryController {
//   protected final Logger logger = LoggerFactory.getLogger( ShandongBatchDeliveryController.class);
//
//     @Autowired
//     private IShandongBatchDeliveryService shandongBatchDeliveryService;
//
//     @ApiOperation(value="保存")
//     @PostMapping("")
//     public Message addShandongBatchDelivery(@RequestBody ShandongBatchDeliveryDto shandongBatchDeliveryDto) {
//         try {
//             ShandongBatchDelivery shandongBatchDelivery = BeanCopyUtil.convertBean(shandongBatchDeliveryDto, ShandongBatchDelivery.class);
//             return Success(shandongBatchDeliveryService.save(shandongBatchDelivery));
//         }catch (Exception e){
//              logger.error("保存异常：===》" + e);
//              return Error(e.getMessage());
//         }
//     }
//     @ApiOperation(value="查询所有")
//     @GetMapping()
//     public Message getShandongBatchDeliveryList() {
//        try {
//            return Success(shandongBatchDeliveryService.list());
//        }catch (Exception e){
//            logger.error("查询异常：===》" + e);
//            return Error(e.getMessage());
//        }
//     }
//     @ApiOperation(value = "查询列表-分页")
//     @GetMapping("shandongBatchDeliveryListPage")
//     public Message shandongBatchDeliveryListPage(ShandongBatchDeliveryDto shandongBatchDeliveryDto) {
//         try {
//              Integer pageSize = shandongBatchDeliveryDto.getPageSize();
//              Integer pageNum = shandongBatchDeliveryDto.getPageNum();
//              Page<ShandongBatchDelivery> page = startPage(pageNum,pageSize);
//              QueryWrapper<ShandongBatchDelivery> wrapper = new QueryWrapper<ShandongBatchDelivery>();
//              IPage<ShandongBatchDelivery> pageResult = shandongBatchDeliveryService.page(page,wrapper);
//              List<ShandongBatchDelivery> list = pageResult.getRecords();
//              return Success( getPageResult(list,pageNum,pageSize,(int)pageResult.getTotal()));
//         }catch (Exception e){
//              logger.error("查询异常：===》" + e);
//              return Error(e.getMessage());
//         }
//     }
//     @ApiOperation(value = "数据详情")
//     @GetMapping("/{id}")
//     public Message getShandongBatchDeliveryInfo(@PathVariable("id") String id){
//          try {
//               ShandongBatchDelivery shandongBatchDelivery = shandongBatchDeliveryService.getById(id);
//               return Success(shandongBatchDelivery);
//          }catch (Exception e){
//               logger.error("查询异常：===》" + e);
//               return Error(e.getMessage());
//          }
//     }
//
//     @ApiOperation(value = "根据id更新")
//     @PutMapping()
//     public Message updateshandongBatchDelivery(@RequestBody ShandongBatchDeliveryDto shandongBatchDeliveryDto){
//           try{
//               ShandongBatchDelivery shandongBatchDelivery = BeanCopyUtil.convertBean(shandongBatchDeliveryDto, ShandongBatchDelivery.class);
//               shandongBatchDeliveryService.updateById(shandongBatchDelivery);
//               return Success();
//           }catch(Exception e){
//               logger.error("更新异常：===》" + e);
//               return Error(e.getMessage());
//           }
//     }
//     @ApiOperation(value = "根据baseId逻辑删除")
//     @DeleteMapping("/{id}")
//     public Message updateByIsDelete(@PathVariable("id") String id){
//           try{
//                List<String> strings = StringUtil.splitStr(id, ",");
//                return Success(shandongBatchDeliveryService.removeByIds(strings));
//           }catch(Exception e){
//               logger.error("删除异常：===》" + e);
//               return Error(e.getMessage());
//           }
//     }
//      @ApiOperation(value = "自定义查询列表-分页")
//      @GetMapping("findShandongBatchDeliveryListPage")
//      @ApiIgnore
//    public Message findShandongBatchDeliveryListPage(ShandongBatchDeliveryDto shandongBatchDeliveryDto) {
//            try {
//                    Integer pageSize = shandongBatchDeliveryDto.getPageSize();
//                    Integer pageNum = shandongBatchDeliveryDto.getPageNum();
//                    Page<ShandongBatchDelivery> page = startPage(pageNum,pageSize);
//                    ShandongBatchDelivery shandongBatchDelivery = BeanCopyUtil.convertBean(shandongBatchDeliveryDto, ShandongBatchDelivery.class);
//                    List<ShandongBatchDelivery> list = shandongBatchDeliveryService.findListPage(page,shandongBatchDelivery);
//                    return Success( getPageResult(list,pageNum,pageSize,(int)page.getTotal()));
//                }catch (Exception e){
//                    logger.error("查询异常：===》" + e);
//                    return Error(e.getMessage());
//            }
//      }
//}
