package com.liudi.back.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.liudi.back.utils.PageDto;

import java.util.Date;

/**
 * <p>
 * 学校地址信息表Dto
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
@Data
@ApiModel(value = "SchoolAddressDto对象", description = "学校地址信息表")
public class SchoolAddressDto extends PageDto {

    @ApiModelProperty("主键Id")
    private String baseId;
    @ApiModelProperty("创建时间")
    private Date baseCreateTime;
    @ApiModelProperty("更新时间")
    private Date baseUpdateTime;
    @ApiModelProperty("逻辑删除（0:未删除,1:删除）")
    private Boolean isDelete;
    @ApiModelProperty("创建者")
    private String creator;
    @ApiModelProperty("院校")
    private String schoolName;
    @ApiModelProperty("院校编码")
    private String schoolNo;
    @ApiModelProperty("省")
    private String province;
    @ApiModelProperty("市")
    private String city;
    @ApiModelProperty("县")
    private String county;
    @ApiModelProperty("区")
    private String district;
    @ApiModelProperty("地址编码")
    private String adcode;
    @ApiModelProperty("城市级别")
    private String cityLevel;
    @ApiModelProperty("国家")
    private String country;
    @ApiModelProperty("城市编码")
    private String cityCode;
    @ApiModelProperty("格式化地址")
    private String formattedAddress;
    @ApiModelProperty("经度")
    private String lat;
    @ApiModelProperty("纬度")
    private String lng;
}
