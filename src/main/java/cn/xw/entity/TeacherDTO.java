package cn.xw.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author AnHui OuYang
 * @version 1.0
 */
@Data
@AllArgsConstructor
@Schema(title = "老师模型DTO", description = "请求视图老师模型DTO")
public class TeacherDTO {

    @Schema(name = "老师ID", description = "老师ID属性", format = "int64", example = "1")
    private Long id;                // 老师ID

    @Schema(name = "老师姓名", description = "老师姓名属性", example = "jack")
    private String name;            // 老师姓名

    @Schema(name = "老师年龄", description = "老师年龄属性", format = "int32", example = "35")
    private Integer age;            // 老师年龄

    @Schema(name = "老师生日",
            description = "老师生日属性",
            type = "String",
            format = "date-time",
            example = "2023-12-12 00:00:00")
    private Date birthday;          // 老师生日

    @Schema(name = "老师地址", description = "老师地址属性", example = "安徽合肥")
    private String address;         // 老师地址

    @Schema(name = "老师工资", description = "老师工资属性", format = "BigDecimal", example = "6000.0")
    private BigDecimal salary;      // 老师工资

    @Schema(name = "老师评分", description = "老师评分属性", format = "double", example = "55.50")
    private Double fraction;        // 老师评分

    @Schema(name = "老师爱好", description = "老师爱好属性（List类型）",
            type = "array", format = "array", example = "[\"玩\", \"写字\"]")
    private List<String> likes;     // 老师爱好

    @Schema(name = "是否是班主任", description = "是否是班主任属性", type = "Boolean", example = "true")
    private Boolean isHeadmaster;   // 是否是班主任
}
