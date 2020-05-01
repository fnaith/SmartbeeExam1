package io.swagger.api;

import java.util.List;
import io.swagger.model.Client;

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

@Api(value = "client", description = "the client API")
public interface ClientApi {

    @ApiOperation(value = "Create client", notes = "", response = Client.class, responseContainer = "List", tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Client.class) })
    @RequestMapping(value = "/client",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<List<Client>> createClient(

@ApiParam(value = "" ,required=true ) @RequestBody List<Client> body

);


    @ApiOperation(value = "Delete client", notes = "", response = Void.class, tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid client id supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Client not found", response = Void.class) })
    @RequestMapping(value = "/client/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteClient(
@ApiParam(value = "",required=true ) @PathVariable("id") String id


);


    @ApiOperation(value = "List all client", notes = "", response = Client.class, responseContainer = "List", tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Client.class),
        @ApiResponse(code = 400, message = "Invalid client id supplied", response = Client.class),
        @ApiResponse(code = 404, message = "Client not found", response = Client.class) })
    @RequestMapping(value = "/client",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Client>> listClient();


    @ApiOperation(value = "Get client by client id", notes = "", response = Client.class, tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Client.class),
        @ApiResponse(code = 400, message = "Invalid client id supplied", response = Client.class),
        @ApiResponse(code = 404, message = "Client not found", response = Client.class) })
    @RequestMapping(value = "/client/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Client> readClient(
@ApiParam(value = "",required=true ) @PathVariable("id") String id


);


    @ApiOperation(value = "Updated client", notes = "", response = Client.class, tags={ "client", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Client.class),
        @ApiResponse(code = 400, message = "Invalid client supplied", response = Client.class),
        @ApiResponse(code = 404, message = "Client not found", response = Client.class) })
    @RequestMapping(value = "/client/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Client> updateClient(
@ApiParam(value = "",required=true ) @PathVariable("id") String id


,

@ApiParam(value = "Updated client object" ,required=true ) @RequestBody Client body

);

}
