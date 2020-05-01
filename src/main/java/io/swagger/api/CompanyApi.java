package io.swagger.api;

import io.swagger.model.Company;
import java.util.List;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-05-01T19:52:15.474+08:00")

@Api(value = "company", description = "the company API")
public interface CompanyApi {

    @ApiOperation(value = "Create company", notes = "", response = Company.class, responseContainer = "List", tags={ "company", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Company.class) })
    @RequestMapping(value = "/company",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<List<Company>> createCompany(

@ApiParam(value = "" ,required=true ) @RequestBody List<Company> body

);


    @ApiOperation(value = "Delete company", notes = "", response = Void.class, tags={ "company", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid company id supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Company not found", response = Void.class) })
    @RequestMapping(value = "/company/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCompany(
@ApiParam(value = "",required=true ) @PathVariable("id") String id


);


    @ApiOperation(value = "List all company", notes = "", response = Company.class, responseContainer = "List", tags={ "company", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Company.class),
        @ApiResponse(code = 400, message = "Invalid company id supplied", response = Company.class),
        @ApiResponse(code = 404, message = "Company not found", response = Company.class) })
    @RequestMapping(value = "/company",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Company>> listCompany();


    @ApiOperation(value = "Get company by company id", notes = "", response = Company.class, tags={ "company", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Company.class),
        @ApiResponse(code = 400, message = "Invalid company id supplied", response = Company.class),
        @ApiResponse(code = 404, message = "Company not found", response = Company.class) })
    @RequestMapping(value = "/company/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Company> readCompany(
@ApiParam(value = "",required=true ) @PathVariable("id") String id


);


    @ApiOperation(value = "Updated company", notes = "", response = Company.class, tags={ "company", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Company.class),
        @ApiResponse(code = 400, message = "Invalid company supplied", response = Company.class),
        @ApiResponse(code = 404, message = "Company not found", response = Company.class) })
    @RequestMapping(value = "/company/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Company> updateCompany(
@ApiParam(value = "",required=true ) @PathVariable("id") String id


,

@ApiParam(value = "Updated company object" ,required=true ) @RequestBody Company body

);

}
