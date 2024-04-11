package cn.sanfate.controller;

import cn.sanfate.entity.AjaxResult;
import cn.sanfate.entity.TeacherDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anhui OuYang
 * @version 1.0
 **/
@RestController
@RequestMapping("/teacher")
@Tag(name = "TeacherControllerAPI", description = "老师控制器接口")
public class TeacherController {

    @PostMapping("/add")
    @Operation( summary = "老师信息添加",
            description = "老师信息添加，并返回响应AjaxResult")
    public AjaxResult addTeacher(@RequestBody TeacherDTO teacherDTO) {
        return new AjaxResult(200, "成功", null);
    }

}
