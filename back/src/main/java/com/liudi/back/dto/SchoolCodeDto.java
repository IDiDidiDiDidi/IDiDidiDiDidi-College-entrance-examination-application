package com.liudi.back.dto;

import com.liudi.back.utils.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 技术经纪人Dto
 * </p>
 *
 * @author LiuD
 * @since 2021-08-02
 */
@Data
@ApiModel(value = "SchoolCodeDto对象", description = "技术经纪人")
public class SchoolCodeDto extends PageDto {

    @ApiModelProperty("主键Id")
    private String baseId;
    @ApiModelProperty("创建时间")
    private Date baseCreateTime;
    @ApiModelProperty("更新时间")
    private Date baseUpdateTime;
    @ApiModelProperty("创建者")
    private String creator;
    @ApiModelProperty("逻辑删除（0:未删除,1:删除）")
    private Boolean isDelete;
    @ApiModelProperty("学校代码")
    private String codeNo;
    @ApiModelProperty("学校名称")
    private String schoolName;
    @ApiModelProperty("备注")
    private String Notes;
}
