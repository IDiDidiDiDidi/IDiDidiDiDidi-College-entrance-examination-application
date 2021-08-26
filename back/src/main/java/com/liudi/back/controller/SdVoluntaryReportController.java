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
//import com.liudi.back.entity.SdVoluntaryReport;
//import com.liudi.back.dto.SdVoluntaryReportDto;
//import com.liudi.back.service.ISdVoluntaryReportService ;
//import java.util.List;
//
//
// /**
// * <p>
// * 山东省普通类常规批第一次志愿投档情况 前端控制器
// * </p>
// *
// * @author LiuD
// * @since 2021-08-26
// */
//@RestController
//@RequestMapping("sdVoluntaryReport")
//@Api(tags = "sdVoluntaryReport", description = "sdVoluntaryReport")
//public class SdVoluntaryReportController extends WebController {
//   protected final Logger logger = LoggerFactory.getLogger( SdVoluntaryReportController.class);
//
//     @Autowired
//     private ISdVoluntaryReportService sdVoluntaryReportService;
//
//     @ApiOperation(value="保存")
//     @PostMapping("")
//     public Message addSdVoluntaryReport(@RequestBody SdVoluntaryReportDto sdVoluntaryReportDto) {
//         try {
//             SdVoluntaryReport sdVoluntaryReport = BeanCopyUtil.convertBean(sdVoluntaryReportDto, SdVoluntaryReport.class);
//             return Success(sdVoluntaryReportService.save(sdVoluntaryReport));
//         }catch (Exception e){
//              logger.error("保存异常：===》" + e);
//              return Error(e.getMessage());
//         }
//     }
//     @ApiOperation(value="查询所有")
//     @GetMapping()
//     public Message getSdVoluntaryReportList() {
//        try {
//            return Success(sdVoluntaryReportService.list());
//        }catch (Exception e){
//            logger.error("查询异常：===》" + e);
//            return Error(e.getMessage());
//        }
//     }
//     @ApiOperation(value = "查询列表-分页")
//     @GetMapping("sdVoluntaryReportListPage")
//     public Message sdVoluntaryReportListPage(SdVoluntaryReportDto sdVoluntaryReportDto) {
//         try {
//              Integer pageSize = sdVoluntaryReportDto.getPageSize();
//              Integer pageNum = sdVoluntaryReportDto.getPageNum();
//              Page<SdVoluntaryReport> page = startPage(pageNum,pageSize);
//              QueryWrapper<SdVoluntaryReport> wrapper = new QueryWrapper<SdVoluntaryReport>();
//              IPage<SdVoluntaryReport> pageResult = sdVoluntaryReportService.page(page,wrapper);
//              List<SdVoluntaryReport> list = pageResult.getRecords();
//              return Success( getPageResult(list,pageNum,pageSize,(int)pageResult.getTotal()));
//         }catch (Exception e){
//              logger.error("查询异常：===》" + e);
//              return Error(e.getMessage());
//         }
//     }
//     @ApiOperation(value = "数据详情")
//     @GetMapping("/{id}")
//     public Message getSdVoluntaryReportInfo(@PathVariable("id") String id){
//          try {
//               SdVoluntaryReport sdVoluntaryReport = sdVoluntaryReportService.getById(id);
//               return Success(sdVoluntaryReport);
//          }catch (Exception e){
//               logger.error("查询异常：===》" + e);
//               return Error(e.getMessage());
//          }
//     }
//
//     @ApiOperation(value = "根据id更新")
//     @PutMapping()
//     public Message updatesdVoluntaryReport(@RequestBody SdVoluntaryReportDto sdVoluntaryReportDto){
//           try{
//               SdVoluntaryReport sdVoluntaryReport = BeanCopyUtil.convertBean(sdVoluntaryReportDto, SdVoluntaryReport.class);
//               sdVoluntaryReportService.updateById(sdVoluntaryReport);
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
//                return Success(sdVoluntaryReportService.removeByIds(strings));
//           }catch(Exception e){
//               logger.error("删除异常：===》" + e);
//               return Error(e.getMessage());
//           }
//     }
//      @ApiOperation(value = "自定义查询列表-分页")
//      @GetMapping("findSdVoluntaryReportListPage")
//      @ApiIgnore
//    public Message findSdVoluntaryReportListPage(SdVoluntaryReportDto sdVoluntaryReportDto) {
//            try {
//                    Integer pageSize = sdVoluntaryReportDto.getPageSize();
//                    Integer pageNum = sdVoluntaryReportDto.getPageNum();
//                    Page<SdVoluntaryReport> page = startPage(pageNum,pageSize);
//                    SdVoluntaryReport sdVoluntaryReport = BeanCopyUtil.convertBean(sdVoluntaryReportDto, SdVoluntaryReport.class);
//                    List<SdVoluntaryReport> list = sdVoluntaryReportService.findListPage(page,sdVoluntaryReport);
//                    return Success( getPageResult(list,pageNum,pageSize,(int)page.getTotal()));
//                }catch (Exception e){
//                    logger.error("查询异常：===》" + e);
//                    return Error(e.getMessage());
//            }
//      }
//}
