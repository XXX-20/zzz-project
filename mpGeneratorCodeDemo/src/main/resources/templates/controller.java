package ${package.Controller};


import ${package.Entity}.${entity};

import ${package.Service}.${table.serviceName};

import 自定义公共返回响应类.Result;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


<#if restControllerStyle>

        <#else>

import org.springframework.stereotype.Controller;

</#if>

        <#if superControllerClassPackage??>

import ${superControllerClassPackage};

        </#if>


import java.util.List;


/**
 * <p>
 * ${table.comment} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Api(tags = "${table.comment}")

<#if restControllerStyle>

@RestController

<#else>

@Controller

</#if>

@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if><#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")

<#if kotlin>

class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>

<#else>

<#if superControllerClass??>

public class ${table.controllerName} extends ${superControllerClass} {

<#else>

public class ${table.controllerName} {

</#if>


@Autowired

private ${table.serviceName} ${table.serviceName?uncap_first};


@ApiOperation(value = "${table.comment}分页列表", response = ${entity}.class)

@GetMapping(value = "/page")

public  Result list(${entity} ${table.entityPath}, @ApiParam("当前页码")@RequestParam("pageNum")Long pageNum,@ApiParam("每页显示条目个数") @RequestParam("pageSize")Long pageSize) {


        QueryWrapper<${entity}>  queryWrapper= new QueryWrapper<>(${table.entityPath});

        IPage<${entity}> page = ${table.entityPath}Service.page(

        new Page<>(pageNum, pageSize),queryWrapper );

        return Result.success("查询成功",page);

        }


@ApiOperation(value = "${table.comment}条件查询")

@PostMapping("/get")

public Result list(@RequestBody ${entity} ${table.entityPath}){

        QueryWrapper<${entity}>  queryWrapper= new QueryWrapper<>(${table.entityPath});

        List<${entity}> ${table.entityPath}List = ${table.entityPath}Service.list(queryWrapper);

        return Result.success("查询成功",${table.entityPath}List);

        }


@ApiOperation(value = "${table.comment}详情", response = ${entity}.class)

@GetMapping(value = "/info/{id}")

public  Result info(@PathVariable Long id) {


        ${entity} data = ${table.serviceName?uncap_first}.getById(id);

        return Result.success("查询成功",data);

        }


@ApiOperation(value = "${table.comment}新增")

@PostMapping(value = "/add")

public  Result add(@RequestBody ${entity} ${table.entityPath}) {


        ${table.entityPath}Service.save(${table.entityPath});

        return Result.success("保存成功");

        }


@ApiOperation(value = "${table.comment}根据id修改")

@PostMapping(value = "/modify")

public  Result modify(@RequestBody ${entity} ${table.entityPath}) {


        ${table.entityPath}Service.updateById(${table.entityPath});

        return Result.success("更新成功");

        }


@ApiOperation(value = "${table.comment}根据id删除")

@GetMapping(value = "/remove/{id}")

public  Result remove(@PathVariable("id") Long id) {


        ${table.entityPath}Service.removeById(id);

        return Result.success();

        }


@ApiOperation(value = "${table.comment}根据id批量删除")

@PostMapping(value = "/removes")

public  Result removes(@RequestBody List<Long> ids) {


        ${table.serviceName?uncap_first}.removeByIds(ids);

        return Result.success();

        }


        }

</#if>