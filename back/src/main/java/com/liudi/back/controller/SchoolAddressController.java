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
//import com.liudi.back.entity.SchoolAddress;
//import com.liudi.back.dto.SchoolAddressDto;
//import com.liudi.back.service.ISchoolAddressService ;
//import java.util.List;
//
//
// /**
// * <p>
// * 学校地址信息表 前端控制器
// * </p>
// *
// * @author LiuD
// * @since 2021-08-26
// */
//@RestController
//@RequestMapping("schoolAddress")
//@Api(tags = "schoolAddress", description = "schoolAddress")
//public class SchoolAddressController extends WebController {
//   protected final Logger logger = LoggerFactory.getLogger( SchoolAddressController.class);
//
//     @Autowired
//     private ISchoolAddressService schoolAddressService;
//
//     @ApiOperation(value="保存")
//     @PostMapping("")
//     public Message addSchoolAddress(@RequestBody SchoolAddressDto schoolAddressDto) {
//         try {
//             SchoolAddress schoolAddress = BeanCopyUtil.convertBean(schoolAddressDto, SchoolAddress.class);
//             return Success(schoolAddressService.save(schoolAddress));
//         }catch (Exception e){
//              logger.error("保存异常：===》" + e);
//              return Error(e.getMessage());
//         }
//     }
//     @ApiOperation(value="查询所有")
//     @GetMapping()
//     public Message getSchoolAddressList() {
//        try {
//            return Success(schoolAddressService.list());
//        }catch (Exception e){
//            logger.error("查询异常：===》" + e);
//            return Error(e.getMessage());
//        }
//     }
//     @ApiOperation(value = "查询列表-分页")
//     @GetMapping("schoolAddressListPage")
//     public Message schoolAddressListPage(SchoolAddressDto schoolAddressDto) {
//         try {
//              Integer pageSize = schoolAddressDto.getPageSize();
//              Integer pageNum = schoolAddressDto.getPageNum();
//              Page<SchoolAddress> page = startPage(pageNum,pageSize);
//              QueryWrapper<SchoolAddress> wrapper = new QueryWrapper<SchoolAddress>();
//              IPage<SchoolAddress> pageResult = schoolAddressService.page(page,wrapper);
//              List<SchoolAddress> list = pageResult.getRecords();
//              return Success( getPageResult(list,pageNum,pageSize,(int)pageResult.getTotal()));
//         }catch (Exception e){
//              logger.error("查询异常：===》" + e);
//              return Error(e.getMessage());
//         }
//     }
//     @ApiOperation(value = "数据详情")
//     @GetMapping("/{id}")
//     public Message getSchoolAddressInfo(@PathVariable("id") String id){
//          try {
//               SchoolAddress schoolAddress = schoolAddressService.getById(id);
//               return Success(schoolAddress);
//          }catch (Exception e){
//               logger.error("查询异常：===》" + e);
//               return Error(e.getMessage());
//          }
//     }
//
//     @ApiOperation(value = "根据id更新")
//     @PutMapping()
//     public Message updateschoolAddress(@RequestBody SchoolAddressDto schoolAddressDto){
//           try{
//               SchoolAddress schoolAddress = BeanCopyUtil.convertBean(schoolAddressDto, SchoolAddress.class);
//               schoolAddressService.updateById(schoolAddress);
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
//                return Success(schoolAddressService.removeByIds(strings));
//           }catch(Exception e){
//               logger.error("删除异常：===》" + e);
//               return Error(e.getMessage());
//           }
//     }
//      @ApiOperation(value = "自定义查询列表-分页")
//      @GetMapping("findSchoolAddressListPage")
//      @ApiIgnore
//    public Message findSchoolAddressListPage(SchoolAddressDto schoolAddressDto) {
//            try {
//                    Integer pageSize = schoolAddressDto.getPageSize();
//                    Integer pageNum = schoolAddressDto.getPageNum();
//                    Page<SchoolAddress> page = startPage(pageNum,pageSize);
//                    SchoolAddress schoolAddress = BeanCopyUtil.convertBean(schoolAddressDto, SchoolAddress.class);
//                    List<SchoolAddress> list = schoolAddressService.findListPage(page,schoolAddress);
//                    return Success( getPageResult(list,pageNum,pageSize,(int)page.getTotal()));
//                }catch (Exception e){
//                    logger.error("查询异常：===》" + e);
//                    return Error(e.getMessage());
//            }
//      }
//}
