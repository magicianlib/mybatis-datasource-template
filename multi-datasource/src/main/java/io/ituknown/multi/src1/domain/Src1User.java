package io.ituknown.multi.src1.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName
public class Src1User implements Serializable {

    private static final long serialVersionUID = -2678193384486086652L;

    @TableId
    private Long id;

    @TableField
    private String name;

    @TableField
    private Integer age;

    @TableField
    private Integer gender;
}
