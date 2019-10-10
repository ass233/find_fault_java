package com.zjjw.common.enmus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author crossoverJie
 */

public enum MsgTypeEnum {

    /** 成功 */
    PRIVATE(1, "私聊"),
    /** 成功 */
    GROUP(2, "群聊"),
    ;


    /** 枚举值码 */
    private final Integer code;

    /** 枚举描述 */
    private final String message;

    /**
     * 构建一个 StatusEnum 。
     * @param code 枚举值码。
     * @param message 枚举描述。
     */
    private MsgTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 得到枚举值码。
     * @return 枚举值码。
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 得到枚举描述。
     * @return 枚举描述。
     */
    public String getMessage() {
        return message;
    }

    /**
     * 得到枚举值码。
     * @return 枚举值码。
     */
    public Integer code() {
        return code;
    }

    /**
     * 得到枚举描述。
     * @return 枚举描述。
     */
    public String message() {
        return message;
    }

    /**
     * 通过枚举值码查找枚举值。
     * @param code 查找枚举值的枚举值码。
     * @return 枚举值码对应的枚举值。
     * @throws IllegalArgumentException 如果 code 没有对应的 StatusEnum 。
     */
    public static MsgTypeEnum findStatus(Integer code) {
        for (MsgTypeEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("ResultInfo StatusEnum not legal:" + code);
    }

    /**
     * 获取全部枚举值。
     *
     * @return 全部枚举值。
     */
    public static List<MsgTypeEnum> getAllStatus() {
        List<MsgTypeEnum> list = new ArrayList<MsgTypeEnum>();
        for (MsgTypeEnum status : values()) {
            list.add(status);
        }
        return list;
    }

    /**
     * 获取全部枚举值码。
     *
     * @return 全部枚举值码。
     */
    public static List<Integer> getAllStatusCode() {
        List<Integer> list = new ArrayList<>();
        for (MsgTypeEnum status : values()) {
            list.add(status.code());
        }
        return list;
    }
}
