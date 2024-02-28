package cn.xw.controller;

import cn.xw.entity.AjaxResult;
import cn.xw.entity.StudentDTO;
import cn.xw.entity.StudentVO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 一个简单的Controller来测试Swagger
 *
 * @author AnHui OuYang
 * @version 1.0
 */
// 接口定义
@RestController
@RequestMapping("/student")
@Tag(
        name = "StudentControllerAPI",
        description = "学生控制器接口",
        externalDocs = @ExternalDocumentation(
                description = "这是一个接口文档介绍",
                url = "https://www.cnblogs.com/antLaddie/"))
public class StudentController {

    /***
     * 根据ID查询学生信息（单条）
     * @param id 学生id
     * @return 返回一条数据
     */
    @Operation(
            summary = "根据Id查询学生信息",
            description = "根据ID查询学生信息，并返回响应结果信息",
            parameters = {
                    @Parameter(name = "id", description = "学生ID", required = true, example = "1")
            },

            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "响应成功",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul和StudentVO组合模型",
                                            description = "返回实体，AjaxResult内data为StudentVO模型",
                                            anyOf = {AjaxResult.class, StudentVO.class})
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "响应失败",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul模型",
                                            description = "返回实体，AjaxResult内data为空",
                                            implementation = AjaxResult.class)
                            )
                    )
            }
    )
    @GetMapping("/findOne/{id}")
    public AjaxResult findOneStudent(@PathVariable(value = "id") Long id) {
        //模拟学生数据
        List<String> likes = Arrays.asList("抓鱼", "爬山", "写字");
        StudentVO studentVO = new StudentVO(id, "张三", 22, "安徽六安", 93.5, likes);
        return new AjaxResult(200, "成功", studentVO);
    }

    /***
     * 查询全部学生数据
     * @return 返回d条数据
     */
    @Operation(
            summary = "查询全部学生数据",
            description = "查询学生信息，并返回响应结果信息",
            parameters = {},
            deprecated = true,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "响应成功",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul和StudentVO组合模型",
                                            description = "返回实体，AjaxResult内data为" +
                                                    "StudentVO模型(并且StudentVO为集合)",
                                            anyOf = {AjaxResult.class, StudentVO.class})
                            )
                    )
            }
    )
    @GetMapping("/findAll")
    public AjaxResult findAllStudent() {
        //模拟学生数据
        List<String> likes = Arrays.asList("抓鱼", "爬山", "写字");
        StudentVO student1 = new StudentVO(1L, "张三", 22, "安徽六安", 93.5, likes);
        StudentVO student2 = new StudentVO(2L, "李四", 24, "安徽合肥", 99.5, likes);
        return new AjaxResult(200, "成功", Arrays.asList(student1, student2));
    }

    /***
     * 学生添加接口
     * @param studentDTO 学生DTO信息
     * @return 成功信息
     */
    @Operation(
            summary = "学生添加接口",
            description = "学生添加接口",
            parameters = {},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "学生信息DTO",
                    required = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StudentDTO.class)
                            )
                    }
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "响应成功",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul模型",
                                            description = "返回实体AjaxResult，并且Data为null",
                                            implementation = AjaxResult.class)
                            )
                    )
            }
    )
    @PostMapping("/saveStudent")
    public AjaxResult saveStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println("成功添加数据：" + studentDTO);
        return new AjaxResult(200, "成功", null);
    }

    /***
     * 学生更新
     * @param studentDTO 学生DTO信息
     * @return 成功信息
     */
    @Operation(
            summary = "学生更新接口",
            description = "学生更新接口",
            parameters = {},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "学生信息DTO",
                    required = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "StudentDTO模型",
                                            description = "注意StudentDTO的ID属性必传",
                                            implementation = StudentDTO.class)
                            )
                    }
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "响应成功",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul模型",
                                            description = "返回实体AjaxResult，并且Data为null",
                                            implementation = AjaxResult.class)
                            )
                    )
            }
    )
    @PutMapping("/updateStudent")
    public AjaxResult updateStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println("更新的数据是：" + studentDTO);
        return new AjaxResult(200, "成功", studentDTO);
    }

    /***
     * 删除学生信息
     * @param id 学生ID
     * @return 成功信息
     */
    @Operation(
            summary = "根据Id查询学生信息",
            description = "根据ID查询学生信息，并返回响应结果信息",
            parameters = {
                    @Parameter(name = "id", in = ParameterIn.PATH, description = "学生ID",
                            required = true, example = "1")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "响应成功",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul模型",
                                            description = "返回实体AjaxResult，并且Data为null",
                                            implementation = AjaxResult.class)
                            )
                    )
            }
    )
    @DeleteMapping("/delStudent/{id}")
    public AjaxResult delStudent(@PathVariable(value = "id") Long id) {
        System.out.println("删除ID为：" + id + " 的学生");
        return new AjaxResult(200, "成功", null);
    }
}
