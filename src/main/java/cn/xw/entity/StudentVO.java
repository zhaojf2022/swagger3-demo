package cn.xw.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author AnHui OuYang
 * @version 1.0
 */
// 模型
@Data
@AllArgsConstructor
@Schema(title = "学生模型VO", description = "响应视图学生模型VO")
public class StudentVO {
    @Schema(name = "学生ID", description = "学生ID属性", format = "int64", example = "1")
    private Long id;            // 学生ID
    @Schema(name = "学生姓名", description = "学生姓名属性", example = "jack")
    private String name;        // 学生姓名
    @Schema(name = "学生年龄", description = "学生年龄属性", format = "int32", example = "24")
    private Integer age;        // 学生年龄
    @Schema(name = "学生地址", description = "学生地址属性", example = "安徽合肥")
    private String address;     // 学生地址
    @Schema(name = "学生分数", description = "学生分数属性", format = "double", example = "55.50")
    private Double fraction;    // 学生分数
    @Schema(name = "学生爱好", description = "学生爱好属性（List类型）",
            type = "array", example = "[\"玩\", \"写字\"]")
    private List<String> likes; // 学生爱好
}
