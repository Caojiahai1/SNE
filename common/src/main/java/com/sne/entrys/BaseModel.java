package com.sne.entrys;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Yan liang
 * @create 2019/1/24
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class BaseModel {
    private long RowId;

    private String Creater;

    private Date CreateDate;
}