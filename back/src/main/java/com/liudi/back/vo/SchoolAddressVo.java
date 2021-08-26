package com.liudi.back.vo;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.liudi.back.core.base.BaseVo;

/**
 * <p>
 * 学校地址信息表Vo
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
@Data
@ApiModel(value = "SchoolAddressVo对象", description = "学校地址信息表")
public class SchoolAddressVo extends BaseVo {

    @ApiModelProperty(value = "主键Id")
    private String baseId;
    @ApiModelProperty(value = "创建时间")
    private Date baseCreateTime;
    @ApiModelProperty(value = "更新时间")
    private Date baseUpdateTime;
    @ApiModelProperty(value = "逻辑删除（0:未删除,1:删除）")
    private Boolean isDelete;
    @ApiModelProperty(value = "创建者")
    private String creator;
    @ApiModelProperty(value = "院校")
    private String schoolName;
    @ApiModelProperty(value = "院校编码")
    private String schoolNo;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "县")
    private String county;
    @ApiModelProperty(value = "区")
    private String district;
    @ApiModelProperty(value = "地址编码")
    private String adcode;
    @ApiModelProperty(value = "城市级别")
    private String cityLevel;
    @ApiModelProperty(value = "国家")
    private String country;
    @ApiModelProperty(value = "城市编码")
    private String cityCode;
    @ApiModelProperty(value = "格式化地址")
    private String formattedAddress;
    @ApiModelProperty(value = "经度")
    private String lat;
    @ApiModelProperty(value = "纬度")
    private String lng;

}
