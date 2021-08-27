package com.liudi.back.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.liudi.back.core.base.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

@ApiModel(
    value = "SysAreaDto对象",
    description = ""
)
public class SysAreaDto extends PageDto {
    @ApiModelProperty("主键")
    private String baseId;
    @ApiModelProperty("地区编码")
    private String areaCode;
    @ApiModelProperty("地区级别")
    private Integer areaLevel;
    @ApiModelProperty("是否显示")
    private Integer areaIsShow;
    @ApiModelProperty("地区电话区号")
    private String areaPhoneCode;
    @ApiModelProperty("地区邮编")
    private String areaPostalCode;
    @ApiModelProperty("地区类型编码")
    private String areaTypeNo;
    @ApiModelProperty("已弃用，后期删除，不建议使用")
    private String areaNo;
    @ApiModelProperty("已弃用，后期删除，不建议使用")
    private String areaParentNo;
    @ApiModelProperty("父级主键")
    private String baseParentId;
    @ApiModelProperty("地区名称")
    private String baseName;
    @ApiModelProperty("备注")
    private String baseNote;
    @ApiModelProperty("创建时间")
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private Date baseCreateTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private Date baseUpdateTime;
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("创建者")
    private String creator;
    @ApiModelProperty("更新者")
    private String updateBy;
    @ApiModelProperty("租户字段")
    private String tenantId;
    @ApiModelProperty("逻辑删除（0:未删除,1:删除）")
    private Boolean isDelete;

    public SysAreaDto() {
    }

