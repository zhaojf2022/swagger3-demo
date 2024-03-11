package cn.xw.config;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.media.*;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 接口描述
 *
 * @author Anhui OuYang
 * @version 1.0
 **/
public class InterfaceDescriptionConfig {

    /***
     * get方式保存老师信息接口
     * @return PathItem
     */
    public static PathItem addTeacher() {
        //=====================创建字段描述信息（老师类描述）如：TeacherDTO=====================
        Schema id = new IntegerSchema().format("int64").description("老师ID");
        Schema name = new StringSchema().minLength(2).maxLength(5).example("张三").description("老师姓名");
        Schema age = new IntegerSchema().format("int32").maximum(new BigDecimal("99"))
                .minimum(new BigDecimal("1")).example("23").description("老师年龄");
        Schema birthday = new DateSchema().format("date").example("2023-12-12").description("老师生日");
        Schema address = new StringSchema().minLength(2).maxLength(9).example("安徽省").description("老师地址");
        Schema salary = new NumberSchema().format("bigDecimal").maximum(new BigDecimal("99999.99"))
                .minimum(new BigDecimal("100.00")).example("6500.50").description("老师工资");
        Schema fraction = new NumberSchema().format("double").maximum(new BigDecimal("99.99"))
                .minimum(new BigDecimal("10.00")).example("25.3").description("老师评分");
        Schema likes = new ArraySchema().minItems(1).maxItems(10).description("这是一个爱好数组");
        Schema isHeadmaster = new BooleanSchema().example(true).description("是否是班主任");
        Schema schema = new ObjectSchema().description("老师对象属性")
                .addProperty("id", id).addProperty("name", name).addProperty("age", age)
                .addProperty("birthday", birthday).addProperty("address", address)
                .addProperty("salary", salary).addProperty("fraction", fraction)
                .addProperty("likes", likes).addProperty("isHeadmaster", isHeadmaster);
        //=====================响应字段描述信息（返回类描述）如：AjaxResult=====================
        Schema resultSchema = new ObjectSchema().description("响应信息对象")
                .addProperty("code", new IntegerSchema().example("200").description("响应码"))
                .addProperty("msg", new StringSchema().example("成功").description("响应信息"))
                .addProperty("data", schema);


        //设置响应头信息，可以设置系统响应头，也可以设置自定义响应头，具体声明，前端好获取指定响应头信息
        HashMap<String, Header> headers = new HashMap<>();
        headers.put("my-header1", new Header().description("测试响应头1").schema(new StringSchema()));
        headers.put("my-header2", new Header().description("测试响应头2").schema(new StringSchema()));
        headers.put("my-header3", new Header().description("测试响应头3").schema(new StringSchema()));

        // 设置响应信息
        ApiResponses apiResponses = new ApiResponses()
                .addApiResponse("200", new ApiResponse().description("响应成功信息").headers(headers)
                        .content(new Content().addMediaType("application/json",
                                new MediaType().schema(resultSchema))))
                .addApiResponse("500", new ApiResponse().description("响应失败"));
        // 设置请求信息
        RequestBody requestBody = new RequestBody()
                .content(new Content().addMediaType("application/json",
                        new MediaType().schema(schema)));

        // 设置请求URL后缀参数信息（可以添加多个）  接口描述
        List<Parameter> parameters = new ArrayList<>();
        Parameter sign = new Parameter()
                .name("sign")                       // 设置参数名称
                .description("URL参数标记信息")       // 设置描述
                .required(false)                    // 是否必传
                .in("path")                         // 参数信息参数位置（当前在URL路径后）
                .schema(new StringSchema())         // 参数类型
                .example("tx117839");               // 示例数据
        parameters.add(sign);

        // 设置当前接口描述信息
        Operation operation1 = new Operation()
                .operationId("addTeacher")
                .description("这是一个添加老师信息的接口")
                .requestBody(requestBody)
                .parameters(parameters)
                .responses(apiResponses);

        // 设置接口路径信息及请求方式（这里我设置了一个post请求的接口）
        return new PathItem().post(operation1).description("POST请求");
    }
}
