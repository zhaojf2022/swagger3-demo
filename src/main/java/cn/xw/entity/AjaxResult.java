package cn.xw.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author AnHui OuYang
 * @version 1.0
 */
// 响应对象模型定义
@Data
@AllArgsConstructor
@Schema(description = "响应返回数据对象")
public class AjaxResult {

    @Schema(
            title = "code",
            description = "响应码",
            format = "int32",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer code;

    @Schema(
            title = "msg",
            description = "响应信息",
            accessMode = Schema.AccessMode.READ_ONLY,
            example = "成功或失败",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String msg;

    @Schema(title = "data", description = "响应数据", accessMode = Schema.AccessMode.READ_ONLY)
    private Object data;
}