    public String getBaseId() {
        return this.baseId;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public Integer getAreaLevel() {
        return this.areaLevel;
    }

    public Integer getAreaIsShow() {
        return this.areaIsShow;
    }

    public String getAreaPhoneCode() {
        return this.areaPhoneCode;
    }

    public String getAreaPostalCode() {
        return this.areaPostalCode;
    }

    public String getAreaTypeNo() {
        return this.areaTypeNo;
    }

    public String getAreaNo() {
        return this.areaNo;
    }

    public String getAreaParentNo() {
        return this.areaParentNo;
    }

    public String getBaseParentId() {
        return this.baseParentId;
    }

    public String getBaseName() {
        return this.baseName;
    }

    public String getBaseNote() {
        return this.baseNote;
    }

    public Date getBaseCreateTime() {
        return this.baseCreateTime;
    }

    public Date getBaseUpdateTime() {
        return this.baseUpdateTime;
    }

    public Integer getSort() {
        return this.sort;
    }

    public String getCreator() {
        return this.creator;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public void setBaseId(final String baseId) {
        this.baseId = baseId;
    }

    public void setAreaCode(final String areaCode) {
        this.areaCode = areaCode;
    }

    public void setAreaLevel(final Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public void setAreaIsShow(final Integer areaIsShow) {
        this.areaIsShow = areaIsShow;
    }

    public void setAreaPhoneCode(final String areaPhoneCode) {
        this.areaPhoneCode = areaPhoneCode;
    }

    public void setAreaPostalCode(final String areaPostalCode) {
        this.areaPostalCode = areaPostalCode;
    }

    public void setAreaTypeNo(final String areaTypeNo) {
        this.areaTypeNo = areaTypeNo;
    }

    public void setAreaNo(final String areaNo) {
        this.areaNo = areaNo;
    }

    public void setAreaParentNo(final String areaParentNo) {
        this.areaParentNo = areaParentNo;
    }

    public void setBaseParentId(final String baseParentId) {
        this.baseParentId = baseParentId;
    }

    public void setBaseName(final String baseName) {
        this.baseName = baseName;
    }

    public void setBaseNote(final String baseNote) {
        this.baseNote = baseNote;
    }

    public void setBaseCreateTime(final Date baseCreateTime) {
        this.baseCreateTime = baseCreateTime;
    }

    public void setBaseUpdateTime(final Date baseUpdateTime) {
        this.baseUpdateTime = baseUpdateTime;
    }

    public void setSort(final Integer sort) {
        this.sort = sort;
    }

    public void setCreator(final String creator) {
        this.creator = creator;
    }

    public void setUpdateBy(final String updateBy) {
        this.updateBy = updateBy;
    }

    public void setTenantId(final String tenantId) {
        this.tenantId = tenantId;
    }

    public void setIsDelete(final Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SysAreaDto)) {
            return false;
        } else {
            SysAreaDto other = (SysAreaDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label239: {
                    Object this$baseId = this.getBaseId();
                    Object other$baseId = other.getBaseId();
                    if (this$baseId == null) {
                        if (other$baseId == null) {
                            break label239;
                        }
                    } else if (this$baseId.equals(other$baseId)) {
                        break label239;
                    }

                    return false;
                }

                Object this$areaCode = this.getAreaCode();
                Object other$areaCode = other.getAreaCode();
                if (this$areaCode == null) {
                    if (other$areaCode != null) {
                        return false;
                    }
                } else if (!this$areaCode.equals(other$areaCode)) {
                    return false;
                }

                Object this$areaLevel = this.getAreaLevel();
                Object other$areaLevel = other.getAreaLevel();
                if (this$areaLevel == null) {
                    if (other$areaLevel != null) {
                        return false;
                    }
                } else if (!this$areaLevel.equals(other$areaLevel)) {
                    return false;
                }

                label218: {
                    Object this$areaIsShow = this.getAreaIsShow();
                    Object other$areaIsShow = other.getAreaIsShow();
                    if (this$areaIsShow == null) {
                        if (other$areaIsShow == null) {
                            break label218;
                        }
                    } else if (this$areaIsShow.equals(other$areaIsShow)) {
                        break label218;
                    }

                    return false;
                }

                label211: {
                    Object this$areaPhoneCode = this.getAreaPhoneCode();
                    Object other$areaPhoneCode = other.getAreaPhoneCode();
                    if (this$areaPhoneCode == null) {
                        if (other$areaPhoneCode == null) {
                            break label211;
                        }
                    } else if (this$areaPhoneCode.equals(other$areaPhoneCode)) {
                        break label211;
                    }

                    return false;
                }

                Object this$areaPostalCode = this.getAreaPostalCode();
                Object other$areaPostalCode = other.getAreaPostalCode();
                if (this$areaPostalCode == null) {
                    if (other$areaPostalCode != null) {
                        return false;
                    }
                } else if (!this$areaPostalCode.equals(other$areaPostalCode)) {
                    return false;
                }

                Object this$areaTypeNo = this.getAreaTypeNo();
                Object other$areaTypeNo = other.getAreaTypeNo();
                if (this$areaTypeNo == null) {
                    if (other$areaTypeNo != null) {
                        return false;
                    }
                } else if (!this$areaTypeNo.equals(other$areaTypeNo)) {
                    return false;
                }

                label190: {
                    Object this$areaNo = this.getAreaNo();
                    Object other$areaNo = other.getAreaNo();
                    if (this$areaNo == null) {
                        if (other$areaNo == null) {
                            break label190;
                        }
                    } else if (this$areaNo.equals(other$areaNo)) {
                        break label190;
                    }

                    return false;
                }

                label183: {
                    Object this$areaParentNo = this.getAreaParentNo();
                    Object other$areaParentNo = other.getAreaParentNo();
                    if (this$areaParentNo == null) {
                        if (other$areaParentNo == null) {
                            break label183;
                        }
                    } else if (this$areaParentNo.equals(other$areaParentNo)) {
                        break label183;
                    }

                    return false;
                }

                Object this$baseParentId = this.getBaseParentId();
                Object other$baseParentId = other.getBaseParentId();
                if (this$baseParentId == null) {
                    if (other$baseParentId != null) {
                        return false;
                    }
                } else if (!this$baseParentId.equals(other$baseParentId)) {
                    return false;
                }

                label169: {
                    Object this$baseName = this.getBaseName();
                    Object other$baseName = other.getBaseName();
                    if (this$baseName == null) {
                        if (other$baseName == null) {
                            break label169;
                        }
                    } else if (this$baseName.equals(other$baseName)) {
                        break label169;
                    }

                    return false;
                }

                Object this$baseNote = this.getBaseNote();
                Object other$baseNote = other.getBaseNote();
                if (this$baseNote == null) {
                    if (other$baseNote != null) {
                        return false;
                    }
                } else if (!this$baseNote.equals(other$baseNote)) {
                    return false;
                }

                label155: {
                    Object this$baseCreateTime = this.getBaseCreateTime();
                    Object other$baseCreateTime = other.getBaseCreateTime();
                    if (this$baseCreateTime == null) {
                        if (other$baseCreateTime == null) {
                            break label155;
                        }
                    } else if (this$baseCreateTime.equals(other$baseCreateTime)) {
                        break label155;
                    }

                    return false;
                }

                Object this$baseUpdateTime = this.getBaseUpdateTime();
                Object other$baseUpdateTime = other.getBaseUpdateTime();
                if (this$baseUpdateTime == null) {
                    if (other$baseUpdateTime != null) {
                        return false;
                    }
                } else if (!this$baseUpdateTime.equals(other$baseUpdateTime)) {
                    return false;
                }

                Object this$sort = this.getSort();
                Object other$sort = other.getSort();
                if (this$sort == null) {
                    if (other$sort != null) {
                        return false;
                    }
                } else if (!this$sort.equals(other$sort)) {
                    return false;
                }

                label134: {
                    Object this$creator = this.getCreator();
                    Object other$creator = other.getCreator();
                    if (this$creator == null) {
                        if (other$creator == null) {
                            break label134;
                        }
                    } else if (this$creator.equals(other$creator)) {
                        break label134;
                    }

                    return false;
                }

                label127: {
                    Object this$updateBy = this.getUpdateBy();
                    Object other$updateBy = other.getUpdateBy();
                    if (this$updateBy == null) {
                        if (other$updateBy == null) {
                            break label127;
                        }
                    } else if (this$updateBy.equals(other$updateBy)) {
                        break label127;
                    }

                    return false;
                }

                Object this$tenantId = this.getTenantId();
                Object other$tenantId = other.getTenantId();
                if (this$tenantId == null) {
                    if (other$tenantId != null) {
                        return false;
                    }
                } else if (!this$tenantId.equals(other$tenantId)) {
                    return false;
                }

                Object this$isDelete = this.getIsDelete();
                Object other$isDelete = other.getIsDelete();
                if (this$isDelete == null) {
                    if (other$isDelete != null) {
                        return false;
                    }
                } else if (!this$isDelete.equals(other$isDelete)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SysAreaDto;
    }


    public String toString() {
        return "SysAreaDto(baseId=" + this.getBaseId() + ", areaCode=" + this.getAreaCode() + ", areaLevel=" + this.getAreaLevel() + ", areaIsShow=" + this.getAreaIsShow() + ", areaPhoneCode=" + this.getAreaPhoneCode() + ", areaPostalCode=" + this.getAreaPostalCode() + ", areaTypeNo=" + this.getAreaTypeNo() + ", areaNo=" + this.getAreaNo() + ", areaParentNo=" + this.getAreaParentNo() + ", baseParentId=" + this.getBaseParentId() + ", baseName=" + this.getBaseName() + ", baseNote=" + this.getBaseNote() + ", baseCreateTime=" + this.getBaseCreateTime() + ", baseUpdateTime=" + this.getBaseUpdateTime() + ", sort=" + this.getSort() + ", creator=" + this.getCreator() + ", updateBy=" + this.getUpdateBy() + ", tenantId=" + this.getTenantId() + ", isDelete=" + this.getIsDelete() + ")";
    }
}
