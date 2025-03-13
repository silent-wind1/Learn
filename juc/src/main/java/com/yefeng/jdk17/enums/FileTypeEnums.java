package com.yefeng.jdk17.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum FileTypeEnums {
    // lds_company公司表文件类型
    /** 企业经营固定场所证明照片 */
    businessLocationProof("businessLocationProof", "lds_company", "business_location_proof"),

    /** 企业经营场所照片 */
    businessLocationPhoto("businessLocationPhoto", "lds_company", "business_location_photo"),

    /** 企业门头照片 */
    doorFrontPic("doorFrontPic", "lds_company", "door_front_pic"),

    /** 收银台照片 */
    cashierPic("cashierPic", "lds_company", "cashier_pic"),

    /** 场景照片 */
    scenePic("scenePic", "lds_company", "scene_pic"),

    /** 法人手持身份证照片 */
    legalIdHandFront("legalIdHandFront", "lds_company", "legalId_hand_front"),

    /** 法人身份证正面照片 */
    legalIdCardFront("legalIdCardFront", "lds_company", "legal_id_card_front"),

    /** 法人身份证背面照片 */
    legalIdCardBack("legalIdCardBack", "lds_lds_company", "legal_id_card_back"),

    /** 银行开户许可证文件 */
    corporateBankOpeningPermit("corporateBankOpeningPermit", "lds_company", "corporate_bank_opening_permit");

    private final String tableFiledName;
    private final String tableName;
    private final String fieldName;

    private static final Map<String, FileTypeEnums> FIELD_NAME_MAP = new HashMap<>();

    // 静态代码块初始化 Map，提高查找效率
    static {
        for (FileTypeEnums type : values()) {
            FIELD_NAME_MAP.put(type.getFieldName(), type);
        }
    }

    FileTypeEnums(String fieldName, String tableName, String tableFiledName) {
        this.fieldName = fieldName;
        this.tableName = tableName;
        this.tableFiledName = tableFiledName;
    }

    public static FileTypeEnums getByFieldName(String fieldName) {
        return FIELD_NAME_MAP.get(fieldName);
    }
}
