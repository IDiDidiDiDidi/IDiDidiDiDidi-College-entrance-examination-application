package com.liudi.back.vo;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 技术经纪人Vo
 * </p>
 *
 * @author LiuD
 * @since 2021-08-02
 */
@Data
@ApiModel(value = "SchoolCodeVo对象", description = "技术经纪人")
public class SchoolCodeVo {

    @ApiModelProperty(value = "主键Id")
    private String baseId;
    @ApiModelProperty(value = "创建时间")
    private Date baseCreateTime;
    @ApiModelProperty(value = "更新时间")
    private Date baseUpdateTime;
    @ApiModelProperty(value = "创建者")
    private String creator;
    @ApiModelProperty(value = "逻辑删除（0:未删除,1:删除）")
    private Boolean isDelete;
    @ApiModelProperty(value = "学校代码")
    private String codeNo;
    @ApiModelProperty(value = "学校名称")
    private String schoolName;
    @ApiModelProperty(value = "备注")
    private String Notes;

}
