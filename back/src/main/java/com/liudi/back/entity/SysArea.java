package com.liudi.back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liudi.back.core.base.InfoEntity;

@TableName("sys_area")
public class SysArea extends InfoEntity {
    private String areaCode;
    private Integer areaLevel;
    @TableField("area_Is_show")
    private Integer areaIsShow;
    private String areaPhoneCode;
    private String areaPostalCode;
    private String areaTypeNo;
    private String areaNo;
    private String areaParentNo;
    private String baseParentId;
    private String baseName;
    private String baseNote;
    private Integer sort;
    private String updateBy;
    private String tenantId;

    public SysArea() {
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

    public Integer getSort() {
        return this.sort;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public String getTenantId() {
        return this.tenantId;
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

    public void setSort(final Integer sort) {
        this.sort = sort;
    }

    public void setUpdateBy(final String updateBy) {
        this.updateBy = updateBy;
    }

    public void setTenantId(final String tenantId) {
        this.tenantId = tenantId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SysArea)) {
            return false;
        } else {
            SysArea other = (SysArea)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
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

                Object this$areaIsShow = this.getAreaIsShow();
                Object other$areaIsShow = other.getAreaIsShow();
                if (this$areaIsShow == null) {
                    if (other$areaIsShow != null) {
                        return false;
                    }
                } else if (!this$areaIsShow.equals(other$areaIsShow)) {
                    return false;
                }

                label158: {
                    Object this$areaPhoneCode = this.getAreaPhoneCode();
                    Object other$areaPhoneCode = other.getAreaPhoneCode();
                    if (this$areaPhoneCode == null) {
                        if (other$areaPhoneCode == null) {
                            break label158;
                        }
                    } else if (this$areaPhoneCode.equals(other$areaPhoneCode)) {
                        break label158;
                    }

                    return false;
                }

                label151: {
                    Object this$areaPostalCode = this.getAreaPostalCode();
                    Object other$areaPostalCode = other.getAreaPostalCode();
                    if (this$areaPostalCode == null) {
                        if (other$areaPostalCode == null) {
                            break label151;
                        }
                    } else if (this$areaPostalCode.equals(other$areaPostalCode)) {
                        break label151;
                    }

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

                label137: {
                    Object this$areaNo = this.getAreaNo();
                    Object other$areaNo = other.getAreaNo();
                    if (this$areaNo == null) {
                        if (other$areaNo == null) {
                            break label137;
                        }
                    } else if (this$areaNo.equals(other$areaNo)) {
                        break label137;
                    }

                    return false;
                }

                label130: {
                    Object this$areaParentNo = this.getAreaParentNo();
                    Object other$areaParentNo = other.getAreaParentNo();
                    if (this$areaParentNo == null) {
                        if (other$areaParentNo == null) {
                            break label130;
                        }
                    } else if (this$areaParentNo.equals(other$areaParentNo)) {
                        break label130;
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

                Object this$baseName = this.getBaseName();
                Object other$baseName = other.getBaseName();
                if (this$baseName == null) {
                    if (other$baseName != null) {
                        return false;
                    }
                } else if (!this$baseName.equals(other$baseName)) {
                    return false;
                }

                label109: {
                    Object this$baseNote = this.getBaseNote();
                    Object other$baseNote = other.getBaseNote();
                    if (this$baseNote == null) {
                        if (other$baseNote == null) {
                            break label109;
                        }
                    } else if (this$baseNote.equals(other$baseNote)) {
                        break label109;
                    }

                    return false;
                }

                label102: {
                    Object this$sort = this.getSort();
                    Object other$sort = other.getSort();
                    if (this$sort == null) {
                        if (other$sort == null) {
                            break label102;
                        }
                    } else if (this$sort.equals(other$sort)) {
                        break label102;
                    }

                    return false;
                }

                Object this$updateBy = this.getUpdateBy();
                Object other$updateBy = other.getUpdateBy();
                if (this$updateBy == null) {
                    if (other$updateBy != null) {
                        return false;
                    }
                } else if (!this$updateBy.equals(other$updateBy)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SysArea;
    }


    public String toString() {
        return "SysArea(areaCode=" + this.getAreaCode() + ", areaLevel=" + this.getAreaLevel() + ", areaIsShow=" + this.getAreaIsShow() + ", areaPhoneCode=" + this.getAreaPhoneCode() + ", areaPostalCode=" + this.getAreaPostalCode() + ", areaTypeNo=" + this.getAreaTypeNo() + ", areaNo=" + this.getAreaNo() + ", areaParentNo=" + this.getAreaParentNo() + ", baseParentId=" + this.getBaseParentId() + ", baseName=" + this.getBaseName() + ", baseNote=" + this.getBaseNote() + ", sort=" + this.getSort() + ", updateBy=" + this.getUpdateBy() + ", tenantId=" + this.getTenantId() + ")";
    }
}
